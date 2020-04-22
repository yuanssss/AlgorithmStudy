package jianzhiOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class question8_JumpFloor {
    public static void main(String[] args) {
        question8_JumpFloor q = new question8_JumpFloor();
        int a = q.JumpFloor(3);
        System.out.println(a);
    }

    int method = 0;

    public int JumpFloor(int target) {
        if (target == 2) {
            return 2;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 0) {
            return 0;
        }
        /**
         * 斐波那契
         * 台 1 2 3 4 5
         * 法 1 2 3 5 8
         * 当时没看出
         *
         * a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
         *
         * b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
         *
         * c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)
         *
         * d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
         *
         * e.可以发现最终得出的是一个斐波那契数列：
         */
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //循环
    public int JumpFloor2(int target)
    {
        if (target == 2) {
            return 2;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 0) {
            return 0;
        }

        int method=0;
        int preNum=1;
        int oneNum=2;
        for(int i=target;i>2;i--)
        {
            method=preNum+oneNum;
            preNum=oneNum;
            oneNum=method;

        }
        return method;
    }
}
