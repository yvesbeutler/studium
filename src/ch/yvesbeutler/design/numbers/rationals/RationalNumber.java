/*
package ch.yvesbeutler.design.numbers.rationals;

import ch.yvesbeutler.design.algebra.Field;
import ch.yvesbeutler.design.numbers.integers.IntegerNumber;
import ch.yvesbeutler.design.numbers.integers.Sign;
import ch.yvesbeutler.design.numbers.naturals.Succ;
import ch.yvesbeutler.design.numbers.naturals.Zero;
import ch.yvesbeutler.design.order.DiscreteOrdering;
import ch.yvesbeutler.design.order.LinearOrdering;
import ch.yvesbeutler.design.order.StrictLinearOrdering;

public final class RationalNumber implements Field<RationalNumber>,
        LinearOrdering<RationalNumber>,
        DiscreteOrdering<RationalNumber>,
        StrictLinearOrdering<RationalNumber> {

    private static final IntegerNumber ZERO = new IntegerNumber(Sign.plus, new Zero());
    private static final IntegerNumber ONE = new IntegerNumber(Sign.plus, new Succ(new Zero()));

    private IntegerNumber numerator;
    private IntegerNumber denominator;

    public RationalNumber(IntegerNumber numerator, IntegerNumber denominator) {
        if (denominator.isZero())
            throw new IllegalArgumentException("The denominator must not be zero!");
        else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public final IntegerNumber getNum() {
        return numerator;
    }

    public final IntegerNumber getDen() {
        return denominator;
    }

    public final RationalNumber getZero() {

    }

    public final RationalNumber getOne() {

    }

    public final RationalNumber getAddInv() {

    }

    public final RationalNumber getMultInv() {
        if (getNum().isZero())
            throw new ArithmeticException("Zero has no inverse!");
        else
    }

    public final RationalNumber plus(RationalNumber rl,
                                     RationalNumber rr) {

    }

    public final RationalNumber minus(RationalNumber rl,
                                      RationalNumber rr) {

    }

    public final RationalNumber times(RationalNumber rl,
                                      RationalNumber rr) {

    }

    public final RationalNumber dividedby(RationalNumber rl,
                                          RationalNumber rr) {

    }

    public final boolean leq(RationalNumber rl,
                             RationalNumber rr) {

    }

    public final float getDeci() {

    }

}
*/