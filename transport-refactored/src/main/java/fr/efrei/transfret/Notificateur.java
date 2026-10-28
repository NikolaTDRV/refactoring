package fr.efrei.transfret;

public class Notificateur {

    private final CanalEmail email;
    private final CanalSms sms;

    public Notificateur(CanalEmail email, CanalSms sms) {
        this.email = email;
        this.sms = sms;
    }

    public void souhaiterBienvenue(Client client) {
        email.envoyer(client.getEmail(), "Bienvenue chez TransFret", "Bonjour " + client.getNom() + ", votre compte " + client.getType().name().toLowerCase() + " a été créé.");
    }

    // email pour tous les clients, SMS en plus pour les clients premium
    public void notifier(Client client, String sujet, String corps, String texteSms) {
        email.envoyer(client.getEmail(), sujet, corps);
        if (client.getType() == TypeClient.PREMIUM) {
            sms.envoyer(client.getTelephone(), texteSms);
        }
    }
}
