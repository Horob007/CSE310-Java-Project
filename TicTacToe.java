import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;
import javax.sound.sampled.Clip;

import static java.awt.Color.*;

public class TicTacToe extends JFrame implements ActionListener {
    private Clip clip;
    Random random = new Random();
    JLabel heading, clockLabel;
    Font font = new Font("", Font.BOLD, 40);
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();

    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();

    JButton[] buttons = new JButton[9];
    JButton resetButton = new JButton("Reset");
    JButton resetScoreButton = new JButton("Reset Scores");// new button


    JPanel reset_panel = new JPanel();

    boolean player1_turn;
    int count = 0;



    TicTacToe() {


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(Color.ORANGE);
        textfield.setForeground(BLACK);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);


        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 500);
        title_panel.setBackground(BLACK);
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));
        reset_panel.setBackground(ORANGE);
        reset_panel.add(resetButton);




        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        frame.add(reset_panel, BorderLayout.SOUTH);

        firstTurn();
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    buttons[i].setText("");
                    buttons[i].setEnabled(true);
                    buttons[i].setBackground(WHITE); // reset the background color to default
                    buttons[i].setForeground(WHITE);


                }
                textfield.setText("Tic-Tac-Toe");
                count = 0;
                firstTurn();
            }
        });


        clockLabel = new JLabel("Clock");
//        clockLabel.setBackground(BLACK);
        clockLabel.setForeground(Color.YELLOW);
        clockLabel.setFont(font);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        title_panel.add(clockLabel, BorderLayout.SOUTH);
//        this.add(clockLabel, BorderLayout.SOUTH);


        Thread t = new Thread() {
            public void run() {

                try {
                    while (true) {

                        String datetime = new Date().toLocaleString();

                        clockLabel.setText(datetime);


                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        t.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) { // handle reset button click event
            // Reset the text and enable the buttons
            resetButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < 9; i++) {
                        buttons[i].setText("");
                        buttons[i].setEnabled(true);
                        buttons[i].setBackground(null); // reset the background color to default
                        buttons[i].setForeground(null);
                    }
                    textfield.setText("Tic-Tac-Toe");
                    count = 0;
                    firstTurn();
                }
            });

           firstTurn();
        } else { // handle the game button clicks
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons[i]) {
                    if (player1_turn) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(255, 0, 0));
                            buttons[i].setText("X");
                            player1_turn = false;
                            textfield.setText("O turn");
                            check();
                        }
                    } else {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(0, 0, 255));
                            buttons[i].setText("O");
                            player1_turn = true;
                            textfield.setText("X turn");
                            check();
                        }
                    }
                }
            }
        }
    }





    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        int count = 0;
        //check X win conditions
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }
        //check O win conditions
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        if (
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        if (
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }

        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText() == "X" || buttons[i].getText() == "O") {
                count++;
            }
        }
        if (count == 9) {
            draw();
        }

    }


    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
    }

    public void draw() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setBackground(Color.RED);
            buttons[i].setEnabled(false);
        }
        textfield.setText("Draw");
    }


}