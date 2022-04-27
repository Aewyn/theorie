package be.vdab.theorie.domain;

import java.util.Objects;

public class Rechthoek {
    private final int lengte;
    private final int breedte;

    public Rechthoek(int lengte, int breedte){
        if(breedte <= 0 || lengte < breedte){
            throw new IllegalArgumentException();
        }
        this.lengte = lengte;
        this.breedte = breedte;
    }

    public int getOpperVlakte(){
        return lengte * breedte;
    }

    public int getOmtrek(){
        return (lengte * 2) + (breedte * 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rechthoek rechthoek = (Rechthoek) o;
        return lengte == rechthoek.lengte && breedte == rechthoek.breedte;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lengte, breedte);
    }
}
