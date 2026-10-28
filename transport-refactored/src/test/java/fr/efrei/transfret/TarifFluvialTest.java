package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifFluvialTest {

    @Test
    void prixAuKmEtAuKilo() {
        // 365 * 0.40 + 20000 * 0.02
        assertEquals(546.0, new TarifFluvial().calculer(365, 20000, 0), 0.001);
    }

    @Test
    void minimumDeFacturation() {
        assertEquals(300.0, new TarifFluvial().calculer(365, 100, 0), 0.001);
    }
}
