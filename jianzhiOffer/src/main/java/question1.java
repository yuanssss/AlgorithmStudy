/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class question1 {
    public static void main(String[] args) {
        int target=15;
        int [][]array=new int[][] {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(target,array));
    }
    public static boolean Find(int target, int[][] array) {
        boolean flag=false;
        lable1:
        for(int i=0;i<array.length;i++)
        {
            lable2:
            for(int  j=0;j<array[i].length;j++)
            {
                if(array[i][j]>target)
                {
                    break lable2;

                }
                if(array[i][j]==target)
                {

                    flag=true;
                    break lable1;
                }
            }
        }
        return flag;
    }

}

