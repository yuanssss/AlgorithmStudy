package leetcode;

public class q24_quickSort {
    public static void main(String[] args) {
        q24_quickSort q=new q24_quickSort();
        int[]array={5,2,3,1,6,4,7,8,0,9};
        q.quickSort2(array,0,array.length-1);
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
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

    public void quickSort2(int[]array,int start,int end)
    {
        int target=array[start];
        int i=start;
        int j=end;
        while (i<=j)
        {
            while (i<j&&array[j]>target)
                j--;
            if(i<j)
            {
                int temp=0;
                temp=array[j];
                array[j]=array[i];
                array[i]=temp;
            }
            while (i<j&&array[i]<target)
                i++;
            if(i<j)
            {
                int temp=0;
                temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
            i++;
        }
        if(i-1>start)
        {
            quickSort2(array,start,i-1);
        }
        if(j+1<end)
        {
            quickSort2(array,j+1,end);
        }
    }
}
