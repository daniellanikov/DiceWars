package sample;

public class Player {

    int ID;
    int Dice;
    String Name;

    public Player(int ID, int dice, String name) {
        this.ID = ID;
        Dice = dice;
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDice() {
        return Dice;
    }

    public void setDice(int dice) {
        Dice = dice;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
