package fr.efrei.transfret;

import java.util.List;

/**
 * Calcule le prix HT arrondi avec la chaîne de décorateurs qu'on lui donne (voir {@link AssembleurPrix}).
 */
public class CalculateurPrix {

    private final CalculPrix chaine;

    public CalculateurPrix(CalculPrix chaine) {
        this.chaine = chaine;
    }

    public double calculerPrixHT(List<Colis> colis, int distance, ModeTransport mode, boolean urgent, boolean assurance, TypeClient typeClient) {
        DemandePrix demande = new DemandePrix(colis, distance, mode, urgent, assurance, typeClient);
        return Utils.arrondir(chaine.calculer(demande));
    }
}
