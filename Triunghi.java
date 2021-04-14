package FormeGeometrice;

public class Triunghi extends Forma {

	public Triunghi(String arie) {
		super(arie);
		this.nume="triunghi";
	}

	@Override
	public String getNume() {
		return nume;
	}
	
	public void draw() {
		System.out.print(" " + nume);
		
	}

}
