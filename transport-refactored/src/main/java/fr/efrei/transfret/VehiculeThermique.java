package fr.efrei.transfret;

public abstract class VehiculeThermique extends Vehicule implements Ravitaillable {

    protected VehiculeThermique(String immatriculation, double capaciteMax, ModeTransport mode) {
        super(immatriculation, capaciteMax, mode);
    }

    public void faireLePlein() {
        System.out.println("Plein effectué pour " + immatriculation);
    }
}
