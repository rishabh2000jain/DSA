public class MaxPriorityQueue extends PriorityQueue {

    @Override
    Integer remove() {
       if(heap.isEmpty())return null;
       int removedElement = heap.get(0);
       heap.set(0, heap.get(heap.size()-1)); 
       heap.remove(heap.size()-1);
       heapifyDownword();
       return removedElement;
    }

    @Override
    void add(Integer data) {
        heap.add(data);
        heapifyUpward();
    }


    private void heapifyUpward(){
        int childIndex = heap.size()-1;
        int parentIndex = getParent(childIndex);

        while(parentIndex >= 0 && heap.get(parentIndex) < heap.get(childIndex)){
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = getParent(childIndex); 
        }

    }

    private void heapifyDownword(){
        if(heap.isEmpty())return;
        int parentIndex = 0;
        int childIndex = 1;
        if(heap.size()> 2 && heap.get(2) > heap.get(1)){
            childIndex = 2;
        }
        while(childIndex < heap.size() && heap.get(childIndex) > heap.get(parentIndex)){
            swap(childIndex,parentIndex);
            parentIndex = childIndex;
            childIndex = getLeftChildIndex(parentIndex);
            int rightChild =getRightChildIndex(parentIndex);
            if(heap.size() > rightChild && heap.get(rightChild) > heap.get(childIndex)){
                childIndex = rightChild;
            }
        }

    }

    private int getParent(int index){
        return (index-1)/2;
    }
    private int getLeftChildIndex(int index){
        return (2*index)+1;
    }
    private int getRightChildIndex(int index){
        return (2*index)+2;
    }
    private void swap(int from,int to){
        int temp = heap.get(from);
        heap.set(from, heap.get(to));
        heap.set(to, temp);
    }
    
}
