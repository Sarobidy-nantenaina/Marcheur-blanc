package org.example.MarcheurBlanc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarcheurTest {
  private Lieu hei;
  private Lieu esti;
  private Marcheur bjarni;

  @BeforeEach
  public void setUp() {
    Random random = new Random();

    hei = new Lieu("HEI");
    Lieu pullman = new Lieu("Pullman");
    Lieu balancoire = new Lieu("Balancoire");
    Lieu sekolintsika = new Lieu("Sekolintsika");
    Lieu marais = new Lieu("Marais");
    Lieu nexta = new Lieu("Nexta");
    Lieu boulevard = new Lieu("Boulevard");
    esti = new Lieu("ESTI");

    bjarni = new Marcheur(hei, random);

    // Ajouter les rues connues au fur et à mesure
    bjarni.ajouterRuesConnues(hei, List.of(
        new Rue("Andriatsihoarana", hei, pullman),
        new Rue("Rue Sans Nom", hei, balancoire),
        new Rue("Rue de Sekolintsika", hei, sekolintsika)
    ));

    bjarni.ajouterRuesConnues(pullman, List.of(
        new Rue("Andriatsihoarana", pullman, hei),
        new Rue("Ranaivo", pullman, balancoire),
        new Rue("Rue de Nexta", pullman, nexta)
    ));

    bjarni.ajouterRuesConnues(balancoire, List.of(
        new Rue("Rue Sans Nom", balancoire, hei),
        new Rue("Ranaivo", balancoire, pullman),
        new Rue("Rue du Boulevard", balancoire, boulevard),
        new Rue("Rue de l'ESTI", balancoire, esti)
    ));

    bjarni.ajouterRuesConnues(sekolintsika, List.of(
        new Rue("Rue de Sekolintsika", sekolintsika, hei),
        new Rue("Rue de Marais", sekolintsika, marais)
    ));

    bjarni.ajouterRuesConnues(marais, List.of(
        new Rue("Rue de Marais", marais, sekolintsika)
    ));

    bjarni.ajouterRuesConnues(nexta, List.of(
        new Rue("Rue de Nexta", nexta, pullman)
    ));

    bjarni.ajouterRuesConnues(boulevard, List.of(
        new Rue("Rue du Boulevard", boulevard, balancoire),
        new Rue("Rue de l'ESTI", boulevard, esti)
    ));

    bjarni.ajouterRuesConnues(esti, List.of(
        new Rue("Rue de l'ESTI", esti, balancoire),
        new Rue("Rue de l'ESTI", esti, boulevard)
    ));
  }

  @Test
  public void testMarcheurAtteintDestination() {
    assertTrue(bjarni.marcherVers(esti));
    assertEquals(esti, bjarni.getPositionActuelle());
  }

  @Test
  public void testLieuxVisites() {
    bjarni.marcherVers(esti);
    Set<Lieu> lieuxVisites = bjarni.getLieuxVisites();
    assertTrue(lieuxVisites.contains(hei));
    assertTrue(lieuxVisites.contains(esti));
  }

}
