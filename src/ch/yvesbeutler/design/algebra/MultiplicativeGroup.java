package ch.yvesbeutler.design.algebra;

public interface MultiplicativeGroup <T> extends MultiplicativeMonoid <T> {
    
    // a multiplicative monoid with
    // inverse elements: a * (1/a) = 1
    
    public abstract T getMultInv();

}