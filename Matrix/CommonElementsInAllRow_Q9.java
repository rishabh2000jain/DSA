import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class CommonElementsInAllRow_Q9{
 
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        findCommonElements(list);
    }

    public static ArrayList<Integer> findCommonElements(ArrayList<ArrayList<Integer>> mat)
    {
       ArrayList<Integer> ans = new ArrayList<>();

       HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<mat.size();i++){
             for(int j=0;j<mat.get(i).size();j++){
                 int ele = mat.get(i).get(j);
                if(i==0){
                    map.put(ele,1);
                }else if(map.containsKey(ele) && map.get(ele) == i){
                    map.put(ele, map.get(ele)+1);
                }
            }
        }
        for(Map.Entry<Integer,Integer> mp:map.entrySet()){
            if(mp.getValue() == mat.size()){
                ans.add(mp.getKey());
            }
        }    
        
        return ans;

    }
}