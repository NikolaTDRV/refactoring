package fr.efrei.transfret;

public class SupplementRefrigere extends DecorateurPrix {

    private static final double MAJORATION = 1.20;

    public SupplementRefrigere(CalculPrix enveloppe) {
        super(enveloppe);
    }

    public double calculer(DemandePrix demande) {
        double prix = enveloppe.calculer(demande);
        if (demande.contient(TypeMarchandise.REFRIGERE)) {
            return prix * MAJORATION;
        }
        return prix;
    }
}
