package fr.efrei.transfret;

import java.util.List;

public class Camion extends VehiculeThermique {

    private final boolean adr; // certification matières dangereuses

    public Camion(String immatriculation, double capaciteMax, boolean adr) {
        super(immatriculation, capaciteMax, ModeTransport.ROUTE);
        this.adr = adr;
    }

    // le froid est réservé au camion frigorifique, le dangereux aux camions ADR
    protected boolean accepte(List<Colis> colis) {
        if (contient(colis, TypeMarchandise.REFRIGERE)) return false;
        return adr || !contient(colis, TypeMarchandise.DANGEREUX);
    }

    public void partir(int distanceKm) {
        faireLePlein();
        System.out.println("Le camion " + immatriculation + " roule sur " + distanceKm + " km");
    }
}
