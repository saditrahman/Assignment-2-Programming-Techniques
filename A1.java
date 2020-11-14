import java.util.Scanner;
import java.util.Random;

//responsible for the entire program
public class A1{
    public void Menu(){

        //defining 2 steps for calculator and lotto checker
        System.out.println("follow the steps mentioned down to move further\nenter 1 for calculator\nenter 2 for lotto checker");
        Scanner sc=new Scanner(System.in);

        //taking a choice from user and storing in variable
        int choice=sc.nextInt();

        //drawing user according to his choice
        switch(choice){
            //for calculator
            case 1:{
                System.out.println("enter any positive no.");//first number from user

                //determining the datatype of the variable
                if(!sc.hasNextDouble()){
                    String s=sc.nextLine();
                    System.err.println(s+" is not a valid number");
                    sc.close();
                    return ;
                }

                //if the value is of double datatype then storing it in the variable
                double n1=sc.nextDouble();

                System.out.println("enter another positive no.");//second number from user
                if(!sc.hasNextDouble()){
                    String s=sc.nextLine();
                    System.err.println(s+" is not a valid number");
                    sc.close();
                    return ;
                }
                double n2=sc.nextDouble();
                //determining the numbers are positive or not
                if(n1<0||n2<0){
                    System.out.println("number is invalid");
                }
                else{
                    //taking operation frorm user
                    System.out.println("enter 0 for Addition\nenter 1 for Substraction\nenter 2 for Multiplication\nentere 3 for Devision");
                    int sign=sc.nextInt();

                    //calling the calculate method and passing args to the method and storing result in the variable
                    double result=calculate(n1,n2,sign);

                    System.out.printf("%f",result);//printing result
                }
            }
            break;

            //for lotto checker
            case 2:{
                //taking 1st number 
                System.out.println("enter a number from 1 to 24");
                int chosen1=sc.nextInt();
                //taking 2nd number 
                System.out.println("enter a number from 1 to 24");
                int chosen2=sc.nextInt();
                //taking 3rdnumber 
                System.out.println("enter a number from 1 to 24");
                int chosen3=sc.nextInt();
                String res=checkLotto(chosen1, chosen2, chosen3);
                System.out.printf("%s",res);
            }
            break;
            default:
            System.out.println("The input was incorret");
            break;
        }
        sc.close();//closing scanner object
    }

    //defining calculate method which take 3 parameter as an arguments and returns double value
    private double calculate(double number1, double number2, int operation){
       
        //making and returning operations as per user's wish
        switch(operation){
            case 0:
            return number1+number2;

            case 1:
            return number1-number2;

            case 2:
            return number1*number2;

            case 3:
            //validating 2nd number as if it is 0 then division is not possible
            if(number2==0){
                return -2.0;
            }
            else{
                return number1/number2;
            }
            default:
            return -1.0;
        }
    }

    //definihng checkLotto method which takes 3 parameter as an argument and returning string value
    private String checkLotto(int chosen1, int chosen2, int chosen3){
         //declaing object of random class
         Random rand=new Random();
         //for counting correct guesses
         int guess=0;
         //to return a value to menu method
         String res="";
        //determining the rang of numbers
        if((chosen1<1||chosen1>24)||(chosen2<1||chosen2>24)||(chosen3<1||chosen3>24)){
            System.out.println("your one or more input(s) are outside of prescribed range");
        }
        else{
            //generating 8 random numbers
            int random1 = rand.nextInt(24)+1;
            int random2 = rand.nextInt(24)+1;
            int random3 = rand.nextInt(24)+1;
            int random4 = rand.nextInt(24)+1;
            int random5 = rand.nextInt(24)+1;
            int random6 = rand.nextInt(24)+1;
            int random7 = rand.nextInt(24)+1;
            int random8 = rand.nextInt(24)+1;

            //if either 1 or 2 or 3 is correct
            if(chosen1 == random1 || chosen1 == random2 || chosen1 == random3 || chosen1 == random4 || chosen1 == random5 || chosen1 == random6 || chosen1 == random7 || chosen1 == random8 || chosen2 == random1 || chosen2 == random2 || chosen2 == random3 || chosen2 == random4 || chosen2 == random5 || chosen2 == random6 || chosen2 == random7 || chosen2 == random8 || chosen3 == random1 || chosen3 == random2 || chosen3 == random3 || chosen3 == random4 || chosen3 == random5 || chosen3 == random6 || chosen3 == random7 || chosen3 == random8) { 
                //if 1 is correct
                if(chosen1 == random1 || chosen1 == random2 || chosen1 == random3 || chosen1 == random4 || chosen1 == random5 || chosen1 == random6 || chosen1 == random7 || chosen1 == random8){
                    guess++;
                    //if 1 and 2 are correct
                    if(chosen2 == random1 || chosen2 == random2 || chosen2 == random3 || chosen2 == random4 || chosen2 == random5 || chosen2 == random6 || chosen2 == random7 || chosen2 == random8){
                        guess++;
                        //if all numbers are correct
                        if(chosen3 == random1 || chosen3 == random2 || chosen3 == random3 || chosen3 == random4 || chosen3 == random5 || chosen3 == random6 || chosen3 == random7 || chosen3 == random8){
                            guess++;
                            res= "\nYour chosen numbers: " + chosen1 + " " + chosen2 + " " + chosen3 + "\n" + "Drawn numbers: " + random1 + " " + random2 + " " + random3 + " " + random4 + " " + random5 + " " + random6 + " " + random7 + " " + random8 + "\nCorrect Guesses: "+chosen1 + " " + chosen2 + " " + chosen3 + "\nTotal Correct Guesses: " + guess;
                        }
                        else{
                            res= "\nYour chosen numbers: " + chosen1 + " " + chosen2 + " " + chosen3 + "\n" + "Drawn numbers: " + random1 + " " + random2 + " " + random3 + " " + random4 + " " + random5 + " " + random6 + " " + random7 + " " + random8 + "\nCorrect Guesses: "+chosen1 + " " + chosen2 + "\nTotal Correct Guesses: " + guess;
                        }
                    }
                    //if 1 and 3 are correct
                    else if(chosen3 == random1 || chosen3 == random2 || chosen3 == random3 || chosen3 == random4 || chosen3 == random5 || chosen3 == random6 || chosen3 == random7 || chosen3 == random8){
                        guess++;
                        res= "\nYour chosen numbers: " + chosen1 + " " + chosen2 + " " + chosen3 + "\n" + "Drawn numbers: " + random1 + " " + random2 + " " + random3 + " " + random4 + " " + random5 + " " + random6 + " " + random7 + " " + random8 + "\nCorrect Guesses: "+ chosen1 + " " + chosen3 + "\nTotal Correct Guesses: " + guess;
                    }
                    else{
                        res= "\nYour chosen numbers: " + chosen1 + " " + chosen2 + " " + chosen3 + "\n" + "Drawn numbers: " + random1 + " " + random2 + " " + random3 + " " + random4 + " " + random5 + " " + random6 + " " + random7 + " " + random8 + "\nCorrect Guesses: "+chosen1 + "\nTotal Correct Guesses: " + guess;
                    }
                }
                //if 1 is incorrect and either 2 or 2 and 3 both are correct
                else if(chosen2 == random1 || chosen2 == random2 || chosen2 == random3 || chosen2 == random4 || chosen2 == random5 || chosen2 == random6 || chosen2 == random7 || chosen2 == random8){
                    guess=0;
                    guess++;
                    if(chosen3 == random1 || chosen3 == random2 || chosen3 == random3 || chosen3 == random4 || chosen3 == random5 || chosen3 == random6 || chosen3 == random7 || chosen3 == random8){
                        guess++;
                        res= "\nYour chosen numbers: " + chosen1 + " " + chosen2 + " " + chosen3 + "\n" + "Drawn numbers: " + random1 + " " + random2 + " " + random3 + " " + random4 + " " + random5 + " " + random6 + " " + random7 + " " + random8 + "\nCorrect Guesses: "+ chosen2 + " " + chosen3 + "\nTotal Correct Guesses: " + guess;
                    }
                    else{
                        res= "\nYour chosen numbers: " + chosen1 + " " + chosen2 + " " + chosen3 + "\n" + "Drawn numbers: " + random1 + " " + random2 + " " + random3 + " " + random4 + " " + random5 + " " + random6 + " " + random7 + " " + random8 + "\nCorrect Guesses: "+ chosen2 + "\nTotal Correct Guesses: " + guess;
                    }
                }
            
                //if only 3 is correct
                else if(chosen3 == random1 || chosen3 == random2 || chosen3 == random3 || chosen3 == random4 || chosen3 == random5 || chosen3 == random6 || chosen3 == random7 || chosen3 == random8){
                    guess++;
                    res= "\nYour chosen numbers: " + chosen1 + " " + chosen2 + " " + chosen3 + "\n" + "Drawn numbers: " + random1 + " " + random2 + " " + random3 + " " + random4 + " " + random5 + " " + random6 + " " + random7 + " " + random8 + "\nCorrect Guesses: "+ chosen3 + "\nTotal Correct Guesses: " + guess;
                }
            }
            //if nothing is correct
            else{
                res= "\nYour chosen numbers: " + chosen1 + " " + chosen2 + " " + chosen3 + "\n" + "Drawn numbers: " + random1 + " " + random2 + " " + random3 + " " + random4 + " " + random5 + " " + random6 + " " + random7 + " " + random8 + "\nCorrect Guesses: 0" + "\nTotal Correct Guesses: " + guess;
            }
        }
        //returning the string to menu method
        return res;
    }

}