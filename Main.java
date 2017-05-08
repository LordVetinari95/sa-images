import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        double[] deltas = {0.1,0.3,0.4};
        double[] coolingRates = {0.001, 0.005, 0.01};
        int[] methods = {1,2,3};
        int n = 150;
        int counter=0;
        for(double delta: deltas){
            for(double coolingRate: coolingRates){
                for(int m: methods){
                    ImageSolver g = new ImageSolver(delta, n, coolingRate, m);
                    int[][] before = g.getBits();
                    int[][] after = g.solveImage();
                    try {
                        String x = Integer.toString(counter++)+"d"+Double.toString(delta)+"cr"+Double.toString(coolingRate)+"m"+Integer.toString(m);
                        Drawer.drawImage(before,x+"before", 4);
                        Drawer.drawImage(after,x+"after", 4);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
