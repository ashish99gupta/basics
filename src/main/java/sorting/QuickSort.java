package sorting;

public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = {89, 45, 3, 675, 22, 545, 0, -2, 43};
        //int[] arr ={-2 ,0, 3 ,22, 43, 45, 89, 545, 675 };
        int[] arr = {675, 545, 89, 45, 43, 22, 3, 0, -2};

        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left<right){
            int pivot = partition(arr,left,right);
            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot){
                swap(arr,j,i);
                i++;
            }
        }
        swap(arr,i,right);
        return i;

    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
