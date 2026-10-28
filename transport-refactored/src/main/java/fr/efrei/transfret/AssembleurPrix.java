package fr.efrei.transfret;

/**
 * Assemble les chaînes de décorateurs du calcul de prix.
 * <p>
 * Ordre, de l'intérieur vers l'extérieur : tarif de base → suppléments → urgence → remise → assurance.
 * La remise porte sur le prix après suppléments et urgence, l'assurance s'ajoute après la remise.
 */
public class AssembleurPrix {

    // règles historiques, celles décrites par les tests de contrat
    public static CalculPrix tarifsHistoriques() {
        return urgenceRemiseAssurance(supplementsMarchandise());
    }

    // règles actuelles : supplément « hors gabarit » en plus
    public static CalculPrix avecHorsGabarit() {
        return urgenceRemiseAssurance(new SupplementHorsGabarit(supplementsMarchandise()));
    }

    private static CalculPrix supplementsMarchandise() {
        return new SupplementRefrigere(
                new SupplementDangereux(
                        new SupplementFragile(
                                new TarifDeBase())));
    }

    private static CalculPrix urgenceRemiseAssurance(CalculPrix supplements) {
        return new Assurance(
                new RemiseClient(
                        new SupplementUrgence(supplements)));
    }
}
