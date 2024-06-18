package org.example.MarcheurBlanc;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rue {

  private String nom;
  private Lieu lieu1;
  private Lieu lieu2;

  public Lieu getAutreLieu(Lieu lieu) {
    return lieu.equals(lieu1) ? lieu2 : lieu1;
  }

  @Override
  public String toString() {
    return nom + ": " + lieu1.getNom() + " <-> " + lieu2.getNom();
  }

}
