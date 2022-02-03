import java.util.*;
public class UnderGraduateStudent extends LoanAccount{
    private double stationaryLoan ;
    private double stationaryInterest;
    private final double stationaryInterestRate = 0.15;
    
    UnderGraduateStudent(String name, String program, int currentYr){
        super(name, program, currentYr, 4, 0.11); // duration is 4 and subsistence rate is 11% for underGraduate 
        this.generateAccountNumber();
    }

    
    @Override
    protected void generateAccountNumber(){
        Random random = new Random(3);
        String underGradAccountNumber;

        if((LoanAccount.accounts).size() == 0){
            underGradAccountNumber = "UG" + random.nextInt(1000);
            setAccountNumber(underGradAccountNumber);
        }
        //This else block checks a generated account number exists or not.. 
        else{
            boolean accountExists = true;
            //iterates until the generated account number is unique
            do{
                underGradAccountNumber = "UG" + random.nextInt(1000);
                for(int i =0; i< (LoanAccount.accounts).size() ; i++){
                    //The ArrayList supports different types of Loan.. 
                    //Only the under graduate accounts have to be checked
                    if(LoanAccount.accounts.get(i) instanceof UnderGraduateStudent){
                        if(LoanAccount.accounts.get(i).getAccountNumber().equals(underGradAccountNumber)){
                            accountExists = true;
                            break;  
                        }
                    }else   // the iteration account is an instance of another subclass
                        continue;
                    
                }
                super.setAccountNumber(underGradAccountNumber);
                accountExists = false;


            }while(accountExists);
        }

    }

    public void applyForStationaryLoan(double stationaryAmount){
        this.stationaryLoan += stationaryAmount;
        double payBackAmount = calculateCompoundtInterest(stationaryAmount, this.stationaryInterestRate);
        this.stationaryInterest += payBackAmount - stationaryAmount; 
        
        System.out.println("....Stationary Loan granted....");
        this.miniStatement += "\n" + (new Date()).toString() + ": Applied for tuition fee loan of MWK" + stationaryAmount +
            " with a payback amount of MWK" + payBackAmount;
    }
    //method for repaying stationary Loan
    public void payBackStationaryLoan(double amount){
        this.stationaryLoan -= amount;
        this.miniStatement += "\n" + (new Date()).toString() + ": Paid back an amount of  " + amount + 
                        "to your stationary  Loan";      
    }
    
}