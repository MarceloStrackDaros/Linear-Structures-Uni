package menu;

import static org.junit.Assert.*;
import org.junit.Test;
import classes.Paciente;
import menu.Menu;

public class MenuTest { //Testa o programa como se estivesse rodando normalmente

	private Menu menu = new Menu();
	Paciente p1 = new Paciente("Lucas", 27);
	Paciente p2 = new Paciente("Marta", 33);
	Paciente p3 = new Paciente("José", 96);
	Paciente p4 = new Paciente("Lucia", 61);
	Paciente p5 = new Paciente("Amanda", 14);
	
	@Test
	public void testIniciarProcessoVacinacao() {
		menu.iniciarProcessoVacinacao(p1, p2, p3, p4, p5);
	}
	
}