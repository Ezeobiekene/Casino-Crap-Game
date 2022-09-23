import java.util.Scanner;
import java.util.Random;


public class Main {

    enum Status{
        WON,
        LOSE,
        CONTINUE
    }


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);



        System.out.print("Enter Your name: ");
        String name = input.nextLine();

        int point;
        Status status;

        int addDice = rollDice();

        switch( addDice ) {

            case 7:
            case 11:
                status = Status.WON;
                break;

            case 2:
            case 3:
            case 12:
                status = Status.LOSE;

            default:
                status = Status.CONTINUE;
                point = addDice;
                System.out.println( name + ", point is " + point );
                break;

        }
            point = addDice;

        while(status == Status.CONTINUE){
            addDice = rollDice();

            if(addDice == point){
                status = Status.WON;
            }
            else if(addDice == 7) {
                status = Status.LOSE;
            }
          else {
                addDice = rollDice();
           }
       }

        if( status == Status.WON ) {
            System.out.println( name + ", You won !!!" );
        }
        else {
            System.out.println( name + ", You lost :'(" );
        }


        }

    public static int rollDice(){
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int dieOne, dieTwo, addDice;


         dieOne = random.nextInt(6) + 1;
         dieTwo = random.nextInt(6) + 1;



        System.out.println("You rolled " + dieOne + " + " + dieTwo + " = " + (dieOne + dieTwo));

        return dieOne + dieTwo;
    }

}
