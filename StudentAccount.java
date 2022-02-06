public class StudentAccount{
    private String name;
    private String program;
    private int currentYear;
    private double tuitionLoan;
    private double tuitionLoanInterest;
    private double subsistenceLoan;
    private double subsistenceLoanInterest;
    private String accountNumber;

    private int programDuration;

    public StudentAccount(String name, String program, int currentYear, 
            int programDuration, String accountNumber){
                    this.name = name;
                    this.program = program;
                    this.currentYear = currentYear;
                    this.programDuration = programDuration;
                    this.accountNumber = accountNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public int getProgramDuration() {
        return programDuration;
    }

    public void setProgramDuration(int programDuration) {
        this.programDuration = programDuration;
    }
    
    
    public void applyForTuitionLoan(double amount){
        //
        double repayAmount = AnnualCompoundInterest(amount, 0.1);
        this.tuitionLoan += repayAmount; 
        this.tuitionLoanInterest = repayAmount - amount;

    }
    public void repayTuitionLoan(double amount){
        this.tuitionLoan -= tuitionLoan;
    }
    public double getTuitionLoan (){
        return this.tuitionLoan;
    }

    public void applyForSubsistenceLoan(double amount, double rate){
        double repayAmount = AnnualCompoundInterest(amount, rate);
        this.subsistenceLoan += repayAmount;
        this.subsistenceLoanInterest = repayAmount - amount;
    }
    public void repaySubsistenceLoan (double  amount){
        this.subsistenceLoan -= amount;
    }
    public double getSubsistenceLoan(){
        return this.subsistenceLoan;
    }

    public String getAllLoans(){
        return "Type of Loan \t\t Loan amount \t\t Interest " +
                "_____________________________________________"+
                "\nTuition \t\t " +  this.tuitionLoan + " \t\t " +  this.tuitionLoanInterest +
                "\nSubsistence \t\t " + this.subsistenceLoan + " \t\t " + this.subsistenceLoanInterest;
    }


    public double AnnualCompoundInterest(double amount, double rate) {
        int time =  this.programDuration - this.currentYear;
        double A = amount * ( Math.pow(1 + rate, time ));
        return A;
    }
    



}