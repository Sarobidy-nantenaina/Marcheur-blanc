package org.example.MarcheurBlanc;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Lieu {
    private String nom;

    @Override
    public String toString() {
        return nom;
    }

}
