package ch.yvesbeutler.xml.example.numbers;

import ch.yvesbeutler.xml.example.numbers.integers.IntegerNumber;
import ch.yvesbeutler.xml.example.numbers.integers.Sign;
import ch.yvesbeutler.xml.example.numbers.naturals.NaturalNumber;
import ch.yvesbeutler.xml.example.numbers.naturals.Succ;
import ch.yvesbeutler.xml.example.numbers.rationals.RationalNumber;

public class NumberTest {

    private static final NaturalNumber N_ZER = NaturalNumber.ZER;
    private static final NaturalNumber N_ONE = NaturalNumber.ONE;
    private static final NaturalNumber N_TWO = new Succ(N_ONE);
    private static final NaturalNumber N_THR = new Succ(N_TWO);

    private static final IntegerNumber Z_ZER = IntegerNumber.ZER;
    private static final IntegerNumber Z_ONE = IntegerNumber.ONE;
    private static final IntegerNumber Z_TWO = new IntegerNumber(Sign.plus, N_TWO);
    private static final IntegerNumber Z_THR = new IntegerNumber(Sign.plus, N_THR);
    private static final IntegerNumber Z_M_ONE = Z_ONE.getAddInv();
    private static final IntegerNumber Z_M_TWO = Z_TWO.getAddInv();
    private static final IntegerNumber Z_M_THR = Z_THR.getAddInv();

    private static final RationalNumber Q_ZER = RationalNumber.ZER;
    private static final RationalNumber Q_ONE = RationalNumber.ONE;
    private static final RationalNumber Q_TWO = new RationalNumber(Z_TWO, Z_ONE);
    private static final RationalNumber Q_THR = new RationalNumber(Z_THR, Z_ONE);
    private static final RationalNumber Q_M_ONE = Q_ONE.getAddInv();
    private static final RationalNumber Q_M_TWO = Q_TWO.getAddInv();
    private static final RationalNumber Q_M_THR = Q_THR.getAddInv();
    private static final RationalNumber Q_ONE_HALF = Q_TWO.getMultInv();
    private static final RationalNumber Q_ONE_THIR = Q_THR.getMultInv();
    private static final RationalNumber Q_M_ONE_HALF = Q_ONE_HALF.getAddInv();
    private static final RationalNumber Q_M_ONE_THIR = Q_ONE_THIR.getAddInv();
    private static final RationalNumber Q_M_TWO_THIR = new RationalNumber(Z_M_TWO, Z_THR);

    public static void main(String[] args) {
        // args[0] must contain a terminated absolute path to a temporary directory

        System.out.println("");


        // START: number (Java-)object tests

        System.out.println(Z_THR.minus(Z_TWO).getDeci());
        System.out.println(Q_M_TWO_THIR.minus(Q_ONE_THIR).getDeci());
        System.out.println(Q_M_TWO_THIR.dividedby(Q_ONE_HALF).getDeci() + "\n");

        // testing the power function on N, Z, and Q (recursively)
        // tests all other arithmetic operations on N, Z, and Q
        System.out.println(N_THR.power(N_THR).getDeci());
        System.out.println(Z_M_THR.power(N_THR).getDeci());
        System.out.println(Q_M_TWO_THIR.power(N_THR).getDeci() + "\n");

        // testing the gr ordering on Q (recursively)
        // tests all other orderings on Q, Z, and N
        System.out.println(Q_ZER.gr(Q_M_TWO_THIR, Q_M_TWO_THIR));
        System.out.println(Q_ZER.gr(Q_M_ONE_THIR, Q_M_TWO_THIR));
        System.out.println(Q_ZER.gr(Q_M_TWO_THIR, Q_M_ONE_THIR) + "\n");

        // END: number (Java-)object tests


        // START: Taylor-series exercise




        // END: Taylor-series exercise

    }

}