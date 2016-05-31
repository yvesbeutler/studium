package ch.yvesbeutler.xml.example.numbers.rationals;

import ch.yvesbeutler.xml.example.numbers.integers.IntegerNumber;
import ch.yvesbeutler.xml.example.numbers.naturals.NaturalNumber;

import ch.yvesbeutler.xml.example.algebra.Field;
import ch.yvesbeutler.xml.example.order.DiscreteOrdering;
import ch.yvesbeutler.xml.example.order.LinearOrdering;
import ch.yvesbeutler.xml.example.order.StrictLinearOrdering;
import ch.yvesbeutler.xml.example.xml.XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RationalNumber",
        namespace = "http://www.ti.bfh.ch/fileadmin/modules/BTI7055-de.xml")
@XmlType(propOrder = {"num", "den"})
public final class RationalNumber
        implements Field<RationalNumber>,
        LinearOrdering<RationalNumber>,
        DiscreteOrdering<RationalNumber>,
        StrictLinearOrdering<RationalNumber>,
        XML {

    @XmlElement(name = "numerator")
    private IntegerNumber num;
    @XmlElement(name = "denominator")
    private IntegerNumber den;

    public final IntegerNumber getNum() {
        return num;
    }

    public final IntegerNumber getDen() {
        return den;
    }

    public RationalNumber(IntegerNumber numerator, IntegerNumber denominator) {
        if (denominator.isZero()) throw
                new IllegalArgumentException("The denominator must not be zero!");
        else {
            num = numerator;
            den = denominator;
        }
    }

    public RationalNumber() {
    } // for JAXB only

    public final boolean isPos() {
        return getNum().isPos() && getDen().isPos();
    }

    public final boolean isNeg() {
        return !isPos();
    }

    @XmlTransient
    private static final IntegerNumber Z_ZER = IntegerNumber.ZER; // for brevity
    @XmlTransient
    private static final IntegerNumber Z_ONE = IntegerNumber.ONE; // for brevity

    @XmlTransient
    public static final RationalNumber ZER = new RationalNumber(Z_ZER, Z_ONE);
    @XmlTransient
    public static final RationalNumber ONE = new RationalNumber(Z_ONE, Z_ONE);

    public final RationalNumber getZero() {
        return ZER;
    }

    public final RationalNumber getOne() {
        return ONE;
    }

    public final RationalNumber getAddInv() {
        return new RationalNumber(getNum().getAddInv(), getDen());
    }

    public final RationalNumber getMultInv() {
        if (getNum().isZero()) throw new ArithmeticException("Zero has no inverse!");
        else return new RationalNumber(getDen(), getNum());
    }

    public final float getDeci() {
        return ((float) getNum().getDeci()) / ((float) getDen().getDeci());
    }

    public final RationalNumber plus(RationalNumber rl, RationalNumber rr) {
        return new RationalNumber(Z_ZER.plus(Z_ONE.times(rl.getNum(), rr.getDen()),
                Z_ONE.times(rr.getNum(), rl.getDen())),
                Z_ONE.times(rl.getDen(), rr.getDen()));
        // the result fraction could be reduced by means of the
        // greatest common divisor of the numerator and denominator
    }

    public final RationalNumber minus(RationalNumber rr) {
        return plus(this, rr.getAddInv());
    }

    public final RationalNumber times(RationalNumber rl, RationalNumber rr) {
        return new RationalNumber(Z_ONE.times(rl.getNum(), rr.getNum()),
                Z_ONE.times(rl.getDen(), rr.getDen()));
    }

    public final RationalNumber dividedby(RationalNumber rr) {
        return times(this, rr.getMultInv());
    }

    public final RationalNumber power(NaturalNumber nr) {
        if (nr.isZero()) return getOne();
        if (nr.isOne()) return this;
        return times(this, power(nr.getPred()));
    }

    public final boolean leq(RationalNumber rl, RationalNumber rr) {
        if (rl.isNeg() && rr.isPos()) return true;
        if (rl.isPos() && rr.isNeg()) return false;
        if (rl.isPos() && rr.isPos()) return Z_ZER.leq(Z_ONE.times(rl.getNum(), rr.getDen()),
                Z_ONE.times(rr.getNum(), rl.getNum()));
        if (rl.isNeg() && rr.isNeg()) return Z_ZER.geq(Z_ONE.times(rl.getNum(), rr.getDen()),
                Z_ONE.times(rr.getNum(), rl.getDen()));
        return false; // just to make the compiler happy ;-)
    }

}