package fr.efrei.transfret;

import java.util.List;

public class AffectationVehicule {

    private final Flotte flotte;

    public AffectationVehicule(Flotte flotte) {
        this.flotte = flotte;
    }

    // retourne le premier véhicule qui accepte l'expédition, null si aucun
    public Vehicule trouverVehicule(List<Colis> colis, ModeTransport mode) {
        for (Vehicule v : flotte.getVehicules()) {
            if (v.peutPrendreEnCharge(colis, mode)) {
                return v;
            }
        }
        return null;
    }
}
