package be.vdab.theorie.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class RekeningTest {
    private Rekening rekening;
    private static final BigDecimal TWEE = BigDecimal.valueOf(2);

    @BeforeEach
    void beforeEach(){
        rekening = new Rekening();
    }

    @Test
    void hetSaldoVanEenNieuweRekeningIs0Euro() {
        assertThat(rekening.getSaldo()).isZero();
    }

    @Test
    void naStortenVan10EuroIsSaldo10Euro(){
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }

    @Test
    void naStortenVan10EuroDaarnaStortenVan1EuroIsSaldo11Euro(){
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }

    @Test
    void hetGestorteBedragMagNietNulZijn(){
        assertThatIllegalArgumentException().isThrownBy(() -> rekening.stort(BigDecimal.ZERO));
    }

    @Test
    void hetGestorteBedragMetNietNegatiefZijn(){
        assertThatIllegalArgumentException().isThrownBy(() -> rekening.stort(BigDecimal.valueOf(-1)));
    }

    @Test
    void stortMetNullKanNiet(){
        assertThatNullPointerException().isThrownBy(() -> rekening.stort(null));
    }

    @Test
    void eenNieuweRekeningHeeftGeenStortingen(){
        assertThat(rekening.getStortingen()).isEmpty();
    }

    @Test
    void nadatJe10EuroStortIsErEenStortingVan10Euro(){
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getStortingen()).containsOnly(BigDecimal.TEN);
    }

    @Test
    void nadatJe10EuroStortEnDan1EuroZijnDeStortingen10EuroEn1Euro(){
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getStortingen()).containsExactly(BigDecimal.TEN,BigDecimal.ONE);
    }

    @Test
    void stortingenVan2En10En1GesorteerdZijn1En2En10(){
        rekening.stort(TWEE);
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getStortingenGesorteerd()).isSorted().containsExactly(BigDecimal.ONE, TWEE,BigDecimal.TEN);
    }
}