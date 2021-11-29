// Robot Bounded In Circle

class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0) {
            return true;
        }
        
        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0;
        int x = 0;
        int y = 0;
        for(int i = 0 ;i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            
            if(c == 'G') {
                x+= dirs[dir][0]; 
                y+= dirs[dir][1];
            } else if(c == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        return (x == 0 && y == 0 ) || dir != 0;
    }
}

// Ugly Number II

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        
        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(n2, Math.min(n3,n5));
            if(dp[i] == n2) {
                p2++;
                n2 = dp[p2] * 2;
            }
            if(dp[i] == n3) {
                p3++;
                n3 = dp[p3] * 3;
            }
            if(dp[i] == n5) {
                p5++;
                n5 = dp[p5] * 5;
            }
        }
        return dp[n-1];
    }
}