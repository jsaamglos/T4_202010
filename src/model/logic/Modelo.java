package model.logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.google.gson.Gson;

import model.data_structures.ListaEncadenada;
import model.data_structures.Node;
import model.data_structures.MaxPQ;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */

	private ListaEncadenada<Double, Multa> lista;
	private MaxPQ<Multa> heap;

	private PrimeraClase prClase;
	private final static String path2 = "./data/comparendos_dei_2018_small.geojson";

	private final static String path = "./data/comparendos_dei_2018.geojson";

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo() {
		heap = new MaxPQ<>();
		Gson gson = new Gson();
		lista = new ListaEncadenada<Double, Multa>();
		try {
			FileInputStream inputStream = new FileInputStream(path2);
			InputStreamReader ISReader = new InputStreamReader(inputStream);
			BufferedReader bf = new BufferedReader(ISReader);
			PrimeraClase pc = gson.fromJson(bf, PrimeraClase.class);
			prClase = pc;
			System.out.println(pc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Se crea la lista con base en los datos cargados
	 */

	public void crearLista() {
		Multa[] multas = prClase.getFeatures();
		for (Multa multa : multas) {
			agregar(multa);
		}
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo
	 * 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoLista() {
		return lista.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * 
	 * @param dato
	 */

	public void agregar(Multa dato) 
	{
		Double llave = dato.getGeometry().getCoord()[0];
		lista.agregarElemento(llave, dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * 
	 * @param dato
	 *            Dato a eliminar
	 * @return dato eliminado
	 */

	public void eliminar(Multa dato) {
		lista.eliminarElemento(dato);
	}

	public void agregarHeap(Multa m)
	{
		heap.insert(m);
	}

	public String masAlNortePorVehiculos(String tipoVehiculo, int n)
	{
		for(Node<Double, Multa> actual = lista.darPrimeraPosicion(); actual!= null; actual = actual.getSiguiente())
		{
			if(actual.getElemento().getProperties().getClaseVehiculo().equals(tipoVehiculo))
			{
				heap.insert(actual.getElemento());
			}
		}

		String respuesta = "";
		Iterator<Multa> iter = heap.iterator();
		for(int i = 0; i < n && iter.hasNext(); i++)
		{
			respuesta += iter.next() + "\n";
		}
		
		return respuesta;
	}
	
}