 class Undergraduate extends Loan {
    private double StationaryLoan;
    private double StationaryLoanInterest;
    private final double StationaryLoanInterestRate = 0.15;

    public Undergraduate(String Name,String ProgramEnrolled, int CurrentYear){
        super(Name,ProgramEnrolled,CurrentYear,0.11,4,"UG");
        //for undergrade subsistence loan interest is 11% ,duration is 4 Yrs and we add UG to the account number 
    }
    public void applyForStationaryAllowance(double amount){
        double AmountToBePaid = AnnualCompoundInterest(amount, this.StationaryLoanInterestRate);
        this.StationaryLoan += AmountToBePaid;
        this.StationaryLoanInterest = AmountToBePaid - amount;
        System.out.println("---Stationary Loan Successfully granted---");
    }
    public void repayStationaryAllowance(double amount){

        if(this.StationaryLoan <= 0){
            System.out.printf("You don't have any stationary loan right now..." + 
                            "\nMWK%.2f returned \n", amount );
            return;
        }
        double Extra = 0 ; //the money left after repaying loan
        
        if(this.StationaryLoan - amount <= 0){
            System.out.println("You've Successfully repaid your stationary loan Allowance.");
            
            //returns extra money if the amount paid back is greater than the loan 
            if(this.StationaryLoan - amount < 0.00) {
                Extra = amount - this.StationaryLoan;
                System.out.printf("The extra money: MWK%.2f returned \n", Extra );
            }
            //apparently user has no loan
            this.StationaryLoan = 0 ;
            this.StationaryLoanInterest = 0 ; // when the loan is fully repaid sets interest to zero
        }
        //when the amount paid does not fully repay the loan 
        else{ 
            System.out.printf("You've paid MWK%.2f to your stationary loan Allowance\n", amount);
            this.StationaryLoan -= amount;
        }
    }
    public double getStationaryAllowance(){
        return this.StationaryLoan;
    }

    @Override
    public void getAllLoans() {
   
        //when the user has no loans
        if(super.getTuitionLoan() == 0 && super.getSubsistenceLoan() == 0 && this.StationaryLoan == 0 ){
            System.out.println("\nYou don't have any LoanS so far ");
            return;
        }
        super.getAllLoans();
        System.out.printf("\nStationary  \t\t %12.2f \t\t %9.2f \n", this.StationaryLoan, this.StationaryLoanInterest);
    }
@Override
public double getTotalLoans() {
    return super.getTotalLoans() + this.StationaryLoan;
}
  }
