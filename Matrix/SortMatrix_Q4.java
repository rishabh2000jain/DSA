import java.util.*;
class SortedMatrix_Q4 {
    public static void main(String...k){
        
    }


    public static int[][] sortMatrix(int arr[][],int N){
        int ans[][] = new int[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int col=0;col<N;col++){
            pq.add(arr[0][col]);
        }
    }

}