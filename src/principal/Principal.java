package principal;

import medicion.Aleatorio;
import medicion.TiempoStress;


public class Principal {

	public static void main(String[] args)
	{	
	
		//Aleatorio 2
		
			
		for (int i = 100; i <= 2000; i= i + 100) {
			TiempoStress.generarGrafosKruskalBFS(i, i*2, 50);
			System.out.println();
			System.out.println();
			TiempoStress.generarGrafosKruskalUnionFind(i, i*2, 50);
			System.out.println();
			System.out.println();
			TiempoStress.generarGrafosPrim(i, i*2, 50);
			System.out.println();
			System.out.println();
	}
		

		for (int i = 10; i <= 200; i = i + 10) {
			TiempoStress.generarGrafosKruskalBFS(i, Aleatorio.cantMaxAristas(i), 50);
			System.out.println();
			System.out.println();
			TiempoStress.generarGrafosKruskalUnionFind(i, Aleatorio.cantMaxAristas(i), 50);
			System.out.println();
			System.out.println();
			TiempoStress.generarGrafosPrim(i, Aleatorio.cantMaxAristas(i), 50);
			System.out.println();
			System.out.println();
		}
	
//		//Aleatorio 1
		
		
		for (int i = 100; i <= 2000; i = i + 100) {
			TiempoStress.generarGrafosKruskalBFS(i, 50);
			System.out.println();
			System.out.println();
			TiempoStress.generarGrafosKruskalUnionFind(i, 50);
			System.out.println();
			System.out.println();
			TiempoStress.generarGrafosPrim(i, 50);
			System.out.println();
			System.out.println();
		}


		for (int i = 10; i <= 200; i = i + 10) {
			TiempoStress.generarGrafosKruskalBFS(i, 50);
			System.out.println();
			System.out.println();
			TiempoStress.generarGrafosKruskalUnionFind(i, 50);
			System.out.println();
			System.out.println();
			TiempoStress.generarGrafosPrim(i, 50);
			System.out.println();
			System.out.println();
		}

		TiempoStress.generarGrafosKruskalBFS_Prueba(10, 50);
	}

}
