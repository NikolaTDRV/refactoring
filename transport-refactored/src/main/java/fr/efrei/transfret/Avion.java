package fr.efrei.transfret;

import java.util.List;

public class Avion extends VehiculeThermique {

    private static final int DISTANCE_ROULAGE_KM = 2;
    private static final int ALTITUDE_CROISIERE_PIEDS = 35000;

    public Avion(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax, ModeTransport.AIR);
    }

    // dangereux et réfrigéré sont déjà refusés par ValidateurExpedition
    protected boolean accepte(List<Colis> colis) {
        return true;
    }

    public void partir(int distanceKm) {
        faireLePlein();
        System.out.println("L'avion " + immatriculation + " roule sur " + DISTANCE_ROULAGE_KM + " km de piste");
        System.out.println("L'avion " + immatriculation + " vole à " + ALTITUDE_CROISIERE_PIEDS + " pieds");
    }
}
