import java.io.PrintStream;
import java.util.*;
public class MaxRectangle_Q5 {
    public static PrintStream pt = System.out;
    public static void main(String...k){
      
        int arr[][] = {
        {0,0},
        {0,0},
        {0,0},
        {0,1},
        {1,0},
        {1,0},
        {1,0},
        {1,0},
        {0,1},
        {1,0},
        {0,1},
        {1,1},
        {0,0},
        {1,1}};
        System.out.println("ans=>" + maxRectangle(arr));
    } 

    public static int maxRectangle(int arr[][]){
        int ans=0;
        int blocks[] = new int[arr[0].length];
        int n = blocks.length;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    blocks[j] = 0;
                }else{
                    blocks[j] += arr[i][j];
                }
            }
            
            ans = Math.max(ans,maxHeight(blocks));
            pt.println("ans = "+ans);
        }

        return ans;
    }


    private static int maxHeight(int arr[]){
        int n = arr.length;
        int minL[] = new int[n];
        int minR[] = new int[n];
        Stack<Integer> st = new Stack<>();
        pt.print("Arr");
        PrinterUtil.printArray1d(arr);
        for(int pos=n-1;pos>=0;pos--){
            int currElement = arr[pos];
            while(!st.isEmpty() && arr[st.peek()]>=currElement){
                st.pop();
            }
            if(st.isEmpty()){
                minR[pos]=n;
            }else{
                minR[pos] = st.peek();
            }
            st.add(pos);
        }
        st.clear();
        for(int pos=0;pos<n;pos++){
            int currElement = arr[pos];
            while(!st.isEmpty() && arr[st.peek()]>=currElement){
                st.pop();
            }
            if(st.isEmpty()){
                minL[pos]= -1;
            }else{
                minL[pos] = st.peek();
            }
            st.add(pos);
        }
        int ans=0;
        for(int pos=0;pos<n;++pos){
            int currHeight = arr[pos];
            int currBreadth = (minR[pos]-minL[pos])-1;
            int currArea = currBreadth*currHeight;
            if(currArea>ans){
                ans = currArea;
            }
        }

        return ans;
    } 


}
