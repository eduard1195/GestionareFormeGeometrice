package FormeGeometrice;

import java.util.ArrayList;

import abstractions.IGraficElement;


public class PlansaDeLucru implements IGraficElement{
	public ArrayList<IGraficElement> elemente = new ArrayList<IGraficElement>();
	
	static int id = 0;
    int idPlansa;
	
	public PlansaDeLucru(){
		this.idPlansa=id;
		id++;
	}
	
	public void addElement(IGraficElement e) {
		elemente.add(e);
	}

	@Override
	public void draw() {
		System.out.println("\nPlansa de lucru, id= " + idPlansa + " :");
		for(IGraficElement elGrafic : elemente) {
			elGrafic.draw();
		}
		
	}
	
	public void afisareId() {
		System.out.println("Plansa id= " + idPlansa + " :");
		try {
			
		
		for(IGraficElement elGrafic : elemente) {
			if(elGrafic instanceof PlansaDeLucru)
			{
				System.out.println(">>");
				elGrafic.draw();
			}
		}
		}catch(Exception e) {
			
		}
	}
	
	public PlansaDeLucru cautareId(int id, ArrayList<IGraficElement> elemente)
	{
		try {
		for(IGraficElement elGrafic : elemente) {
			if(elGrafic instanceof PlansaDeLucru)
			{
				if(((PlansaDeLucru) elGrafic).idPlansa==id) {
					return (PlansaDeLucru) elGrafic;
				}
				else {
					PlansaDeLucru plansa = cautareId(id, ((PlansaDeLucru) elGrafic).elemente);
					
					if(plansa != null )
						return plansa;
				}
				elGrafic.draw();
			}
		}
		}catch(Exception e) {
			
		}
		return null;
	}
	
	public PlansaDeLucru cautareId(int id) {
		if(this.idPlansa==id) {
			return this;
		}
		return cautareId(id,elemente);
	}

}
