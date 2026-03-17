import java.util.HashMap;
import java.util.Map;

public class a3090 {
    public int maximumLengthSubstring(String s) {
        int l=0,r=0,n=s.length(),max=0;
        int[][] map = new int[26][2];//出现两次，map[i][0]为第一次出现的位置,map[i][1]为第二次
        for(int i=0;i<26;i++){map[i][0]=-1;map[i][1]=-1;}
        for(;r<n;r++){
            int x = s.charAt(r)-'a';
            if(map[x][0]==-1){//第一次出现
                map[x][0]=r;
            }else if(map[x][1]==-1){//第二次出现
                map[x][1]=r;
            }else{//第n次出现
                l = Math.max(l,map[x][0]+1);
                map[x][0] = map[x][1];
                map[x][1] = r;
            }
            //System.out.println("r:"+r+" l:"+l+" max:"+max);
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}
