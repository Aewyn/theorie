package be.vdab.theorie.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class VeilingTest {
    private Veiling veiling;

    @BeforeEach
    void beforeEach(){
        veiling = new Veiling();
    }

    @Test
    @DisplayName("Zonder biedingen is het hoogste bod 0 euro")
    void ZonderBiedingenIsHetHoogsteBod0Euro(){
        assertThat(veiling.getHoogsteBod()).isZero();
    }

    @Test
    @DisplayName("Maak een bod van 1000 euro en het hoogste bod is 1000 euro")
    void maakEenBodVan1000EuroEnHetHoogsteBodIs1000Euro(){
        veiling.doeBod(BigDecimal.valueOf(1000));
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("1000");
    }

    @Test
    @DisplayName("Bij meerdere biedingen is het hoogste bod gelijk aan de hoogste bieding")
    void bijMeerdereBiedingenIsHetHoogsteBodGelijkAanDeHoogsteBieding(){
        veiling.doeBod(BigDecimal.valueOf(1000));
        veiling.doeBod(BigDecimal.valueOf(500));
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("1000");
    }

    //Doe chapter 6 van theorie - BeforeEach

}