package fr.efrei.transfret;

import java.util.List;

public class Bateau extends VehiculeThermique implements Refrigerable {

    private static final double KM_PAR_MILLE_NAUTIQUE = 1.852;
    private static final double TEMPERATURE = 4;

    private final boolean conteneursRefrigeres;

    public Bateau(String immatriculation, double capaciteMax, boolean conteneursRefrigeres) {
        super(immatriculation, capaciteMax, ModeTransport.MER);
        this.conteneursRefrigeres = conteneursRefrigeres;
    }

    protected boolean accepte(List<Colis> colis) {
        return conteneursRefrigeres || !contient(colis, TypeMarchandise.REFRIGERE);
    }

    public void partir(int distanceKm) {
        faireLePlein();
        int milles = (int) (distanceKm / KM_PAR_MILLE_NAUTIQUE);
        System.out.println("Le navire " + immatriculation + " navigue sur " + milles + " milles nautiques");
        if (contient(chargement, TypeMarchandise.REFRIGERE)) {
            activerRefrigeration(TEMPERATURE);
        }
    }

    // appelée seulement si le navire a accepté du réfrigéré, donc s'il a des conteneurs frigorifiques
    public void activerRefrigeration(double temperature) {
        System.out.println("Conteneurs frigorifiques réglés à " + temperature + "°C");
    }
}
