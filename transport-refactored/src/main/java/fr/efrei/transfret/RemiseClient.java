package fr.efrei.transfret;

/**
 * Applique la remise du type de client (stratégie de l'étape 5).
 */
public class RemiseClient extends DecorateurPrix {

    public RemiseClient(CalculPrix enveloppe) {
        super(enveloppe);
    }

    public double calculer(DemandePrix demande) {
        return demande.typeClient().getRemise().appliquer(enveloppe.calculer(demande));
    }
}
