package expresion;

import number.RationalScalar;
import number.RealScalar;
import number.Scalar;

/*
* Handle a polynomial term
* which have coefficient and exponent
* */
public class PolyTerm implements Comparable<PolyTerm> {
    private Scalar coefficient;
    private int exponent;
    private char scalarField;

    // Scalar scalarField gets r/q
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
        } else { // free variable
            expo = "0";
            scalar = polyterm;
        }

        this.exponent = Integer.parseInt(expo);

        // Get the scalar field
        switch (scalarField) {
            case 'q':
            case 'Q':
                this.scalarField = 'Q';
                this.coefficient = new RationalScalar(scalar);
                break;
            case 'r':
            case 'R':

                this.scalarField = 'R';
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

    // Check whether or not the two terms can be added together
    public boolean canAdd(PolyTerm pt) {
        return pt.getExponent() == this.getExponent();
    }

    // Adding two terms
    public PolyTerm add(PolyTerm pt) {
        if (!canAdd(pt)) {
            return null; // Cant add
        }

        Scalar outScalar = this.coefficient.add(pt.getCoefficient());
        return new PolyTerm(outScalar, this.getExponent());
    }

    // Multiplying two terms
    public PolyTerm mul(PolyTerm pt) {
        Scalar outScalar = this.getCoefficient().mul(pt.getCoefficient());
        int outExpo = this.getExponent() + pt.getExponent();

        return new PolyTerm(outScalar, outExpo);
    }

    // Get a scalar and evaluate this term with the input scalar
    public Scalar evaluate(Scalar scalar) {
        Scalar ans = getCoefficient();
        for (int i = getExponent(); i >  0 ; i--) {
            ans = ans.mul(scalar);
        }

        return ans;
    }

    // Return the derivative of this term
    public PolyTerm derivate() {
        Scalar outScalar;
        int outExpo = getExponent();

        if (outExpo == 0) { // the derivative is zero for free variable
            outScalar = getCoefficient().add(getCoefficient().neg());
        } else {
            Scalar expo = null;
            switch (this.scalarField) {
                case 'Q':
                    expo = new RationalScalar("" + outExpo);
                    break;
                case 'R':
                    expo = new RealScalar("" + outExpo);
                    break;
            }

            outScalar = getCoefficient().mul(expo);
            outExpo--;
        }

        return new PolyTerm(outScalar, outExpo);
    }

    // Return whether or not the terms are equals
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PolyTerm)) {
            return false;
        }

        PolyTerm other = (PolyTerm) obj;
        return other.getExponent() == this.getExponent() & other.coefficient.equals(this.getCoefficient());
    }

    // Return a meaningful string
    @Override
    public String toString() {
        String ans = this.coefficient.toString();
        if (getExponent() != 0) {
            ans += "x^" + getExponent();
        }

        return ans;
    }

    // Return if the terms is equal to zero
    public boolean isZero()
    {
    	return coefficient.isZero();
    }

    // Compare two terms
    @Override
    public int compareTo(PolyTerm other) {
        return other.getExponent() - this.getExponent();
    }
}
