package main;

import candidatos.Candidato;
import votacao.Menu;

public class Main {
	public static void main(String[] args) {
		Candidato c1 = new Candidato("Amanda", 36, "PSOL", "111");
		Candidato c2 = new Candidato("Paulo", 52, "PSDB", "222");
		Candidato c3 = new Candidato("Joana", 41, "NOVO", "333");

		Menu menu = new Menu();
		menu.iniciarEleicoes(c1, c2, c3);
	}
}
