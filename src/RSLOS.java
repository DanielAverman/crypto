public class RSLOS {

    public String doRSLOS(int n, int[] a, int[] c) {
        int[] b = new int[n];
        String input = "";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
            input += a[n-i-1];
        }
        System.out.println(input);
        int k = 0;
        while (res.indexOf(input, n) == -1) {
            res.append(b[n-1]);
            int r = 0;
            for (int i = 0; i < n; i++) {
                r += (b[i]*c[i]);
                r %= 2;
            }
            for (int i = n-2; i >= 0; i--) {
                b[i+1] = b[i];
            }
            b[0] = r;
            k++;
        }
        return res.substring(0, res.length()-n);
    }

    public String GeffeGen(String rs1, String rs2, String rs3) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            if (rs1.charAt(i % rs1.length()) == '1') {
                res.append(rs2.charAt(i % rs2.length()));
            } else {
                res.append(rs3.charAt(i % rs3.length()));
            }
        }
        return res.toString();
    }

    public int getCount(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public int[] getThy(String str, int param) {
        int[] thy = new int[param];
        for (int i = 0; i < param; i++) {
            for (int j = 0; j < str.length()-i-1; j++) {
                if ((str.charAt(j) == str.charAt(j+1)) && (str.charAt(j) == '0' || str.charAt(j) == '1')) {
                    thy[i] += 1;
                } else {
                    thy[i] += -1;
                }
            }
        }
        return thy;
    }
}
