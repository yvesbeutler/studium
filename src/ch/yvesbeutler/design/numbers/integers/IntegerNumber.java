package ch.yvesbeutler.design.numbers.integers;

import ch.yvesbeutler.design.algebra.AdditiveGroup;
import ch.yvesbeutler.design.algebra.MultiplicativeMonoid;
import ch.yvesbeutler.design.numbers.naturals.NaturalNumber;
import ch.yvesbeutler.design.numbers.naturals.Succ;
import ch.yvesbeutler.design.numbers.naturals.Zero;
import ch.yvesbeutler.design.order.DiscreteOrdering;
import ch.yvesbeutler.design.order.LinearOrdering;
import ch.yvesbeutler.design.order.StrictLinearOrdering;

public final class IntegerNumber implements AdditiveGroup<IntegerNumber>,
        MultiplicativeMonoid<IntegerNumber>,
        LinearOrdering<IntegerNumber>,
        StrictLinearOrdering<IntegerNumber>,
        DiscreteOrdering<IntegerNumber> {

    private static final NaturalNumber ZERO = new Zero();

    private NaturalNumber magnitude;
    private Sign sign;

    public IntegerNumber(Sign sign, NaturalNumber magnitude) {
        this.sign = sign;
        this.magnitude = magnitude;
    }

    public final NaturalNumber getAbs() {
        return magnitude;
    }

    public final Sign getSign() {
        return sign;
    }

    public final IntegerNumber getZero() {
        return new IntegerNumber(Sign.plus, ZERO);
    }

    public final IntegerNumber getOne() {
        return new IntegerNumber(Sign.plus, new Succ(ZERO));
    }

    public final boolean isZero() {
        return magnitude.isZero();
    }

    public final boolean isPos() {
        return (isZero() || sign == Sign.plus);
    }

    public final boolean isNeg() {
        return (!isPos());
    }

    public final IntegerNumber getAddInv() {
        sign = (sign == Sign.plus) ? Sign.minus : Sign.plus;
        return this;
    }

    public final IntegerNumber plus(IntegerNumber il, IntegerNumber ir) {
        if (il.isPos() && ir.isPos() || il.isNeg() && ir.isNeg()) {
            return new IntegerNumber(il.getSign(), ZERO.plus(il.getAbs(), ir.getAbs()));
        } else {

            // do some magic!
        }
        return null;
    }

    public final IntegerNumber minus(IntegerNumber il, IntegerNumber ir) {
        return null;
    }

    public final IntegerNumber times(IntegerNumber il, IntegerNumber ir) {
        return null;
    }

    public final boolean leq(IntegerNumber il, IntegerNumber ir) {
        return (il.getDeci() <= ir.getDeci());
    }

    public final int getDeci() {
        return magnitude.getDeci();
    }

}