package lv.acodemy.homework;

public class PezDispensor {

    private String pezName;
    private String pezColor;
    private String pezSeriesName;
    private int currentCandyAmount;
    private final int MAX_CANDY_AMOUNT = 30;

    public PezDispensor(String pezName, String pezColor, String pezSeriesName) {
        this.pezName = pezName;
        this.pezColor = pezColor;
        this.pezSeriesName = pezSeriesName;
        this.currentCandyAmount = MAX_CANDY_AMOUNT;
    }

    public String getPezName() {
        return pezName;
    }

    public String getPezColor() {
        return pezColor;
    }

    public String getPezSeriesName() {
        return pezSeriesName;
    }

    public int getCurrentCandyAmount() {
        return currentCandyAmount;
    }

    @Override
    public String toString() {
        return "PezDispensor{" +
                "pezName='" + pezName + '\'' +
                ", pezColor='" + pezColor + '\'' +
                ", pezSeriesName='" + pezSeriesName + '\'' +
                '}';
    }

    //Method that decrements candy count for 1;

    public void eatSingle(){
        if (getCurrentCandyAmount() <=0){
            System.out.println("Out of candy!");
        } else {
            System.out.println("Eat single");
            currentCandyAmount--;
        }
    }

    //Method that decrements candy count for multiple candy;

    public void eatMultiple(int candyAmount){
        if (currentCandyAmount - candyAmount <=0){
            System.out.println("Out of candy!");
        } else if (candyAmount > currentCandyAmount){
            System.out.println("You can not eat more than candy amount inside!");
        } else {
            currentCandyAmount = currentCandyAmount - candyAmount;
        }
    }

    //Method that restores candy amount to MAX;

    public void restoreCandy(){
        currentCandyAmount = MAX_CANDY_AMOUNT;
        System.out.println("Dispensor is full");
    }

    //Method that adds one candy to the current candy amount;

    public void addSingle(){
        if (currentCandyAmount == MAX_CANDY_AMOUNT){
            System.out.println("Dispensor is already full!");
        } else {
            currentCandyAmount++;
        }
    }

    //Method that adds multiple candy to the current candy amount;

    public void addMultiple(int addMultipleCandy){
        if (addMultipleCandy > MAX_CANDY_AMOUNT){
            System.out.println("Can not add more than MAX amount");
        } else if (addMultipleCandy + currentCandyAmount > MAX_CANDY_AMOUNT) {
            System.out.println("Can not add more than MAX amount");
        } else {
            currentCandyAmount = currentCandyAmount + addMultipleCandy;
        }
    }
}
