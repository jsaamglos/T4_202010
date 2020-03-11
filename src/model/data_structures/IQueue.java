package model.data_structures;

public interface IQueue <T> {

	/**
	 * Retorna el numero de elementos en la fila
	 * @return numero total de elementos.
	 */
	public int size();
	
	/**
	 * Muestra si la fila esta vacia.
	 * @return Verdadero si esta vacia, falso de lo contrario.
	 */
	public boolean isEmpty();
	
	/**
	 * A�ade un elemento al final de la fila.
	 * @param dato Elemento a a�adir en la fila.
	 */
	public void enqueue(T dato);
	
	/**
	 * Retorna el elemento que este de primeras en la fila
	 * @return El elemento en la primera posici�n.
	 */
	public Node<K,T> getPrimero();
	
	
	/**
	 * Quita el primer elemento y retorna el primer elemento de la fila.
	 * @return Primer elemento de la cola. 
	 * 
	 */
	public Node<K,T> dequeue();
	
	
	
}
