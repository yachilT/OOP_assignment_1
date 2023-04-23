package scalars;

public class IntegerScalar implements Scalar {
    private int number;
    public IntegerScalar(int number) {
        this.number = number;
    }
    public IntegerScalar(String str) {
        this.number = Integer.parseInt(str);
    }

    public Scalar add(Scalar s) {
        return s.add(this);
    }

    public Scalar add(IntegerScalar i) {
        return new IntegerScalar(this.number + i.number);
    }

    public Scalar add(RationalScalar r) {
        return r.add(this);
    }

    public Scalar mul(Scalar s) {
       return s.mul(this);
    }

    public Scalar mul(IntegerScalar s) {
        return new IntegerScalar(this.number * s.number);
    }

    public Scalar mul(RationalScalar r) {
        return r.mul(this);
    }

    public Scalar neg() {
        return new IntegerScalar(-this.number);
    }

    public Scalar power(int exponent) {
        Scalar powered = new IntegerScalar(1);
        for (int i = 0; i < exponent; i++) {
            powered = this.mul(powered);
        }
        return powered;
    }

    public int sign() {
        if (this.number > 0)
            return 1;
        if (this.number < 0)
            return -1;
        return 0;
    }

    public int getInt() {
        return this.number;
    }
    public double getValue() {
        return number;
    }
    public boolean equals(Object o){
        if(o instanceof Scalar)
            return ((Scalar)o).getValue() == getValue();
        return false;
    }
    @Override
    public String toString() {
        return this.number + "";
    }

}
