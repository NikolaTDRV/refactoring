package fr.efrei.transfret;

/**
 * Enveloppe un autre calcul de prix et le modifie.
 */
public abstract class DecorateurPrix implements CalculPrix {

    protected final CalculPrix enveloppe;

    protected DecorateurPrix(CalculPrix enveloppe) {
        this.enveloppe = enveloppe;
    }
}
