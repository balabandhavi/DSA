import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;++i){
            int min_index=i;
            for(int j=i+1;j<n;++j){
                if(arr[j]<arr[min_index]){
                    min_index=j;
                }
            }
            if(min_index!=i){
                int temp=arr[min_index];
                arr[min_index]=arr[i];
                arr[i]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={34,78,9,45,22,-7,7,1};
        System.out.println("Initial array : "+ Arrays.toString(arr));
        SelectionSort.selectionSort(arr);
        System.out.println("Sorted array : "+ Arrays.toString(arr));
    }
}
