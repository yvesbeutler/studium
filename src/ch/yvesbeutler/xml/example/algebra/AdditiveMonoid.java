package ch.yvesbeutler.xml.example.algebra;


public interface AdditiveMonoid <T> {
    
    // an algebraic structure with
    // an operation '+' ("plus") that is
    // commutative (a + b = b + a) and
    // associative (a + (b + c) = (a + b) + c), and
    // has a neutral element '0' ("zero") (a + 0 = a)
    
    // mathematical style
    public abstract T plus (T a, T b);
    
    // OO-style
    //public abstract T plus (T b);
    
    public abstract T getZero ();

}