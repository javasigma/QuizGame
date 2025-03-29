package jcgmeone;


import javax.swing.*;
import java.awt.*;

public class RewardScreen extends JFrame {
    public RewardScreen() {
        setTitle("Level 4: Congratulations!");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel message = new JLabel("🎉 Congratulations! 🎉", SwingConstants.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 24));
        message.setForeground(Color.BLUE);
        add(message, BorderLayout.CENTER);

        JLabel subMessage = new JLabel("You've unlocked the final level!", SwingConstants.CENTER);
        subMessage.setFont(new Font("Arial", Font.PLAIN, 18));
        add(subMessage, BorderLayout.SOUTH);

        setVisible(true);
    }
}
