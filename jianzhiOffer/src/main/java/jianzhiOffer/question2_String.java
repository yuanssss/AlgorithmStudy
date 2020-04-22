package jianzhiOffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 补充知识：String、StringBuffer、StringBuilder的区别
 * 首先，从性能、速度方面来说：StringBuilder > StringBuffer > String
 * 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
 * 然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
 *
 */

public class question2_String {

    public String replaceSpace(StringBuffer str) {
        for(int i=0;i<str.length();i++)
        {
            if(String.valueOf(str.charAt(i)).equals(" "))
            {
                str.deleteCharAt(i);
//                str.append("%20");
                str.insert(i,"%20");
            }
        }
        return str.toString();
    }


    public String anotherAnswer(StringBuffer str)
    {
        return str.toString().replaceAll("\\s", "%20");
    }
}
