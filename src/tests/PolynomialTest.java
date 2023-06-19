package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scalars.*;
import nomials.*;

import java.util.LinkedList;
import java.util.List;

class PolynomialTest {
    Polynomial polynomialT = new Polynomial();
    @BeforeEach
    void setUp() {
        polynomialT = Polynomial.build("1 2 3");
        System.out.println("Polynomial:");
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void build() {
        System.out.println("tests build:");
        List<Monomial> monomialList = new LinkedList();
        monomialList.add(new Monomial(0,new IntegerScalar(1)));
        polynomialT = new Polynomial(monomialList);
        if(polynomialT.equals(Polynomial.build("1")))
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }

    @Test
    void add() {
        System.out.println("Tests add:");
        if(polynomialT.add(polynomialT).equals(Polynomial.build("2 4 6")))
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }

    @Test
    void mult() {
        System.out.println("Tests mult:");
        polynomialT = Polynomial.build("1 1");
        if(polynomialT.mul(polynomialT).equals(Polynomial.build("1 2 1")))
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }

    @Test
    void evaluate() {
        System.out.println("Tests evaluate:");
        if((new IntegerScalar(6)).equals(polynomialT.evaluate(new IntegerScalar(1))))
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }

    @Test
    void derivative() {
        System.out.println("Tests derivative:");
        if(polynomialT.derivative().equals(Polynomial.build("2 6")))
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }

    @Test
    void testEquals() {
        System.out.println("Tests equals:");
        if(polynomialT.equals(Polynomial.build("1 2 3")))
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }

    @Test
    void testToString() {
        System.out.println("Tests toString:");
        if(polynomialT.toString().equals("1 + 2x + 3x^2"))
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }
}