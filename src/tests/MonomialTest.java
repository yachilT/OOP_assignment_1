package tests;

import nomials.Monomial;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scalars.IntegerScalar;
import scalars.RationalScalar;

class MonomialTest {

    Monomial monomial;
    @BeforeEach
    void setUp() {
        monomial = new Monomial(3, new RationalScalar(3, 4));
        System.out.println();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void equals() {
        System.out.print("equals: ");
        if (this.monomial.equals(new Monomial(3, new RationalScalar(6, 8))))
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }
    @Test
    void validAdd() {
        System.out.print("valid add: ");
        if (this.monomial.add(new Monomial(3, new RationalScalar(1, 4))).equals(new Monomial(3, new IntegerScalar(1))))
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void invalidAdd() {
        System.out.print("invalid add: ");
        if (this.monomial.add(new Monomial(2, new IntegerScalar(1))) == null)
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void mult() {
        System.out.print("multiply: ");
        if (this.monomial.mul(new Monomial(2, new RationalScalar(4, 3))).equals(new Monomial(5, new IntegerScalar(1))))
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void evaluate() {
        System.out.print("evaluate: ");
        if (this.monomial.evaluate(new IntegerScalar(4)).equals(new IntegerScalar(48)))
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void derivative() {
        System.out.print("derivative: ");
        if (this.monomial.derivative().equals(new Monomial(2, new RationalScalar(9, 4))))
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void sign() {
        System.out.print("sign: ");
        if (this.monomial.sign() == 1)
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void testToString() {
        System.out.print("toString: ");
        if (this.monomial.toString().equals("3/4*x^3"))
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void testToString2() {
        System.out.println("toString2: ");
        if (new Monomial(1, new IntegerScalar(1)).toString().equals("x"))
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }
}