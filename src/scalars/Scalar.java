package scalars;

public interface Scalar {
    public Scalar add(Scalar s);
    public Scalar add(IntegerScalar i);
    public Scalar add(RationalScalar r);
    public Scalar mult(Scalar s);
    public Scalar mult(IntegerScalar s);
    public Scalar mult(RationalScalar r);

    public Scalar neg();

    public Scalar power(int exponent);
    public int sign();
    public double getValue();
}
