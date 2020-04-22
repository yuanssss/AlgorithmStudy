package jianzhiOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 保证base和exponent不同时为0
 */
public class question12_power {
    public static void main(String[] args) {
        question12_power question12_power = new question12_power();
        double a = question12_power.Power(2, -3);
        System.out.println(a);

    }

    public double Power(double base, int exponent) {
        //考察能否考虑多种情况
        if (base == 0.0) {
            return 0;
        } else if (exponent == 0) {
            return 1;
        } else if (base == 0 && exponent <= 0) {
            throw new RuntimeException();
        } else if (base != 0 && exponent < 0) {
            double flag=1/base;
            double msg=1/base;
            for (int i=-1;i>exponent;i--) {
                msg=msg*flag;
            }
            return msg;
        } else {
//            return Math.pow(base,exponent);
            if (exponent == 1) {
                return base;
            } else {
                double flag = base;
                for (int i = 1; i < exponent; i++) {
                    base = base * flag;
                }
                return base;
            }

        }

    }
}
