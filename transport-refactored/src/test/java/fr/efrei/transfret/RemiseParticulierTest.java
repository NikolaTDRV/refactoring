package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemiseParticulierTest {

    @Test
    void aucuneRemise() {
        assertEquals(1000.0, new RemiseParticulier().appliquer(1000), 0.001);
    }
}
