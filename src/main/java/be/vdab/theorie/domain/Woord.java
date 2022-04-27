package be.vdab.theorie.domain;

public class Woord {
    private final String woord;

    public Woord(String woord) {
        this.woord = woord;
    }

    public boolean isPalindroom(){
        return woord.toLowerCase().equals(new StringBuilder(woord.toLowerCase()).reverse().toString());
    }
}
