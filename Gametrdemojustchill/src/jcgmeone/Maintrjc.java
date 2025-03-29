package jcgmeone;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class Maintrjc extends JFrame {
    private String[] questions;
    private String[] correctAnswers;
    private JLabel[] levelLabels;
    private JButton startButton;
    private JLabel questionLabel;
    private JTextField answerField;
    private JLabel feedbackLabel;
    private JPanel levelsPanel;
    private int currentLevel = 0;
    private int score = 0;

    public static void main(String[] args) {
        new Maintrjc();
        
    }

    public Maintrjc() {
        initializeGame();
        addGUIComponents();
    }

    private void initializeGame() {

        questions = new String[]{
            "1. LEVEL 1 In which sport can the ball travel at speeds over 100 km/h ?",
            "2. LEVEL 2 Who Painted the Monalisa?",
            "3. LEVEL 3 What is the capital of France?",
            "4. LEVEL 4 Distance=240km, Velocity= 600 m/s Time = ???? s"
        };

        correctAnswers = new String[]{
            "pingpong",
            "leonardodavinci",
            "paris",
            "400"
        };

        levelLabels = new JLabel[4];
    }

    private void addGUIComponents() {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("FIGUI Games IGUIDI QUIZ");
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(30, 30, 30));

       
       
        
        startButton = new JButton("Start Quiz");
        startButton.setBounds(320, 100, 160, 50);
        startButton.setFont(new Font("Arial", Font.BOLD, 14));
        startButton.setBackground(new Color(255, 105, 180));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startButton.addActionListener(e -> startQuiz());
        add(startButton);

        questionLabel = new JLabel("Question will appear here...");
        questionLabel.setBounds(100, 200, 600, 50);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setForeground(Color.LIGHT_GRAY);
        add(questionLabel);

        answerField = new JTextField();
        answerField.setBounds(100, 260, 600, 30);
        answerField.setFont(new Font("Arial", Font.PLAIN, 14));
        answerField.setForeground(Color.DARK_GRAY);
        add(answerField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(320, 300, 160, 50);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(e -> checkAnswer());
        add(submitButton);

        feedbackLabel = new JLabel();
        feedbackLabel.setBounds(100, 360, 600, 40);
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 14));
        feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
        feedbackLabel.setVisible(false);
        add(feedbackLabel);

        levelsPanel = new JPanel();
        levelsPanel.setBounds(100, 420, 600, 100);
        levelsPanel.setBackground(new Color(40, 40, 40));
        levelsPanel.setBorder(new LineBorder(Color.CYAN, 2));
        levelsPanel.setLayout(new GridLayout(1, 4, 10, 10));
        for (int i = 0; i < 4; i++) {
            levelLabels[i] = new JLabel((i + 1) + ". " + questions[i]);
            levelLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            levelLabels[i].setFont(new Font("Arial", Font.BOLD, 12));
            levelLabels[i].setForeground(Color.GRAY);
            levelLabels[i].setOpaque(true);
            levelLabels[i].setBackground(new Color(50, 50, 50));
            levelLabels[i].setBorder(new LineBorder(Color.CYAN, 1));
            levelLabels[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            levelLabels[i].setEnabled(false);
            levelLabels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (int j = 0; j < 4; j++) {
                        if (levelLabels[j] == e.getSource() && j <= currentLevel) {
                            openLevelGame(j);
                            break;
                        }
                    }
                }
            });
            levelsPanel.add(levelLabels[i]);
        }
        add(levelsPanel);
    }
  
    private void startQuiz() {
        currentLevel = 0;
        score = 0;
        showQuestion(currentLevel);
        updateUIForLevel(currentLevel);
    }

    private void showQuestion(int levelIndex) {
        questionLabel.setText(questions[levelIndex]);
        answerField.setText("");
        answerField.requestFocus();
        feedbackLabel.setVisible(false);
    }

    private void checkAnswer() {
        String userAnswer = answerField.getText().trim();
        if (userAnswer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an answer!", "Empty Answer", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (userAnswer.equalsIgnoreCase(correctAnswers[currentLevel])) {
            handleCorrectAnswer();
        } else {
            handleIncorrectAnswer();
        }
    }

    private void handleCorrectAnswer() {
        feedbackLabel.setText("Correct! Well done!");
        feedbackLabel.setForeground(Color.GREEN);
        feedbackLabel.setVisible(true);
        score += 100;
        currentLevel++;
        if (currentLevel < questions.length) {
            updateUIForLevel(currentLevel);
            showQuestion(currentLevel);
        } else {
            showCompletionScreen();
        }
    }

    private void handleIncorrectAnswer() {
        feedbackLabel.setText("Incorrect! Try again.");
        feedbackLabel.setForeground(Color.RED);
        feedbackLabel.setVisible(true);
    }

    private void updateUIForLevel(int level) {
        for (int i = 0; i < levelLabels.length; i++) {
            if (i <= level) {
                levelLabels[i].setBackground(Color.GREEN);
                levelLabels[i].setEnabled(true);
            } else {
                levelLabels[i].setBackground(new Color(50, 50, 50));
                levelLabels[i].setEnabled(false);
            }
        }
    }


    private void openLevelGame(int levelIndex) {
        switch (levelIndex) {
            case 0:
            	 new Game().setVisible(true);  // Open the Game class
                break;
            case 1:
                openWindow(new PaintGui()); // Open the PaintGUI class
                break;
            case 2:
                openWindow(new Calcguijc()); // Open the PuzzleGameI class
                break;
            case 3:
                openWindow(new PuzzleGame()); // Open the Calcguijc class
                break;
            default:
                break;
        }
    }

    private void openWindow(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the child window
        frame.setSize(700, 900);
        frame.setVisible(true);
        frame.setLocationRelativeTo(this); // Center the child window relative to the main window
    }

    private void showCompletionScreen() {
        JOptionPane.showMessageDialog(this, "Congratulations! You've completed all levels!\nFinal Score: " + score, "Quiz Completed", JOptionPane.INFORMATION_MESSAGE);
        startButton.setText("Restart Quiz");
    }
}