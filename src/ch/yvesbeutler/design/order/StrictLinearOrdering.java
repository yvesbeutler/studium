package ch.yvesbeutler.design.order;


public interface StrictLinearOrdering <T>
    extends DiscreteOrdering <T> {
    
    public default boolean le (T l, T r) {
        return (leq(l, r) && !eq(l, r));
    }

    public default boolean gr (T l, T r) {
        return le(r, l);
    }
    
}