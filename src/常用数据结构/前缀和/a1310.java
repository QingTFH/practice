package 常用数据结构.前缀和;

public class a1310 {

    // 异或有可逆性, 比如 a ^ b = c 那么 b ^ c = a
    // 已知异或前缀数组prefix[], 那么[l, r]的异或值 = prefix[r+1] ^ prefix[l]

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix_xor = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++) {
            prefix_xor[i+1] = prefix_xor[i] ^ arr[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = prefix_xor[r+1] ^ prefix_xor[l];
        }

        return result;
    }

}
