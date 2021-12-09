package bfs;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import grafo.Grafo;

public class BFSTest {
	Grafo g;
	
	
	@Before
	public void setUp() throws Exception{
		g = new Grafo(5);
		g.agregarArista(0, 1, 1);
		g.agregarArista(0, 2, 2);
		g.agregarArista(2, 3, 3);
		
	}

	@Test (expected=IllegalArgumentException.class)
	public void grafoNullTest() 
	{
		BFS.esConexo(null);
	}
	
	@Test
	public void grafoNoConexoTest()
	{

		assertFalse(BFS.esConexo(g));
	}
	
	@Test
	public void grafoVacioTest()
	{
		 g = new Grafo(0);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void grafoConexoTest()
	{
		
		g.agregarArista(3, 4, 1);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void alcanzablesTest()
	{
	
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		
		int[] esperado = {0, 1, 2, 3};
		Assert.iguales(esperado, alcanzables);
	}
	
	@Test
	public void alcanzablesTodosTest()
	{
	
		g.agregarArista(3, 4, 1);
		
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		
		int[] esperado = {0, 1, 2, 3, 4};
		Assert.iguales(esperado, alcanzables);
	}
	
	@Test
	public void alcanzablesNingunoTest()
	{
	
		
		Set<Integer> alcanzables = BFS.alcanzables(g, 4);
		
		int[] esperado = {4};
		Assert.iguales(esperado, alcanzables);
	}

}
