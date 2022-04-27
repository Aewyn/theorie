package be.vdab.theorie.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public class Artikel {
    private final BigDecimal prijsExclBtw;
    private final BigDecimal prijsInclBtw;

    public Artikel(BigDecimal prijsExclBtw, BigDecimal btwPercentage){
        this.prijsExclBtw = prijsExclBtw;
        prijsInclBtw = prijsExclBtw.multiply(BigDecimal.ONE.add(btwPercentage.divide(BigDecimal.valueOf(100))));
    }

    public BigDecimal getPrijsInclBtw(){
        return prijsInclBtw.setScale(2,RoundingMode.HALF_UP);
    }
}
