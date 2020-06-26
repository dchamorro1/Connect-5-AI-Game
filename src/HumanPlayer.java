import java.util.Scanner;

public class HumanPlayer extends Player
{
    public HumanPlayer(String name, char letter)
    {
        super(name,letter);
    }

    public Move getMove(Board board)
    {
        int x,z;
        Move m;

        Scanner s = new Scanner(System.in);
        do {

            do {
                System.out.print("X Coordinate: ");
                x = s.nextInt();
            } while (x < 0 || x > Board.X_SIZE);

            do {
                System.out.print("Z Coordinate: ");
                z = s.nextInt();
            } while (z < 0 || z > Board.Z_SIZE);

            m = new Move(x,z);

        } while (board.isFull(m));

        return m;

    }

    public Player freshCopy()
    {
        return new HumanPlayer(getName(),getLetter());
    }
}
