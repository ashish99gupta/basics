package sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {89, 45, 3, 675, 22, 545, 0, -2, 43};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] l = new int[len1];
        int[] r = new int[len2];

        for (int k = 0; k < len1; k++) {
            l[k] = arr[left + k];
        }
        for (int k = 0; k < len2; k++) {
            r[k] = arr[mid + 1 + k];
        }
        int j=0;int i= 0;
        int k = left;
        while (i<len1 && j < len2) {
            if (l[i] < r[j]) {
                arr[k] = l[i];
                i++;
                k++;
            } else {
                arr[k] = r[j];
                j++;
                k++;
            }
        }
        while (i<len1) {
            arr[k] = l[i];
            i++;
            k++;
        }
        while (j < len2) {
            arr[k] = r[j];
            j++;
            k++;
        }

    }

}
