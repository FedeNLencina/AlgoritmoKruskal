package medicion;

import grafo.Grafo;
import kruskal.Kruskal;
import prim.Prim;

public class Tiempo {
	
	private Grafo grafo;
	private static long tiempoInicial;
	private static long tiempoFinal;

	public Tiempo(Grafo g) {
		grafo = g;
	}

	public void resolverKruskalUnionFind() {
		tiempoInicial = System.currentTimeMillis();

		Kruskal.KruskalUnionFind(grafo);

		tiempoFinal = System.currentTimeMillis();

	}

	public void resolverKruskalBFS() {
		tiempoInicial = System.currentTimeMillis();

		Kruskal.KruskalBFS(grafo);

		tiempoFinal = System.currentTimeMillis();

	}
	
	public void resolverPrim() {
		tiempoInicial = System.currentTimeMillis();

		Prim.prim(grafo);

		tiempoFinal = System.currentTimeMillis();

	}

	public static double darTiempo() {
		return ((tiempoFinal - tiempoInicial));
	}

	

}
