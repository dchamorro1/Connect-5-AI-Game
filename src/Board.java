//Daniel Chamorro
import java.awt.*;

public class Board {

    //attributes
    public static final int X_SIZE = 8;// columns or width
    public static final int Y_SIZE = 7;// rows or height
    public static final int Z_SIZE = 8;// depth or length
    public static final char TIE = 'T';
    public static final char RED = 'R';
    public static final char BLUE = 'B';
    public static final char EMPTY = '-';
    public static final char PLAYING = 'P';

    private char[][][] board = new char[Z_SIZE][Y_SIZE][X_SIZE];
    private char winner;

    //constructors
    public Board() {
        winner = PLAYING;

        for (int z = 0; z < Z_SIZE; z++) {
            for (int y = 0; y < Y_SIZE; y++) {
                for (int x = 0; x < X_SIZE; x++) {
                    board[z][y][x] = EMPTY;
                }
            }
        }
    }

    public Board(Board b) {
        this.board = b.board;
        this.winner = b.winner;
    }

    public Location makeMove(Move m, char p)
    {
        if (isFull(m)) return null;
        Location l = null;

        int x = m.getX();
        int z = m.getZ();
        int y;

        for (y = Y_SIZE-1; y >= 0; y--) {
            if(board[z][y][x] == EMPTY) {
                l = new Location(x,y,z);
                setLocation(l,p);
                break;
            }
        }

        //different wins
        break_point:
        {
            for (int t = 0; t < 13; t++) {

                int X = x;
                int Y = y;
                int Z = z;
                int c = 0;

                while ((Y < Y_SIZE && Y >= 0) && (X < X_SIZE && X >= 0) && (Z < Z_SIZE && Z >= 0)) {
                    if (board[Z][Y][X] == p) c++;
                    if (c >= 5) {
                        winner = p;
                        break break_point;
                    }
                    //2D
                    //horizontal one board
                    if (t == 0)
                        X++;
                    //vertical one board
                    if (t == 1)
                        Z++;
                    //across Top L to Bottom R one board
                    if (t == 2) {
                        X++;
                        Z++;
                    }
                    //across Bottom L to Top R one board
                    if (t == 3) {
                        X--;
                        Z++;
                    }
                    //3D
                    //vertical straight
                    if (t == 4)
                        Y++;
                    //diagonal vertical front Top L to Bottom R
                    if (t == 5) {
                        Y++;
                        X++;
                    }
                    //diagonal vertical front Bottom L to Top Right
                    if (t == 6) {
                        Y--;
                        X++;
                    }
                    //diagonal vertical side Top L to Bottom R
                    if (t == 7) {
                        Y++;
                        Z++;
                    }
                    //diagonal vertical side Bottom L to Top Right
                    if (t == 8) {
                        Y--;
                        Z--;
                    }
                    //diagonal across Top L Front to Bottom R Back
                    if (t == 9) {
                        Y++;
                        X++;
                        Z--;
                    }
                    //diagonal across Bottom L Front to Top Right Back
                    if (t == 10) {
                        Y--;
                        X++;
                        Z--;
                    }
                    //diagonal across Bottom L Back to Top R Front
                    if (t == 11) {
                        Y++;
                        X++;
                        Z++;
                    }
                    //diagonal across Bottom L Front to Top Right Back
                    if (t == 12) {
                        Y--;
                        X++;
                        Z++;
                    }
                }

                X = x;
                Y = y;
                Z = z;

                do {
                    //2D
                    //horizontal one board
                    if (t == 0)
                        X--;
                    //vertical one board
                    if (t == 1)
                        Z--;
                    //across Top L to Bottom R one board
                    if (t == 2) {
                        X--;
                        Z--;
                    }
                    //across Bottom L to Top R one board
                    if (t == 3) {
                        X++;
                        Z--;
                    }
                    //3D
                    //vertical straight
                    if (t == 4)
                        Y--;
                    //diagonal vertical front Top L to Bottom R
                    if (t == 5) {
                        Y--;
                        X--;
                    }
                    //diagonal vertical front Bottom L to Top Right
                    if (t == 6) {
                        Y++;
                        X--;
                    }
                    //diagonal vertical side Top L to Bottom R
                    if (t == 7) {
                        Y--;
                        Z--;
                    }
                    //diagonal vertical side Bottom L to Top Right
                    if (t == 8) {
                        Y++;
                        Z++;
                    }
                    //diagonal across Top L Front to Bottom R Back
                    if (t == 9) {
                        Y--;
                        X--;
                        Z++;
                    }
                    //diagonal across Bottom L Front to Top Right Back
                    if (t == 10) {
                        Y++;
                        X--;
                        Z++;
                    }
                    //diagonal across Bottom L Back to Top R Front
                    if (t == 11) {
                        Y--;
                        X--;
                        Z--;
                    }
                    //diagonal across Bottom L Front to Top Right Back
                    if (t == 12) {
                        Y++;
                        X--;
                        Z--;
                    }
                    if ((Y < Y_SIZE && Y >= 0) && (X < X_SIZE && X >= 0) && (Z < Z_SIZE && Z >= 0)) {
                        if (board[Z][Y][X] == p) c++;
                    }
                    if (c >= 5) {
                        winner = p;
                        break break_point;
                    }
                } while ((Y < Y_SIZE && Y >= 0) && (X < X_SIZE && X >= 0) && (Z < Z_SIZE && Z >= 0));
            }
        }
        return l;
    }

    public void setLocation(Location l, char p)
    {
        int x = l.getX();
        int y = l.getY();
        int z = l.getZ();
        board[z][y][x] = p;
    }

    public char getLocation(int x, int y, int z)
    {
        char c = board[z][y][x];
        return c;
    }

    public char getWinner()
    {
        return winner;
    }

    public char[][][] getBoard()
    {
        return board;
    }

    boolean isFull(Move m)
    {
        int x = m.getX();
        int y = 0;
        int z = m.getZ();
        if(board[z][y][x] == EMPTY)
            return false;
        else
            return true;
    }

    public void reset()
    {
        winner = PLAYING;

        for (int z = 0; z < Z_SIZE; z++) {
            for (int y = 0; y < Y_SIZE; y++) {
                for (int x = 0; x < X_SIZE; x++) {
                    board[z][y][x] = EMPTY;
                }
            }
        }
    }

    public void draw(Graphics g)
    {
        //GRIDS
        //y lines
        int x = 70;
        int y = 70;
        for(int m = 0; m < 7; m++ ) {
            for (int i = 0; i <= 8; i++) {
                g.setColor(Color.WHITE);
                g.drawLine(x, y, x - 30, y+80);
                x += 10;
            }
            x = 70;
            y +=100;
        }

        //x lines
        int x2 = 70;
        int y2 = 70;
        for(int m = 0; m < 7; m++ ) {
            for (int i = 0; i <= 8; i++) {
                g.setColor(Color.WHITE);
                g.drawLine(x2, y2, x2 + 80, y2);
                y2 += 10;
                x2 -= 4;

            }
            x2 = 70;
            y2 += 10;
        }

        // board content
        for (int z = 0; z < Z_SIZE; z++) {
            for (y = 0; y < Y_SIZE; y++) {
                for (x = 0; x < X_SIZE; x++) {

                    char p = getLocation(x,y,z);
                    if (p != EMPTY) {

                        double slantDis = z*4;
                        double yDif = y * 100;
                        double cx = 45 + (x * 10) + slantDis - 1;
                        double cy = yDif + 85 - (z * 10) + 57;

                        Color color = Color.BLACK;
                        if (p == RED) color = Color.RED;
                        if (p == BLUE) color = Color.BLUE;
                        g.setColor(color);

                        g.fillOval((int)cx, (int)cy, 6, 7);
                    }



                }
            }
        }

    }
}

