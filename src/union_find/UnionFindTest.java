package union_find;

import static org.junit.Assert.*;

import org.junit.Test;

import grafo.Grafo;

public class UnionFindTest {
	
	@Test
	public void MismaComponenteConexaTest() {
		Grafo g = new Grafo(3);
		
		g.agregarArista(0, 1, 1);
		g.agregarArista(1, 2, 0);
		UnionFind.union(g, 1, 2);
		UnionFind.union(g, 0, 1);
		
		assertTrue(UnionFind.find(g, 1, 2));
		
	}
	
	@Test
	public void DiferenteComponenteConexaTest() {
		Grafo g = new Grafo(5);
		
		g.agregarArista(0, 1, 0);
		g.agregarArista(1, 2, 0);
		g.agregarArista(3, 4, 0);
		UnionFind.union(g, 1, 2);
		UnionFind.union(g, 0, 1);
		UnionFind.union(g, 3, 4);
		
		assertFalse(UnionFind.find(g, 4, 0));
		
	}

}
