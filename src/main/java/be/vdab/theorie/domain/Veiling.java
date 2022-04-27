package be.vdab.theorie.domain;

import java.math.BigDecimal;

public class Veiling {
    private BigDecimal hoogsteBod = BigDecimal.ZERO;

    public void doeBod(BigDecimal bedrag){
        if (bedrag.doubleValue() > hoogsteBod.floatValue()){
            hoogsteBod = bedrag;
        }
    }

    public BigDecimal getHoogsteBod(){
        return hoogsteBod;
    }
}
