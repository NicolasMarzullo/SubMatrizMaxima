package edu.unlam.matriz;

import org.junit.Test;

public class TestMatriz {

	@Test
	public void test() {
		int[][] valores = { { 2, 10, -4, 6 }, { -7, 5, -30, -5 }, { 1, -8, -6, 4 }, { 3, -2, 1, 6 }, { 12, 3, -15, 4 }, { 2, 3, -10, -15} };
		Matriz ma = new Matriz(valores, 6, 4);

		double coordenadas = ma.encontrarMatrizMaxima();
		
		int topeI = (int) coordenadas;	//me quedo con el entero y el decimal
		int topeJ = (int)(10*coordenadas- topeI*10);
	
		
		System.out.println("\nMatriz MAXIMA!");
		
		for (int i = 0; i <= topeI; i++) {
			for (int j = 0; j <= topeJ; j++) 
				System.out.print(valores[i][j] +"\t");
			System.out.println();
		}
	}

}
