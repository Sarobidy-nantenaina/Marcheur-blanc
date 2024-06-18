package org.example.MarcheurBlanc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarteTest {
  private Carte carte;
  private Lieu hei;
  private Lieu pullman;

  @BeforeEach
  public void setUp() {
    carte = new Carte(new ArrayList<>(), new ArrayList<>());
    hei = new Lieu("HEI");
    pullman = new Lieu("Pullman");
    carte.ajouterLieu(hei);
    carte.ajouterLieu(pullman);
    carte.ajouterRue(new Rue("Andriatsihoarana", hei, pullman));
  }

  @Test
  public void testAjoutLieu() {
    assertEquals(2, carte.getLieux().size());
    assertTrue(carte.getLieux().contains(hei));
    assertTrue(carte.getLieux().contains(pullman));
  }

  @Test
  public void testAjoutRue() {
    assertEquals(1, carte.getRues().size());
  }

  @Test
  public void testGetLieu() {
    assertEquals(hei, carte.getLieu("HEI"));
    assertEquals(pullman, carte.getLieu("Pullman"));
    assertNull(carte.getLieu("NonExistentLieu"));
  }

  @Test
  public void testGetRuesDepuis() {
    List<Rue> ruesDepuisHei = carte.getRuesDepuis(hei);
    assertEquals(1, ruesDepuisHei.size());
    assertEquals("Andriatsihoarana", ruesDepuisHei.get(0).getNom());

    List<Rue> ruesDepuisPullman = carte.getRuesDepuis(pullman);
    assertEquals(1, ruesDepuisPullman.size());
    assertEquals("Andriatsihoarana", ruesDepuisPullman.get(0).getNom());
  }

}
