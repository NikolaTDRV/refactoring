package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssuranceTest {

    private static final CalculPrix CENT_EUROS = demande -> 100.0;

    private static DemandePrix demande(TypeMarchandise type, double valeur, boolean urgent, boolean assurance, TypeClient client) {
        Colis colis = new Colis("colis", 10, 10, 10, 10, type, valeur);
        return new DemandePrix(List.of(colis), 100, ModeTransport.ROUTE, urgent, assurance, client);
    }

    @Test
    void ajouteDeuxPourcentDeLaValeur() {
        assertEquals(140.0, new Assurance(CENT_EUROS).calculer(demande(TypeMarchandise.STANDARD, 2000, false, true, TypeClient.PARTICULIER)), 0.001);
    }

    @Test
    void ajouteAuMoinsQuinzeEuros() {
        assertEquals(115.0, new Assurance(CENT_EUROS).calculer(demande(TypeMarchandise.STANDARD, 100, false, true, TypeClient.PARTICULIER)), 0.001);
    }

    @Test
    void neChangeRienSansAssurance() {
        assertEquals(100.0, new Assurance(CENT_EUROS).calculer(demande(TypeMarchandise.STANDARD, 2000, false, false, TypeClient.PARTICULIER)), 0.001);
    }
}
