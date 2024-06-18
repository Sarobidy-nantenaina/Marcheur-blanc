package org.example.MarcheurBlanc;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Marcheur {
  private Lieu positionActuelle;
  private Set<Lieu> lieuxVisites;
  private Carte carte;
  private Random random;

  public Lieu getPositionActuelle() {
    return positionActuelle;
  }

  public boolean marcherVers(Lieu destination) {
    while (!positionActuelle.equals(destination)) {
      List<Rue> ruesVoisines = carte.getRuesDepuis(positionActuelle);
      if (ruesVoisines.isEmpty()) {
        return false;
      }

      Rue rueChoisie = ruesVoisines.get(random.nextInt(ruesVoisines.size()));
      System.out.println("Marcheur emprunte la rue: " + rueChoisie.getNom());
      positionActuelle = rueChoisie.getAutreLieu(positionActuelle);
      lieuxVisites.add(positionActuelle);
      System.out.println("Marcheur arrive à: " + positionActuelle.getNom());
    }
    return true;
  }

  public Set<Lieu> getLieuxVisites() {
    return lieuxVisites;
  }

}
