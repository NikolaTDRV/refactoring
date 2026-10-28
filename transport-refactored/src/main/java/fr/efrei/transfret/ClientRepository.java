package fr.efrei.transfret;

public interface ClientRepository {

    void sauvegarder(Client client);

    // retourne null si aucun client n'a cet email
    Client trouver(String email);
}
