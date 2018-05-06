package number;

/*
 * Handle a scalar of the Real Field
 * */
public class RationalScalar implements Scalar {
    private int numer;
    private int denom;
    private int sign;

    // Constructors...
    public  RationalScalar(String scalar) {
        if (scalar.isEmpty()) {
            scalar = "+";
        }

        // find the sign
        switch (scalar.charAt(0)) {
            case '-':
                this.sign = -1;
                scalar = scalar.substring(1);
                break;
            case '+':
                this.sign = 1;
                scalar = scalar.substring(1);
                break;
            default:
                this.sign = 1;
        }

        if (scalar.isEmpty()) { // The scalar input was + or - (1)
            this.numer = 1;
            this.denom = 1;
        } else { // Extracting the numerator and denominator
            String[] number = scalar.split("/");
            this.numer = Integer.parseInt(number[0]);
            if (number.length == 2) {
                this.denom = Integer.parseInt(number[1]);
            } else {
                this.denom = 1;
            }
        }
    }

    public RationalScalar(int numer, int denom, int sign) {
        this.numer = numer;
        this.denom = denom;
        this.sign = sign;
    }

    public int getNumer() {
        return numer;
    }

    public int getDenom() {
        return denom;
    }

    public int getSign() {
        return sign;
    }

    // Implementing the interface...

    public Scalar add(Scalar s) {
        RationalScalar rs = (RationalScalar)s;
        int newNomer = (this.sign * this.getNumer() * rs.getDenom()) + (rs.getSign() * rs.getNumer() * this.getDenom());
        int newDenom = this.getDenom() * rs.getDenom();
        int newSign = (int)Math.signum(newNomer);

        return new RationalScalar(Math.abs(newNomer), newDenom, newSign);
    }

    public Scalar mul(Scalar s) {
        RationalScalar rs = (RationalScalar)s;
        int newNomer = this.getNumer() * rs.getNumer();
        int newDenom = this.getDenom() * rs.getDenom();
        int newSign = this.getSign() * rs.getSign();

        return new RationalScalar(Math.abs(newNomer), newDenom, newSign);
    }

    public Scalar neg() {
        return new RationalScalar(getNumer(), getDenom(), getSign() * -1);
    }

    public Scalar inv() {
        return new RationalScalar(getDenom(), getNumer(), getSign());
    }

    public boolean equals(Scalar s) {
        if (!(s instanceof RationalScalar)) {
            return false;
        }

        RationalScalar rs = (RationalScalar)s;
        if (this.getSign() != rs.getSign()) {
            return false;
        }

        return (double) getNumer()/rs.getNumer() == (double)getDenom()/rs.getDenom();
    }

    
    
    @Override
    public String toString() {
        String ans;
        if (this.sign == 1) {
            ans = "+";
        } else {
            ans = "-";
        }

        ans += this.numer;
        if (this.denom != 1) {
            ans += "/" + this.denom;
        }

        return ans;
    }

	@Override
	public boolean isZero() {
		
		return numer == 0;
	}
}