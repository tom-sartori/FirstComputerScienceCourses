package fr.umontpellier.iut;

import java.util.HashMap;
import java.util.Map;

public final class GestionDistances {

    private final static Map<String, Integer> distanceVille;

    static {
        distanceVille = new HashMap<>();
        distanceVille.put("Montpellier", 0);
        distanceVille.put("Sète", 36);
        distanceVille.put("Sommières", 30);
        distanceVille.put("Nîmes", 58);
        distanceVille.put("Lunel", 30);
        distanceVille.put("Béziers", 80);
    }

    public static int getDistance(String ville) {
        return distanceVille.get(ville); 
    }
}
