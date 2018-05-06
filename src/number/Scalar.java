package number;

/*
* Specifying what a Scalar should do
* */
public interface Scalar {

	// Add a scalar to this scalar
	public Scalar add(Scalar s);

	// Multiply a scalar with this scalar
	public Scalar mul(Scalar s);

	// Negate this scalar
	public Scalar neg();

	// Inverse this scalar
	public Scalar inv();

	// Return whether or not this scalar equals to input scalar
	public boolean equals(Scalar s);

	// Return whether or not this scalar is zero
	public boolean isZero();

	// Return a meaningful string
	public String toString();
}
