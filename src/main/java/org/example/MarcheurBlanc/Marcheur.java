package org.example.MarcheurBlanc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Marcheur {
  private Lieu positionActuelle;
  private Set<Lieu> lieuxVisites;
  private Random random;
  private Map<Lieu, List<Rue>> ruesConnues;

  public Marcheur(Lieu positionDepart, Random random) {
    this.positionActuelle = positionDepart;
    this.lieuxVisites = new HashSet<>();
    this.random = random;
    this.ruesConnues = new HashMap<>();
    this.lieuxVisites.add(positionDepart);
  }

  public void ajouterRuesConnues(Lieu lieu, List<Rue> rues) {
    if (!ruesConnues.containsKey(lieu)) {
      ruesConnues.put(lieu, new ArrayList<>(rues));
    }
  }

  public boolean marcherVers(Lieu destination) {
    while (!positionActuelle.equals(destination)) {
      List<Rue> ruesVoisines = ruesConnues.getOrDefault(positionActuelle, Collections.emptyList());
      if (ruesVoisines.isEmpty()) {
        return false;
      }

      Rue rueChoisie = ruesVoisines.get(random.nextInt(ruesVoisines.size()));
      System.out.println("Marcheur emprunte la rue: " + rueChoisie.getNom());
      positionActuelle = rueChoisie.getAutreLieu(positionActuelle);
      lieuxVisites.add(positionActuelle);
      System.out.println("Marcheur arrive à: " + positionActuelle.getNom());

      // Simuler la découverte de nouvelles rues adjacentes au nouveau lieu
      // Ceci peut être remplacé par une logique pour obtenir réellement les rues adjacentes
      List<Rue> nouvellesRues = obtenirRuesDepuis(positionActuelle);
      ajouterRuesConnues(positionActuelle, nouvellesRues);
    }
    return true;
  }

  // Méthode simulée pour obtenir les rues adjacentes à un lieu
  // Cette méthode doit être remplacée par une logique réelle pour découvrir les rues adjacentes
  private List<Rue> obtenirRuesDepuis(Lieu lieu) {
    // Exemple simulé
    return Collections.emptyList(); // Remplacer par une logique réelle
  }

  public Set<Lieu> getLieuxVisites() {
    return lieuxVisites;
  }

}
