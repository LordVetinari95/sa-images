public class CostCounter {

    public static int countCost(int[][]bits){
        return countCostOne(bits);
    }

    public static int countCost(int[][] bits, int i){
        switch (i){
            case 1:
                return countCostOne(bits);
            case 2:
                return countCostTwo(bits);
            case 3:
                return countCostThree(bits);
            default:
                return countCostOne(bits);
        }
    }

    private static int countCostThree(int[][] bits) {
        return countCostTwoThree(bits, false);
    }

    private static int countCostTwo(int[][] bits) {
        return countCostTwoThree(bits,true);
    }

    private static int countCostTwoThree(int[][] bits, boolean fun) {
        int cost = 0;
        int size = bits.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int k;
                if(fun) k = 1;
                else k = 2;
                if(checkLocation(i+k, j+k, size) && bits[i][j]!=bits[i+k][j+k]) cost+=k;
                if(checkLocation(i+k, j-k, size) && bits[i][j]!=bits[i+k][j-k]) cost+=k;
                if(checkLocation(i-k, j+k, size) && bits[i][j]!=bits[i-k][j+k]) cost+=k;
                if(checkLocation(i-k, j-k, size) && bits[i][j]!=bits[i-k][j-k]) cost+=k;
                if(checkLocation(i+k, j, size) && bits[i][j]!=bits[i+k][j]) cost+=k;
                if(checkLocation(i-k, j, size) && bits[i][j]!=bits[i-k][j]) cost+=k;
                if(checkLocation(i, j+k, size) && bits[i][j]!=bits[i][j+k]) cost+=k;
                if(checkLocation(i, j-k, size) && bits[i][j]!=bits[i][j-k]) cost+=k;
                if(fun) k = 2;
                else k =1;
                if(checkLocation(i+k, j+k, size) && bits[i][j]==bits[i+k][j+k]) cost+=k;
                if(checkLocation(i+k, j-k, size) && bits[i][j]==bits[i+k][j-k]) cost+=k;
                if(checkLocation(i-k, j+k, size) && bits[i][j]==bits[i-k][j+k]) cost+=k;
                if(checkLocation(i-k, j-k, size) && bits[i][j]==bits[i-k][j-k]) cost+=k;
                if(checkLocation(i+k, j, size) && bits[i][j]==bits[i+k][j]) cost+=k;
                if(checkLocation(i-k, j, size) && bits[i][j]==bits[i-k][j]) cost+=k;
                if(checkLocation(i, j+k, size) && bits[i][j]==bits[i][j+k]) cost+=k;
                if(checkLocation(i, j-k, size) && bits[i][j]==bits[i][j-k]) cost+=k;
            }
        }
        return cost;
    }

    private static int countCostOne(int[][] bits) {
        int cost = 0;
        int size = bits.length;
        int edge = 2;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 1; k <= edge; k++) {
                    if(checkLocation(i+k, j+k, size) && bits[i][j]!=bits[i+k][j+k]) cost+=k;
                    if(checkLocation(i+k, j-k, size) && bits[i][j]!=bits[i+k][j-k]) cost+=k;
                    if(checkLocation(i-k, j+k, size) && bits[i][j]!=bits[i-k][j+k]) cost+=k;
                    if(checkLocation(i-k, j-k, size) && bits[i][j]!=bits[i-k][j-k]) cost+=k;
                    if(checkLocation(i+k, j, size) && bits[i][j]==bits[i+k][j]) cost+=k;
                    if(checkLocation(i-k, j, size) && bits[i][j]==bits[i-k][j]) cost+=k;
                    if(checkLocation(i, j+k, size) && bits[i][j]==bits[i][j+k]) cost+=k;
                    if(checkLocation(i, j-k, size) && bits[i][j]==bits[i][j-k]) cost+=k;
                }
            }
        }
        return cost;
    }

    private static boolean checkLocation(int i, int j, int size) {
        if(i < 0 || i >= size) return false;
        else if(j < 0 || j >= size) return false;
        else return true;
    }
}
