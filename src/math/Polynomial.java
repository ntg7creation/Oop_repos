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
		for (int i = 0; i < equation.length(); i++) {
			if (equation.charAt(i) == '+' | equation.charAt(i) == '-') {
				addTerm(new PolyTerm(equation.substring(pre, i), scalarField)); // this sorts the torm
				pre = i;
			}
		}
		addTerm(new PolyTerm(equation.substring(pre), scalarField));
		removeZero();
	}

	public Polynomial(LinkedList<PolyTerm> equation, char scalarField) {
		this.equation = new LinkedList<>();
		this.equation.addAll(equation);
	}

	public Polynomial add(Polynomial poly) {

		Polynomial output = new Polynomial(equation, scalarField);
		for (PolyTerm term : poly.getequation()) {
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

		for (PolyTerm polyTerm : poly.getequation()) {
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
		if(scalarField == 'q'| scalarField == 'Q')
			output = new RationalScalar("0");
		else  //(scalarField == 'r'| scalarField == 'R' )
			output = new RealScalar(0);
		for (PolyTerm polyTerm : equation) {
			output.add(polyTerm.evaluate(scalar));
		}
		return output;
	}

	public Polynomial derivate() {
		Polynomial output = new Polynomial(new LinkedList<PolyTerm>(), scalarField);
		
		return null;
	}

	@Override
	public String toString() {
		return null;
	}

	public boolean equals(Polynomial poly) {
		return true;
	}

	public LinkedList<PolyTerm> getequation() {
		return equation;
	}
	
	private void removeZero()
	{
		if(equation.getFirst().getCoefficient().equals(0))
			equation.removeFirst();
	}
}
