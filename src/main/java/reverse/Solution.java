package reverse;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Math.abs;

@Slf4j
class Solution {
    public int reverse(int x) {
        int rev = 0;
        int pop = x % 10;
        x /= 10;
        while (x != 0) {
            int temp = rev * 10 + pop;
            if (abs(temp) < Integer.MAX_VALUE)
                rev = temp;
            pop = x % 10;
            x /= 10;
        }
        int temp = rev + x;
        if (abs(temp) < Integer.MAX_VALUE)
            rev = temp;

        return rev;
    }
    public static void main(String[] args){
        log.info("{}", new Solution().reverse(120));
    }
}