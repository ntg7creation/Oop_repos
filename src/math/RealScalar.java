package math;

import java.text.DecimalFormat;

public class RealScalar implements Scalar {

	private double scalar;

	public RealScalar(String scalar) {
		this.scalar = Double.parseDouble(scalar);
	}

	@Override
	public Scalar add(Scalar s) {
		RealScalar rs = (RealScalar) s;
		scalar += rs.getValue();
		scalar = Format(scalar);
		return this;

	}

	@Override
	public Scalar mul(Scalar s) {
		RealScalar rs = (RealScalar) s;
		scalar *= rs.getValue();
		scalar = Format(scalar);
		return this;
	}

	@Override
	public Scalar neg() {
		scalar *= -1;
		return this;
	}

	@Override
	public Scalar inv() {
		scalar = 1 / scalar;
		scalar = Format(scalar);
		return this;
	}

	@Override
	public boolean equals(Scalar s) {
		return scalar == ((RealScalar) s).getValue();
	}

	public double getValue() {
		return scalar;
	}
	
	@Override
	public String toString()
	{
		return Double.toString(scalar);
	}
	

	private static double Format(double d) {

		DecimalFormat df = new DecimalFormat("#.###");
		return Double.parseDouble(df.format(d));

	}

}
