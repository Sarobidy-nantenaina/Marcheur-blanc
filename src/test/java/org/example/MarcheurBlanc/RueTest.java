package org.example.MarcheurBlanc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RueTest {

  @Test
  public void testGetNom() {
    Lieu lieu1 = new Lieu("HEI");
    Lieu lieu2 = new Lieu("Pullman");
    Rue rue = new Rue("Andriatsihoarana", lieu1, lieu2);
    assertEquals("Andriatsihoarana", rue.getNom());
  }

  @Test
  public void testGetLieu1() {
    Lieu lieu1 = new Lieu("HEI");
    Lieu lieu2 = new Lieu("Pullman");
    Rue rue = new Rue("Andriatsihoarana", lieu1, lieu2);
    assertEquals(lieu1, rue.getLieu1());
  }

  @Test
  public void testGetLieu2() {
    Lieu lieu1 = new Lieu("HEI");
    Lieu lieu2 = new Lieu("Pullman");
    Rue rue = new Rue("Andriatsihoarana", lieu1, lieu2);
    assertEquals(lieu2, rue.getLieu2());
  }

  @Test
  public void testGetAutreLieu() {
    Lieu lieu1 = new Lieu("HEI");
    Lieu lieu2 = new Lieu("Pullman");
    Rue rue = new Rue("Andriatsihoarana", lieu1, lieu2);

    assertEquals(lieu2, rue.getAutreLieu(lieu1));
    assertEquals(lieu1, rue.getAutreLieu(lieu2));
  }

  @Test
  public void testToString() {
    Lieu lieu1 = new Lieu("HEI");
    Lieu lieu2 = new Lieu("Pullman");
    Rue rue = new Rue("Andriatsihoarana", lieu1, lieu2);

    assertEquals("Andriatsihoarana: HEI <-> Pullman", rue.toString());
  }

}
