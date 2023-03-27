import java.util.ArrayList;
import java.util.List;

abstract class PriorityQueue {
    protected final List<Integer> heap = new ArrayList<>();
    int size(){
        return heap.size();
    }
    Integer peek(){
        if(isEmpty()){
            return null;
        }
        return heap.get(0);
    }
    abstract Integer remove();
    abstract void add(Integer data);

    boolean isEmpty(){
        return heap.isEmpty();
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer("[");
        for(int ele:heap){
            sb.append(ele+",");
        }
        sb.append("]");
        return sb.toString();
    }
}