package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifAirTest {

    @Test
    void poidsReelSiPlusLourdQueLeVolume() {
        assertEquals(1050.0, new TarifAir().calculer(1000, 100, 0.1), 0.001);
    }

    @Test
    void poidsVolumetriqueSiPlusGrand() {
        assertEquals(1351.5, new TarifAir().calculer(1000, 100, 1), 0.001);
    }
}
