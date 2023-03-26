import java.io.PrintStream;

public final class PrinterUtil {
    public static PrintStream pt = System.out;

    public static void printArray1d(int arr[]){
        pt.println("");
        for(int pos=0;pos<arr.length;pos++){
            pt.print(arr[pos]+" , ");
        }
        pt.println();
    } 
    public void printArray2d(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                pt.print(arr[i][j]+" , ");
            }
            pt.println("");
        }
    } 
}
