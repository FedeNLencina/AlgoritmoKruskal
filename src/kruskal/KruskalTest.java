package kruskal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import bfs.BFS;
import grafo.Arista;
import grafo.Grafo;

public class KruskalTest {
	/* 		
	 *         GRAFO EJEMPLO
	 * 
	 *     1----------2---------3
	 *    /|        /   \       |\
	 *   / |       /     \      | \
	 *  /  |      /       \     |  \
	 * 0   |     8         \    |   4
	 *  \  |   /  \         \   |  /
	 *   \ |  /    \         \  | /
	 *    \| /      \         \ |/
	 *     7----------6---------5
	 * 
	 *    ARBOL GENERADOR MINIMO
	 *               
	 *         (8)       (6)
	 *     1-----------2--------3
	 *    /          /   \       \
	 *(4)/       (3)/     \       \(9)
	 *  /          /       \       \
	 * 0          8         \(4)    4
	 * 				         \	     
	 *                        \        
	 *     7----------6--------5
	 *         (1)        (3)		
	 */
	
	//----------------------------INICIALIZACION DE GRAFOS-----------------------------//
	Grafo grafo;
	
	@Before
	public void setUp() throws Exception{
		grafo = new Grafo(9);
		grafo.agregarArista(0, 1, 4); 
		grafo.agregarArista(1, 2, 8); 
		grafo.agregarArista(2, 3, 6); 
		grafo.agregarArista(3, 4, 9); 
		grafo.agregarArista(4, 5, 10); 
		grafo.agregarArista(5, 6, 3); 
		grafo.agregarArista(6, 7, 1); 
		grafo.agregarArista(7, 8, 6); 
		grafo.agregarArista(7, 0, 8);
		grafo.agregarArista(6, 8, 5);
		grafo.agregarArista(8, 2, 3); 
		grafo.agregarArista(1, 7, 12); 
		grafo.agregarArista(2, 5, 4); 
		grafo.agregarArista(3, 5, 13); 
	}

	private Grafo grafoEjemploKruskalBFS() {
		return Kruskal.KruskalBFS(grafo);
	}

	private Grafo grafoEjemploKruskalUnionFind() {

		return Kruskal.KruskalUnionFind(grafo);
	}

	// ------------------------------TESTS---------------------------------//

	@Test
	public void conexoBFStest() {

		assertTrue(BFS.esConexo(grafoEjemploKruskalBFS()));
	}

	@Test
	public void conexoUnionFindtest() {

		assertTrue(BFS.esConexo(grafoEjemploKruskalUnionFind()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void AGMgrafoNoConexoBFS() {

		Grafo grafoNoConexo = new Grafo(3);
		grafoNoConexo.agregarArista(0, 1, 2);
		Kruskal.KruskalBFS(grafoNoConexo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void AGMgrafoNoConexoUnionFind() {

		Grafo grafoNoConexo = new Grafo(3);
		grafoNoConexo.agregarArista(0, 1, 2);
		Kruskal.KruskalBFS(grafoNoConexo);
	}

	public void AGMgrafoUnicoVerticeBFS() {
		Grafo grafoUnVertice = new Grafo(1);
		Grafo grafo = Kruskal.KruskalBFS(grafoUnVertice);
		assertEquals(grafoUnVertice, grafo);
	}

	public void AGMgrafoUnicoVerticeUnionFind() {
		Grafo grafoUnVertice = new Grafo(1);
		Grafo grafo = Kruskal.KruskalUnionFind(grafoUnVertice);
		assertEquals(grafoUnVertice, grafo);
	}

	@Test
	public void conexoSinCiclosTest() {

		Grafo gKruskalBFS = grafoEjemploKruskalBFS();
		Grafo gKruskalUnionFind = grafoEjemploKruskalUnionFind();

		int CantAristasBFS = gKruskalBFS.GetAristas().size();
		int CantAristasUF = gKruskalUnionFind.GetAristas().size();

		assertTrue(BFS.esConexo(gKruskalBFS) && (CantAristasBFS == gKruskalBFS.GetVertices() - 1));
		assertTrue(BFS.esConexo(gKruskalUnionFind) && (CantAristasUF == gKruskalUnionFind.GetVertices() - 1));
	}
	
	@Test
	public void ArbolUnicoCaminoBFS() {
		
		Grafo grafoUnicoCamino = new Grafo(4);
		grafoUnicoCamino.agregarArista(0, 1, 2);
		grafoUnicoCamino.agregarArista(1, 2, 3);
		grafoUnicoCamino.agregarArista(2, 3, 1);
		
		assertEquals(grafoUnicoCamino, Kruskal.KruskalBFS(grafoUnicoCamino));
	}
	
	@Test
	public void ArbolUnicoCaminoUnionFind() {
		
		Grafo grafoUnicoCamino = new Grafo(4);
		grafoUnicoCamino.agregarArista(0, 1, 2);
		grafoUnicoCamino.agregarArista(1, 2, 3);
		grafoUnicoCamino.agregarArista(2, 3, 1);
		
		assertEquals(grafoUnicoCamino, Kruskal.KruskalUnionFind(grafoUnicoCamino));
	}

	@Test
	public void generarArbolMinimoBFStest() {

		Grafo arbolMinimo = new Grafo(9);
		arbolMinimo.agregarArista(6, 7, 1);
		arbolMinimo.agregarArista(5, 6, 3);
		arbolMinimo.agregarArista(8, 2, 3);
		arbolMinimo.agregarArista(0, 1, 4);
		arbolMinimo.agregarArista(2, 5, 4);
		arbolMinimo.agregarArista(2, 3, 6);
		arbolMinimo.agregarArista(1, 2, 8);
		arbolMinimo.agregarArista(3, 4, 9);

		Grafo gKruskalBFS = grafoEjemploKruskalBFS();

		boolean sonIguales = true;
		for (int i = 0; i < gKruskalBFS.GetAristas().size(); i++) {

			Arista caminoMinimo = arbolMinimo.GetAristas().get(i);
			if (!gKruskalBFS.GetAristas().get(i).equals(caminoMinimo)) {
				sonIguales = false;
				break;
			}
		}
		assertEquals(true, sonIguales);
		assertEquals(gKruskalBFS.GetAristas(), arbolMinimo.GetAristas());

	}

	@Test
	public void generarArbolMinimoUnionFindtest() {

		Grafo arbolMinimo = new Grafo(9);
		arbolMinimo.agregarArista(6, 7, 1);
		arbolMinimo.agregarArista(5, 6, 3);
		arbolMinimo.agregarArista(8, 2, 3);
		arbolMinimo.agregarArista(0, 1, 4);
		arbolMinimo.agregarArista(2, 5, 4);
		arbolMinimo.agregarArista(2, 3, 6);
		arbolMinimo.agregarArista(1, 2, 8);
		arbolMinimo.agregarArista(3, 4, 9);

		Grafo gKruskalUF = grafoEjemploKruskalUnionFind();

		boolean sonIguales = true;
		for (int i = 0; i < gKruskalUF.GetAristas().size(); i++) {

			Arista caminoMinimo = arbolMinimo.GetAristas().get(i);
			if (!gKruskalUF.GetAristas().get(i).equals(caminoMinimo)) {
				sonIguales = false;
				break;
			}
		}
		assertEquals(true, sonIguales);
		assertEquals(gKruskalUF.GetAristas(), arbolMinimo.GetAristas());
	}
	


}
