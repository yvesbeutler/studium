package ch.yvesbeutler.xml.example.numbers.naturals;

import ch.yvesbeutler.xml.example.algebra.AdditiveMonoid;
import ch.yvesbeutler.xml.example.algebra.MultiplicativeMonoid;
import ch.yvesbeutler.xml.example.order.DiscreteOrdering;
import ch.yvesbeutler.xml.example.order.LinearOrdering;
import ch.yvesbeutler.xml.example.order.StrictLinearOrdering;
import ch.yvesbeutler.xml.example.xml.XML;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlTransient // it's an abstract class!
@XmlSeeAlso({Zero.class, Succ.class}) // see it's implementing classes!
public abstract class NaturalNumber
        implements AdditiveMonoid<NaturalNumber>,
        MultiplicativeMonoid<NaturalNumber>,
        LinearOrdering<NaturalNumber>,
        DiscreteOrdering<NaturalNumber>,
        StrictLinearOrdering<NaturalNumber>,
        XML {

    public static final Zero ZER = new Zero();
    // see concrete subclass Zero in this package

    public static final Succ ONE = new Succ(ZER);
    // see concrete subclass Succ in this package

    public final NaturalNumber getZero() {
        return ZER;
    }

    public final NaturalNumber getOne() {
        return ONE;
    }

    public abstract boolean isZero();

    public abstract boolean isOne();

    public abstract NaturalNumber getPred(); // predecessor

    public abstract int getDeci(); // decimal representation

    public final NaturalNumber plus(NaturalNumber nl,
                                    NaturalNumber nr) {
        if (nr.isZero()) return nl;
        return plus(new Succ(nl), nr.getPred());
    }

    public final NaturalNumber times(NaturalNumber nl,
                                     NaturalNumber nr) {
        if (nl.isZero() || nr.isZero()) return getZero();
        return plus(nl, times(nl, nr.getPred()));
    }

    public final NaturalNumber power(NaturalNumber nr) {
        if (nr.isZero()) return getOne();
        if (nr.isOne()) return this;
        return times(this, power(nr.getPred()));
    }

    public final NaturalNumber factorial() {
        if (isZero()) return getOne();
        return times(this, getPred().factorial());
    }

    public final boolean leq(NaturalNumber nl,
                             NaturalNumber nr) {
        if (nl.isZero()) return true;
        if (nr.isZero()) return false;
        return leq(nl.getPred(), nr.getPred());
    }

}