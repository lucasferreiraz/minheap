package structures;

public class MinHeap {

    private Vector list = new Vector(0);

    public MinHeap(Vector list) {
        heapify(list);
    }

    public void add(int item){
        list.add(item);
        heapifyUp();
    }

    private void heapify(Vector rawList){

        if (rawList.getSize() == 0) {
            throw new IllegalStateException();
        }

        for(int i = 0; i < rawList.getSize(); i++){
            add(rawList.getAt(i));
        }
    }

    public void heapifyUp(){
        int index = list.getSize() - 1;
        while(hasParent(index) && parent(index) > list.getAt(index)){
            list.swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private Vector list = new Vector(capacity);

    public MinHeap(int capacity) {
        this.capacity = capacity;
    }

    //Auxiliar methods
    private int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }

    private int leftChild(int index) {
        return list.getAt(getLeftChildIndex(index));
    }

    private int rightChild(int index) {
        return list.getAt(getRightChildIndex(index));
    }

    private int parent(int index) {
        return list.getAt(getParentIndex(index));
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < list.getSize();
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < list.getSize();
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) < list.getSize();
    }

}
