void main() {
  final arr = [5,1,4,2,3,5,2];
  quickSort(arr,0,arr.length-1);
  print(arr);
}



void quickSort(List<int> arr,int st,int en){
  if(st>=en){
    return;
  }
  
  int pivotIndex = sort(arr,st,en);
  quickSort(arr,st,pivotIndex-1);
  quickSort(arr,pivotIndex+1,en);
  
}

int sort(List<int> arr,int st,int en){
  int pivotElement = arr[st];
  int numbersLessThenPivot = 0;
  
  for(int i=st+1;i<=en;i++){
    if(arr[i]<pivotElement){
      numbersLessThenPivot++;
    }
  }
  int newPivotIndex = st+numbersLessThenPivot;
  int temp = arr[st];
  arr[st] = arr[newPivotIndex];
  arr[newPivotIndex]=temp;
  
  int i=st,j=en;
  while(i<newPivotIndex && j>newPivotIndex){
    if(arr[i]<pivotElement){
      i++;
    }else if(arr[j]>=pivotElement){
      j--;
    }else{
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j]= temp;
    }
  }
  
  return newPivotIndex;
}
