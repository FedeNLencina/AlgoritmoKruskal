package medicion;

import static org.junit.Assert.*;
import grafo.Grafo;
import org.junit.Test;
import bfs.BFS;

public class AleatorioTest {
	
	//------------------TEST GRAFO ALEATORIO-----------------------//
	
	@Test
	public void devuelveGrafoAleatorioValidoTest() {
		
		Grafo grafoAleatorio = Aleatorio.aleatorio(5);
		boolean esConexo = BFS.esConexo(grafoAleatorio);
		boolean masDeUnVertice = grafoAleatorio.GetVertices() > 1;
		assertTrue(esConexo && masDeUnVertice);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void grafoUnicoVerticeTest() {
		Aleatorio.aleatorio(1);
	}
	
	//------------------TEST GRAFO ALEATORIO 2-----------------------//
	@Test
	public void devuelveGrafoAleatorio2ValidoTest() {
		
		Grafo grafoAleatorio = Aleatorio.aleatorio2(5, 10);
		boolean esConexo = BFS.esConexo(grafoAleatorio);
		boolean masDeUnVertice = grafoAleatorio.GetVertices() > 1;
		assertTrue(esConexo && masDeUnVertice);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void grafoaAleatorio2UnicoVerticeTest() {
		Aleatorio.aleatorio2(1, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void grafoAleatorio2NoConexoTest() {
		Aleatorio.aleatorio2(3, 0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void grafoAleatorio2SuperaCantMaxAristasTest() {
		Aleatorio.aleatorio2(3, 4);
	}
	
	//------------TEST METODOS AUXILIARES-----------------//
	
	@Test (expected=IllegalArgumentException.class)
	public void verticeInvalidoCantMaxAristas() {
		Aleatorio.cantMaxAristas(-1);
	}
	
	@Test
	public void cantMaxAristasPosibles() {
		
		Grafo g = new Grafo(3);
		assertEquals(3, Aleatorio.cantMaxAristas(g.GetVertices()));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void tamañoCeroArregloDeGrafos() {
		Aleatorio.llenarDeGrafosAleatorios(5, 10, 0);
	}
}
