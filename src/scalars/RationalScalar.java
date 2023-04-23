package scalars;

public class RationalScalar implements Scalar{
    private int numerator;
    private int denominator;
    public RationalScalar(int numerator, int denominator) {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public RationalScalar(String str) {
        this(new IntegerScalar(str.split("/")[0]).getInt(),
                new IntegerScalar(str.split("/")[1]).getInt());
    }
    private int gcd(int n1, int n2) {
        n1 = n1 < 0 ? -n1: n1;
        n2 = n2 < 0 ? -n2: n2;
        int temp;
        while (n2 != 0) {
            temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }


    public Scalar add(Scalar s) {
        return s.add(this);
    }

    public Scalar add(IntegerScalar i) {
        return this.add(new RationalScalar(i.getInt(), 1));
    }

    public Scalar add(RationalScalar r) {
        return new RationalScalar(this.numerator * r.denominator + r.numerator * this.denominator,
                this.denominator * r.denominator).reduce();
    }

    public Scalar mul(Scalar s) {
        return s.mul(this);
    }

    public Scalar mul(IntegerScalar s) {
        return this.mul(new RationalScalar(s.getInt(), 1));
    }

    public Scalar mul(RationalScalar r) {
        return new RationalScalar(this.numerator * r.numerator,
                this.denominator * r.denominator);
    }

    public Scalar neg() {
        return new RationalScalar(-this.numerator, this.denominator);
    }

    public Scalar power(int exponent) {
        Scalar powered = new RationalScalar(1, 1);
        for (int i = 0; i < exponent; i++) {
            powered = this.mul(powered);
        }
        return powered;
    }

    public int sign() {
        if (this.numerator == 0)
            return 0;
        if (this.numerator > 0 == this.denominator > 0)
            return 1;
        return -1;
    }
    public RationalScalar reduce() {
        int gcd = this.gcd(this.numerator, this.denominator);
        return new RationalScalar(this.numerator / gcd, this.denominator / gcd);
    }
    public double getValue(){
        return (double) numerator/denominator;
    }
    public boolean equals(Object o){
        if(o instanceof Scalar)
            return ((Scalar)o).getValue() == getValue();
        return false;
    }
    public String toString(){
        return denominator == 1 ? numerator + "" : numerator + "/" + denominator;
    }
}
