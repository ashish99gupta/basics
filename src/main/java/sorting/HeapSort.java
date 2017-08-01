package sorting;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {89, 45, 3, 675, 22, 545, 0, -2, 43};
        buildHeap(arr);
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            maxTopDownHeapify(arr, i, 0);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    public static void buildHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            maxTopDownHeapify(arr, arr.length, i);
        }
    }

    public static void maxTopDownHeapify(int[] arr, int size, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < size && arr[left] > arr[max]) {
            max = left;
        }
        if (right < size && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            swap(arr, max, i);
            maxTopDownHeapify(arr, size, max);
        }

    }

    public static void bottomUpHeapify(int[] arr, int i){
        int parent = i/2;
        if (parent >= 0 && arr[parent] < arr[i]){
            swap(arr,parent,i);
            bottomUpHeapify(arr,parent);
        }
    }

    public static void swap(int[] arr, int max, int i) {
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
    }
}
