
public class MergeSort {
    public void merge(
    int[] array, int[] leftarray, int[] rightarray, int left, int right) {
 
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (leftarray[i] <= rightarray[j]) {
            array[k++] = leftarray[i++];
        }
        else {
            array[k++] = rightarray[j++];
        }
    }
    while (i < left) {
        array[k++] = leftarray[i++];
    }
    while (j < right) {
        array[k++] = rightarray[j++];
    }
}

public void mergeSort(int[] array, int num) {
    if (num < 2) {
        return;
    }
    int mid = num / 2;
    int[] leftarray = new int[mid];
    int[] rightarray = new int[num - mid];

    for (int i = 0; i < mid; i++) {
        leftarray[i] = array[i];
    }
    for (int i = mid; i < num; i++) {
        rightarray[i - mid] = array[i];
    }
    mergeSort(leftarray, mid);
    mergeSort(rightarray, num - mid);

    merge(array, leftarray, rightarray, mid, num - mid);
}
}