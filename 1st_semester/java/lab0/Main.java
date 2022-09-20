import java.util.Random;
import java.lang.Math;

public class Main{
    static boolean CheckIfValueInArray(double[] nums, double valueToCheck)
    {
        for (double el : nums){
            if (el == valueToCheck){
                return true;
            }
        }
        return false;
    }

    static double[] CalculateTanLnAbsX(double[] nums)
    {
        double[] newNums = new double[nums.length];

        for(int i = 0; i < newNums.length; i++){
            newNums[i] = Math.tan(Math.log(Math.abs(nums[i])));
        }

        return newNums;
    }

    static double[] CalculateFirstScaryThing(double[] nums)
    {
        double [] newNums = new double[nums.length];

        for(int i = 0; i < newNums.length; i++){
            newNums[i] = Math.cos(nums[i]) / 2;
            newNums[i] = 1 - Math.pow(newNums[i], Math.tan(newNums[i]));
            newNums[i] = 4 / newNums[i];

            double scaryPower = Math.atan((nums[i] + 2.5) / 13);
            scaryPower = 0.5 * (scaryPower - 3);
            scaryPower = Math.pow(scaryPower, 1 / 3);

            newNums[i] = Math.pow(newNums[i], scaryPower);
        }

        return newNums;
    }

    static double[] CalculateSecondScaryThing(double[] nums)
    {
        double [] newNums = new double[nums.length];

        for (int i = 0; i < newNums.length; i++){
            newNums[i] = Math.pow(Math.PI * nums[i], nums[i]);
            newNums[i] = Math.pow(0.5 * newNums[i], 3);
            newNums[i] = Math.pow(Math.sin(newNums[i]), 2);
            newNums[i] = 1 / Math.exp(newNums[i]);
            newNums[i] = Math.atan(newNums[i]);
        }

        return newNums;
    }

    public static void PrettyOutput(double[][] nums)
    {
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[0].length; j++){
                System.out.printf("%10.4f ", nums[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args)
    {
        int[] b = new int[12];

        for(int i = 0; i < b.length; i++){
            b[i] = i + 5;
        }

        double[] x = new double[18];
        Random randomizer = new Random();


        for(int i = 0; i < x.length; i++){
            x[i] = randomizer.nextDouble() * 13 - 4;
        }

        double[][] h = new double[12][18];

        for(int i = 0; i < b.length; i++){
            if(x[i] == 7){
                h[i] = CalculateTanLnAbsX(x);
            }

            else if(CheckIfValueInArray(new double [] {5, 6, 8, 10, 11, 13}, b[i]) == true){
                h[i] = CalculateFirstScaryThing(x);
            }

            else{
                h[i] = CalculateSecondScaryThing(x);
            }
        }

        PrettyOutput(h);
    }
}