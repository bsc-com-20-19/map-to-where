import java.util.ArrayList;

import java.util.Scanner;
public class LoanManagementSystem {
   static Scanner input = new Scanner(System.in);
    
    public static void main(String [] args) {
        System.out.println(" ");
        System.out.println("\t------LOAN MANAGEMENT SYSTEM------" +
            "\n___________________________________________________________");
            home();
    }
    public static void home(){
        System.out.println("" + 
        "\n1. Create account" +
        "\n2. Account Login" +
        "\n3. List All Loan Accounts" +
        "\n4. About" +
        "\n5. Exit");
        System.out.print("\nEnter your option::::: ");
        int choice = input.nextInt();
        switch(choice){
            case 1: createAccount();break;
            case 2: accountLogin() ; break;
            case 3: ListAllAccounts(); break;
            case 4: System.out.println("\nAbout:\nLoan management system Allows Undergraduate or Postgaraduate Students,"+
                                        "\nto be able apply for different types of loans" + 
                                        "\nfor a student to apply and payaback his /her loans he /she must hava an account." +
                                        "\n---------------------------------------------------------------------------------");
                    break;
            case 5: exit();
            default: System.out.println("___WRONG____CHOICE___" +
                            " Try again: \n");
                    home(); //returns to the home method
        }
        
        main(null);
}

 // show all available accounts
 public static void ListAllAccounts() {
    System.out.println();
    if(Loan.loanAccount.isEmpty()){
        System.out.println("----No Account available so far----");
        
    }
    else{
        System.out.println("AccountNumber \t Loan Amount" + 
                        "\n-------------------------------------");
        for(int i =0; i<Loan.loanAccount.size(); i++){
            System.out.printf("%6s \t\t %12.2f", Loan.loanAccount.get(i).getAccountNumber(),
                                Loan.loanAccount.get(i).getTotalLoans() );
            System.out.println();
        }
    }
    System.out.println("\n---------------------------------------------------");
}
//method to create an account for both type of students
public static void createAccount() {
    System.out.println();
    System.out.println("\t...Create An Account..." +
                "\n---------------------------------------");
    System.out.println(" 1. Undergraduate Account" +
                        "\n2. PostGraduate Account" +
                        "\n3. Main menu" + 
                        "\n4. Exit");
    System.out.print("Enter option: ");
    int choice = input.nextInt();
    if(choice ==1 ||choice ==2){
        System.out.println();
        System.out.print("Enter first name :::: ");
        String name = input.next();
        System.out.print("Enter last name  :::: ");
        name = name +" " + input.next();
        System.out.print("Enter ProgramEnrolled  :::: ");
        String programEnrolled = input.next();
        System.out.print("Enter Current Year :::: ");
        int Currentyear = input.nextInt();
        // Creating Undergraduate account
        if(choice ==1){
            //checks if a user has Entered a valid current year
            if(Currentyear < 1 || Currentyear > 4){
                System.out.println("\n!!!!___Invalid year undergraduate can only be in years 1,2,3 or 4 :( ");
                createAccount();
            }
            // creating and Adding  the account to the array list defined in the super class
            else{
                Loan.loanAccount.add(new Undergraduate(name, programEnrolled, Currentyear));
                System.out.println("\n__________!!Account Created Succesfully!!__________" + 
                    //the index of the created account is the last index of the arraylist (size -1)
                    "\n----Your Account Number is: " + Loan.loanAccount.get( Loan.loanAccount.size() -1 ).getAccountNumber());
                System.out.println("---Go to main menu to log in to your account---");
                System.out.println("----------------------------------------------------------");
                return;

            }
        }
        // Creating Postgraduate account
        else {
             //checks if  the user has entered a valid current year
             if(Currentyear < 1 || Currentyear > 3){
                System.out.println("\n Invalid year postgraduate can only be in years 1,2 or 3 :( \n");
                createAccount();
            }
            // creating and adding  the account to the array list defined in the super class
            else{
                Loan.loanAccount.add(new Postgraduate(name, programEnrolled, Currentyear));
                System.out.println("\n__________!!Account Created Succesfully!!__________" + 
                    "\n---Your Account Number is: " + Loan.loanAccount.get( Loan.loanAccount.size() -1 ).getAccountNumber());
                    System.out.println("---Go to main menu to log in to your account---");
                    System.out.println("----------------------------------------------------------");
                return;

            }
        }

    }
    // method to Return to main menu
    if(choice == 3) {
        main(null);
        return;
    }
    // method for Quiting the program
    else if(choice == 4)exit();
    //this Allows the user to try again  creating an account after a wrong input
    else {
        System.out.println("___INVALID CHOICE___:(  " +
                            "Try again \n");
        createAccount();
    }
}
// Student log in menu...   
public static void accountLogin(){
    System.out.println("\tLogin" +
                "\n-----------------------");
    System.out.print("Enter your Account number : ");
    // to covert the students account number code to uppercase
    String accountNum = input.next().toUpperCase();
    // error message for entering an invalid account number
    if(accountNum.length() != 5){
        System.out.println("\n!!!You have entered an invalid length of account number" +
                    "\nFormat:: AABBB, where A is a letter and B is a digit." );
        System.out.print("1. Try again" +  
                        "\n2. Main menu " + 
                        "\nEnter your option: " );
        //try again option
        if(input.nextInt() ==1)
            accountLogin();
        else main(null);
    }
    // Searches the account number and if found directs to loan student menu
    else{
        boolean isAccountPresent = false;
        int accountIndex = -1;
        //Iterates to find if the account number exists and if so finds its index
        for(int i=0; i<Loan.loanAccount.size() ; i++){
            //it compares the entered account number with the account number at that particular index
            if(accountNum.equals(Loan.loanAccount.get(i).getAccountNumber())){
                isAccountPresent = true;
                accountIndex = i;
                break;
            }
        }
        //logs in to the account
        if(isAccountPresent){
            // passes the student object to the studenaccount  method
            StudentAccount.AccountStudentAccount(Loan.loanAccount.get(accountIndex));
            main(null);
        }
        //when account is not found
        else{
            System.out.println(":::: Account number " + accountNum + " does not exits ::::" +
                        "\n------------------------------------------------------------------");
            main(null); //returns to the main menu
        }
    }
    
}
//exits the whole  program with a message
public static void exit() {
    System.out.println("\n\t::::Thanks For Choosing Loan Management System have a nice day :) ::::"+
                "\n-----------------------------------------------------------------------------");
    System.exit(0);
}
 }

