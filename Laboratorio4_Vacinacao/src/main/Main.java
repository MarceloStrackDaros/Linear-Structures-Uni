package main;

import classes.Paciente;
import menu.Menu;

public class Main {

	public static void main(String[] args) {
		
		Paciente p1 = new Paciente("João", 94);
		Paciente p2 = new Paciente("Maria", 99);
		Paciente p3 = new Paciente("Lucia", 44);
		Paciente p4 = new Paciente("Lucas", 63);
		Paciente p5 = new Paciente("José", 14);
		Paciente p6 = new Paciente("Amanda", 33);
		Paciente p7 = new Paciente("Mateus", 47);
		Paciente p8 = new Paciente("Cleide", 73);
		Paciente p9 = new Paciente("Janaína", 22);
		Paciente p10 = new Paciente("Pedro", 68);
		
		Menu menu = new Menu();
		menu.iniciarProcessoVacinacao(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
		
	}
	
}