package sample;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import FormeGeometrice.*;
import abstractions.IGraficElement;
import abstractions.IMenuItem;
import implementations.Menu;
import implementations.MenuItem;

public class ApplicationMenu{
	private Scanner consoleScanner = new Scanner(System.in);
	private PlansaDeLucru plansa = new PlansaDeLucru();
	
    private Menu mainMenu = null;
    public ApplicationMenu()
    {
                 
    }
	
    public void load()
    {
        
        ArrayList<IMenuItem> menuItems = new ArrayList();
        
        int shortCut = 1;    
        
         
       IMenuItem currentItem = new MenuItem("Adauga forma", shortCut++, (parameters)->{
           uiAddElement();
       });       
       menuItems.add(currentItem);
       
       currentItem = new MenuItem("Sterge forma", shortCut++, (parameters)->{
    	   	uiDeleteElement();
       });       
       menuItems.add(currentItem); 
       
       currentItem = new MenuItem("Modifica forma", shortCut++, (parameters)->{
   	   	uiModifyElements();
      });       
      menuItems.add(currentItem);
      
      currentItem = new MenuItem("Vizualizare plansa de lucru", shortCut++, (parameters)->{
  	   	uiViewElements();
     });       
     menuItems.add(currentItem);
       
        mainMenu = new Menu("Main Menu", -1, menuItems);
        
    }
    
    public void execute()
    {
        mainMenu.execute();
    }
    
	private void uiViewElements() {
		
		System.out.println("Vizualizare plansa ");
		
		plansa.draw();
		
		System.out.println("\n\n");
	}

	private void uiDeleteElement() {
		System.out.println("Ce id are plansa de lucru de unde doriti sa o stergeti un element?");
		plansa.afisareId();
		int id = consoleScanner.nextInt();
		
		PlansaDeLucru plansaTemporara = plansa.cautareId(id);
		System.out.println("Ce id are elementul pe care doriti sa il stergeti?");
		
		int i=0;
		for(IGraficElement elGrf:plansaTemporara.elemente) {
			System.out.println(i + " ");
			elGrf.draw();
			i++;
		}
		
		System.out.println("Alegeti id-ul elementului: ");
		int el = consoleScanner.nextInt();
		plansaTemporara.elemente.remove(el);
	}

	private void uiModifyElements() {
		System.out.println("Ce id are plansa de lucru unde doriti sa modificati aria elementelor");
		plansa.afisareId();
		int id = consoleScanner.nextInt();
		System.out.println("Ce arie doriti sa modificati?");
		String el = consoleScanner.next();
		PlansaDeLucru plansaTemporara = plansa.cautareId(id);
		for(IGraficElement elGrf:plansaTemporara.elemente)
		{
			if(elGrf instanceof Forma) {
				((Forma) elGrf).setArie(el);
			}
		}
		
	}

	private void uiAddElement() {
		System.out.println("Ce id are plansa de lucru unde doriti sa adaugati elementul");
		plansa.afisareId();
		int id = consoleScanner.nextInt();
		System.out.println("Ce element doriti sa introduceti?\n1.Patrat\n2.Dreptungi\n3.Triunghi\n4.Cerc\n5.Plansa de lucru");
		int el =consoleScanner.nextInt() ;
		switch(el)
		{
		case 1:
			System.out.println("S-a creat un nou cerc");
			plansa.cautareId(id).addElement(new Cerc("25m^2"));
			break;
		case 2:
			System.out.println("S-a creat un nou dreptunghi");
			plansa.cautareId(id).addElement(new Dreptunghi("25m^2"));
			break;
		case 3:
			System.out.println("S-a creat un nou triunghi");
			plansa.cautareId(id).addElement(new Triunghi("25m^2"));
			break;
		case 4:
			System.out.println("S-a creat un nou patrat");
			plansa.cautareId(id).addElement(new Patrat("25m^2"));
			break;
		case 5:
			System.out.println("S-a creat o noua plansa de lucru");
			plansa.cautareId(id).addElement(new PlansaDeLucru());
			break;
		default:
			System.out.println("Nu s-a creat nici-un obiect.");
			break;
		}
	}
    
}