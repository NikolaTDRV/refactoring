package fr.efrei.transfret;

import java.util.ArrayList;
import java.util.List;

public class EmailConsole implements CanalEmail {

    private static final String EXPEDITEUR = "noreply@transfret.fr";

    // garde une trace des emails envoyés (demandé par le support client)
    private final List<String[]> journal = new ArrayList<String[]>();

    public void envoyer(String destinataire, String sujet, String corps) {
        if (destinataire == null || !destinataire.contains("@")) {
            // adresse invalide : l'email ne part pas
            return;
        }
        System.out.println("[EMAIL] " + EXPEDITEUR + " -> " + destinataire + " | " + sujet);
        System.out.println("        " + corps);
        journal.add(new String[]{destinataire, sujet, corps});
    }

    public List<String[]> getJournal() {
        return journal;
    }
}
