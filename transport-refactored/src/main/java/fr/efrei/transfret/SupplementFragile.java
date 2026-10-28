package fr.efrei.transfret;

public class SupplementFragile extends DecorateurPrix {

    private static final double MAJORATION = 1.15;

    public SupplementFragile(CalculPrix enveloppe) {
        super(enveloppe);
    }

    public double calculer(DemandePrix demande) {
        double prix = enveloppe.calculer(demande);
        if (demande.contient(TypeMarchandise.FRAGILE)) {
            return prix * MAJORATION;
        }
        return prix;
    }
}
