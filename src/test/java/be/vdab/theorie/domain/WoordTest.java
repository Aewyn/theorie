package be.vdab.theorie.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class WoordTest {

    @Test
    void isLepelEenPalindroom(){
        var w1 = new Woord("Lepel");
        assertThat(w1.isPalindroom()).isTrue();
    }

    @Test
    void isKoksmutsGeenPalindroom(){
        assertThat(new Woord("Koksmuts").isPalindroom()).isFalse();
    }
}