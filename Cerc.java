package FormeGeometrice;

public class Cerc extends Forma {

	public Cerc(String arie) {
		super(arie);
		this.nume="cerc";
	}

	@Override
	public String getNume() {
		return nume;
	}
	
	public void draw() {
		System.out.print(" " + nume);
		
	}


}
