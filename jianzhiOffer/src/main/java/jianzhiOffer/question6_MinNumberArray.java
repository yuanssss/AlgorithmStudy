package jianzhiOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 *

 *
 * 采用二分法解答这个问题，
 * mid = low + (high - low)/2
 * 需要考虑三种情况：
 * (1)array[mid] > array[high]:
 * 出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
 * low = mid + 1
 * (2)array[mid] == array[high]:
 * 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
 * 还是右边,这时只好一个一个试 ，
 * high = high - 1
 * (3)array[mid] < array[high]:
 * 出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
 * 边。因为右边必然都是递增的。
 * high = mid
 * 注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
 * 比如 array = [4,6]
 * array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
 * 如果high = mid - 1，就会产生错误， 因此high = mid
 * 但情形(1)中low = mid + 1就不会错误
 */
public class question6_MinNumberArray {
    public static void main(String[] args) {
        int[]a={1,0,1,1,1};
      question6_MinNumberArray q=new question6_MinNumberArray();
      q.minNumberInRotateArray(a);
    }

    /**
     * 第一次做的时候没注意审题，题目要求是非递减数组的旋转数组，所以【1，2，3，4，5】也可，
     * 因此不能把array[mid]和array[start]比较
     * 要与array[end]比较
     * 还有就是当array[mid]与array[start]或者array[end]相等如【1，0，1，1，1】时
     * 不能写array[min]==array[start] start=start+1
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if(array.length==0)
            return 0;
        int start=0;
        int end=array.length-1;

        while (start<end)
        {
            int mid=start+(end-start)/2;
            if(array[mid]>array[end])
            {
                start=mid+1;
            }else if(array[mid] == array[end]){
                end = end- 1;
            }
            else
            {
                end=mid;
            }
        }
        System.out.println(array[start]);
        return array[start];

    }




}
