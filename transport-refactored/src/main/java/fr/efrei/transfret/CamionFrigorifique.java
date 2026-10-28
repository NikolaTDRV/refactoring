package fr.efrei.transfret;

import java.util.List;

public class CamionFrigorifique extends VehiculeThermique implements Refrigerable {

    private static final double TEMPERATURE = 4;

    public CamionFrigorifique(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax, ModeTransport.ROUTE);
    }

    // on ne mobilise le camion frigorifique que pour du réfrigéré
    protected boolean accepte(List<Colis> colis) {
        return contient(colis, TypeMarchandise.REFRIGERE);
    }

    public void partir(int distanceKm) {
        faireLePlein();
        System.out.println("Le camion frigorifique " + immatriculation + " roule sur " + distanceKm + " km");
        activerRefrigeration(TEMPERATURE);
    }

    public void activerRefrigeration(double temperature) {
        System.out.println("Réfrigération activée à " + temperature + "°C sur " + immatriculation);
    }
}
