package interfaces;

import java.util.List;
import classes.Paciente;

public interface FilaNaoVacinados {
	
	int getTamanhoFilaNaoVacinados();
	List<Paciente> adicionaPacientesNaoVacinados();
	void imprimeFilaNaoVacinados();
		
}