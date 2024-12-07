import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;++i){
            int j=i-1;
            int key=arr[i];

            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                --j;
            }
            arr[j+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] arr={12,78,90,13,7,5,32,25};
        System.out.println("Initial array: "+ Arrays.toString(arr));

        InsertionSort.insertionSort(arr);
        System.out.println("Sorted Array: "+Arrays.toString(arr));
    }

}
