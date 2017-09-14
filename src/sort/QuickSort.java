package sort;

/**
 * Created by l81022078 on 2017/8/24.
 */
public class QuickSort {
    public void quickSort(int[] arr, int low, int high){
        int pivot = arr[high];
        int l = low;
        int r = high - 1;
//        int index = l;
//        for(int i = l; i <= r; i++){
//            if(arr[i] < pivot){
//                swap(arr, index, i);
//                index++;
//            }
//        }
        while(l <= r){
            while(l <= r && arr[l] < pivot)
                l++;
            while(l <= r && arr[r] > pivot)
                r--;
            if(l <= r){
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        int index = l;
        swap(arr, index, high);
        if(low < index - 1)
            quickSort(arr, low, index - 1);
        if(index + 1< high)
            quickSort(arr, index + 1, high);
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 5, 6, 5};
        new QuickSort().quickSort(arr, 0, 5);
        for(int i : arr){
            System.out.println(i);
        }
    }
}
