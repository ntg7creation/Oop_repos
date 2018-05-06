package expresion;

import java.util.LinkedList;

import number.RationalScalar;
import number.RealScalar;
import number.Scalar;

/*
* Handle a Polynomial expression by holding a PolyTerm Collection
* */
public class Polynomial {

	private char scalarField;
	private LinkedList<PolyTerm> equation;

	public Polynomial(String equation, char scalarField) {
		this.scalarField = scalarField;
		this.equation = new LinkedList<>();
		int pre = 0;
		if (!equation.isEmpty()) {
			for (int i = 1; i < equation.length(); i++) {
				if (equation.charAt(i) == '+' | equation.charAt(i) == '-') {
					addTerm(new PolyTerm(equation.substring(pre, i), scalarField)); // this extracts the terms
					pre = i;
				}
			}
			addTerm(new PolyTerm(equation.substring(pre), scalarField)); // the last term
		}

		removeZero();
	}

	public Polynomial(LinkedList<PolyTerm> equation, char scalarField) {
		this.scalarField = scalarField;
		this.equation = new LinkedList<>();
		this.equation.addAll(equation);
	}

	public Polynomial add(Polynomial poly) {
		Polynomial output = new Polynomial(equation, scalarField);
		for (PolyTerm term : poly.getEquation()) {
			output.addTerm(term);
		}
		output.removeZero();
		return output;
	}

	//addes 1 term to the current polynom this also makes the list in order by the exponent 
	private void addTerm(PolyTerm term) {

		if (term == null) // check
			return;
		int index = 0;

		for (; index < equation.size(); index++) {

			PolyTerm data = equation.get(index);

			if (term.compareTo(data) == 0) {
				equation.set(index, data.add(term));
				break;
			}
			if (term.compareTo(data) > 0) {
				equation.add(index, term);
				break;
			}
		}

		if (index == equation.size())
			equation.addLast(term);
	}

	//for each term in this polynom multiply it by a term in the other poly and return the result 
	public Polynomial mul(Polynomial poly) {

		Polynomial output = new Polynomial(new LinkedList<PolyTerm>(), scalarField);
		for (PolyTerm polyTerm : poly.getEquation()) {
			output = output.add(this.mul(polyTerm));
		}
		return output;
	}

	//Multiply 1 term and this polynomial and return the result
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
			output = output.add(polyTerm.evaluate(scalar));
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
		
		if (equation.isEmpty())
			output = "0";
		
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
			if (!equation.get(i).equals(poly.getEquation().get(i)))
				return false;

		return true;
	}

	//check if we have a zero * x as 1 of the term and removes it
	private void removeZero() {
		for (int i = 0; i < equation.size(); i++) {
			if(equation.get(i).isZero())
				equation.remove(i);
		}
	}

	public char getScalarField() {
		return scalarField;
	}

	public LinkedList<PolyTerm> getEquation() {
		return equation;
	}

}
