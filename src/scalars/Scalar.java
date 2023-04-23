package scalars;

public interface Scalar {
    public Scalar add(Scalar s);
    public Scalar add(IntegerScalar i);
    public Scalar add(RationalScalar r);
    public Scalar mul(Scalar s);
    public Scalar mul(IntegerScalar s);
    public Scalar mul(RationalScalar r);

    public Scalar neg();

    public Scalar power(int exponent);
    public int sign();
    public double getValue();
}
