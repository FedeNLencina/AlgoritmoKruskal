package kruskal;

import grafo.Grafo;
import grafo.Arista;
import union_find.UnionFind;
import bfs.BFS;
import java.util.ArrayList;
import java.util.Set;

public class Kruskal {

	/*----------ALGORITMO DE KRUSKAL UTILIZANDO UNION FIND-------------------*/

	public static Grafo KruskalUnionFind(Grafo grafo) {

		verificarGrafo(grafo);
	
		Grafo arbolMinimo = new Grafo(grafo.GetVertices());

		@SuppressWarnings("unchecked")
		ArrayList<Arista> pendientes = (ArrayList<Arista>) grafo.GetAristas().clone();
		
		Arista arista = pendientes.get(0);
		
		arbolMinimo.agregarArista(arista.getInicial(), arista.getTerminal(), arista.getPeso());

		UnionFind.union(arbolMinimo, arista.getInicial(), arista.getTerminal());

		pendientes.remove(arista);

		int i = 1;
		
		while (i <= arbolMinimo.GetVertices() - 1 && pendientes.size() >= 1) {
			arista = pendientes.get(0);

			if (!UnionFind.find(arbolMinimo, arista.getInicial(), arista.getTerminal())) {

				arbolMinimo.agregarArista(arista.getInicial(), arista.getTerminal(), arista.getPeso());

				UnionFind.union(arbolMinimo, arista.getInicial(), arista.getTerminal());
			
				pendientes.remove(arista);
				i++;
			}
		
			pendientes.remove(arista);
		}
		return arbolMinimo;
	}

	/*----------ALGORITMO DE KRUSKAL UTILIZANDO BFS-------------------*/

	public static Grafo KruskalBFS(Grafo grafo) {

		verificarGrafo(grafo);

		Grafo arbolMinimo = new Grafo(grafo.GetVertices());

		@SuppressWarnings("unchecked")
		ArrayList<Arista> pendientes = (ArrayList<Arista>) grafo.GetAristas().clone();

		Arista arista = pendientes.get(0);
		arbolMinimo.agregarArista(arista.getInicial(), arista.getTerminal(), arista.getPeso());
		pendientes.remove(arista);

		int i = 1;
		while (i <= grafo.GetVertices() - 1 && pendientes.size() >= 1) {
			arista = pendientes.get(0);

			Set<Integer> alcanzados = BFS.alcanzables(arbolMinimo, arista.getInicial());
			if (!alcanzados.contains(arista.getTerminal())) {
				arbolMinimo.agregarArista(arista.getInicial(), arista.getTerminal(), arista.getPeso());
				i++;
			}

			pendientes.remove(arista);
		}
		return arbolMinimo;
	}

	// -----------------------METODO AUXILIAR--------------------------------------

	private static void verificarGrafo(Grafo grafo) {
		if (!BFS.esConexo(grafo))
			throw new IllegalArgumentException("El grafo no es conexo, no es posible realizar el algoritmo.");
	}
}

