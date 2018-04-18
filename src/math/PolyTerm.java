package math;

public class PolyTerm implements Comparable {
    private Scalar coefficient;
    private int exponent;

    public PolyTerm(String polyterm, char scalarField) {
        // Find where to split
        int xIndex = polyterm.indexOf('x');
        if (xIndex == -1) {
            xIndex = polyterm.indexOf('X');
        }

        // Get the exponent
        String expo = polyterm.substring(xIndex + 1);
        if (expo.isEmpty()) {
            expo = "1";
        } else {
            expo = expo.substring(1);
        }

        this.exponent = Integer.parseInt(expo);

        // Get the scalar
        String scalar = polyterm.substring(0,xIndex);
        switch (scalarField) {
            case 'q':
            case 'Q':
                this.coefficient = new RationalScalar(scalar);
                break;
            case 'r':
            case 'R':
                this.coefficient = new RealScalar(scalar);
                break;
        }
    }

    public int getExponent() {
        return exponent;
    }

    public Scalar getCoefficient() {
        return coefficient;
    }

    @Override
    public int compareTo(Object o) {
        PolyTerm other = (PolyTerm)o;
        return other.getExponent() - this.getExponent();
    }
}
