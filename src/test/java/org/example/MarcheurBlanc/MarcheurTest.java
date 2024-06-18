package org.example.MarcheurBlanc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarcheurTest {
  private Carte carte;
  private Lieu hei;
  private Lieu esti;
  private Marcheur bjarni;

  @BeforeEach
  public void setUp() {
    carte = new Carte();
    Random random = new Random();

    hei = new Lieu("HEI");
    Lieu pullman = new Lieu("Pullman");
    Lieu balancoire = new Lieu("Balancoire");
    Lieu sekolintsika = new Lieu("Sekolintsika");
    Lieu marais = new Lieu("Marais");
    Lieu nexta = new Lieu("Nexta");
    Lieu boulevard = new Lieu("Boulevard");
    esti = new Lieu("ESTI");

    carte.ajouterLieu(hei);
    carte.ajouterLieu(pullman);
    carte.ajouterLieu(balancoire);
    carte.ajouterLieu(sekolintsika);
    carte.ajouterLieu(marais);
    carte.ajouterLieu(nexta);
    carte.ajouterLieu(boulevard);
    carte.ajouterLieu(esti);

    carte.ajouterRue(new Rue("Andriatsihoarana", hei, pullman));
    carte.ajouterRue(new Rue("Rue Sans Nom", hei, balancoire));
    carte.ajouterRue(new Rue("Rue de Sekolintsika", hei, sekolintsika));
    carte.ajouterRue(new Rue("Rue de Marais", sekolintsika, marais));
    carte.ajouterRue(new Rue("Rue de Sekolintsika", sekolintsika, hei));
    carte.ajouterRue(new Rue("Rue de Marais", marais, sekolintsika));
    carte.ajouterRue(new Rue("Rue Sans Nom", pullman, hei));
    carte.ajouterRue(new Rue("Ranaivo", pullman, balancoire));
    carte.ajouterRue(new Rue("Rue de Nexta", pullman, nexta));
    carte.ajouterRue(new Rue("Rue de Nexta", nexta, pullman));
    carte.ajouterRue(new Rue("Rue Sans Nom", balancoire, hei));
    carte.ajouterRue(new Rue("Ranaivo", balancoire, pullman));
    carte.ajouterRue(new Rue("Rue du Boulevard", balancoire, boulevard));
    carte.ajouterRue(new Rue("Rue de l'ESTI", balancoire, esti));
    carte.ajouterRue(new Rue("Rue du Boulevard", boulevard, balancoire));
    carte.ajouterRue(new Rue("Rue de l'ESTI", boulevard, esti));
    carte.ajouterRue(new Rue("Rue de l'ESTI", esti, balancoire));
    carte.ajouterRue(new Rue("Rue de l'ESTI", esti, boulevard));

    bjarni = new Marcheur(hei, new HashSet<>(), carte, random);
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
