package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BoardGUI_ extends Application {

    private double sceneWidth = 1024;
    private double sceneHeight = 768;

    private int n = 4;
    private int m = 5;
    int ID = 0;
    int diceCounter = 0;

    double gridWidth = sceneWidth / n;
    double gridHeight = sceneHeight / m;

    MyNode[][] playfield = new MyNode[n][m];
    int Dice = 3;
    int dice = 0;

    Player player = new Player(10, Dice, "player1");
    Player player2 = new Player(11, Dice, "player2");
    private DeCompose deCompose = new DeCompose();
    private DeCompose deCompose2 = new DeCompose();
    private Controller diceroll = new Controller();
    private Controller closeTurn = new Controller();
    Button button= new Button("Roll the Dice");


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Dice Wars");
        Group root = new Group();
        List<Integer> player1DiceList= deCompose.generate(45,10);
        List<Integer> player2DiceList= deCompose2.generate(45,10);
        int diceRoll = diceroll.diceRoll(player1DiceList.get(1), player2DiceList.get(1), player, player2);
        button.setOnAction(eventHandler -> System.out.println(diceRoll));


        // initialize playfield
        for( int i=0; i < n; i++) {
            for( int j=0; j < m; j++) {

                String name;
                if (ID<10) {
                    name = player.getName();
                    dice = player1DiceList.get(ID);
                }
                else {
                    name = player2.getName();
                    dice = player2DiceList.get(diceCounter);
                    diceCounter = diceCounter+1;
                }

                // create node
                MyNode node = new MyNode(i + "/" + j + " ID: " + ID + " Name: " + name + " Dice:" + dice, i * gridWidth, j * gridHeight, gridWidth, gridHeight, ID, dice);
                ID = ID+1;

                // add to playfield for further reference using an array
                playfield[i][j] = node;

            }
        }

        shuffle(playfield);

        // add node to group
        for( int i=0; i < n; i++) {
            for( int j=0; j < m; j++) {
                MyNode node = playfield[i][j];
                root.getChildren().add( node);
            }
        }

        root.getChildren().add(button);
        Scene scene = new Scene( root, sceneWidth, sceneHeight);
        primaryStage.setScene( scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    public static class MyNode extends StackPane {

        public MyNode( String name, double x, double y, double width, double height, int ID, int dicevaule) {

            // create rectangle
            Rectangle rectangle = new Rectangle( width, height);
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.LIGHTBLUE);

            //create mouse event onclick
            rectangle.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent t) {
                    rectangle.setFill(Color.DARKCYAN);
                }
            });

            // create label
            Label label = new Label( name);

            // set position
            setTranslateX( x);
            setTranslateY( y);
            getChildren().addAll( rectangle, label);

        }
    }

    //shuffle the nodes to get a random order
    public MyNode[][] shuffle(MyNode[][] playfield){

        Random random = new Random();
        int numberOfValues = playfield.length * playfield[0].length;
        for (int i = numberOfValues - 1; i > 0; i--) {
            int index = random.nextInt(i);
            int row = i / playfield[0].length;
            int column = i - row * playfield[0].length;
            int randomRow = index / playfield[0].length;
            int randomColumn = index - randomRow * playfield[0].length;
            BoardGUI_.MyNode temp = playfield[row][column];
            playfield[row][column] = playfield[randomRow][randomColumn];
            playfield[randomRow][randomColumn] = temp;
        }
        System.out.println(Arrays.deepToString(playfield[0]));
        return playfield;
    }


}
