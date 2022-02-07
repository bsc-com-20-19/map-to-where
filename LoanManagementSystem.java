import java.util.*;
public class LoanManagementSystem {
     public static void main(String [] args){
// the array to hold all the loans for each type of  student loan account
    public static ArrayList<PostGraduateAccount> postAccounts = new ArrayList<>();
    public static ArrayList<UnderGraduateStudentAccount> underAccounts = new ArrayList<>();
    static Scanner input  = new Scanner(System.in);
    
    
//the main menu for the whole program
        System.out.println("\t\t\t\tLOAN MANAGEMENT SYSTEM" +
        "\n              __________________________________________________");
        System.out.println(
              "1. Create Account" +
            "\n2. Apply Loan" +
            "\n3. view Loans" +
            "\n4. List All Accounts" +
            "\n5. Exit");

            int opt = input.nextInt();
            if (opt ==1){
                createAccount();
                
            }else
            if(opt ==2){
                applyLoan();
            }else 
            if(opt ==3){
                viewLoan();
            }else
            if(opt ==4){
                listAllBanks();
            }else
            if(opt  ==5){
               exit();
            }
            else{
                System.out.println("Invalid input try again");
                main(null);
            }

     // to create  a method for creating a loan account for both types of students
     public static void createAccount() {

    }
    // to create  a method for applying for a  loan for both types of students
  public static void applyLoan() {
    }

//method to allow the user to view the loans he\she has 
 public static void viewLoan() {
        System.out.println(
            "\tAccount type" +
            "\n---------------------" + 
            "\n1. Undergraduate" + 
            "\n2. Postgraduate" + 
            "\n3. Return to main" + 
            "\n4. exit");
            int opt = input.nextInt();
            switch (opt) {
                case 1: 
                    System.out.print("Enter account number: ");
                    // checks if the account exists 
                    int itExists = findUnderGradAccount(input.next());
                    if (itExists ==-1){
                        System.out.println("The account number does not exists");
                    }
                    else{
                        LoanManagementSystem.underAccounts.get(itExists).getAllLoans();
                    }
                    break;
            
                default:
                    break;
            }
    }


    public static void listAllBanks() {
        if(LoanManagementSystem.postAccounts.isEmpty()){
            System.out.println("No accounts availble");
        }
    }
   
    //returns zero when the count does not exists
    public static int findUnderGradAccount(String accountNuber){
        return -1;
    }
    // the method for exiting the whole loan management system
    public static void exit(){
        System.out.println("Thanks for trusting the loan management system");
        System.exit(1);
    }
  }
}