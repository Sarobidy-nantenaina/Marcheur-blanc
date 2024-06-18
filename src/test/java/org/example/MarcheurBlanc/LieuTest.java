package org.example.MarcheurBlanc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class LieuTest {

  @Test
  public void testGetNom() {
    Lieu lieu = new Lieu("HEI");
    assertEquals("HEI", lieu.getNom());
  }

  @Test
  public void testToString() {
    Lieu lieu = new Lieu("HEI");
    assertEquals("HEI", lieu.toString());
  }

  @Test
  public void testEquals() {
    Lieu lieu1 = new Lieu("HEI");
    Lieu lieu2 = new Lieu("HEI");
    Lieu lieu3 = new Lieu("Pullman");

    assertTrue(lieu1.equals(lieu2));
    assertFalse(lieu1.equals(lieu3));
  }

  @Test
  public void testHashCode() {
    Lieu lieu1 = new Lieu("HEI");
    Lieu lieu2 = new Lieu("HEI");

    assertEquals(lieu1.hashCode(), lieu2.hashCode());
  }

}
