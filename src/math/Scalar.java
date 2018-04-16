package math;

public interface Scalar {

    public Object getValue();
    
    public Scalar add(Scalar s);

    public Scalar mul(Scalar s);

    public Scalar neg();

    public Scalar inv();

    public boolean equals(Scalar s);
}