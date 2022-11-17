package dice;

public abstract class Die {

    /**
     * the letters that the die can roll from
     */
    String letters;

    /**
     * the letter that is currently shown on the die
     */
    char upFace;

    /*
     * rolls the die by randomly choosing the upFace from letters
     */
    public void roll(){
        this.upFace = letters.charAt((int)(Math.random() * (letters.length() - 1)));
    }
}
