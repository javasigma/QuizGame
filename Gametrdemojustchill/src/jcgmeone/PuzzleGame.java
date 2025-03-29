package jcgmeone;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleGame extends JFrame {
    private String correctWord = "MARSEILLE";
    private JTextField answerField;
    private JLabel scrambledLabel;
    private JButton submitButton;

    public PuzzleGame() {
        setTitle("Level 3: Word Scramble");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        scrambledLabel = new JLabel("Scrambled Word: EMRILASL");
        scrambledLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(scrambledLabel);

        answerField = new JTextField(10);
        add(answerField);

        submitButton = new JButton("Submit Answer");
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText().toUpperCase();
                if (userAnswer.equals(correctWord)) {
                    JOptionPane.showMessageDialog(null, "Correct! Well done!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong answer! Try again.");
                }
            }
        });

        setVisible(true);
    }
}
