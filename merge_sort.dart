void main() {
  final arr = [5,1,4,2,3,5,2];
  mergeSort(arr,0,arr.length-1);
  print(arr);
}


void mergeSort(List<int> arr,int st,int en){
  if(st>=en){
    return;
  }
  
  int mid = (st+en)~/2;
  mergeSort(arr,st,mid);
  mergeSort(arr,mid+1,en);
  merge(arr,st,mid,en);
}

void merge(List<int> arr,int st,int mid,int en){
  
  //include +1 in the left array because we need to include the mid element as well.
  //If we dont do so then the middle element will not be included in the merge.
  int leftArrSize = (mid-st)+1;
  int rightArrSize = en-mid;
  
  List<int> arrLeft = List.filled(leftArrSize,0);
  List<int> arrRight = List.filled(rightArrSize,0);
  
  int k = st;
  int i=0,j=0;
  
  while(i<leftArrSize){
   arrLeft[i++] = arr[k++];
  }
  
  while(j<rightArrSize){
   arrRight[j++] = arr[k++];
  }
  
  k = st;
  i=0;
  j=0;
  
  while(i<leftArrSize && j<rightArrSize){
    if(arrLeft[i]<arrRight[j]){
      arr[k++] = arrLeft[i++];
    }else{
      arr[k++] = arrRight[j++];
    }
  }
  
  while(i<leftArrSize){
   arr[k++] = arrLeft[i++];
  }
  
  while(j<rightArrSize){
   arr[k++] = arrRight[j++];
  }
  
}
