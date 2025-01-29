import java.util.Scanner;
public class Assignment2_20230808001 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Please enter your first name >> ");
        String firstName = scn.next();
        firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
        System.out.print("Please enter your surname >> ");
        String lastName = scn.next();
        lastName = lastName.toUpperCase();
        System.out.print("Please enter your starting balance >> ");
        double balance = scn.nextDouble();
        while(balance<0){
            System.out.println("ERROR: Invalid balance");
            System.out.print("Please enter your starting balance >> ");
            balance = scn.nextDouble();
        }
        scn.nextLine();
        String selection = "";
        while(!selection.equals("Q")){
            System.out.println("Hello "+ firstName + " " + lastName);
            System.out.println("What would like to do today?");
            System.out.println("B to see (B)alance in your account ");
            System.out.println("W to (W)ithdraw cash ");
            System.out.println("D to (D)eposit cash ");
            System.out.println("P to (P)ay a bill ");
            System.out.println("Q to (Q)uit");
            System.out.print("Please enter your selection >> ");
            selection = scn.next();
            
            switch(selection){
                
                case "B":
                System.out.println("Your account balance is: " + balance);
                break;
                
                case "W":
                System.out.print("How much are you withdrawing? ");
                double withdraw = scn.nextDouble();

                if(withdraw<0 || withdraw>balance){
                    System.out.println("ERROR: Invalid withdraw amount ");
                    continue;
                }
                else{
                    balance -=withdraw;

                    double[] money = {200, 100, 50, 20, 10, 5, 1, 0.500, 0.250, 0.10, 0.050, 0.010};
                    for(int i = 0 ; i<money.length-1 ; i++){
                        int moneyPart = (int) (withdraw/money[i]);
                        if(moneyPart != 0){
                            System.out.println(moneyPart + " - " + money[i]);
                            withdraw -= moneyPart*money[i];
                        } 
                    }
                }
                break;

                case "D":
                System.out.print("How much are you depositing? ");
                double deposit = scn.nextDouble();
                if(deposit<0){
                    System.out.println("ERROR: Invalid deposit amount ");
                    continue;
                }
                balance += deposit ;

                case "P":
                System.out.print("Which of the following bills would you like to pay? ");
                System.out.println("\n1 - Electricity \n2 - Water \n3 - Internet");
                System.out.print("Please enter your selection >> ");
                int selectionofbills = scn.nextInt();
                double bill = 0.01 + (100.0 - 0.01) * Math.random();

                while( selectionofbills!=1 && selectionofbills!=2 && selectionofbills!=3){
                    System.out.print("Please enter 1, 2 or 3 >> ");
                    selectionofbills = scn.nextInt();
                }
                if(bill>balance){
                    System.out.println("You do not have sufficent funds to pay this bills");
                }else{
                    balance-=bill;
                }
                if(selectionofbills==1){
                    System.out.println("Your Electricity bill is " + bill);
                }else if(selectionofbills==2){
                    System.out.println("Your Water bill is " + bill);
                }else if(selectionofbills==3){
                    System.out.println("Your Internet bill is " + bill);
                }
                System.out.print("Do you wish to pay this bill now (Y/N)? ");
                String yesNo = scn.next();
                if(yesNo.equals("Y")){
                    System.out.println("Thank you for payment.");
                }
                
            }
        }
        if(selection.equals("Q")){
            System.out.println("Thank you for using our ATM. Have a nice day!");
            } 
    }
    }

