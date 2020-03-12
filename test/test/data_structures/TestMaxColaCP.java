package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.MaxPQ;

public class TestMaxColaCP {

	private MaxColaCP<Integer> colaPriority;
	private static int TAMANO = 50;

	@Before
	public void setUp1() {
		colaPriority = new MaxPQ<Integer>(TAMANO);
	}

	public void setUp2() {
		colaPriority = new MaxColaCP<Integer>();
		pQueue.add(10);
		pQueue.add(30);
		pQueue.add(20);
		pQueue.add(400);
	}

	@Test
	public void testContains() {
		setUp2();
		int x = 84;
		assertTrue(colaPriority.contains(20));

	}

	@Test
	public void testTamaño() {
		setUp2();
		assertTrue(colaPriority.size() == 4);
		setUp1();
		assertTrue(colaPriority.size() == 50);
	}

	@Test
	public void estaVacia() {
		assertTrue(colaPriority.isEmpty());

	}

}
