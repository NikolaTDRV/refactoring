package fr.efrei.transfret;

public class SupplementHorsGabarit extends DecorateurPrix {

    private static final double MAJORATION = 1.10;
    private static final double DIMENSION_MAX_CM = 200;

    public SupplementHorsGabarit(CalculPrix enveloppe) {
        super(enveloppe);
    }

    public double calculer(DemandePrix demande) {
        double prix = enveloppe.calculer(demande);
        for (Colis c : demande.colis()) {
            if (estHorsGabarit(c)) {
                return prix * MAJORATION;
            }
        }
        return prix;
    }

    private static boolean estHorsGabarit(Colis c) {
        return c.getLongueur() > DIMENSION_MAX_CM || c.getLargeur() > DIMENSION_MAX_CM || c.getHauteur() > DIMENSION_MAX_CM;
    }
}
