package setModule;

public interface SimpleSet<E>{
    boolean add(E element); // inserta element si no existe ya en el Set, Devuelve si la operacion fue exitosa
    boolean remove(E element); // Remueve element si existe en el Set. Devuelve si la operacion fue exitosa
    boolean contains(E element); // Devuelve si element existe en el Set
    void clear(); // Borra todos los elementos del Set, dejandolo vacio
    boolean isEmpty(); // Devuelve si el Set esta vacio
    int size(); // Devuelve la cantidad de elementos en el Set
    E[] toArray(); // Devuelve un array con todos los elementos del Set
    SimpleSet<E> unionWith(SimpleSet<E> other); // Devuelve un Set con los contenidos de este Set y other
    SimpleSet<E> intersectionWith(SimpleSet<E> other); // Devuelve un Set con los elementos que este Set y other tienen en comun
    SimpleSet<E> differenceWith(SimpleSet<E> other); // Devuelve un Set con los elementos de este Set pero no en other
}
