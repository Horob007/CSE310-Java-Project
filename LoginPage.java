import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static java.awt.Color.*;

public class LoginPage extends JFrame implements ActionListener {

    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("USER ID:");
    JLabel userPasswordLabel = new JLabel("PASSWORD:");
    JLabel messageLabel = new JLabel();
    HashMap<String, String> logininfo = new HashMap<String, String>();

    LoginPage(HashMap<String, String> loginInfoOriginal) {

        logininfo = loginInfoOriginal;

        JLabel backgroundLabel = new JLabel(new ImageIcon("D:\\RRR\\untitled\\src\\back2.jpg"));

        // create a JLabel with the heading
        JLabel titleLabel = new JLabel("Tic Tac Toe");
        titleLabel.setFont(new Font(null, Font.BOLD, 60));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(GREEN);


        userIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userIDLabel.setForeground(WHITE);
        userPasswordLabel.setForeground(WHITE);

        messageLabel.setFont(new Font(null, Font.ITALIC, 25));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        userIDField.setHorizontalAlignment(SwingConstants.CENTER);
        userPasswordField.setHorizontalAlignment(SwingConstants.CENTER);

        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);

        resetButton.setHorizontalAlignment(SwingConstants.CENTER);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        // use GridBagLayout
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        backgroundLabel.setLayout(layout);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // add the components to the backgroundLabel using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        backgroundLabel.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        backgroundLabel.add(userIDLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        backgroundLabel.add(userIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        backgroundLabel.add(userPasswordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        backgroundLabel.add(userPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        backgroundLabel.add(messageLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        backgroundLabel.add(loginButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        backgroundLabel.add(resetButton, gbc);

        getContentPane().add(backgroundLabel);

        setPreferredSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource() == loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    dispose();
                    TicTacToe tictactoe = new TicTacToe();
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("username not found");

            }
        }
    }
}