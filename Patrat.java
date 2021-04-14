package FormeGeometrice;

public class Patrat extends Forma {

	public Patrat(String arie) {
		super(arie);
		this.nume="patrat";
	}

	@Override
	public String getNume() {
		return nume;
	}

	public void draw() {
		System.out.print(" " + nume);
		
	}

	
}
