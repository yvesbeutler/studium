package ch.yvesbeutler.xml.example.numbers.integers;

import ch.yvesbeutler.xml.example.numbers.naturals.NaturalNumber;

import ch.yvesbeutler.xml.example.algebra.AdditiveGroup;
import ch.yvesbeutler.xml.example.algebra.MultiplicativeMonoid;
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
@XmlRootElement(name = "IntegerNumber",
        namespace = "http://www.ti.bfh.ch/fileadmin/modules/BTI7055-de.xml")
@XmlType(propOrder = {"sign", "abs"})
public final class IntegerNumber
        implements AdditiveGroup<IntegerNumber>,
        MultiplicativeMonoid<IntegerNumber>,
        LinearOrdering<IntegerNumber>,
        StrictLinearOrdering<IntegerNumber>,
        DiscreteOrdering<IntegerNumber>,
        XML {

    @XmlElement(name = "sign")
    private Sign sign;
    @XmlElement(name = "magnitude")
    private NaturalNumber abs;

    public final Sign getSign() {
        return sign;
    }

    public final NaturalNumber getAbs() {
        return abs;
    }

    public IntegerNumber(Sign sign, NaturalNumber magnitude) {
        this.sign = sign;
        this.abs = magnitude;
    }

    public IntegerNumber() {
    } // for JAXB only

    public final boolean isZero() {
        return getAbs().isZero();
    }

    public final boolean isOne() {
        return getAbs().isOne() && getSign() == Sign.plus;
    }

    public final boolean isPos() {
        return isZero() || getSign() == Sign.plus;
    }

    public final boolean isNeg() {
        return !isPos();
    }

    @XmlTransient
    public static final IntegerNumber ZER = new IntegerNumber(Sign.plus, NaturalNumber.ZER);
    @XmlTransient
    public static final IntegerNumber ONE = new IntegerNumber(Sign.plus, NaturalNumber.ONE);

    public final IntegerNumber getZero() {
        return ZER;
    }

    public final IntegerNumber getOne() {
        return ONE;
    }

    public final IntegerNumber getAddInv() {
        if (isZero()) return this;
        if (isNeg()) return new IntegerNumber(Sign.plus, getAbs());
        return new IntegerNumber(Sign.minus, getAbs());
    }

    public final int getDeci() {
        if (isPos()) return getAbs().getDeci();
        return -getAbs().getDeci();
    }

    public final IntegerNumber plus(IntegerNumber il, IntegerNumber ir) {
        if (il.isPos() && ir.isPos())
            return new IntegerNumber(Sign.plus,
                    NaturalNumber.ZER.plus(il.getAbs(), ir.getAbs()));
        if (il.isNeg() && ir.isNeg())
            return new IntegerNumber(Sign.minus,
                    NaturalNumber.ZER.plus(il.getAbs(), ir.getAbs()));
        if (il.isPos() && ir.isNeg())
            if (il.isZero()) return ir;
            else return plus(new IntegerNumber(Sign.plus, il.getAbs().getPred()),
                    new IntegerNumber(Sign.minus, ir.getAbs().getPred()));
        if (il.isNeg() && ir.isPos())
            if (ir.isZero()) return il;
            else return plus(new IntegerNumber(Sign.minus, il.getAbs().getPred()),
                    new IntegerNumber(Sign.plus, ir.getAbs().getPred()));
        return null; // just to make the compiler happy ;-)
    }

    public final IntegerNumber minus(IntegerNumber ir) {
        return plus(this, ir.getAddInv());
    }

    public final IntegerNumber times(IntegerNumber il, IntegerNumber ir) {
        if (il.isZero() || ir.isZero()) return getZero();
        if ((il.isPos() && ir.isPos()) || (il.isNeg() && ir.isNeg()))
            return new IntegerNumber(Sign.plus, NaturalNumber.ONE.times(il.getAbs(), ir.getAbs()));
        return new IntegerNumber(Sign.minus, NaturalNumber.ONE.times(il.getAbs(), ir.getAbs()));
    }

    public final IntegerNumber power(NaturalNumber nr) {
        if (nr.isZero()) return getOne();
        if (nr.isOne()) return this;
        return times(this, power(nr.getPred()));
    }

    public final boolean leq(IntegerNumber il, IntegerNumber ir) {
        if (il.isNeg() && ir.isPos()) return true;
        if (il.isPos() && ir.isNeg()) return false;
        if (il.isPos() && ir.isPos()) return NaturalNumber.ZER.leq(il.getAbs(), ir.getAbs());
        if (il.isNeg() && ir.isNeg()) return NaturalNumber.ZER.geq(il.getAbs(), ir.getAbs());
        return false; // just to make the compiler happy ;-)
    }

}