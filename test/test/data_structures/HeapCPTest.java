package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.MaxPQ;

public class HeapCPTest {

	private MaxPQ<Integer> colaPrioridadHeap;
	private static int TAMANO = 50;

	@Before
	public void setUp1() {
		colaPrioridadHeap = new MaxPQ<Integer>(TAMANO);
	}

	public void setUp2() {
		colaPrioridadHeap = new MaxPQ<Integer>(15);
		colaPrioridadHeap.insert(5);
		colaPrioridadHeap.insert(3);
		colaPrioridadHeap.insert(17);
		colaPrioridadHeap.insert(10);
		colaPrioridadHeap.insert(84);
		colaPrioridadHeap.insert(19);
		colaPrioridadHeap.insert(6);
		colaPrioridadHeap.insert(22);
		colaPrioridadHeap.insert(9);
	}

	@Test
	public void testMaxHeap() {
		setUp2();
		int x = 84;
		assertTrue(x == colaPrioridadHeap.max());
	}

	@Test
	public void testTamaño() {
		setUp2();
		assertTrue(colaPrioridadHeap.size() == 15);
		setUp1();
		assertTrue(colaPrioridadHeap.size() == 50);
	}

	@Test
	public void estaVacia() {
		setUp2();
		assertFalse(colaPrioridadHeap.isEmpty());

	}

}
