package edu.unlam.matriz;

public class Matriz {

	private int[][] valores;
	private int filas;
	private int columnas;

	public Matriz(int[][] valores, int filas, int columnas) {
		this.valores = valores;
		this.filas = filas;
		this.columnas = columnas;
	}

	/* devuelve un x,y que representa el valor de i,j de la posicion inferior derecha
	 * de la matriz maxima
	 */
	
	public double encontrarMatrizMaxima() {
		int[][] matAux = new int[this.filas][this.columnas];
		int i = 0, j = 1, valorMaximo;
		double iADevolver, jADevolver;
		/*
		 * se usa programacion dinamica para resolver el anidamiento de for y reducir la
		 * complejidad computacional
		 */

		matAux[0][0] = this.valores[0][0]; // guardo el primer valor

		// Cargo la matriz auxiliar con la suma de todas las combinaciones posibles

		// primer fila
		for (; j < this.columnas; j++)
			matAux[i][j] += this.valores[i][j] + matAux[i][j - 1];

		// primer columna
		j = 0;
		for (i = 1; i < this.filas; i++)
			matAux[i][j] += this.valores[i][j] + matAux[i - 1][j];

		for (i = 1; i < this.filas; i++)
			for (j = 1; j < this.columnas; j++)
				matAux[i][j] += this.valores[i][j] + matAux[i - 1][j] + matAux[i][j - 1] - matAux[i - 1][j - 1];

		// busco el mayor
		valorMaximo = matAux[0][0];
		iADevolver = i;
		jADevolver = j;
		for (i = 0; i < this.filas; i++) {
			for (j = 0; j < this.columnas; j++) {
				if (matAux[i][j] > valorMaximo) {
					valorMaximo = matAux[i][j];
					iADevolver = i;
					jADevolver = j;
				}
			}
		}
		
		System.out.println("----------MOSTRANDO MATRIZ----------------");
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 4; j++) 
				System.out.print(matAux[i][j] +"\t");
			System.out.println();
		}
		
		
		return iADevolver + jADevolver/10;
	}

}
