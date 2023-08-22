package org.statesidejokes.ui;

import org.statesidejokes.wrapperapi.DadJokes;
import org.statesidejokes.wrapperapi.DadJokesSync;

import javax.swing.*;
import java.awt.*;
public class DadJokesGUI extends JFrame {
    private final DadJokes dadJokes;

    private final JTextArea resultArea;

    public DadJokesGUI() {
        dadJokes = new DadJokesSync(); // Instantiate your DadJokes class

        setTitle("Dad Jokes App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        JPanel buttonPanel = getjPanel();

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    private JPanel getjPanel() {
        JButton randomJokeButton = new JButton("Get Random Joke");
        randomJokeButton.addActionListener(e -> {
            String randomJoke = dadJokes.getRandomJoke();
            resultArea.setText("Random Joke:\n" + randomJoke);
        });

        JButton jokeCountButton = new JButton("Get Joke Count");
        jokeCountButton.addActionListener(e -> {
            int jokeCount = dadJokes.getJokeCount();
            resultArea.setText("Joke Count: " + jokeCount);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(randomJokeButton);
        buttonPanel.add(jokeCountButton);
        return buttonPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DadJokesGUI gui = new DadJokesGUI();
            gui.setVisible(true);
        });
    }
}
