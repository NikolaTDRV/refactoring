package fr.efrei.transfret;

public interface TarifTransport {

    // tarif de base HT, avant suppléments et remise
    double calculer(int distance, double poids, double volume);
}
