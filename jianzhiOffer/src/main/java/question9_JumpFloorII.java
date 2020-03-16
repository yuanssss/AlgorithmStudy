import java.util.LinkedList;
import java.util.List;

/**
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 台阶 1 2 3 5 6
 * 方法 1 2 4 8 16
 * 只观察到了 f(n)=f(1)+f(2)+f(3)+....+f(n)
 * 没注意到  f(n)=2f(n-1)
 *
 *
 * 每个台阶可以看作一块木板，让青蛙跳上去，n个台阶就有n块木板，最后一块木板是青蛙到达的位子，
 * 必须存在，其他 (n-1) 块木板可以任意选择是否存在，
 * 则每个木板有存在和不存在两种选择，(n-1) 块木板 就有 [2^(n-1)] 种跳法，可以直接得到结果
 */
public class question9_JumpFloorII {
    public static void main(String[] args) {
        question9_JumpFloorII q=new question9_JumpFloorII();
        int a=q.JumpFloorII(5);
        System.out.println(a);
    }
    public int JumpFloorII(int target) {
       if(target==1)
       {
           return 1;
       }
       if(target==2)
       {
           return 2;
       }
       int startNum=1;
       int secNum=2;
       int method=0;
        int[]arr=new int[target];
        arr[0]=1;
        arr[1]=2;
       for(int i=2;i<target;i++)
       {
           int k=1;
           while (i-k>=0)
           {
               arr[i]+=arr[i-k];
               k++;
           }
           arr[i]=arr[i]+1;
       }
       return arr[target-1];
    }

    public int JumpFloorII2(int target) {
        if(target==1)
        {
            return 1;
        }
        if(target==2)
        {
            return 2;
        }

      int secNum=2;
      for(int i=2;i<target;i++)
      {
          secNum=secNum*2;
      }
      return secNum;
    }
}
