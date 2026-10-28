package fr.efrei.transfret;

import java.util.List;

public class Peniche extends VehiculeThermique {

    public Peniche(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax, ModeTransport.FLUVIAL);
    }

    // pas de cale réfrigérée
    protected boolean accepte(List<Colis> colis) {
        return !contient(colis, TypeMarchandise.REFRIGERE);
    }

    public void partir(int distanceKm) {
        faireLePlein();
        System.out.println("La péniche " + immatriculation + " navigue sur " + distanceKm + " km de voies fluviales");
    }
}
