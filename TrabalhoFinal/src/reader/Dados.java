package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import enums.Sexo;
import pessoas.GerenciadorPessoas;
import pessoas.Pessoa;

public class Dados {

	public static void gravaArquivo(List<Pessoa> pessoas) throws Exception  {
		FileWriter arq = new FileWriter("DadosPessoas.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		
		for (Pessoa pessoa1 : pessoas) {
			gravarArq.println(pessoa1.getNome() + ";" + pessoa1.getSexo() + ";" + pessoa1.getIdade() + ";" + 
					pessoa1.getPeso() + ";" + pessoa1.getAltura() + ";");
		}
	
		arq.close();
		System.out.println("Dados Gravados!");
	}
	
	public static void leArquivo(GerenciadorPessoas g1) throws Exception {
		verificaSeArquivoExiste();
		InputStream is = new FileInputStream("DadosPessoas.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		
		while (linha != null) {
			String campos [] = linha.split(";");
			
			Sexo sexo = null;
			if (campos[1] == "FEMININO") {
				sexo = Sexo.FEMININO;
			}else {
				sexo = Sexo.MASCULINO;
			}
		
			g1.adicionaPessoa(new Pessoa(campos[0],sexo,Integer.valueOf(campos[2]),Double.valueOf(campos[3]),Double.valueOf(campos[4])));
			linha = br.readLine();
		}
		
		 br.close();
	}
	
	private static boolean verificaSeArquivoExiste () throws IOException {
		boolean verificador = false;
		File arquivoPessoas = new File("DadosPessoas.txt");
		
		if (arquivoPessoas.exists()) {
			verificador = true;
		} else {
			verificador = arquivoPessoas.createNewFile();
		}
	return verificador;
	}
	
}