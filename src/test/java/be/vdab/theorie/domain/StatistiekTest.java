package be.vdab.theorie.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class StatistiekTest {

    @Test
    @DisplayName("Get gemiddelde van 0 en 10 is 5")
    void hetGemiddeldeVan0En10Is5(){
        assertThat(Statistiek.getGemiddelde(new BigDecimal[] {BigDecimal.ZERO,BigDecimal.TEN})).isEqualByComparingTo("5");
    }

    @Test
    @DisplayName("Het gemiddelde van een getal is dat getal")
    void hetGemiddeldeVanEenGetalIsDatGetal(){
        var enigGetal = BigDecimal.valueOf(1.23);
        assertThat(Statistiek.getGemiddelde(new BigDecimal[]{enigGetal})).isEqualByComparingTo(enigGetal);
    }

    @Test
    @DisplayName("Het gemiddelde van een lege verzameling kan je niet berekenen")
    void hetGemiddeldeVanEenLegeVerzamelingKanJeNietBerekenen(){
        assertThatIllegalArgumentException().isThrownBy(() -> Statistiek.getGemiddelde(new BigDecimal[]{}));
    }

    @Test
    @DisplayName("Het gemiddelde van 0 kan je niet berekenen")
    void hetGemiddeldeVan0KanJeNietBerekenen(){
        assertThatNullPointerException().isThrownBy(() -> Statistiek.getGemiddelde(null));
    }

    @Test
    @DisplayName("Een array element mag niet null bevatten")
    void eenArrayElementMagNietNullBevatten(){
        assertThatNullPointerException().isThrownBy(() -> Statistiek.getGemiddelde(new BigDecimal[]{null}));
    }
}