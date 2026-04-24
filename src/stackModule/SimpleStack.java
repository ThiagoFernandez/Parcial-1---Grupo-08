package stackModule;

public interface SimpleStack <E>{
    void push(E element); // inserta element al final de la pila
    E pop(); // Remueve el ultimo elemento de la pila y lo devuelve
    E peek(); // Devuelve el ultimo elemento de la pila sin removerlo
    void clear(); // Borra todos los elementos de la pila, dejandola vacia
    int size(); // Devuelve la cantidad de elementos een la pila
    boolean isEmpty(); // true or false en base si esta vacia o no la pila
}
