package listModule;

public interface SimpleList<E>{
    boolean add(E element); // inserta element al final de la lista, devuelve true siempre
    void add(int index, E element); // inserta element en el index dado, corriendo todos los elementos en ese indice y los siguientes a la derecha
    E remove(int index); // remueve el elemento de la lista en el index dado, y lo devuelve
    boolean remove(Object object); // remueve object pasado por referencia, devuelve true si se encontro y pudo ser removido de la lista
    void clear(); // borra todos los elementos de la lista, dejandola vacia
    boolean contains( Object object); // devuelve true si la lista contiene el object pasado por referencia
    E get(int index); // devuelve el elemento ubicado en index
    E set(int index, E element); // reemplaza el elemento ubicado en index por element, y devuelve el elemento que estaba ahi antes de ser reemplazado
    int size(); // devuelve la cantidad de elementos en la lista

}
