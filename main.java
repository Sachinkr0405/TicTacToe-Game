import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



class SimpleTicTacToe {

    static String turn = "X";
    static JButton[] buttons = new JButton[9];
    static JLabel status;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(300, 350);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 3));
        status = new JLabel("X's Turn", SwingConstants.CENTER);

        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton();
            btn.setFont(new Font("Arial", Font.BOLD, 40));
            int index = i;
            btn.addActionListener(e -> handleClick(index));
            buttons[i] = btn;
            panel.add(btn);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.add(status, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void handleClick(int i) {
        if (!buttons[i].getText().equals("") || checkWinner() != null) return;

        buttons[i].setText(turn);
        String winner = checkWinner();

        if (winner != null) {
            status.setText(winner.equals("Draw") ? "It's a Draw!" : "Winner: " + winner);
            disableAll();
        } else {
            turn = turn.equals("X") ? "O" : "X";
            status.setText(turn + "'s Turn");
        }
    }

    static String checkWinner() {
        int[][] win = {
                {0,1,2}, {3,4,5}, {6,7,8},
                {0,3,6}, {1,4,7}, {2,5,8},
                {0,4,8}, {2,4,6}
        };
        for (int[] w : win) {
            String a = buttons[w[0]].getText();
            String b = buttons[w[1]].getText();
            String c = buttons[w[2]].getText();
            if (!a.isEmpty() && a.equals(b) && b.equals(c)) return a;
        }
        for (JButton b : buttons)
            if (b.getText().isEmpty()) return null;
        return "Draw";
    }

    static void disableAll() {
        for (JButton b : buttons) b.setEnabled(false);
    }
}


//
//class JavaProject {
//
//    static String[] board;
//    static String turn;
//
//
//
//    static String checkWinner()
//    {
//        for (int a = 0; a < 8; a++) {
//            String line = null;
//
//            switch (a) {
//                case 0:
//                    line = board[0] + board[1] + board[2];
//                    break;
//                case 1:
//                    line = board[3] + board[4] + board[5];
//                    break;
//                case 2:
//                    line = board[6] + board[7] + board[8];
//                    break;
//                case 3:
//                    line = board[0] + board[3] + board[6];
//                    break;
//                case 4:
//                    line = board[1] + board[4] + board[7];
//                    break;
//                case 5:
//                    line = board[2] + board[5] + board[8];
//                    break;
//                case 6:
//                    line = board[0] + board[4] + board[8];
//                    break;
//                case 7:
//                    line = board[2] + board[4] + board[6];
//                    break;
//            }
//
//            if (line.equals("XXX")) {
//                return "X";
//            }
//
//
//            else if (line.equals("OOO")) {
//                return "O";
//            }
//        }
//
//        for (int a = 0; a < 9; a++) {
//            if (Arrays.asList(board).contains(
//                    String.valueOf(a + 1))) {
//                break;
//            }
//            else if (a == 8) {
//                return "draw";
//            }
//        }
//
//
//        System.out.println(
//                turn + "'s turn; enter a slot number to place "
//                        + turn + " in:");
//        return null;
//    }
//
//    // To print out the board.
//	/* |---|---|---|
//	| 1 | 2 | 3 |
//	|-----------|
//	| 4 | 5 | 6 |
//	|-----------|
//	| 7 | 8 | 9 |
//	|---|---|---|*/
//
//    static void printBoard()
//    {
//        System.out.println("|---|---|---|");
//        System.out.println("| " + board[0] + " | "
//                + board[1] + " | " + board[2]
//                + " |");
//        System.out.println("|-----------|");
//        System.out.println("| " + board[3] + " | "
//                + board[4] + " | " + board[5]
//                + " |");
//        System.out.println("|-----------|");
//        System.out.println("| " + board[6] + " | "
//                + board[7] + " | " + board[8]
//                + " |");
//        System.out.println("|---|---|---|");
//    }
//
//    public static void main(String[] args)
//    {
//        Scanner in = new Scanner(System.in);
//        board = new String[9];
//        turn = "X";
//        String winner = null;
//
//        for (int a = 0; a < 9; a++) {
//            board[a] = String.valueOf(a + 1);
//        }
//
//        System.out.println("Welcome to 3x3 Tic Tac Toe.");
//        printBoard();
//
//        System.out.println(
//                "X will play first. Enter a slot number to place X in:");
//
//        while (winner == null) {
//            int numInput;
//
//
//            try {
//                numInput = in.nextInt();
//                if (!(numInput > 0 && numInput <= 9)) {
//                    System.out.println(
//                            "Invalid input; re-enter slot number:");
//                    continue;
//                }
//            }
//            catch (InputMismatchException e) {
//                System.out.println(
//                        "Invalid input; re-enter slot number:");
//                continue;
//            }
//
//
//            if (board[numInput - 1].equals(
//                    String.valueOf(numInput))) {
//                board[numInput - 1] = turn;
//
//                if (turn.equals("X")) {
//                    turn = "O";
//                }
//                else {
//                    turn = "X";
//                }
//
//                printBoard();
//                winner = checkWinner();
//            }
//            else {
//                System.out.println(
//                        "Slot already taken; re-enter slot number:");
//            }
//        }
//
//
//        if (winner.equalsIgnoreCase("draw")) {
//            System.out.println(
//                    "It's a draw! Thanks for playing.");
//        }
//
//
//        else {
//            System.out.println(
//                    "Congratulations! " + winner
//                            + "'s have won! Thanks for playing.");
//        }
//        in.close();
//    }
//
//
//}
//
