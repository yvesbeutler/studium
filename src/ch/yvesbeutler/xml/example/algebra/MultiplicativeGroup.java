package ch.yvesbeutler.xml.example.algebra;


public interface MultiplicativeGroup  <T>
    extends      MultiplicativeMonoid <T> {
    
    // a multiplicative monoid with (multiplicative)
    // inverse elements: a * (1/a) = 1
    
    public abstract T getMultInv();

}