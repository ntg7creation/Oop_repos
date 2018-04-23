package math;

public class RationalScalar implements Scalar {
    private int nomer;
    private int denom;
    private int sign;

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

        if (scalar.isEmpty()) {
            this.nomer = 1;
            this.denom = 1;
        } else {
            String[] number = scalar.split("/");
            this.nomer = Integer.parseInt(number[0]);
            if (number.length == 2) {
                this.denom = Integer.parseInt(number[1]);
            } else {
                this.denom = 1;
            }
        }
    }

    public RationalScalar(int nomer, int denom, int sign) {
        this.nomer = nomer;
        this.denom = denom;
        this.sign = sign;
    }

    public int getNomer() {
        return nomer;
    }

    public int getDenom() {
        return denom;
    }

    public int getSign() {
        return sign;
    }

    public Scalar add(Scalar s) {
        RationalScalar rs = (RationalScalar)s;
        int newNomer = (this.sign * this.getNomer() * rs.getDenom()) + (rs.getSign() * rs.getNomer() * this.getDenom());
        int newDenom = this.getDenom() * rs.getDenom();
        int newSign = (int)Math.signum(newNomer);

        return new RationalScalar(Math.abs(newNomer), newDenom, newSign);
    }

    public Scalar mul(Scalar s) {
        RationalScalar rs = (RationalScalar)s;
        int newNomer = this.getNomer() * rs.getNomer();
        int newDenom = this.getDenom() * rs.getDenom();
        int newSign = this.getSign() * rs.getSign();

        return new RationalScalar(Math.abs(newNomer), newDenom, newSign);
    }

    public Scalar neg() {
        return new RationalScalar(getNomer(), getDenom(), getSign() * -1);
    }

    public Scalar inv() {
        return new RationalScalar(getDenom(), getNomer(), getSign());
    }

    public boolean equals(Scalar s) {
        if (!(s instanceof RationalScalar)) {
            return false;
        }

        RationalScalar rs = (RationalScalar)s;
        if (this.getSign() != rs.getSign()) {
            return false;
        }

        return (double)getNomer()/rs.getNomer() == (double)getDenom()/rs.getDenom();
    }

    
    
    @Override
    public String toString() {
        String ans;
        if (this.sign == 1) {
            ans = "+";
        } else {
            ans = "-";
        }

        ans += this.nomer;
        if (this.denom != 1) {
            ans += "/" + this.denom;
        }

        return ans;
    }

	@Override
	public boolean isZero() {
		
		return nomer == 0;
	}
}