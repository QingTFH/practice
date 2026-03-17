import java.util.HashMap;
import java.util.Map;

public class a3 {
    public int lengthOfLongestSubstring(String s) {
        int max=0,l=0,r=0,n=s.length();
        char[] arr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();//字符->出现次数
        for(;r<n;r++){
            //窗口右扩
            //System.out.println(l+"  "+r);
            while(map.getOrDefault(arr[r],0)!=0){//右扩合法化
                map.merge(arr[l],-1,Integer::sum);
                l++;
            }
            map.merge(arr[r],1,Integer::sum);
            max = Math.max(max,r-l+1);
        }

        return max;
    }
    public int lengthOfLongestSubstring_ver2(String s) {
        //不统计出现次数，只统计各个字符最后出现位置
        int max=0,l=0,r=0,n=s.length();
        char[] arr = s.toCharArray();
        int[] last = new int[128];//char类型压缩至0-127
        for(int i=0;i<128;i++) {last[i]=-1;}//未出现过
        for(;r<n;r++){
            //窗口右扩
                //如果s[r]在窗口中出现过(last[s[r]]>=l)，则l=last[s[r]]+1
                //即l = max(l,last[s[r]]+1)
            l = Math.max(last[arr[r]]+1,l);
            max = Math.max(max,r-l+1);
            last[arr[r]]=r;
        }

        return max;
    }
}
