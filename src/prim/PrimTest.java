package prim;

import static org.junit.Assert.*;

import org.junit.Test;

import bfs.BFS;
import grafo.Arista;
import grafo.Grafo;

public class PrimTest {

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
	private Grafo grafoEjemplo() {
		Grafo grafo = new Grafo(9);
		grafo.agregarArista(0, 1, 4); // AB 4
		grafo.agregarArista(1, 2, 8); // BC 8
		grafo.agregarArista(2, 3, 6); // CD 6
		grafo.agregarArista(3, 4, 9); // DE 9
		grafo.agregarArista(4, 5, 10); // EF 10
		grafo.agregarArista(5, 6, 3); // FG 3
		grafo.agregarArista(6, 7, 1); // GH 1
		grafo.agregarArista(7, 8, 6); // HI 6
		grafo.agregarArista(7, 0, 8); // HA 8
		grafo.agregarArista(6, 8, 5); // GI 5
		grafo.agregarArista(8, 2, 3); // IC 3
		grafo.agregarArista(1, 7, 12); // BH 12
		grafo.agregarArista(2, 5, 4); // CF 4
		grafo.agregarArista(3, 5, 13); // DF 13

		return grafo;

	}
	
	@Test
	public void conexotest() {

		assertTrue(BFS.esConexo(grafoEjemplo()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void AGMgrafoNoConexo() {

		Grafo grafoNoConexo = new Grafo(3);
		grafoNoConexo.agregarArista(0, 1, 2);
		Prim.prim(grafoNoConexo);
	}
	
	@Test
	public void AGMgrafoUnicoVertice() {
		Grafo grafoUnVertice = new Grafo(1);
		Grafo grafoPrim = Prim.prim(grafoUnVertice);
		assertEquals(grafoUnVertice, grafoPrim);
	}
	
	@Test
	public void ArbolUnicoCamino() {
		
		Grafo grafoUnicoCamino = new Grafo(3);
		grafoUnicoCamino.agregarArista(0, 1, 1);
		grafoUnicoCamino.agregarArista(1, 2, 2);
		
		assertEquals(grafoUnicoCamino, Prim.prim(grafoUnicoCamino));
	}
	
	@Test
	public void generarArbolMinimotest() {

		Grafo arbolMinimo = new Grafo(9);
		arbolMinimo.agregarArista(6, 7, 1);
		arbolMinimo.agregarArista(5, 6, 3);
		arbolMinimo.agregarArista(8, 2, 3);
		arbolMinimo.agregarArista(0, 1, 4);
		arbolMinimo.agregarArista(2, 5, 4);
		arbolMinimo.agregarArista(2, 3, 6);
		arbolMinimo.agregarArista(1, 2, 8);
		arbolMinimo.agregarArista(3, 4, 9);

		Grafo g = Prim.prim(grafoEjemplo());
		boolean mismasAristas = true;
		for (int i = 0; i < g.GetAristas().size(); i++) {
			Arista arista = g.GetAristas().get(i);
			if (!arbolMinimo.existeArista(arista.getInicial(), arista.getTerminal(), arista.getPeso())) {
				mismasAristas=false;
			}
		}
		assertEquals(true, mismasAristas);
		assertEquals(g.GetVertices(), arbolMinimo.GetVertices());
	}

}
