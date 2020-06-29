package leetcode;

import java.util.Arrays;

/*
给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，
或者在待命状态。

然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，
因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的最短时间。


假设数组 ["A","A","A","B","B","C"]，n = 2，A的频率最高，记为count = 3，所以两个A之间必须间隔2个任务，
才能满足题意并且是最短时间（两个A的间隔大于2的总时间必然不是最短），
因此执行顺序为： A->X->X->A->X->X->A，这里的X表示除了A以外其他字母，
或者是待命，不用关心具体是什么，反正用来填充两个A的间隔的。上面执行顺序的规律是：
 有count - 1个A，其中每个A需要搭配n个X，再加上最后一个A，所以总时间为 (count - 1) * (n + 1) + 1
要注意可能会出现多个频率相同且都是最高的任务，
比如 ["A","A","A","B","B","B","C","C"]，所以最后会剩下一个A和一个B，
因此最后要加上频率最高的不同任务的个数 maxCount
公式算出的值可能会比数组的长度小，如["A","A","B","B"]，n = 0，此时要取数组的长度
 */
public class q33_leastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[]count=new int[26];
        for(int i=0;i<tasks.length;i++)
        {
            count[tasks[i]-'A']=count[tasks[i]-'A']+1;//找出频率最高的
        }
        Arrays.sort(count);//排序,count[25]就成了最大的
        int maxCount=0;
        for(int i=25;i>=0;i--)
        {
            if(count[i] != count[25]){
                break;
            }
            maxCount++;
        }
        return Math.max((count[25]-1)*(n-1)+maxCount,tasks.length);

    }
}
