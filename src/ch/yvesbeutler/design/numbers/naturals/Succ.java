package ch.yvesbeutler.design.numbers.naturals;

public final class Succ extends NaturalNumber {
 
    private NaturalNumber predecessor;

    public Succ(NaturalNumber n) {
        this.predecessor = n;
    }

    public final NaturalNumber getPred() {
        return predecessor;
    }
    
    public final boolean isZero() {
        return false;
    }

    public final NaturalNumber getZero() {
        return null;
    }
    
    public final int getDeci() {
        return getPred().getDeci() + 1;
    }

    @Override
    public NaturalNumber getOne() {
        return null;
    }
}