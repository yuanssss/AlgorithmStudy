package leetcode;

public class q24_quickSort {
    public static void main(String[] args) {
        q24_quickSort q=new q24_quickSort();
        int[]array={5,2,3,1,6,4,7,8,0,9};
        q.quickSort(array,0,array.length-1);
    }
    public  void quickSort(int[] array, int start, int end) {
        int i = start, j = end;
        int target = array[start];
        while (i < j) {
            while (i < j && target <= array[j])
                j--;
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
            while (i < j && array[i] <= target)
                i++;
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        if (i - 1 > start){
            quickSort(array, start, i - 1);
        }

        if (j + 1 < end){
            quickSort(array,j + 1, end);
        }
    }
}
