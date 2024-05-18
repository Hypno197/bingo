package org.generation.italy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		HashSet<Integer> tabellone = new HashSet<Integer>();
		ArrayList<Integer> numCartelle = new ArrayList<Integer>();
		HashSet<Integer> scheda = new HashSet<Integer>();
		boolean cinquina = false, bingo = false;
		int[][][] cartelle = new int[10][3][5];
		int qtaCart, countbingo, countcinquina;
		ArrayList<Integer> schedarr = new ArrayList<Integer>();
		ArrayList<Integer> numeriEstratti = new ArrayList<Integer>();
		// INIZIO CODICE
		// crea tabellone
		for (int i = 1; tabellone.size() < 90; i++) {
			tabellone.add(i);
		}
		// crea collection con valori tabellone
		for (int num : tabellone)
			numCartelle.add(num);
		System.out.println("Quante cartelle vuoi giocare?");
		qtaCart = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < qtaCart; i++) {
			scheda.clear();
			do {
				scheda.add(numCartelle.get(r.nextInt(numCartelle.size())));
			} while (scheda.size() < 15);
			for (int num : scheda)
				schedarr.add(num);
			for (int j = 0; j < 3; j++) {
				for (int m = 0; m < 5; m++) {
					cartelle[i][j][m] = schedarr.remove(0);
				}

			}
		}
		System.out.println("Ecco le tue cartelle!:");
		for (int i = 0; i < qtaCart; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("| ");
				for (int m = 0; m < 5; m++) {
					System.out.print(cartelle[i][j][m] + " |");
				}
				System.out.println("");
			}
			System.out.println();
		}
//estrazione numeri
		do {
			int numeroEstratto = r.nextInt(90) + 1;
			if (tabellone.contains(numeroEstratto)) {
				tabellone.remove((Object) numeroEstratto);
				numeriEstratti.add(numeroEstratto);
				System.out.println("Il Numero Estratto è.... " + numeroEstratto + "!!");

				for (int i = 0; i < qtaCart; i++) {
					for (int j = 0; j < 3; j++) {
						for (int m = 0; m < 5; m++) {
							if (numeriEstratti.contains(cartelle[i][j][m]))
								System.out.print("*");
							System.out.print(cartelle[i][j][m] + " |");
						}
						System.out.println("");
					}
					System.out.println();
				}
				for (int i = 0; i < qtaCart; i++) {
					countbingo = 0;
					for (int j = 0; j < 3; j++) {
						countcinquina = 0;
						for (int m = 0; m < 5; m++) {
							if (numeriEstratti.contains(cartelle[i][j][m])) {
								countcinquina++;
								countbingo++;
							}
							if (countcinquina == 5 && !cinquina) {
								System.out.println("Cinquina!");
								cinquina = true;
							}
						}
						if (countbingo == 15) {
							bingo = true;
						}
					}
				}
				System.out.println();
				System.out.println("Premere invio per continuare");
				sc.nextLine();
			}
		} while (!bingo);
	}
}
