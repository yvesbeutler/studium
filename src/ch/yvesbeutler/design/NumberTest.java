package ch.yvesbeutler.design;

import ch.yvesbeutler.design.numbers.integers.IntegerNumber;
import ch.yvesbeutler.design.numbers.integers.Sign;
import ch.yvesbeutler.design.numbers.naturals.NaturalNumber;
import ch.yvesbeutler.design.numbers.naturals.Succ;
import ch.yvesbeutler.design.numbers.naturals.Zero;

public class NumberTest {
    
    private static final NaturalNumber N_ZER = new Zero();
    private static final NaturalNumber N_ONE = new Succ(N_ZER);
    private static final NaturalNumber N_TWO = new Succ(N_ONE);
    private static final NaturalNumber N_THR = new Succ(N_TWO);
    
    private static final IntegerNumber Z_ZER = new IntegerNumber(Sign.plus, N_ZER);
    private static final IntegerNumber Z_ONE = new IntegerNumber(Sign.plus, N_ONE);
    private static final IntegerNumber Z_TWO = new IntegerNumber(Sign.plus, N_TWO);
    private static final IntegerNumber Z_M_ONE = Z_ONE.getAddInv();
    private static final IntegerNumber Z_M_TWO = Z_TWO.getAddInv();

    /*
    private static final RationalNumber Q_ZER = new RationalNumber(Z_ZER, Z_ONE);
    private static final RationalNumber Q_ONE = new RationalNumber(Z_ONE, Z_ONE);
    private static final RationalNumber Q_TWO = new RationalNumber(Z_TWO, Z_ONE);
    private static final RationalNumber Q_M_ONE = Q_ONE.getAddInv();
    private static final RationalNumber Q_M_TWO = Q_TWO.getAddInv();
    private static final RationalNumber Q_HALF = Q_TWO.getMultInv();
    */

    public static void main (String[] args) {

        System.out.println("natural numbers");
        System.out.println("1 + 2 = " + N_ONE.plus(N_ONE, N_TWO).getDeci());
        System.out.println("2 + 0 = " + N_TWO.plus(N_TWO, N_ZER).getDeci());
        System.out.println("2 + 2 = " + N_TWO.plus(N_TWO, N_TWO).getDeci());
        System.out.println("0 + 2 = " + N_ZER.plus(N_ZER, N_TWO).getDeci());
        System.out.println("2 * 1 = " + N_TWO.times(N_TWO, N_ONE).getDeci());
        System.out.println("2 * 2 = " + N_TWO.times(N_TWO, N_TWO).getDeci());
        System.out.println("1 * 1 = " + N_ONE.times(N_ONE, N_ONE).getDeci());
        System.out.println("0 * 2 = " + N_ZER.times(N_ZER, N_TWO).getDeci());
        System.out.println("1 * 2 = " + N_ONE.times(N_ONE, N_TWO).getDeci());
        System.out.println("3 * 2 = " + N_THR.times(N_THR, N_TWO).getDeci());
        System.out.println("2 * 3 = " + N_TWO.times(N_TWO, N_THR).getDeci());

        System.out.println("integer numbers");
        System.out.println("1 + 2 = " + Z_ONE.plus(Z_ONE, Z_TWO).getDeci());
    }

}