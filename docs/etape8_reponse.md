# Étape 8 – Réponses aux questions de la feuille de route

## Combien de fichiers existants ai-je modifiés ?

**8 au total**, contre 8 à 9 prévus à l'étape 1. Mais ce ne sont plus les mêmes fichiers, et il n'y a plus de cascades de `if` à rallonger.

| | Prévu à l'étape 1 | Réalité |
|---|---|---|
| **FLUVIAL** | 7 fichiers + `Peniche` qui implémente toutes les méthodes de `IVehicule` avec des exceptions | 5 fichiers : `ModeTransport` (une ligne), `Flotte` et `Utils` (des données), `EstimateurDelai` et `ValidateurExpedition`. `CalculateurPrix`, `AffectationVehicule` et `demarrerExpedition` n'ont pas été touchés. |
| **Hors gabarit** | 1 à 2 fichiers, dont un `if` de plus dans `CalculateurPrix` | Un décorateur créé, sans toucher aux autres. `CalculateurPrix`, `Main` et l'adaptateur ont changé une seule fois, pour rendre la chaîne injectable à cause du contrat. |

## Les 68 tests passent-ils toujours ?

**Oui.** Mais si on applique « hors gabarit » partout, 6 tests échouent, car c'est une nouvelle règle métier qui change des prix existants. C'est ce qui a justifié la chaîne injectée.

## Ce qui reste perfectible

`EstimateurDelai` (un `switch` sur le mode) et `ValidateurExpedition` (un `if` sur le mode) ont dû être modifiés pour FLUVIAL. C'est le bonus de l'étape 5 que je n'avais pas fait.

Si l'enum `ModeTransport` portait aussi son délai et ses règles (urgence autorisée, réfrigéré autorisé), ajouter un mode ne toucherait plus que l'enum et de nouvelles classes. Je peux le faire si tu veux, pour cocher la dernière ligne de la grille d'auto-évaluation.
