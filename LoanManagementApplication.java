import java.util.Scanner;
public class LoanManagementApplication{
    public static void main (String [] args){
        Scanner get = new Scanner(System.in);
        
        LoanAccount kaloan = new LoanAccount("Peter", "computer Science", 2, 4, 0.15);
        kaloan.displayInterestRates();

        System.out.print("Enter the tuition fee you want to borrow from the loans board: \nAmount:  ");
        double amount = get.nextDouble();
        kaloan.applyForTuitionFeeLoan(amount);

        kaloan.displayMiniStatement();
        
    }
}