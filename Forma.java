package FormeGeometrice;

import abstractions.IGraficElement;

public abstract class Forma implements IGraficElement {
	String nume;
	String arie;
	Forma(String arie){
		this.arie=arie;
	}
	public String getArie() {
		return arie;
	}
	public void setArie(String arie) {
		this.arie = arie;
	}
	public abstract String getNume() ;
	

}
