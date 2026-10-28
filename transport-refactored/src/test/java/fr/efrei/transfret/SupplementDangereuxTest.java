package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplementDangereuxTest {

    private static final CalculPrix CENT_EUROS = demande -> 100.0;

    private static DemandePrix demande(TypeMarchandise type, double valeur, boolean urgent, boolean assurance, TypeClient client) {
        Colis colis = new Colis("colis", 10, 10, 10, 10, type, valeur);
        return new DemandePrix(List.of(colis), 100, ModeTransport.ROUTE, urgent, assurance, client);
    }

    @Test
    void majoreLesMatieresDangereuses() {
        assertEquals(130.0, new SupplementDangereux(CENT_EUROS).calculer(demande(TypeMarchandise.DANGEREUX, 0, false, false, TypeClient.PARTICULIER)), 0.001);
    }

    @Test
    void neChangePasLesAutresColis() {
        assertEquals(100.0, new SupplementDangereux(CENT_EUROS).calculer(demande(TypeMarchandise.STANDARD, 0, false, false, TypeClient.PARTICULIER)), 0.001);
    }
}
