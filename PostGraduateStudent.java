import java.util.*;
public class PostGraduateStudent extends LoanAccount{
    private double researchLoan;
    private double researchInterest;
    private final double researchInterestRate = 0.1;

    PostGraduateStudent(String name, String program, int currentYr){
        super(name, program, currentYr, 3, 0.15);  // duration is 4 and subsistence rate is 11% for PostGraduate
        this.generateAccountNumber();
    }    

    @Override
    protected void generateAccountNumber() {
        Random random = new Random(3);
        String postGradAccountNumber;

        if((LoanAccount.accounts).size() == 0){
            postGradAccountNumber = "PG" + random.nextInt(1000);
            setAccountNumber(postGradAccountNumber);
        }
        //This else block checks a generated account number exists or not.. 
        else{
            boolean accountExists = true;
            //iterates until the generated account number is unique
            do{
                postGradAccountNumber = "PG" + random.nextInt(1000);
                for(int i =0; i< (LoanAccount.accounts).size() ; i++){
                    //The ArrayList supports different types of Loan.. 
                    //Only the under graduate accounts have to be checked
                    if(LoanAccount.accounts.get(i) instanceof PostGraduateStudent){
                        if(LoanAccount.accounts.get(i).getAccountNumber().equals(postGradAccountNumber)){
                            accountExists = true;
                            break;  
                        }
                    }else   // the iteration account is an instance of another subclass
                        continue;
                    
                }
                super.setAccountNumber(postGradAccountNumber);
                accountExists = false;


            }while(accountExists);
        }
        
    }

    //applying for a research grant method
    public void applyForResearchGrant(double researchAmount){
        if(researchAmount < 50_000 &&researchAmount > 100_000){
            System.out.println("The amount for research ranges from MWK50,000.00 to MWK100,000"+
                "\n ...Loan not granted...");
            return;
        }
        this.researchLoan += researchAmount;
        double payBackAmount = calculateCompoundtInterest(researchAmount, this.researchInterestRate);
        this.researchInterest += payBackAmount - researchAmount;
        System.out.println("....Research Loan granted....");

        this.miniStatement += "\n" + (new Date()).toString() + ": Applied for tuition fee loan of MWK" + researchAmount +
            " with a payback amount of MWK" + payBackAmount;
    }

    //repaying research grant loan
    public void payBackResearchLoan(double amount){
        this.researchLoan -= amount;
        this.miniStatement += "\n" + (new Date()).toString() + ": Paid back an amount of  " + amount + 
        "to your research grant Loan";
    }
}