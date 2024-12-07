import java.util.Arrays;

public class QuickSort {
    public static void  quickSort(int[] arr,int lb,int ub){
        if(lb<ub){
            int loc=partition(arr,lb,ub);
            quickSort(arr,lb,loc-1);
            quickSort(arr,loc+1,ub);
        }
    }

    public static int partition(int[] arr,int lb,int ub){
            int i=lb,j=ub;
            int pivot=arr[lb];
            while(i<j){
                while(arr[i]<pivot){
                    ++i;
                }
                while(arr[j]>pivot){
                    --j;
                }
                if(i<j){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
            int temp=pivot;
            pivot=arr[j];
            arr[j]=temp;
            return j;
    }


    public static void main(String[] args) {
        int[] arr={12,67,89,0,7,1,2,-5};

        System.out.println("Initial array : "+ Arrays.toString(arr));
        QuickSort.quickSort(arr,0,arr.length-1);
        System.out.println("Sorted array : "+ Arrays.toString(arr));
    }
}
