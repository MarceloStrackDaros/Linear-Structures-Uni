package main;

import java.util.Scanner;

import ordenacao.*;
import superClasses.Array;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		Array array = null;
		
		int choice = showMenu(key);
		
		System.out.println("Informe o tamanho máximo do array:\n");
		int limit = key.nextInt();
		
		switch(choice) {
			case 1:
				System.out.println("\n***   MÉTODO SELECIONADO -> BUBBLE   ***\n");
				array = new ArrayBubble(limit);
				break;
			case 2:
				System.out.println("\n***   MÉTODO SELECIONADO -> INSERT   ***\n");
				array = new ArrayInsert(limit);
				break;
			case 3:
				System.out.println("\n***   MÉTODO SELECIONADO -> SELECT   ***\n");
				array = new ArraySelect(limit);
				break;
			default: break;
		}
		
		insertValues(key, array, limit);
		showAndSortArrayValues(array);
		
	}
	
	public static void insertValues(Scanner key, Array array, int limit) {
		for(int i = 0; i < limit; i++) {
			System.out.println("Informe o numero que deseja inserir no array:\n");
			long number = key.nextLong();
			try {
				array.insere(number);				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void showAndSortArrayValues(Array array) {
		
		try {
			//mostra array antes da ordenação
			array.mostra(); 
			
			//ordena array
			array.sort(); 
			
			//mostra array após a ordenação
			array.mostra(); 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int showMenu(Scanner key) {
		System.out.println("----------------------------------------------------------\n"
				+ "Selecione o método de ordenação que deseja utilizar:"
				+ "\n[1] - Bubble Sort"
				+ "\n[2] - Insert Sort"
				+ "\n[3] - Select Sort"
				+ "\n----------------------------------------------------------\n");
		int choice = key.nextInt();
		return choice;
	}
}
