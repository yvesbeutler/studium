package ch.yvesbeutler.xml.example.algebra;


public interface MultiplicativeMonoid <T> {
    
    // an algebraic structure with
    // an operation '*' ("times") that is
    // commutative (a * b = b * a)
    // associative (a * (b * c) = (a * b) * c), and
    // has a neutral element '1' ("one") (a * 1 = a)

    // mathematical style
    public abstract T times (T a, T b);
    
    // OO-style
    //public abstract T times (T b);
    
    public abstract T getOne ();

}