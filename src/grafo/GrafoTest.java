package grafo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GrafoTest {
	Grafo g;
	
	
	@Before
	public void setUp() throws Exception{
		g = new Grafo(5);
		g.agregarArista(0, 1, 1);
		g.agregarArista(1, 2, 2);
		g.agregarArista(2, 3, 3);
		g.agregarArista(3, 0, 4);
	}
	
	
	//---------------TESTS ARISTAS-------------------//
	
	@Test
	public void agregarAristaTest() 
	{
		Grafo g = new Grafo(5); 
		g.agregarArista(0, 2, 1); 
		assertTrue(g.existeArista(0, 2, 1)); 
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaVerticeIgual()
	{
		Grafo g = new Grafo(5);
		g.agregarArista(0, 0, 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaExistenteTest() {
		
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(1, 2, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void AristaExistenteOpuestaTest() {
		
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(2, 1, 0);
		
	}
	
	@Test
	public void agregarAristaPesoNegativo() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 2, -1);
		assertTrue(grafo.existeArista(1, 2, -1));
	}

	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaFueraDeRangoSuperior()
	{
		Grafo g = new Grafo(5);
		g.agregarArista(5, 0, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaFueraDeRangoInferior()
	{
		Grafo g = new Grafo(5);
		g.agregarArista(-1, 0, 1);
	}
	
	@Test
	public void eliminarAristaTest() 
	{
		Grafo g = new Grafo(5);
		g.agregarArista(2, 1, 1);
		g.eliminarArista(2, 1,1);
		assertFalse(g.existeArista(2, 1,1));
	}

	@Test (expected=IllegalArgumentException.class)
	public void eliminarAristaInexistenteTest() {
		Grafo grafo = new Grafo(4);

		grafo.eliminarArista(2, 1,7);;
	}
	
	@Test
	public void devolverAristaMinima() {

		
		Arista aristaMinima = new Arista(0, 1, 1);
		
		Arista primeraArista = g.GetAristas().get(0);
		
		assertEquals(aristaMinima, primeraArista);
	}
	
	
	
	//---------------TESTS VERTICES-------------------//
	
	@Test
	public void cantVerticesTest() {

		assertEquals(5,g.GetVertices() );
	}
	
	@Test
	public void gradoTest()
	{

		assertEquals(2, g.grado(1));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void gradoVerticeFueraRangoSuperiorTest() {
		

		g.grado(5);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void gradoVerticeFueraRangoInferiorTest() {
		

		g.grado(-1);
	}

	@Test
	public void gradoCeroTest()
	{

		assertEquals(0, g.grado(4));
	}
	
	//---------------TESTS VECINOS-------------------//
	
	@Test
	public void cantVecinosDeTest() {
	
		assertEquals(2,g.vecinos(3).size() );
		assertEquals(0, g.vecinos(4).size());
	}
	
	@Test
	public void agregarVecinoSimetriaTest() 
	{
		Grafo g = new Grafo(5); 
		g.agregarArista(2, 1, 1); 
		assertTrue(g.existeArista(1, 2,1)); 
		assertTrue(g.existeArista(2, 1,1));
	}
	
	
	
	


}

