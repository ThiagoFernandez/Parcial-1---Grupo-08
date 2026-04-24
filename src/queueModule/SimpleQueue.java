package queueModule;

public interface SimpleQueue <E>{
    void enqueue(E element); // inserta element al final de la cola
    E dequeue(); // Remueve el primer elemento de la cola y lo devuelve
    E peek(); // Devuelve el primer elemento de la cola sin removerlo
    void clear(); // Borra todos los elementos de la cola, dejandola vacia
    int size(); // Devuelve la cantidad de elementos een la cola
    boolean isEmpty(); // true or false en base si esta vacia o no la cola
}
