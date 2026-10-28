package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifRailTest {

    @Test
    void prixAuKmEtAuKilo() {
        assertEquals(470.0, new TarifRail().calculer(500, 1000, 0), 0.001);
    }

    @Test
    void minimumDeFacturation() {
        assertEquals(150.0, new TarifRail().calculer(10, 10, 0), 0.001);
    }
}
