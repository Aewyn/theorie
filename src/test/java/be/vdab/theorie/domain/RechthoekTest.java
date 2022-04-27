package be.vdab.theorie.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RechthoekTest {
    private Rechthoek r;

    @BeforeEach
    void beforeEach(){
        r = new Rechthoek(6,4);
    }

    @Test
    @DisplayName("De oppervlakte van een 4 op 6 vierkant is 24")
    void oppervlakteVan4op5is20() {
        assertThat(r.getOpperVlakte()).isEqualTo(24);
    }

    @Test
    @DisplayName("De omtrek van een 4 op 6 vierkant is 20")
    void omtrekVan4op4is16() {
        assertThat(r.getOmtrek()).isEqualTo(20);
    }

    @Test
    @DisplayName("Rechthoeken met dezelfde lengte en breedte zijn gelijk")
    void rechthoekenMetDezelfdeLengteEnBreedteZijnGelijk(){
        assertThat(r).isEqualTo(new Rechthoek(6,4));
    }

    @Test
    @DisplayName("Rechthoeken met verschillende lengte en of breedte zijn niet gelijk")
    void rechthoekenMetVerschillendeLengteEnOfBreedteZijnNietGelijk(){
        assertThat(r).isNotEqualTo(new Rechthoek(6,3));
    }

    @Test
    @DisplayName("Rechthoeken met dezelfde lengte en breedte hebben dezelfde hashcode")
    void rechthoekenMetDezelfdeLengteEnBreedteHebbenDezelfdeHashcode(){
        assertThat(r).hasSameHashCodeAs(new Rechthoek(6, 4));
    }

    @Test
    void lengteMagNietNegatiefZijn(){
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(-2,3));
    }

    @Test
    void breedTeMagNietNegatiefZijn(){
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(2,-3));
    }

    @Test
    void lengteMagNietKleinerDanBreedteZijn(){
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(2,3));
    }
}