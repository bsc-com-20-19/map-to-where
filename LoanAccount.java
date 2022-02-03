import java.util.*;
abstract public class LoanAccount{

    public static ArrayList<LoanAccount> accounts = new ArrayList<>();
    private String name ;
    private String program;
    private String accountNumber;
    private int currentYr;
    private final int programDuration;

    private double tuitionLoan;
    private double tuitionInterest;
    private final double tuitionInterestRate = 0.1;
    
    private double subsistenceLoan;
    private double subsistenceInterest;
    public final double subsistenceInterestRate;
    
    protected String miniStatement = "----------LOAN MINISTATEMENT----------"; //Keeps records of all processes carried out by a  loan applicant
    //there will be a no arg construstor

    //Specific constructor
    protected LoanAccount(String name,
                         String program,
                         int currentYr,
                         int programDuration,
                         double subsistenceInterestRate){
        this.name = name;
        this.program = program;
        this.currentYr = currentYr;
        this.subsistenceInterestRate = subsistenceInterestRate;
        this.programDuration = programDuration;
        miniStatement += "\n" + (new Date()).toString() + " created your account"; //adds the Date of account creation
    }

    //Generates the account number for a particular type type of studend. Either underGrad or postGrad
    abstract protected void generateAccountNumber();
    
    //setters and getters of the the class attributes

    //This method is protected because only the subclass can set the account number not the user
    protected void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }
    public void setName (String name){
        this.name = name;
    }
    public String getName (){
        return this.name ;
    }
    public void setProgram(String program){
        this.program = program;
    }
    public String getProgram(){
        return this.program;
    }
    public void setCurretYear(int yr){
        this.currentYr = yr;
    }
    public int getCurrentYear(){
        return this.currentYr;
    }
    public int getProgramDuration(){
        return this.programDuration;
    }
    public void getAllLoansAccessed(){
        System.out.println("Type of Loan\t\t Interest");
        if(this.tuitionLoan > 0)
        System.out.println( this.tuitionLoan + "\t\t" + tuitionInterest);
        System.out.println(this.subsistenceLoan + "\t\t");

    }
    //Tuition Loan application method
    public void applyForTuitionFeeLoan(double tuitionFeeAmount){
        tuitionLoan += tuitionFeeAmount;
        double payBackAmount = this.calculateCompoundtInterest(tuitionFeeAmount, this.tuitionInterestRate);
        this.tuitionInterest = payBackAmount - tuitionFeeAmount;
        
        System.out.println("....Tuition fees loan granted....");
        this.miniStatement += "\n" + (new Date()).toString() + ": Applied for tuition fee loan of MWK" + tuitionFeeAmount +
                     " with a payback amount of MWK" + payBackAmount;
    }

    //Subsistence Loan application method
    public void applyForSubsistenceLoan(double subsistenceAmount){
        this.subsistenceLoan +=  subsistenceAmount;
        double payBackAmount = this.calculateCompoundtInterest(subsistenceAmount, this.subsistenceInterestRate);
        this.subsistenceInterest = payBackAmount - subsistenceAmount;

        System.out.println("....Subsistence Loan granted....");
        this.miniStatement += "\n" + (new Date()).toString() + ": Applied for subsistence loan of MWK" + subsistenceAmount +
                     " with a payback amount of MWK" + payBackAmount;
       
    }

    // //method for supporting application of other types of loans from the subclasses
    // protected void otherLoanApplication(double amount, double interest,  String typeOfLoan){
    //     double payBackAmount = this.calculateCompoundtInterest(amount, interest);
    //     this.loan += payBackAmount;
    //     System.out.println("...."+ typeOfLoan + " loan granted....");
    //     miniStatement += "\n" + (new Date()).toString() + ": Applied for " + typeOfLoan +" loan of MWK" + amount +
    //                  " with a payback amount of MWK" + payBackAmount;
    // }

    //Shows the applicant the rates for all loan types
    // public void displayAllLoan(){
    //     System.out.println(
    //             "Interest Rates" +
    //         "\n----------------" +
    //         "\nTuition      : " + this.tuitionInterestRate +
    //         "\nSubsistence  : " + this.subsistenceInterestRate
    //         );
    // }
    public void displayMiniStatement(){
        System.out.println(this.miniStatement);
    }

    //methods for paying back loans
    public void payBackTuitionLoan(double amount){
        this.tuitionLoan -= amount;
        this.miniStatement += "\n" + (new Date()).toString() + ": Paid back an amount of  " + amount + 
                        "to your Tuition Loan";             
    }
    public void payBackSubsistenceLoan(double amount){
        this.subsistenceLoan -= amount;
        this.miniStatement += "\n" + (new Date()).toString() + ": Paid back an amount of  " + amount +
                         "to your Subsistence Loan";
    }

    //Calculates the compount interest of the specifed principle
    /**The interest is compounded annually, this implies that n in the formula will be 1
    P = loan amount
    r = annual interest rate
    t= the time the money is borrowed for 
    A = P(1 + r/n)^(nt) is the formuala
    A is the amount to pay back together, both the principal and compound interest 
    */
    
    public double calculateCompoundtInterest(double P, double r){
        //t is the remain time to finish the program
        int t = this.programDuration - this.currentYr;
        double A = P * (Math.pow( 1+r, t ) * 100)/100.0;
        return A;
    }

}