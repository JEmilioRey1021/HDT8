import java.util.Vector;

    /** Jose Emilio Reyes Paniagua
     * Vector Heap
    * **/

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    protected Vector<E> data; 

        /**Constructor**/
    public VectorHeap(){
        data = new Vector<E>();
    }

        /**Retorna el indice del padre**/
    protected static int padre(int i){
        return (i - 1) / 2;
    }

        /**Retorna el indice del hijo izquierdo**/
    protected static int left(int i){
        return 2 * i + 1;
    }

        /**Retorna el indice del hijo derecho**/
    protected static int right(int i){
        return (2 * i + 1) + 1;
    }

        /**Reordena el Heap**/
    protected void percolateUp(int leaf){
        int padre = padre(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(padre)) < 0)) {
            data.set(leaf, data.get(padre));
            leaf = padre;
            padre = padre(leaf);
        }
        data.set(leaf, value);
    }

        /**Anade un valor y luego ordena el Heap**/
    public void add(E value){
        data.add(value);
        percolateUp(data.size() - 1);
    }

        /**Funcion para bajar un valor en su jerarquia**/
    protected void pushDownRoot(int root){
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos + 1)).compareTo
                                (data.get(childpos)) < 0)) {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                        (value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root, value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root, value);
                return;
            }
        }
    }

        /**Elimina el primer valor del heap**/
    public E remove(){
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }


        /**Retorna el primer valor, en otras estructuras se conoce como peek**/
    @Override
    public E getFirst() {
        if (data.isEmpty()){
            return null;
        } else {
            return data.firstElement();
        }
    }

        /**Imprime los valores del heap ordenadamente**/
    public void print(){
        int initialSize = data.size();
        for (int i = 0; i<initialSize;i++){
            System.out.println(getFirst().toString());
            remove();
        }
    }

}