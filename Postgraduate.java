class Postgraduate extends Loan {
    private double ResearchGrant;
    public Postgraduate(String Name,String ProgramEnrolled, int CurrentYear){
        super(Name,ProgramEnrolled,CurrentYear,0.15,3,"PG");
        /**for postgraduate  subsistence loan interest is 15% ,duration is 3 Yrs
         and we are going to add PG to the account number  */
    }

   public void ApplyForResearchGrant(double amount){
       if(amount < 50000 || amount > 100000){
           System.out.print("INVALID CHOICE THE LOAN AMOUNT CAN ONLY BETWEEN MK50000 AND MK100000" + "\n Loan *Not* Granted... :(");
       }
       else{
           this.ResearchGrant += amount;     
           System.out.println("---Research grant granted---");
   
       }
   }

    public double getResearchGrant(){
        return this.ResearchGrant;
    }
    
    @Override
    public void getAllLoans() {
        //when the student has no loanS
        if(super.getTuitionLoan() ==0 && super.getSubsistenceLoan() ==0 && this.ResearchGrant ==0 ){
            System.out.println("\nYou don't have any Loan so far ");
            return;
        }
        super.getAllLoans();
        System.out.printf("\nResearch     \t\t %12.2f \t\t %9s",this.ResearchGrant," Not applicable \n" );

    }

}
