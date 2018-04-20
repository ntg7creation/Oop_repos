package math;

import java.util.LinkedList;

public class Polynomial {

	private LinkedList<PolyTerm> equsation;

	public Polynomial() {
		equsation = new LinkedList<>();
	}

	public Polynomial add(Polynomial poly) {

		for (PolyTerm term : poly.getPoly()) {
			addTerm(term);
		}
		return this;
	}

	public void addTerm(PolyTerm term) {

		for (int index = 0; index < equsation.size(); index++) {

			PolyTerm data = equsation.get(index);

			if (term.getExponent() == data.getExponent()) {
				data.add(term);
				break;
			}
			if (term.getExponent() < data.getExponent()) {
				equsation.add(index, term);
				break;
			}
		}
	}

	public Polynomial mul(Polynomial poly) {
		Polynomial output = new Polynomial();
		
		return null;
	}
	
	public Polynomial mul(PolyTerm term)
	{
		Polynomial output = new Polynomial();
		for (PolyTerm polyTerm : equsation) {
			output.addTerm(polyTerm.mul(term));
		}
		return null;
	}


	Scalar evaluate(Scalar scalar) {
		return null;
	}

	public Polynomial derivate() {
		return null;
	}

	@Override
	public String toString() {
		return null;
	}

	public boolean equals(Polynomial poly) {
		return true;
	}

	public LinkedList<PolyTerm> getPoly() {
		return equsation;
	}
}
