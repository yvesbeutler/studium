package ch.yvesbeutler.xml.example.algebra;


public interface AdditiveGroup  <T>
         extends AdditiveMonoid <T> {
    
    // an additive monoid (see algebra.AdditiveMonoid)
    // with (additive) inverse elements: a + (-a) = 0
    
    public abstract T getAddInv();

}