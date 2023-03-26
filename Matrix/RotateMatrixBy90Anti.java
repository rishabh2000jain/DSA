public class RotateMatrixBy90Anti {
    public static void main(String[] args) {
        
    }
    //step1= reverse rows
    //step2=convert row to column.
    public static void inplaceRotate(int[][] arr, int n) {
        //Step 1
        for(int col=0;col<n;col++){
            reverse(arr[col]);
        }
        //Step 2
        int i=0,k=0;
        while(i<n){
            int temp = arr[i][k];
            arr[i][k] = arr[k][i];
            arr[k][i] = temp;
            k++;
            if(k>=n){
                i++;
                k = i;
            }
        }
        
        
       
	}


    static void reverse(int arr[]){
        int st = 0,en = arr.length-1;
        while(st<en){
            int temp = arr[st];
            arr[st] = arr[en];
            arr[en] = temp;
            st++;
            en--;
        }
    }
}
