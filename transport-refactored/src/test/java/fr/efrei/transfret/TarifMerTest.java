package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifMerTest {

    @Test
    void prixAuKmEtAuKilo() {
        assertEquals(530.0, new TarifMer().calculer(1000, 1000, 0), 0.001);
    }

    @Test
    void minimumDeFacturation() {
        assertEquals(500.0, new TarifMer().calculer(100, 100, 0), 0.001);
    }
}
