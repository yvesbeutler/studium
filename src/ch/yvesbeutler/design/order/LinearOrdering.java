package ch.yvesbeutler.design.order;


public interface LinearOrdering <T> {
    
    // a binary relation R that is
    // reflexive:       a R a
    // transitive:      (a R b AND b R c) => a R c
    // anti-symmetric:  (a R b AND b R a) => a=b
    // connected:       a R b OR b R a
    //
    // In Java, we cannot express these
    // characteristic laws as constraints.
    
    public abstract boolean leq (T l, T r) ;
    public default  boolean geq (T l, T r) {
        return leq(r, l);
    }

}