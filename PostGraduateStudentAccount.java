public class PostGraduateStudentAccount extends StudentAccount{

    private double researchGrant ;

    public PostGraduateStudent(String name, String program, int currentYear, String accountNumber) {
        super(name, program, currentYear, 3, accountNumber);
    }
         
         
         public void applyForResearchGrant(double amount){
        if (amount <50_000 && amount >100_000){
            System.out.println("The amount entered is INVALID...."+
            "\nThe amount has to range from MWK50,000.00 to MWK100,000.00");
            return;
        }
        this.researchGrant = amount;
    }


     public double getResearchGrant(){
        return this.researchGrant;
    }

    public void applyForSubsistenceLoan(double amount) {
        super.applyForSubsistenceLoan(amount, .15);
    }
    @Override
    public String getAllLoans() {              
        return super.getAllLoans() + 
        "Research \t\t " + this.researchGrant +" \t\t Grant";
    }
    
}