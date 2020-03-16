/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
 *
 *
 *
 * 依旧是斐波那契数列
 * 2*n的大矩形，和n个2*1的小矩形
 * 其中target*2为大矩阵的大小
 * 有以下几种情形：
 * 1⃣️target <= 0 大矩形为<= 2*0,直接return 1；
 * 2⃣️target = 1大矩形为2*1，只有一种摆放方法，return1；
 * 3⃣️target = 2 大矩形为2*2，有两种摆放方法，return2；
 * 4⃣️target = n 分为两步考虑：
 *         最后摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
 *         即在每个 target-1情况的后面加一个2*1的小矩形
 *         在最后摆放两块1*2的小矩形，则摆放方法总共为f（target-2）
 *         在每个target-2后面加两个1*2的小矩形
 *故f（n）=f（n-1）+f（n-2）
 */

public class question10_RectCover {
    //递归
    public int RectCover(int target) {
        if (target<3)
        {
            return target;
        }
        else
        {
            return RectCover(target-1)+RectCover(target-2);
        }
    }

    //循环遍历,大幅度减少时间复杂度
    public int RectCover2(int target)
    {
        if(target<3)
        {
            return target;
        }
        else
        {
            int oneStart=1;
            int twoStart=2;
            int method=0;
            for(int i=3;i<=target;i++)
            {
                method=oneStart+twoStart;
                oneStart=twoStart;
                twoStart=method;
            }
            return method;
        }
    }
}
