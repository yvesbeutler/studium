package ch.yvesbeutler.design.numbers.naturals;

import ch.yvesbeutler.design.algebra.AdditiveMonoid;
import ch.yvesbeutler.design.algebra.MultiplicativeMonoid;
import ch.yvesbeutler.design.order.DiscreteOrdering;
import ch.yvesbeutler.design.order.LinearOrdering;
import ch.yvesbeutler.design.order.StrictLinearOrdering;

public abstract class NaturalNumber implements AdditiveMonoid<NaturalNumber>,
        MultiplicativeMonoid<NaturalNumber>,
        LinearOrdering<NaturalNumber>,
        DiscreteOrdering<NaturalNumber>,
        StrictLinearOrdering<NaturalNumber> {

    public abstract NaturalNumber getZero();

    public abstract boolean isZero();

    public abstract NaturalNumber getPred();

    public abstract int getDeci();

    public final NaturalNumber plus(NaturalNumber nl, NaturalNumber nr) {
        return (nr.isZero()) ? nl : plus(new Succ(nl), nr.getPred());
    }

    public final NaturalNumber times(NaturalNumber nl, NaturalNumber nr) {
        return (nr.isZero()) ? new Zero() : plus(nl, times(nr.getPred(), nl));
    }

    public final boolean leq(NaturalNumber nl, NaturalNumber nr) {
        return (nl.getDeci() <= nr.getDeci());
    }

}