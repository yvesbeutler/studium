package ch.yvesbeutler.design.numbers.naturals;

public final class Zero extends NaturalNumber {

    public final Zero getZero() {
        return this;
    }
    
    public final boolean isZero() {
        return true;
    }
    
    public final int getDeci() {
        return 0;
    }
    
    public final NaturalNumber getPred() {
        return null;
    }

    @Override
    public NaturalNumber getOne() {
        return null;
    }
}