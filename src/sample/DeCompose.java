package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeCompose {

    private Controller board = new Controller();
    int number4 = 10;
    List<Integer> generatedList = new ArrayList<Integer>(10);
    int sum = 0;
    int maradek = 0;


    public List<Integer> generate(int osszeg, int darabszam) {

        while (number4 > 8){


            for (int i= 1; i<darabszam/2; i++){
                int number1 = board.random(1, 4);
                generatedList.add(number1);
                sum = sum + number1;
            }
            for (int i= 1; i<darabszam/2; i++){
                int number2 = board.random(5, 8);
                generatedList.add(number2);
                sum = sum + number2;
            }

            maradek = osszeg - sum;

            int number3 = 8;
            generatedList.add(number3);
            number4 = maradek - 8;
            generatedList.add(number4);
            Collections.shuffle(generatedList);
            sum = sum + number3 + number4;

            System.out.println(generatedList);
            System.out.println(sum);
            System.out.println(number4);

        }

        return generatedList;
    }


}
