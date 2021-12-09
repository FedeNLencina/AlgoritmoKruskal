package medicion;

import java.util.ArrayList;
import java.util.Random;
import bfs.BFS;
import grafo.Grafo;

public class Aleatorio {

	// -----------GENERACION GRAFO ALEATORIO--------------------------//
	public static Grafo aleatorio(int n) {
		
		if (n == 1)
			throw new IllegalArgumentException("No se pueden agregar aristas a un grafo de un unico vertice: " + n);

		Random random = new Random(0);
		Grafo grafo = new Grafo(n);
		
		for (int m = 0; m < n-1; m++) {
			grafo.agregarArista(m, m+1, getRandom(n));
		}
		
		for (int i = 0; i < n; i++)

			for (int j = i + 1; j < n; j++)
				
				if (random.nextFloat() < 0.1 && !grafo.existeArista(i, j, n)) 
					
					grafo.agregarArista(i, j, getRandom(n));
				
		if(BFS.esConexo(grafo))
			return grafo;
		
		return aleatorio(n);
	}

	// -----------GENERACION NUMERO ALEATORIO 2--------------------------//

	public static Grafo aleatorio2(int n, int m) {

		if (n == 1)
			throw new IllegalArgumentException("No se pueden agregar aristas a un grafo de un nico vrtice: " + n);

		if (m < n - 1)
			throw new IllegalArgumentException("No es posible crear un grafo conexo.");

		if (m > cantMaxAristas(n))
			throw new IllegalArgumentException("El grafo no puede tener ms de " + cantMaxAristas(n) + " aristas.");

		Grafo grafo = new Grafo(n);

		
		for (int i = 0; i < n-1; i++) {
			grafo.agregarArista(i, i+1, getRandom(n));
		}
		
		int i = 0;
		int aristasFaltantes = m - grafo.GetAristas().size();
		while (aristasFaltantes > i) {
			int n1 = (int) (Math.random() * n);
			int n2 = (int) (Math.random() * n);
			float n3 = getRandom(n);

			if ((n1 != n2) && !grafo.existeArista(n1, n2,n3)) {
				grafo.agregarArista(n1, n2, n3);
				i = i + 1;
			}
		}
		
		return grafo;

		

	}

	// -----------METODOS AUXILIARES--------------------------//
	
	public static ArrayList<Grafo> llenarDeGrafosAleatorios(int vertices, int aristas, int tamao) {
		
		if(tamao == 0)
			throw new IllegalArgumentException("Debe de haber al menos un grafo en la lista: " + tamao);
		
		ArrayList<Grafo> listaGrafosAleatorios = new ArrayList<Grafo>(tamao);
		for (int i = 0; i < tamao; i++) {

			listaGrafosAleatorios.add(aleatorio2(vertices, aristas));

		}
		return listaGrafosAleatorios;
	}
	public static ArrayList<Grafo> llenarDeGrafosAleatorios(int vertices, int tamao) {
		
		if(tamao == 0)
			throw new IllegalArgumentException("Debe de haber al menos un grafo en la lista: " + tamao);
		
		ArrayList<Grafo> listaGrafosAleatorios = new ArrayList<Grafo>(tamao);
		for (int i = 0; i < tamao; i++) {

			listaGrafosAleatorios.add(aleatorio(vertices));

		}
		return listaGrafosAleatorios;
	}
	
	public static int cantMaxAristas(int n) {
		if(n < 0)
			throw new IllegalArgumentException("la cantidad de vertices debe ser mayor o igual a 0: " + n);
		return n * (n - 1) / 2;
	}
	
	
	private static float getRandom(int n) {
		float scale = (float) Math.pow(10, 1);
		float pesoAleatorio = Math.round(((float) Math.random() * n + 1) * scale) / scale;

		return pesoAleatorio;
	}
	
	public static void main(String[] args) {
		Grafo g = aleatorio2(5,10);
		System.out.println(g.GetAristas());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
