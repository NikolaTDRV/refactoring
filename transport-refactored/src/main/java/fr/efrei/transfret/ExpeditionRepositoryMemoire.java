package fr.efrei.transfret;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpeditionRepositoryMemoire implements ExpeditionRepository {

    private final Map<String, Expedition> expeditions = new HashMap<String, Expedition>();

    public void sauvegarder(Expedition expedition) {
        expeditions.put(expedition.getId(), expedition);
    }

    public void mettreAJourStatut(Expedition expedition) {
        // en mémoire, l'objet est déjà à jour : rien à faire
    }

    public Expedition trouver(String id) {
        return expeditions.get(id);
    }

    public List<Expedition> toutes() {
        return new ArrayList<Expedition>(expeditions.values());
    }
}
