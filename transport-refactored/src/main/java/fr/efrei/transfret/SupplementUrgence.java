package fr.efrei.transfret;

public class SupplementUrgence extends DecorateurPrix {

    private static final double MAJORATION = 1.5;

    public SupplementUrgence(CalculPrix enveloppe) {
        super(enveloppe);
    }

    public double calculer(DemandePrix demande) {
        double prix = enveloppe.calculer(demande);
        if (demande.urgent()) {
            return prix * MAJORATION;
        }
        return prix;
    }
}
