package tests;
import scalars.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RationalScalarTest {
    private Scalar rationalScalarTest = new RationalScalar(1,2);
    private Scalar integerScalarTest = new IntegerScalar(2);
    private Scalar negativeOne = new IntegerScalar(-1);

    private RationalScalar testOn;

    @BeforeEach
    void setUp() {
        System.out.println("RationalScalar:");
        testOn = new RationalScalar(1,1);
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void add(){
    System.out.println("Tests add, input: IntegerScalar");
    if(testOn.add(integerScalarTest).getValue() == 3.0)
        System.out.println("Test succeeded");
    else
        System.out.println("Test failed");
    System.out.println("Tests add, input: RationalScalar");
    if(testOn.add(rationalScalarTest).getValue() == 1.5)
            System.out.println("Test succeeded");
    else
            System.out.println("Test failed");
    }
    @Test
    void mult() {
        System.out.println("Tests mult, input: IntegerScalar");
        if(testOn.mul(integerScalarTest).getValue() == 2.0)
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
        System.out.println("Tests mult, input: RationalScalar");
        if(testOn.mul(rationalScalarTest).getValue() == 0.5)
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }
    @Test
    void neg() {
        System.out.println("Tests neg");
        if(testOn.neg().equals(testOn.mul(negativeOne)))
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }

    @Test
    void power() {
        System.out.println("Tests power");
        testOn = new RationalScalar(2,1);
        if(testOn.power(4).getValue() == 16.0)
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }

    @Test
    void sign() {
        System.out.println("Tests sign, TestOn > 0");
        if(testOn.sign() == 1)
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
        System.out.println("Tests sign, TestOn <= 0");
        if(testOn.neg().sign() == -1)
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }
    @Test
    void reduce() {
        System.out.println("Test reduce");
        testOn = new RationalScalar(4,2);
        if(testOn.getNumerator() == 2 && testOn.getDenominator() == 1)
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }

    @Test
    void getValue() {
        System.out.println("Tests value");
        if(testOn.getValue() == 1)
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }
    @Test
    void testEquals() {
        Scalar sameValue = new IntegerScalar(1);
        System.out.println("Tests Equals, ");
        if(testOn.equals(sameValue))
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
        System.out.println("Tests Equals, ");
        if(!testOn.equals(rationalScalarTest))
            System.out.println("Test succeeded");
        else
            System.out.println("Tests failed");
    }

    @Test
    void testToString() {
        String str = testOn.toString();
        if(str.equals("1/1"))
            System.out.println("Test succeeded");
        else
            System.out.println("Test failed");
    }
}