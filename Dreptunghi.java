package FormeGeometrice;

public class Dreptunghi extends Forma {

	public Dreptunghi(String arie) {
		super(arie);
		this.nume="dreptunghi";
	}

	@Override
	public String getNume() {
		return nume;
	}
	
	public void draw() {
		System.out.print(" " + nume);
		
	}

}