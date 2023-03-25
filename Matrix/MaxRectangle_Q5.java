import java.util.*;
public class MaxRectangle_Q5 {
    public static void main(String...k){
        int arr[][] = {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        System.out.println("ans=>"+maxRectangle(arr));
    } 

    public static int maxRectangle(int arr[][]){
        int ans=0;
        int blocks[] = new int[arr[0].length];
        int n = blocks.length;

        for(int i=0;i<arr.length;i++){
            for(int pos=0;pos<n;++pos){
                if(arr[i][pos]==0){
                    blocks[pos] = 0;
                }else{
                    blocks[pos] += arr[i][pos];
                }
            }
            ans = Math.max(ans,maxHeight(arr[i]));
        }

        return ans;
    }


    private static int maxHeight(int arr[]){
        int n = arr.length-1;
        int minL[] = new int[n+1];
        int minR[] = new int[n+1];
        Stack<Integer> st = new Stack<>();

        for(int pos=n;pos>=0;--pos){
            int currElement = arr[pos];
            while(!st.isEmpty() && st.peek()<=currElement){
                st.pop();
            }
            if(st.isEmpty()){
                minR[pos]=-1;
            }else{
                minR[pos] = st.peek();
            }
        }

        for(int pos=0;pos<n;++pos){
            int currElement = arr[pos];
            while(!st.isEmpty() && st.peek()<=currElement){
                st.pop();
            }
            if(st.isEmpty()){
                minL[pos]=-1;
            }else{
                minL[pos] = st.peek();
            }
        }
        int ans=0;
        for(int pos=0;pos<n;++pos){
            ans = Math.max(ans,minR[pos]-minL[pos]-1);
        }

        return ans;
    } 


}
