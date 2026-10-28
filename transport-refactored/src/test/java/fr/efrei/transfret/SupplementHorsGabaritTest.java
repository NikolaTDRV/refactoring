package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplementHorsGabaritTest {

    private static final CalculPrix CENT_EUROS = demande -> 100.0;

    private static DemandePrix demande(double longueur, double largeur, double hauteur) {
        Colis colis = new Colis("colis", 10, longueur, largeur, hauteur, TypeMarchandise.STANDARD, 0);
        return new DemandePrix(List.of(colis), 100, ModeTransport.ROUTE, false, false, TypeClient.PARTICULIER);
    }

    @Test
    void majoreSiUneDimensionDepasseDeuxMetres() {
        assertEquals(110.0, new SupplementHorsGabarit(CENT_EUROS).calculer(demande(100, 201, 100)), 0.001);
    }

    @Test
    void neChangeRienJusquADeuxMetres() {
        assertEquals(100.0, new SupplementHorsGabarit(CENT_EUROS).calculer(demande(200, 200, 200)), 0.001);
    }
}
