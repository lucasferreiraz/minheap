package structures;

public class MinHeap {

    private int capacity;

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
