import java.util.Scanner;
public class financialForecast{
    public static double futureValueRecursive(int years, double rate, double initial){
        if(years==0){
            return initial;
        }
        return futureValueRecursive(years-1, rate, initial) * (1+rate);
    }
    public static double futureValueIterative(int years, double rate, double initial){
        double result=initial;
        for(int i=1; i<=years; i++){
            result*=(1+rate);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter initial investment amount: ");
        double initial=sc.nextDouble();

        System.out.print("Enter annual growth (in %): ");
        double ratePercent=sc.nextDouble();
        double rate= ratePercent/100;

        System.out.print("Enter number of years to forecast: ");
        int years=sc.nextInt();

        double recursiveResult= futureValueRecursive(years, rate, initial);
        System.out.printf("\n[Recursive] predicted value after %d years: %.2f\n",years,recursiveResult);
        double iterativeResult= futureValueIterative(years, rate, initial);
        System.out.printf("\n[Iterative] predicted value after %d years: %.2f\n",years,iterativeResult);
        sc.close();
    }
}