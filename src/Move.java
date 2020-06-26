public class Move {
    //attributes
    private int x;
    private int z;

    //Constructors
    public Move(int col, int depth)
    {
        this.x = col;
        this.z = depth;
    }

    //methods
    public int getX()
    {
        return x;
    }

    public int getZ() {
        return z;
    }

    public String toString()
    {
        String s = "";
        s+= "(" + x + ", " + z + ")";
        return s;
    }
}
