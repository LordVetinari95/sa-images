import java.util.Random;

public class ImageSolver {
    private Random random = new Random();
    private double delta;
    private int n;
    private int[][] bits;
    private int method;
    private double temp = 20000.0;
    private double coolingRate;

    public int[][] getBits() {
        return bits;
    }

    public ImageSolver(double delta, int n, double coolingRate, int method) {
        this.delta = delta;
        this.n = n;
        this.bits = new int[n][n];
        fillBits();
        this.coolingRate = coolingRate;
        this.method = method;
    }

    private int[][] copyArray(int[][] toCopy){
        int[][] copyArray = new int[n][];
        for (int i = 0; i < n; i++) {
            copyArray[i] = toCopy[i].clone();
        }
        return copyArray;
    }

    private boolean countProbability(int currentCost, int consideredCost){
        if(consideredCost < currentCost) return true;
        else return Math.exp((currentCost-consideredCost)/temp) > random.nextDouble();
    }

    public int[][] solveImage(){
        int iter = 0;
        int[][] current = copyArray(bits);
        int[][] best = copyArray(current);
        int[][] swap;

        System.out.println(CostCounter.countCost(current,method));
        while(temp > 0.0001){
            swap = copyArray(current);
            createNextState(swap);

            if(countProbability(CostCounter.countCost(current,method),CostCounter.countCost(swap,method))){
                current = copyArray(swap);
            }

            if(CostCounter.countCost(best,method) > CostCounter.countCost(current,method)) best = copyArray(current);
            temp = temp*(1-coolingRate);
            iter++;
        }
        System.out.println(CostCounter.countCost(best,method));
        System.out.println("Algorithm generated " + Integer.toString(iter) + " state(s) before it has finished.");
        return best;
    }

    private void createNextState(int[][] current) {
        for (int i = 0; i < 10; i++) {
            int x1, y1, x2, y2;
            do {
                x1 = random.nextInt(n);
                y1 = random.nextInt(n);
                x2 = random.nextInt(n);
                y2 = random.nextInt(n);

            } while (!canChange(x1, y1, x2, y2));
            int tmp = current[x1][y1];
            current[x1][y1] = current[x2][y2];
            current[x2][y2] = tmp;
        }
    }

    private boolean canChange(int x1, int y1, int x2, int y2) {
        if (bits[x1][y1] == bits[x2][y2]) return false;
        else return !(x1 == x2 && y1 == y2);
    }


    private void fillBits(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(delta > random.nextDouble()) bits[i][j] = 1;
                else bits[i][j] = 0;
            }
        }

    }



}
