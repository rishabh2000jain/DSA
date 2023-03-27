import java.util.PriorityQueue;

/*Given that the rows and columns are sorted.

    Solution1->  Insert all the elements in an list and sort that and override the array values.
    Solution2->  Can user min heap(Priotiry Queue) to sort the array.
    Solution3->  Can use PQ of size N as given in [sortMatrix] because the array is sorted in row and column.

*/
class SortedMatrix_Q4 {
    public static void main(String...k){
        int arr[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        arr = sortMatrixOptimised(arr, 4);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(arr[i][j]+" , ");
            }
            System.out.println("");
        }
    }


    public static int[][] sortMatrixOptimised(int arr[][],int N){
        if(N<=1)return arr;
        int ans[][] = new int[N][N];
        PriorityQueue<Triplate> pq = new PriorityQueue<Triplate>((Triplate o1,Triplate o2) -> (o1.val - o2.val));
        for(int row=0;row<N;row++){
            Triplate triplate = new Triplate(row, 0, arr[row][0]);
            pq.add(triplate);
        }
        int row=0,col=0;
        while(!pq.isEmpty()){
            Triplate element = pq.remove();
            ans[row][col] = element.val;
            col++;
            if(col>=N){
                col=0;
                row++;
            }
            int currRow = element.row,currCol = element.col;
            if(currCol<N-1){
                Triplate triplate = new Triplate(currRow, currCol+1, arr[currRow][currCol+1]);
                pq.add(triplate);
            }
        }

        return ans;
    }

    public static int[][] sortedMatrix(int arr[][],int N) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((Integer o1,Integer o2) -> (o1 - o2));
        for(int row=0;row<N;row++){
            for(int col=0;col<N;col++){
            pq.add(arr[row][col]);
            }
        }
        
         for(int row=0;row<N;row++){
            for(int col=0;col<N;col++){
             int ele = pq.remove();
             arr[row][col]=ele;
            }
        }
        

        return arr;
        
    }
}

class Triplate{
    int row,col,val;
    Triplate(int row,int col,int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}