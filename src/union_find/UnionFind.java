package union_find;

import grafo.Grafo;

public class UnionFind {

	
	private static int root(Grafo g,int i) {
		while (g.GetCompConexas()[i] != i) {
			i = g.GetCompConexas()[i];
		}
		return i;
			
	}
	
	public static boolean find(Grafo g, int i, int j) {
		return root(g, i) == root(g, j);
	}
	
	public static void union(Grafo g, int i, int j) {
		int ri = root(g, i);
		int rj = root(g, j);
		
		g.GetCompConexas()[ri] = rj;
	}
}
