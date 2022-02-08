import java.util.*;
class StudentAccount {
   public static Scanner input = new Scanner(System.in);
   public static void AccountStudentAccount(Loan Student) {
    System.out.println();
    System.out.printf("  Welcome %s (%s, %s) to the loan menu" + 
                    "\n_______________________________________________________________________",
                    Student.getName(), Student.getAccountNumber(), Student.getProgramEnrolled());
    
                    LoanMenu(Student); 
   }            

   public static void LoanMenu(Loan Student){
      System.out.println("\n   LOAN MENU " + 
                       "\n-----------------");
System.out.println( 
       "1. Apply For Loan " +
       "\n2. Pay Back Loan " +
       "\n3. Available Loans " +
       "\n4. Logout");
System.out.print("Enter your option:: ");
int option = input.nextInt();
switch (option) {
   case 1: ApplyLoan(Student);
       break;

   case 2: PayBackLoan(Student);
       break;
   case 3: Student.getAllLoans();
           System.out.println();
           break;
   case 4: System.out.println(Student.getName() +  "\n<<<<<<<<<<<Logging out>>>>>>>>>>>...");
           LoanManagementSystem.main(null);
   default: System.out.println("::::iNVALID OPTION::::");
   
}
LoanMenu(Student);
   }
   public static void ApplyLoan(Loan Student) {
      System.out.println();
      //determines weither the account is undergraduate(true) or postgraduate (false)
      boolean isUndergraduate = (Student instanceof Undergraduate);
      System.out.println(":::SELECT LOAN TYPE::: " +
                      "\n---------------------------------" +
                      "\n1. Tuition Loan" +
                      "\n2. Subsistence Loan" +
                      //a conditional statement that print an option based on student either undergrad (stationary) or postgrad (research)
                      "\n3. " + (isUndergraduate ?   "Stationary" : "Research Grant") + 
                      "\n00. Loan Menu"); 
      System.out.print("Select Option:: ");
      int key = input.nextInt();

      switch (key) {
          case 1: System.out.print("Enter Tuition Loan Amount(MWK): ");
                  Student.applyForTuitionLoan(input.nextDouble());
              break;
          case 2: System.out.print("Enter Subsistence Loan Amount(MWK): ");
                  Student.applyForSubsistenceLoan(input.nextDouble());
                  break;
          case 3: 
              //option for undergraduate is stationary therefore...
              if(isUndergraduate){
                  System.out.print("Enter stationary Loan Amount(MWK): ");
                  ((Undergraduate)Student).applyForStationaryAllowance(input.nextDouble());   
              }
              //option for postgraduate is research grant
              else{ 
                  System.out.print("Enter research grant amount(MWK): ");
                  ((Postgraduate)Student).ApplyForResearchGrant(input.nextDouble());
              }
              break;
          case 00: LoanMenu(Student);

          default: System.out.println("!!!!Wrong option try again...");
              break;
      }
      LoanMenu(Student);
}
public static void PayBackLoan(Loan Student) {
   System.out.println();
   //Determines weither the account is undergraduate(true) or postgraduate (false)
   boolean isUndergraduate = (Student instanceof Undergraduate);
   System.out.println("LOAN REPAYMENT:: SELECT LOAN TYPE" +
                   "\n--------------------------------------" +
                   "\n1. Tuition" +
                   "\n2. Subsistence" +
    (isUndergraduate ? "\n3. Stationary" : "") + 
                   "\n00. Loan menu"); 
   System.out.print("Select  option::: ");
   int option = input.nextInt();

   switch (option) {
       case 1: System.out.print("Enter Tuition loan repayment amount(MWK): ");
               Student.repayTuitionLoan(input.nextDouble());
           break;
       case 2: System.out.print("Enter subsistence amount(MWK): ");
               Student.repaySubsistenceLoan(input.nextDouble());;
               break;
       case 3: 
           //option for undergraduate to repay stationary loan
           if(isUndergraduate){
               System.out.print("Enter stationary repayment amount(MWK): ");
               ((Undergraduate)Student).repayStationaryAllowance(input.nextDouble());;   
           }
           //option 3 is invalid for postgraduate
           else{ 
               System.out.println("!!!!invalid Selection try again...");
           }
           break;
       case 00: LoanMenu(Student);

       default: System.out.println("!!!!invalid Selection try again...");
           break;
   }
   LoanMenu(Student);
}

 }
 

