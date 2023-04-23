package nomials;
import scalars.*;

public class Monomial {
    private int exponent;
    private scalars.Scalar coefficient;
    public Monomial(int exponent, Scalar coefficient){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    public Monomial add(Monomial m){
        if(this.exponent != m.exponent)
            return null;
        return new Monomial(this.exponent, this.coefficient.add(m.coefficient));
    }
    public Monomial mul(Monomial m){
        return new Monomial(this.exponent + m.exponent, this.coefficient.mul(m.coefficient));
    }
    public Scalar evaluate(Scalar s){
        Scalar res = this.coefficient.mul(s.power(this.exponent));
        return res;
    }
    public Monomial derivative(){
        return new Monomial(this.exponent - 1, this.coefficient.mul(new IntegerScalar(exponent)));
    }
    public int sign(){
        return this.coefficient.sign();
    }
    public String toString(){
        Scalar one = new IntegerScalar(1);
        Scalar zero = new IntegerScalar(0);
        if(this.coefficient.equals(zero))
            return "0";
        else if(this.exponent == 0)
            return this.coefficient.toString();
        else if(this.coefficient.equals(one))
            return "x^"+this.exponent;
        else
            return this.coefficient.toString() + '*' + "x^"+this.exponent;
    }
    public int getExponent() {
        return exponent;
    }

    public Scalar getCoefficient() {
        return this.coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Monomial))
            return false;
        Monomial monomial = (Monomial) o;
        return this.exponent == monomial.exponent && this.coefficient.equals(monomial.coefficient);
    }

}
