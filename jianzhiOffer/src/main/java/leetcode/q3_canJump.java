package leetcode;

public class q3_canJump {
    public static void main(String[] args) {
        q3_canJump q=new q3_canJump();
        int[]a={0};
        System.out.println(q.canJump(a));
    }
    public boolean canJump(int[] nums) {
       int farLength=0;
       for(int i=0;i<nums.length;++i)
       {

           if(i<=farLength)
           {
               if(farLength<i+nums[i])
               {
                   farLength=i+nums[i];
               }
           }

       }
       if(farLength<nums.length)
       {
           return false;
       }
       else return true;
    }
    //超级简化版
    public boolean canJump2(int []nums)
    {
        int farLength=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>farLength)return false;
            farLength=Math.max(farLength,i+nums[i]);
        }
        return true;
    }
}
