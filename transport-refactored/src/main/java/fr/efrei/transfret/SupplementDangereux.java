package fr.efrei.transfret;

public class SupplementDangereux extends DecorateurPrix {

    private static final double MAJORATION = 1.30;

    public SupplementDangereux(CalculPrix enveloppe) {
        super(enveloppe);
    }

    public double calculer(DemandePrix demande) {
        double prix = enveloppe.calculer(demande);
        if (demande.contient(TypeMarchandise.DANGEREUX)) {
            return prix * MAJORATION;
        }
        return prix;
    }
}
