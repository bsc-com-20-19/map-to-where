public class UnderGraduateStudent extends StudentLoanAccount{
    private double stationaryLoan;
    private double stationaryLoanInterest;    
   
    public UnderGraduateStudent(String name, String program, int currentYear, String accountNumber){

        super(name, program, currentYear, 4, accountNumber);
    }

public void applyForStationaryAllowance(double amount){
        double repayAmount = AnnualCompoundInterest(amount, 0.15);
        this.stationaryLoan += repayAmount;
        this.stationaryLoanInterest = repayAmount - amount;
    }
    public void repayStationaryAllowance(double amount){
        this.stationaryLoan -= amount;
    }
    public void applyForSubsistenceLoan(double amount) {
        super.applyForSubsistenceLoan(amount, .11);
    }
    
    public double getStationaryAllowance(){
        return this.stationaryLoan;
    }

    @Override
    public String getAllLoans() {
        return super.getAllLoans() + 
        "Stationary \t\t " + this.stationaryLoan + " \t\t " + this.stationaryLoanInterest;

    }
}
