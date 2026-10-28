package fr.efrei.transfret;

/**
 * Le cœur de la chaîne : le tarif du mode de transport (stratégie de l'étape 5).
 */
public class TarifDeBase implements CalculPrix {

    public double calculer(DemandePrix demande) {
        return demande.mode().getTarif().calculer(demande.distance(), demande.poidsTotal(), demande.volumeTotal());
    }
}
