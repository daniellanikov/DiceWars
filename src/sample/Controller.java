package sample;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller {

    //create random number
    public int random(int low, int high){
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }

    //implement diceroll
    public int diceRoll(int dicenumber1, int dicenumber2, Player player1, Player player2){

        int player1DiceValue = random(dicenumber1, dicenumber1*6);
        int player2DiceValue = random(dicenumber2, dicenumber2*6);

        if (player1DiceValue <= player2DiceValue){
            dicenumber1 = 1;
        }
        else {
            dicenumber1 = dicenumber1 - 1;
//            player2 = player1;
        }
        return dicenumber1;
    }

    public int closeTurn() {
            return 0;
    }

}
