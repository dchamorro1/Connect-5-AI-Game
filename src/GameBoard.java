import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameBoard extends JFrame {
    public BufferedImage buffer;
    public Graphics g;
    public Board b;
    public HumanPlayer hp,hp2;
    public RandomComputer rc;

    public GameBoard() {
        super();

        b = new Board();
        hp = new HumanPlayer("Player1", Board.RED);
        rc = new RandomComputer("Computer1", Board.BLUE);
        //hp2 = new HumanPlayer("Player2", Board.BLUE);

        setSize(200, 800);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        g = buffer.getGraphics();
        setUndecorated(false);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        do {

            char p1 = hp.getLetter();
            Move m1 = hp.getMove(b);
            b.makeMove(m1, p1);

            char p2 = rc.getLetter();
            Move m2 = rc.getMove(b);
            b.makeMove(m2, p2);

            repaint();

        } while (b.getWinner() == Board.PLAYING);

        System.out.println("THE WINNER IS: " );
        if(b.getWinner() == Board.RED )
        {
            System.out.println("RED");
        }
        if(b.getWinner() == Board.BLUE )
        {
            System.out.println("BLUE");
        }
        if(b.getWinner() == Board.TIE )
        {
            System.out.println("TIE");
        }

    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        b.draw(g);
        g.drawImage(buffer, 0, 0, null);
    }


}
