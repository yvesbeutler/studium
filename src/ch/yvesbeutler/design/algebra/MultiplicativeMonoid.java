package ch.yvesbeutler.design.algebra;

public interface MultiplicativeMonoid <T> {
    
    // a mathematical structure with
    // an operation '*' ("times") that is
    // commutative (a * b = b * a)
    // associative (a * (b * c) = (a * b) * c), and
    // has a neutral element '1' ("one") (a * 1 = a)
    //
    // In Java, we cannot express these
    // characteristic laws as constraints.
    
    public abstract T times (T a, T b);
    
    public abstract T getOne ();

}