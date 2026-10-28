package fr.efrei.transfret;

import java.util.List;

/**
 * Assemble la chaîne de décorateurs, puis calcule le prix HT arrondi.
 */
public class CalculateurPrix {

    // de l'intérieur vers l'extérieur : la remise porte sur le prix après suppléments et urgence,
    // l'assurance s'ajoute après la remise
    private final CalculPrix chaine =
            new Assurance(
                    new RemiseClient(
                            new SupplementUrgence(
                                    new SupplementRefrigere(
                                            new SupplementDangereux(
                                                    new SupplementFragile(
                                                            new TarifDeBase()))))));

    public double calculerPrixHT(List<Colis> colis, int distance, ModeTransport mode, boolean urgent, boolean assurance, TypeClient typeClient) {
        DemandePrix demande = new DemandePrix(colis, distance, mode, urgent, assurance, typeClient);
        return Utils.arrondir(chaine.calculer(demande));
    }
}
