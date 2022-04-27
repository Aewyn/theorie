package be.vdab.theorie.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ArtikelTest {
    @Test
    @DisplayName("De prijs incl btw op 100 met 6 procent is 106")
    void dePrijsInclBtwOp100Met6ProcentIs106(){
        assertThat(new Artikel(BigDecimal.valueOf(100), BigDecimal.valueOf(6)).getPrijsInclBtw()).isEqualByComparingTo("106");
    }

    @Test
    @DisplayName("De prijs incl btw op 264 met 12 procent is 295.68")
    void dePrijsInclBtwOp264Met12ProcentIs295komma68(){
        assertThat(new Artikel(BigDecimal.valueOf(264), BigDecimal.valueOf(12)).getPrijsInclBtw()).isEqualByComparingTo("295.68");
    }
}