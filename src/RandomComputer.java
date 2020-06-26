public class RandomComputer extends Player
{
    public RandomComputer(String name,char letter)
    {
        super(name,letter);
    }

    public Move getMove(Board board)
    {
        Move m;

        do {
            int x = (int) ( Math.random() * ((double)Board.X_SIZE - 0.0001) );
            int z = (int) ( Math.random() * ((double)Board.Z_SIZE - 0.0001) );

            m = new Move(x,z);

        }while(board.isFull(m));

        return m;
    }

    public Player freshCopy()
    {
        return new RandomComputer(getName(),getLetter());
    }
}
