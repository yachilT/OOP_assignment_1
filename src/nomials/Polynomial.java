package nomials;

import scalars.IntegerScalar;
import scalars.RationalScalar;
import scalars.Scalar;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer,Monomial>  monomials;
    public Polynomial(){};
    public Polynomial(List<Monomial> monomialList){
        monomials = new TreeMap<>();
        for(Monomial m: monomialList){
            int exponent = m.getExponent();
            Monomial mono = monomials.getOrDefault(exponent, new Monomial(exponent, new IntegerScalar(0)));
            monomials.put(exponent, mono.add(m));
        }
    }
    public static Polynomial build(String input){
        String[] coeffs = input.split(" ");
        List<Monomial> monomialList = new LinkedList<Monomial>();
        for(int i = 0; i < coeffs.length; i++) {
            if(coeffs[i].contains("/")) {
                monomialList.add(new Monomial(i, new RationalScalar(coeffs[i])));
            }
            else {
                monomialList.add(new Monomial(i, new IntegerScalar(coeffs[i])));
            }
        }
        return new Polynomial(monomialList);
    }
    public Polynomial add(Polynomial p){
        List<Monomial> monomialList = new LinkedList<>();
        monomialList.addAll(p.monomials.values());
        monomialList.addAll(this.monomials.values());
        return new Polynomial(monomialList);
    }
    public Polynomial mult(Polynomial p){
        List<Monomial> monomialList = new LinkedList<>();
        for(Monomial m1: this.monomials.values())
            for(Monomial m2: p.monomials.values())
                monomialList.add(m1.mul(m2));
        return new Polynomial(monomialList);
    }
    public Scalar evaluate(Scalar s){
        Scalar output = new RationalScalar(0,1);
        for(Monomial m: this.monomials.values())
            output = output.add(m.evaluate(s));
        return output;
    }
    public Polynomial derivative(){
        List<Monomial> monomialList = new LinkedList<>();
        for(Monomial m: this.monomials.values())
            monomialList.add(m.derivative());
        return new Polynomial(monomialList);
    }
    public boolean equals(Object o){
        if(o instanceof Polynomial)
            return ((Polynomial)o).monomials.equals(monomials);
        else
            return false;
    }
    public String toString(){
        String output = "";
        for(Monomial m: this.monomials.values())
            output = output + " +" + m.toString();
       return output.replaceAll("-","+-");
    }
}