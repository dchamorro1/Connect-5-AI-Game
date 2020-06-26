public abstract class Player
{
    String name;
    char letter;

    public Player(String name,char letter)
    {
        this.name=name;
        this.letter=letter;
    }

    public char getLetter()
    {
        return letter;
    }

    public abstract Move getMove(Board board);

    public String getName()
    {
        return name;
    }

    public abstract Player freshCopy();

    public String toString()
    {
        String s = "";
        s+= "(" + name + " as " + letter + ")";
        return s;
    }

}
