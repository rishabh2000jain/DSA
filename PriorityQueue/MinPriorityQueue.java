class MinPriorityQueue extends PriorityQueue{
    
   @Override
    public Integer remove() {
        if(isEmpty()){
            return null;
        }
        int removedElement = heap.get(0);
        heap.set(0, heap.get(size()-1));
        heap.remove(size()-1);
        heapifyDownword();
        return removedElement; 
    }

    @Override
    public void add(Integer data) {
        heap.add(data);
        heapifyUpward();
    }

    private void heapifyUpward(){
        int childIndex = heap.size()-1;
        int parentIndex = getParent(childIndex);

        while(parentIndex>=0 && heap.get(parentIndex) > heap.get(childIndex)){
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = getParent(childIndex);
        }

    }
    
    private void heapifyDownword(){
        if(isEmpty()){
            return;
        }
        int parentIndex = 0,childIndex=1;
        if(2 < size() && heap.get(2) < heap.get(childIndex)){
            childIndex=2;
        }
        while(childIndex < size() && heap.get(parentIndex) > heap.get(childIndex)){
            swap(parentIndex, childIndex);
            parentIndex = childIndex;
            int leftChild = getLeftChildIndex(parentIndex);
            int rightChild = getRightChildIndex(parentIndex);
            childIndex = leftChild;
            if(rightChild < size() && heap.get(rightChild) < heap.get(leftChild)){
                childIndex=rightChild;
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