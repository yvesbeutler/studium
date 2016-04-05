package ch.yvesbeutler.design.algebra;

public interface AdditiveGroup <T> extends AdditiveMonoid <T> {
    
    // an additive monoid with
    // inverse elements: a + (-a) = 0
    
    public abstract T getAddInv();

}