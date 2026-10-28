package fr.efrei.transfret;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicule implements Chargeable {

    protected String immatriculation;
    protected double capaciteMax;
    protected double chargeActuelle;
    protected boolean disponible = true;
    protected List<Colis> chargement = new ArrayList<Colis>();
    private final ModeTransport mode;

    protected Vehicule(String immatriculation, double capaciteMax, ModeTransport mode) {
        this.immatriculation = immatriculation;
        this.capaciteMax = capaciteMax;
        this.mode = mode;
    }

    // le véhicule répond lui-même : « puis-je prendre en charge ces colis, pour ce mode ? »
    public boolean peutPrendreEnCharge(List<Colis> colis, ModeTransport modeDemande) {
        return disponible
                && modeDemande == mode
                && capaciteMax - chargeActuelle >= poidsTotal(colis)
                && accepte(colis);
    }

    // règles propres à chaque véhicule (matières dangereuses, froid…)
    protected abstract boolean accepte(List<Colis> colis);

    // chaque véhicule part à sa façon (route, rail, mer, air)
    public abstract void partir(int distanceKm);

    protected static boolean contient(List<Colis> colis, TypeMarchandise type) {
        for (Colis c : colis) {
            if (c.getType() == type) return true;
        }
        return false;
    }

    private static double poidsTotal(List<Colis> colis) {
        double poids = 0;
        for (Colis c : colis) {
            poids = poids + c.getPoids();
        }
        return poids;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public double getCapaciteMax() {
        return capaciteMax;
    }

    public double getChargeActuelle() {
        return chargeActuelle;
    }

    public boolean estDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void charger(Colis colis) {
        if (chargeActuelle + colis.getPoids() > capaciteMax) {
            System.out.println("ERREUR : capacité dépassée pour " + immatriculation);
            return;
        }
        chargement.add(colis);
        chargeActuelle = chargeActuelle + colis.getPoids();
    }

    public void decharger(Colis colis) {
        if (chargement.remove(colis)) {
            chargeActuelle = chargeActuelle - colis.getPoids();
        }
    }
}
