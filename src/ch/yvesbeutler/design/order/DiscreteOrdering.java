package ch.yvesbeutler.design.order;


public interface DiscreteOrdering <T> extends LinearOrdering <T> {
    
    public default boolean eq (T l, T r) {
        // exploiting anti-symmetry
        return (leq(l, r) && leq(r, l));
    }
    
}