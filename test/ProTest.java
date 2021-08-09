import java.util.ArrayList;

/**
 * @author jtl
 * @date 2021/8/3 16:34
 */

class ProTest {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
//        System.out.println(divide(Integer.MAX_VALUE, 2));
    }

    public static int reverse(int x) {
        // 有范围，超过范围返回0
        // 有符号
        // 翻转第一位可能为0
        //
        if (x == 0) {
            return 0;
        }
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = Math.abs(x);
        }

        ArrayList<Integer> arrayList = new ArrayList();
        boolean isLoop = true;
        while (isLoop) {
            int result = x % 10;
            arrayList.add(Math.abs(result));
            x = (x - result) / 10;

            if (x == 0) {
                isLoop = false;
            }
        }

        double num = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            num = (num * 10 + arrayList.get(i));
        }

        if (isNegative) {
            num = -num;
        }

        if (num >= Math.pow(2, 31) - 1 || num <= -Math.pow(2, 31)) {
            return 0;
        }

        return (int) num;
    }

    public static int revers2(int x) {
        double result = 0;
        while (x!=0){
            int temp = x % 10;
            x = (x-temp)/10;
            result = temp+result*10;
            if (result>=Integer.MAX_VALUE||result<=Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int) result;
    }

    public static int divide(int dividend, int divisor) {
        boolean isNegative = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;
        double count = 0;
        double a = Math.abs((double) dividend);
        double b = Math.abs((double) divisor);

        while (a - b >= 0) {
            count++;
            a = a - b;
        }
        System.out.println(count);
        count = isNegative ? -count : count;
        System.out.println(count);
        if (count > Integer.MAX_VALUE || count < Integer.MIN_VALUE) {
            count = Integer.MAX_VALUE;
        }

        return (int) count;
    }

    public static int strStr(String haystack, String needle) {
        // needle 为0时，返回0
        // needle长度大于haystack长度时，肯定不包含
        // 如果haystack长度为7，needle长度为5。其实只用比较3组即可得出答案

        if ("".equals(needle)){
            return 0;
        }

        int sizeA = haystack.length();
        int sizeB = needle.length();

        if (sizeA<sizeB){
            return -1;
        }
        if (sizeA==sizeB){
            return haystack.equals(needle)?0:-1;
        }


        for (int i=0;i<haystack.length()-needle.length()+1;i++){

        }

        return -1;
    }
}
