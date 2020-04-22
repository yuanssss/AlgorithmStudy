package jianzhiOffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 新知识：运算符&  两个操作数中二进制位都为1，结果才为1，否则结果为0，例如
 * a=129 b=128
 * a&b=128
 * “a”的值是129，转换成二进制就是10000001，而“b”的值是128，转换成二进制就是10000000。
 * 根据与运算符的运算规律，只有两个位都是1，结果才是1，可以知道结果就是10000000，即128。
 */

public class question11_NumberOf1 {
    public static void main(String[] args) {
        question11_NumberOf1 question11_numberOf1=new question11_NumberOf1();
        int a=question11_numberOf1.NumberOf1(-11);
        System.out.println(a);
    }
    //不适用于负数的情况
    int count=0;
    public int NumberOf1(int n) {
        if(n>=0) {
            if (n == 1) {
                return count + 1;
            } else {
                if (n % 2 == 0) {
                    return NumberOf1(n / 2);
                } else {
                    count++;
                    return NumberOf1(n / 2);
                }
            }
        }
        else
        {
            int a=Integer.toBinaryString(n).length()-Integer.toBinaryString(-n).length();
            if (-n == 1) {
                return count + 1+a;
            } else {
                if (-n % 2 == 0) {
                    return NumberOf1(-n / 2);
                } else {
                    count++;
                    return NumberOf1(-n / 2);
                }
            }

        }

    }

    /**
     *
     * 如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
     * 原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
     * 举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，
     * 而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
     * 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
     * 如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
     * 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     * @param n
     * @return
     */
    public int NumberOf2(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}
