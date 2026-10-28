package fr.efrei.transfret;

public class Assurance extends DecorateurPrix {

    private static final double TAUX = 0.02;
    private static final double MINIMUM = 15;

    public Assurance(CalculPrix enveloppe) {
        super(enveloppe);
    }

    public double calculer(DemandePrix demande) {
        double prix = enveloppe.calculer(demande);
        if (demande.assurance()) {
            return prix + Math.max(demande.valeurTotale() * TAUX, MINIMUM);
        }
        return prix;
    }
}
