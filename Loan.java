import java.util.ArrayList;
import java.util.Random;

class Loan{
    public static ArrayList<Loan> loanAccount = new ArrayList<>();
    private String Name;
    private String ProgramEnrolled;
    private int CurrentYear;
    private int programDuration;
    private double TuitionLoan;
    private double TuitionLoanInterest;
    private double SubsistenceLoan;
    private double SubsistenceLoanInterest;
    private String AccountNumber;
    public final double SubsistenceInterestRate;

    public Loan(String Name,String ProgramEnrolled, int CurrentYear, double SubsistenceInterestRate, int programDuration,String AccountNumbercode){
        this.Name = Name;
        this.ProgramEnrolled = ProgramEnrolled;
        this.CurrentYear = CurrentYear;
        this.programDuration = programDuration;
        this.SubsistenceInterestRate = SubsistenceInterestRate;
        //generate an account number by passing the account number code to the method generateAccountNumber
        this.AccountNumber = generateAccountNumumber(AccountNumbercode);
    }
    //generates an  account Number for a particular Student
    private String generateAccountNumumber(String prepend){
        Random random = new Random(4);
        String AccountNum;
    
        if((Loan.loanAccount).isEmpty()){
            AccountNum = prepend + random.nextInt(1000);
            return AccountNum;
        }
        //compares the account number generated with other account numbers generated
        else{
            Boolean AccountExists = true;
            //iterates until account number is unique
            do{
                //generate account number before comparing
                AccountNum = prepend + random.nextInt(1000);
                //comparing operation
                for(int i = 0; i< (Loan.loanAccount).size(); i++){
                    
                    if(Loan.loanAccount.get(i).getAccountNumber().equals(AccountNum)){
                        AccountExists = true;
                        break;  //breaks the for loop to generate another number since the account exists
                    }
                    //by Reaching the last index means the account number does'nt exists 
                    if(i+1 == Loan.loanAccount.size()){
                        AccountExists = false;
                    }
                }

            }while(AccountExists);
            return AccountNum;
            }
        }
        

    public String getAccountNumber() {
        return this.AccountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.AccountNumber = accountNumber;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getProgramEnrolled() {
        return ProgramEnrolled;
    }

    public void setProgramEnrolled(String programEnrolled) {
       this.ProgramEnrolled = programEnrolled;
    }

    public int getCurrentYear() {
        return CurrentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.CurrentYear = currentYear;
    }

    public int getProgramDuration() {
        return programDuration;
    }

    public void setProgramDuration(int programDuration) {
        this.programDuration = programDuration;
    }
     // sum of all the loans
     public double getTotalLoans(){
        return this.TuitionLoan + this.SubsistenceLoan;
    }

      // method for applying for susbstince loan
    public void applyForSubsistenceLoan(double amount){
        double AmountToBePaid = AnnualCompoundInterest(amount, this.SubsistenceInterestRate);
        this.SubsistenceLoan += AmountToBePaid;
        this.SubsistenceLoanInterest = AmountToBePaid - amount;
        System.out.println("--- Subsistence loan Applied successfully ----");
    }
    public void repaySubsistenceLoan(double amount){
      //returns amount paid when user has no loans
      if(this.SubsistenceLoan <= 0){
        System.out.printf("You don't have any subsistence loan right now..." + 
                        "\nMWK%.2f returned \n", amount );
    return;
}
double Extra = 0 ; //money left after paying the loan
if(this.SubsistenceLoan - amount <= 0){
    System.out.println("You've Successfully repaid your subsistence loan.");
    //returns extra money if the amount paid back is Greater than the loan 
    if(this.SubsistenceLoan - amount < 0) {
        Extra = amount - this.SubsistenceLoan;
        System.out.printf("The extra money: MWK%.2f returned \n", Extra );
    }
    //When User has no loans...
    this.SubsistenceLoan = 0;
    this.SubsistenceLoanInterest = 0;//sets interest to zero when the loan is fully repaid
}else{ 
    System.out.printf("You've paid MWK%.2f to your subsistence loan\n", amount);
    this.SubsistenceLoan -= amount;
}
    }
    public double getSubsistenceLoan(){
        return this.TuitionLoan;
    }
    //method to show all available  loans and there interest
    public void getAllLoans(){
        System.out.println("Type of Loan \t\t Loan amount\t\t Interest added" + 
        "\n------------------------------------------------------------------------------");
System.out.printf("Tuition      \t\t %12.2f \t\t %9.2f" , this.TuitionLoan, this.TuitionLoanInterest);
System.out.printf("\nSubsistence  \t\t %12.2f \t\t %9.2f", this.SubsistenceLoan, this.SubsistenceLoanInterest);
    }
    public double AnnualCompoundInterest(double amount, double rate){
        int NumOfYears = this.programDuration - this.CurrentYear;
        double ACI = amount * ( Math.pow(1 + rate, NumOfYears ));
        return ACI;
    }
}
// method for applying for tuition loan
    public void applyForTuitionLoan(double amount){
        double AmountToBePaid = AnnualCompoundInterest(amount, 0.10);
        this.TuitionLoan += AmountToBePaid;
        this.TuitionLoanInterest = AmountToBePaid - amount;
        System.out.println("---Tuition Loan Applied successfully ----");
    }
    //method for repaying tuition loan
    public void repayTuitionLoan(double amount){
        if(this.TuitionLoan <= 0){
            System.out.printf("You don't have any tuition loan right now...");
        return;
    }
    double Extra = 0 ; //Amount left after paying the  tuition loan
    
    if(this.TuitionLoan - amount <= 0){
        System.out.println("You've Successfully repaid your tuition loan in full ");
        
        //this returns money left when amount is greater than the specified loan
        if(this.TuitionLoan - amount < 0) {
                Extra = amount - this.TuitionLoan;
            System.out.printf("The money left is : MWK%.2f returned \n", Extra );
        }
        //When student has no Tuition Loan
        this.TuitionLoan = 0;
        this.TuitionLoanInterest = 0; //this sets interest to zero when the loan is fully repaid
    }
    // the message to be shown when the amount paid does not fully repay the loan 
    else{ 
        System.out.printf("You've paid MWK%.2f to your tuition loan\n", amount);
        this.TuitionLoan -= amount;
}     
    }
    public double getTuitionLoan(){
        return this.TuitionLoan;
    }
  