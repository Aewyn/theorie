package be.vdab.theorie.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import static org.assertj.core.api.Assertions.assertThat;

public class JaarTest {
    @Test
    @DisplayName("Een jaar deelbaar door 400 is een schrikkeljaar.")
    void eenJaarDeelbaarDoor400IsEenSchrikkelJaar(){
        var jaar = new Jaar(2000);
        assertThat(jaar.isSchrikkeljaar()).isTrue();
    }

    @Test
    @DisplayName("Een jaar deelbaar door 100 is geen schrikkeljaar.")
    void eenJaarDeelbaarDoor100IsGeenSchrikkeljaar(){
        assertThat(new Jaar(1900).isSchrikkeljaar()).isFalse();
    }

    @Test
    @DisplayName("Een jaar deelbaar door 4 is een schrikkeljaar")
    void eenJaarDeelbaarDoor4IsEenSchrikkeljaar(){
        assertThat(new Jaar(2012).isSchrikkeljaar()).isTrue();
    }

    @Test
    @DisplayName("Een jaar niet deelbaar door 4 is geen schrikkeljaar")
    void eenJaarNietDeelbaarDoor4IsGeenSchrikkelJaar(){
        assertThat(new Jaar(2015).isSchrikkeljaar()).isFalse();
    }

    @Test
    @DisplayName("toString geeft het jaar als tekst")
    void toStringGeefHetJaarAlsTekst(){
        assertThat(new Jaar(2015)).hasToString("2015");
    }

    @Test
    @DisplayName("Jaren met hetzelfde jaartal zijn gelijk")
    void jarenMetHetzelfdeJaartalZijnGelijk(){
        assertThat(new Jaar(2015)).isEqualTo(new Jaar(2015));
    }

    @Test
    @DisplayName("Jaren met een verschillend jaartal zijn niet gelijk")
    void jarenMetEenVerschillendJaartalZijnNietGelijk(){
        assertThat(new Jaar(2014)).isNotEqualTo(new Jaar(2016));
    }

    @Test
    @DisplayName("De hashcode van gelijke jaren is gelijk")
    void deHashcodeVanGelijkeJarenIsGelijk(){
        assertThat(new Jaar(2015)).hasSameHashCodeAs(new Jaar(2015));
    }

}
