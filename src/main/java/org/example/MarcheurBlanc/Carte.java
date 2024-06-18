package org.example.MarcheurBlanc;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Carte {
    private List<Lieu> lieux = new ArrayList<>();
    private List<Rue> rues = new ArrayList<>();

    public void ajouterLieu(Lieu lieu) {
        lieux.add(lieu);
    }

    public void ajouterRue(Rue rue) {
        rues.add(rue);
    }

    public Lieu getLieu(String nom) {
        for (Lieu lieu : lieux) {
            if (lieu.getNom().equals(nom)) {
                return lieu;
            }
        }
        return null;
    }

    public List<Rue> getRuesDepuis(Lieu lieu) {
        List<Rue> ruesVoisines = new ArrayList<>();
        for (Rue rue : rues) {
            if (rue.getLieu1().equals(lieu) || rue.getLieu2().equals(lieu)) {
                ruesVoisines.add(rue);
            }
        }
        return ruesVoisines;
    }
}
