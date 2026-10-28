package fr.efrei.transfret;

import java.util.List;

// train électrique : pas de plein à faire, donc pas Ravitaillable
public class Train extends Vehicule {

    public Train(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax, ModeTransport.RAIL);
    }

    protected boolean accepte(List<Colis> colis) {
        return true;
    }

    public void partir(int distanceKm) {
        System.out.println("Le train " + immatriculation + " circule sur " + distanceKm + " km de voies ferrées");
    }
}
