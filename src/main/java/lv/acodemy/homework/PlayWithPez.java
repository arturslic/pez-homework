package lv.acodemy.homework;

public class PlayWithPez {
    public static void main(String[] args) {

        PezDispensor pezArturs = new PezDispensor("Arturs", "red", "christmas");
        pezArturs.eatSingle();
        pezArturs.eatMultiple(5);
        System.out.println(pezArturs.getCurrentCandyAmount());

        System.out.println(pezArturs.getPezName());
        System.out.println(pezArturs.getPezColor());
        System.out.println(pezArturs.getPezSeriesName());

        pezArturs.restoreCandy();
        System.out.println(pezArturs.getCurrentCandyAmount());

        pezArturs.eatMultiple(20);
        pezArturs.addSingle();
        pezArturs.addMultiple(10);
        System.out.println(pezArturs.getCurrentCandyAmount());



    }
}
