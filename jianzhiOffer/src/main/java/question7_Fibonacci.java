/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 *
 */

public class question7_Fibonacci {
    //递归
    public int Fibonacci(int n) {
      if(n<2)
      {
          return n;
      }
      else
      {
          return Fibonacci(n-1)+Fibonacci(n-2);
      }
    }
    //迭代
    public int Fibonacci2(int n) {
        int msg=0;
        if(n<2)
        {
            return n;
        }
        else
        {
            int preNum=0;
            int oneNum=1;
            for(int i=n;i>1;i--)
            {
                msg=preNum+oneNum;
                preNum=oneNum;
                oneNum=msg;

            }
        }
        return msg;
    }
}
