package structures;

public class MinHeap {

    private Vector list = new Vector(0);

    public MinHeap(Vector list) {
        heapify(copy(list));
    }

    public void add(int item){
        list.add(item);
        heapifyUp();
    }

    public int poll(){
        if (list.getSize() == 0) {
            throw new IllegalStateException();
        }

        int firstElement = list.getAt(0);
        int lastElement = list.getAt(list.getSize() - 1);
        list.replace(0, lastElement);
        list.remove(list.getSize() - 1);
        heapifyDown();
        return firstElement;

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

    public void heapifyDown(){
        int index = 0;
        while (hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (list.getAt(index) < list.getAt(smallerChildIndex)){
                break;
            } else {
                list.swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    //Auxiliar methods
    private Vector copy(Vector list){
        Vector copy = new Vector(list.getSize());

        for(Integer num : list.getVector()){
            if(num != null){
                copy.add(num);
            }
        }

        return copy;
    }

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

    @Override
    public String toString() {
        return list.toString();
    }

}
