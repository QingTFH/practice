package 常用数据结构.前缀和;

public class a2559 {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix_cnt = new int[words.length + 1];
        for (int i = 1; i < words.length + 1; i++) {
            prefix_cnt[i] = prefix_cnt[i-1] +
                    ((isVowel(words[i-1].charAt(0))
                            && isVowel(words[i-1].charAt(words[i-1].length() - 1))) ? 1 : 0);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = prefix_cnt[r+1] - prefix_cnt[l];
        }

        return result;
    }

    private boolean isVowel(char a){
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }

}
