import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        int n=arr.length;
        boolean swapped=false;
        for(int i=0;i<n;++i){
            for(int j=0;j<n-i-1;++j){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={12,78,90,13,7,5,32,25};
        System.out.println("Initial array: "+ Arrays.toString(arr));

        BubbleSort.bubbleSort(arr);
        System.out.println("Sorted Array: "+Arrays.toString(arr));
    }
}
