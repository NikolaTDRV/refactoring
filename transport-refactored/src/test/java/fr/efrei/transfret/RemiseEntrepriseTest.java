package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemiseEntrepriseTest {

    @Test
    void dixPourcentEnDessousDuSeuil() {
        assertEquals(900.0, new RemiseEntreprise().appliquer(1000), 0.001);
    }

    @Test
    void quinzePourcentAuDessusDuSeuil() {
        assertEquals(8500.0, new RemiseEntreprise().appliquer(10000), 0.001);
    }
}
