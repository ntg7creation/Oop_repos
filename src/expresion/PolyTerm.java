package expresion;

import number.RationalScalar;
import number.RealScalar;
import number.Scalar;

public class PolyTerm implements Comparable<PolyTerm> {
    public enum ScalarField{Q,R};

    private Scalar coefficient;
    private int exponent;
    private ScalarField field;

    //scalar field gets r/q
    public PolyTerm(String polyterm, char scalarField) {
        // Find where to split
        int xIndex = polyterm.indexOf('x');
        if (xIndex == -1) {
            xIndex = polyterm.indexOf('X');
        }

        String scalar;
        String expo;
        if (xIndex != -1) {
            // Get the exponent
            expo = polyterm.substring(xIndex + 1);
            if (expo.isEmpty()) {
                expo = "1";
            } else {
                expo = expo.substring(1);
            }

            scalar = polyterm.substring(0, xIndex);
        } else {
            expo = "0";
            scalar = polyterm;
        }

        this.exponent = Integer.parseInt(expo);

        // Get the scalar
        switch (scalarField) {
            case 'q':
            case 'Q':
                this.field = ScalarField.Q;
                this.coefficient = new RationalScalar(scalar);
                break;
            case 'r':
            case 'R':

                this.field = ScalarField.R;
                this.coefficient = new RealScalar(scalar);
                break;
        }
    }

    private PolyTerm(Scalar coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public int getExponent() {
        return exponent;
    }

    public Scalar getCoefficient() {
        return coefficient;
    }

    public boolean canAdd(PolyTerm pt) {
        return pt.getExponent() == this.getExponent();
    }

    public PolyTerm add(PolyTerm pt) {
        if (!canAdd(pt)) {
            return null; // Cant add
        }

        Scalar outScalar = this.coefficient.add(pt.getCoefficient());
        return new PolyTerm(outScalar, this.getExponent());
    }

    public PolyTerm mul(PolyTerm pt) {
        Scalar outScalar = this.getCoefficient().mul(pt.getCoefficient());
        int outExpo = this.getExponent() + pt.getExponent();

        return new PolyTerm(outScalar, outExpo);
    }

    public Scalar evaluate(Scalar scalar) {
        Scalar ans = getCoefficient();
        for (int i = getExponent(); i >  0 ; i--) {
            ans = ans.mul(scalar);
        }

        return ans;
    }

    public PolyTerm derivate() {
        Scalar outScalar;
        int outExpo = getExponent();

        if (outExpo == 0) {
            outScalar = getCoefficient().add(getCoefficient().neg());
        } else {
            Scalar expo = null;
            switch (this.field) {
                case Q:
                    expo = new RationalScalar("" + outExpo);
                    break;
                case R:
                    expo = new RealScalar("" + outExpo);
                    break;
            }

            outScalar = getCoefficient().mul(expo);
            outExpo--;
        }

        return new PolyTerm(outScalar, outExpo);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PolyTerm)) {
            return false;
        }

        PolyTerm other = (PolyTerm) obj;
        return other.getExponent() == this.getExponent() & other.coefficient.equals(this.getCoefficient());
    }

    @Override
    public String toString() {
        String ans = this.coefficient.toString();
        if (getExponent() != 0) {
            ans += "x^" + getExponent();
        }

        return ans;
    }
    
    public boolean isZero()
    {
    	return coefficient.isZero();
    }
    
    @Override
    public int compareTo(PolyTerm other) {
        return other.getExponent() - this.getExponent();
    }
}
