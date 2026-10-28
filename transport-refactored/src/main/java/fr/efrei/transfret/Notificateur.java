package fr.efrei.transfret;

public class Notificateur {

    public void souhaiterBienvenue(Client client) {
        EmailService.envoyer(client.getEmail(), "Bienvenue chez TransFret", "Bonjour " + client.getNom() + ", votre compte " + client.getType().name().toLowerCase() + " a été créé.");
    }

    // email pour tous les clients, SMS en plus pour les clients premium
    public void notifier(Client client, String sujet, String corps, String sms) {
        EmailService.envoyer(client.getEmail(), sujet, corps);
        if (client.getType() == TypeClient.PREMIUM) {
            new SmsService().envoyerSms(client.getTelephone(), sms);
        }
    }
}
