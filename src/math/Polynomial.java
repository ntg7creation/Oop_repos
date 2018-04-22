package math;

import java.util.LinkedList;

public class Polynomial {

	private char scalarField;
	private LinkedList<PolyTerm> equation;
	private Scalar zeroScalar;

	public Polynomial(String equation, char scalarField) {
		this.scalarField = scalarField;
		this.equation = new LinkedList<>();
		int pre = 0;
		for (int i = 1; i < equation.length(); i++) {
			if (equation.charAt(i) == '+' | equation.charAt(i) == '-') {
				addTerm(new PolyTerm(equation.substring(pre, i), scalarField)); // this extracts the terms
				pre = i;
			}
		}
		addTerm(new PolyTerm(equation.substring(pre), scalarField)); // the last term
		intZeroScalar();
		
		
		removeZero();
	}

	public Polynomial(LinkedList<PolyTerm> equation, char scalarField) {
		this.scalarField = scalarField;
		intZeroScalar();
		this.equation = new LinkedList<>();
		this.equation.addAll(equation);
	}
	
	private void intZeroScalar()
	{
		if (scalarField == 'q' | scalarField == 'Q')
			zeroScalar = new RationalScalar("0");
		else // (scalarField == 'r'| scalarField == 'R' )
			zeroScalar = new RealScalar(0);
	}

	public Polynomial add(Polynomial poly) {

		Polynomial output = new Polynomial(equation, scalarField);
		for (PolyTerm term : poly.getEquation()) {
			output.addTerm(term);
		}
		return output;
	}

	public void addTerm(PolyTerm term) {

		int index = 0;

		for (; index < equation.size(); index++) {

			PolyTerm data = equation.get(index);

			if (term.getExponent() == data.getExponent()) {
				data.add(term);
				break;
			}
			if (term.getExponent() < data.getExponent()) {
				equation.add(index, term);
				break;
			}
		}

		if (index == equation.size())
			equation.addLast(term);
	}

	public Polynomial mul(Polynomial poly) {

		Polynomial output = new Polynomial(equation, scalarField);

		for (PolyTerm polyTerm : poly.getEquation()) {
			output.add(this.mul(polyTerm));
		}
		return output;
	}

	public Polynomial mul(PolyTerm term) {
		Polynomial output = new Polynomial(new LinkedList<PolyTerm>(), scalarField);
		for (PolyTerm polyTerm : equation) {
			output.addTerm(polyTerm.mul(term));
		}
		return output;
	}

	public Scalar evaluate(Scalar scalar) {
		Scalar output;
		if (scalarField == 'q' | scalarField == 'Q')
			output = new RationalScalar("0");
		else // (scalarField == 'r'| scalarField == 'R' )
			output = new RealScalar(0);
		
		
		for (PolyTerm polyTerm : equation) {
			output.add(polyTerm.evaluate(scalar));
		}
		return output;
	}

	public Polynomial derivate() {
		Polynomial output = new Polynomial(new LinkedList<PolyTerm>(), scalarField);
		for (PolyTerm polyTerm : equation) {
			output.addTerm(polyTerm.derivate());
		}
		output.removeZero();
		return output;
	}

	@Override
	public String toString() {
		String output = "";
		for (PolyTerm polyTerm : equation) {
			output += polyTerm.toString();
		}

		if (output.charAt(0) == '+') {
			output = output.substring(1);
		}

		return output;
	}

	public boolean equals(Polynomial poly) {
		if (poly == null || poly.getEquation().size() != equation.size())
			return false;

		for (int i = 0; i < equation.size(); i++)
			if(!equation.get(i).equals(poly.getEquation().get(i)))
				return false;
		
		return true;
	}


	private void removeZero() {
		if (equation.getFirst().getCoefficient().equals(zeroScalar))
			equation.removeFirst();
	}

	public char getScalarField() {
		return scalarField;
	}

	public LinkedList<PolyTerm> getEquation() {
		return equation;
	}

	public Scalar getZeroScalar() {
		return zeroScalar;
	}
	
	
}
