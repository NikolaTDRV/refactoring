package fr.efrei.transfret;

import java.util.ArrayList;
import java.util.List;

public class SmsConsole implements CanalSms {

    private static final int LONGUEUR_MAX_SMS = 160;
    private static final String POINTS_DE_SUSPENSION = "...";

    // garde une trace des SMS envoyés (facturés par l'opérateur)
    private final List<String[]> journal = new ArrayList<String[]>();

    public void envoyer(String numero, String message) {
        if (message.length() > LONGUEUR_MAX_SMS) {
            message = message.substring(0, LONGUEUR_MAX_SMS - POINTS_DE_SUSPENSION.length()) + POINTS_DE_SUSPENSION;
        }
        System.out.println("[SMS] -> " + numero + " : " + message);
        journal.add(new String[]{numero, message});
    }

    public List<String[]> getJournal() {
        return journal;
    }
}
