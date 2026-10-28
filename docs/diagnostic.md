# Étape 1 – Diagnostic du code historique

## 1. Rôle et dépendances de chaque classe

| Classe | Ce qu'elle fait | Dépend de |
|---|---|---|
| `Main` | Lance une démo | Services, `Flotte`, `Expedition` |
| `ServiceClient` | Valide **et** enregistre un client **et** envoie l'email de bienvenue | `Database` (singleton), `EmailService` (statique) |
| `ServiceExpedition` | Valide, calcule le délai, crée, démarre, livre, annule les expéditions **et** notifie | `Database`, `CalculateurPrix`, `AffectationVehicule`, `EmailService`, `SmsService`, `Utils` |
| `CalculateurPrix` | Calcule le prix HT (tarif, suppléments, remise, assurance) | `Colis` |
| `AffectationVehicule` | Choisit un véhicule pour une expédition | `Flotte` (statique), classes de véhicules |
| `Expedition` | Données d'une expédition **et** génération de la facture | `Client`, `Colis`, `Vehicule` |
| `Client`, `Colis` | Données métier | – |
| `Database` | Stockage en mémoire (singleton) | – |
| `EmailService` / `SmsService` | Envoi de messages (journal statique) | – |
| `Flotte` | Liste statique des véhicules | Classes de véhicules |
| `IVehicule`, `Vehicule` | Interface et base commune des véhicules | `Colis` |
| `Camion`, `CamionFrigorifique`, `Train`, `Bateau`, `Avion` | Véhicules concrets | `Vehicule` |
| `Utils` | Arrondi, dates, distances, validation d'email | – |

## 2. Tableau défaut → emplacement → principe violé

| Défaut | Emplacement | Principe |
|---|---|---|
| Une classe fait validation, délais, création, cycle de vie et notifications | `ServiceExpedition` | **S** – Responsabilité unique |
| L'entité génère sa propre facture | `Expedition.genererFacture()` | **S** |
| Validation + enregistrement + email de bienvenue dans la même méthode | `ServiceClient.creerClient` | **S** |
| Ajouter un mode = modifier une cascade de `if` / `switch` | `CalculateurPrix`, `ServiceExpedition.calculerDelai`, `AffectationVehicule`, `demarrerExpedition` | **O** – Ouvert/fermé |
| Ajouter un supplément = ajouter un `if` | `CalculateurPrix` (fragile, dangereux, réfrigéré, urgent) | **O** |
| Un camion frigo refuse des colis qu'un `Camion` accepte | `CamionFrigorifique.charger()` | **L** – Liskov |
| `faireLePlein()` lève une exception, cachée par un `catch` vide | `Train.faireLePlein()` + `demarrerExpedition` | **L** |
| L'interface impose `rouler`, `naviguer`, `voler`, `activerRefrigeration` à tous | `IVehicule` → `UnsupportedOperationException` dans `Train`, etc. | **I** – Ségrégation des interfaces |
| Singleton, méthode statique et `new` en dur | `Database.getInstance()`, `EmailService.envoyer()`, `new SmsService()`, `new CalculateurPrix()`, `new AffectationVehicule()` | **D** – Inversion des dépendances |
| État global statique modifiable | `Flotte.vehicules`, `Database.expeditions/clients`, journaux, `ServiceExpedition.compteur`, `Utils.FORMAT_DATE` | **D** |
| Cascade d'`instanceof` | `AffectationVehicule.trouverVehicule` | **O** / **L** |
| Mode, statut et type de client en `String`, type de colis en `int` | `Expedition`, `Client`, `Colis` | Code smell (Type Code) |
| Nombres magiques (1.2, 0.10, 167, 5000, 70, 1440…) | `CalculateurPrix`, `calculerDelai` | Code smell |
| `Math.round(x * 100.0) / 100.0` répété | `CalculateurPrix`, `ServiceExpedition` | Duplication |
| Clé d'API écrite en dur | `SmsService.apiKey` | Sécurité |

## 3. Endroits à modifier pour ajouter le mode FLUVIAL

1. `CalculateurPrix.calculerPrixHT` : nouveau `else if` pour le tarif et le minimum.
2. `ServiceExpedition.calculerDelai` : nouveau `case` pour le délai.
3. `ServiceExpedition.creerExpedition` : règles « réfrigéré interdit » et « pas d'urgence ».
4. `ServiceExpedition.demarrerExpedition` : comment le véhicule part.
5. `AffectationVehicule.trouverVehicule` : nouveau `else if` + `instanceof Peniche`.
6. Nouvelle classe `Peniche` qui doit implémenter **toutes** les méthodes de `IVehicule` (avec des exceptions).
7. `Flotte.initialiser` : ajouter la péniche PEN-0001.
8. `Utils.getDistance` : ajouter Paris → Le Havre (365 km).

→ **7 fichiers existants modifiés** + 1 nouvelle classe.

## 4. Endroits à modifier pour le supplément « hors gabarit »

1. `CalculateurPrix.calculerPrixHT` : détecter un colis > 200 cm et ajouter un `if` ×1,10.
2. (éventuellement) `Colis` : une méthode pour connaître la plus grande dimension.

→ **1 à 2 fichiers existants modifiés**, dans la classe qui fait déjà tout.
