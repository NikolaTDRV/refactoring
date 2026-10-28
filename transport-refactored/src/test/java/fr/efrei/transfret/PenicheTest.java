package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PenicheTest {

    private static List<Colis> colis(double poids, TypeMarchandise type) {
        return List.of(new Colis("colis", poids, 100, 100, 100, type, 0));
    }

    @Test
    void accepteLeFluvial() {
        assertTrue(new Peniche("PEN-0001", 2500000).peutPrendreEnCharge(colis(1000, TypeMarchandise.STANDARD), ModeTransport.FLUVIAL));
    }

    @Test
    void refuseLesAutresModes() {
        assertFalse(new Peniche("PEN-0001", 2500000).peutPrendreEnCharge(colis(1000, TypeMarchandise.STANDARD), ModeTransport.ROUTE));
    }

    @Test
    void refuseLeRefrigere() {
        assertFalse(new Peniche("PEN-0001", 2500000).peutPrendreEnCharge(colis(1000, TypeMarchandise.REFRIGERE), ModeTransport.FLUVIAL));
    }

    @Test
    void refuseAuDelaDeSaCapacite() {
        assertFalse(new Peniche("PEN-0001", 2500000).peutPrendreEnCharge(colis(3000000, TypeMarchandise.STANDARD), ModeTransport.FLUVIAL));
    }
}
