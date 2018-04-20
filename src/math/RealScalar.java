package math;

import java.text.DecimalFormat;

public class RealScalar implements Scalar {

	private double scalar;

	public RealScalar(double scalar)
	{
		this.scalar = scalar;
		Format(scalar);
	}
	
	public RealScalar(String scalar) {
		this.scalar = Double.parseDouble(scalar);
	}

	@Override
	public Scalar add(Scalar s) {
		RealScalar rs = (RealScalar) s;
		RealScalar output = new RealScalar(scalar + rs.getValue());
		return output;

	}

	@Override
	public Scalar mul(Scalar s) {
		RealScalar rs = (RealScalar) s;
		RealScalar output = new RealScalar (scalar * rs.getValue());
		return output;
	}

	@Override
	public Scalar neg() {
		RealScalar output = new RealScalar (scalar * -1);
		return output;
	}

	@Override
	public Scalar inv() {
		RealScalar output = new RealScalar (1 / scalar);
		return output;
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
