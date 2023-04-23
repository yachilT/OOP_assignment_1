package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scalars.*;

import java.util.Objects;

class IntegerScalarTest {
    IntegerScalar num;
    @BeforeEach
    void setUp() {
        this.num = new IntegerScalar(5);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInt() {
        System.out.print("get number: ");
        if (this.num.getInt() == 5)
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void addInteger() {
        System.out.print("add integer: ");
        if (this.num.add(new IntegerScalar(3)).getValue() == 8)
            System.out.println("Success!");
        else
            System.out.println("Failed!");

    }

    @Test
    void addRational() {
        System.out.print("add Rational: ");
        if (this.num.add(new RationalScalar(1, 2)).getValue() == 5.5)
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }


    @Test
    void multInteger() {
        System.out.print("multiply Integer: ");
        if (this.num.mul(new IntegerScalar(3)).getValue() == 15)
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void multRational() {
        System.out.print("multiply Rational: ");
        if (this.num.mul(new IntegerScalar(3)).getValue() == 15.0)
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void neg() {
        System.out.print("negative: ");
        if (this.num.neg().getValue() == -5)
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void power() {
        System.out.print("raise to a power: ");
        if (this.num.power(2).getValue() == 25)
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void sign() {
        System.out.print("sign: ");
        if (this.num.sign() == 1)
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void getValue() {
        System.out.print("get value: ");
        if (this.num.getValue() == 5)
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void equalsInteger() {
        System.out.print("equals Integer: ");
        if (this.num.equals(new IntegerScalar(5)))
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void equalsRational() {
        System.out.print("equals Rational: ");
        if (this.num.equals(new RationalScalar(5, 1)))
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }

    @Test
    void testToString() {
        System.out.print("toString: ");
        if (Objects.equals(this.num.toString(), "5"))
            System.out.println("Success!");
        else
            System.out.println("Failed!");
    }
}