import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPanel;
    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;

    JButton rock;
    JButton paper;
    JButton scissors;
    JButton exit;

    Font titleFont = new Font("Arial", Font.BOLD, 20);
    Font displayFont = new Font("Times New Roman", Font.PLAIN, 15);

    JLabel title;
    JLabel display;
    JLabel playerWins;
    JLabel computerWins;
    JLabel ties;

    JTextArea results;

    ImageIcon titleIcon;
    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorsIcon;
    ImageIcon exitIcon;

    JScrollPane scroll;

    private int playerWinsCount = 0;
    private int playerLosesCount = 0;
    private int tiesCount = 0;

    public RockPaperScissorsFrame()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createTopPanel();
        createMiddlePanel();
        createBottomPanel();

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        setTitle("Rock, Paper, Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // get screen dimensions
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // center frame in screen
        setSize(screenWidth / 3, screenHeight / 2);
        setLocation(screenWidth / 3, screenHeight / 3);

        // sets the frame to be visible and adds the mainPanel to the frame
        setVisible(true);
        add(mainPanel);
    }

    private void createTopPanel()
    {
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 1));

        titleIcon = new ImageIcon("duel.png");
        title = new JLabel("Care for a duel in Rock, Paper, Scissors?");

        title.setFont(titleFont);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(title);
        topPanel.add(new JLabel(titleIcon));
    }

    private void createMiddlePanel()
    {
        middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(4, 1));

        display = new JLabel("Results");
        display.setFont(displayFont);
        display.setHorizontalAlignment(SwingConstants.CENTER);

        results = new JTextArea();
        results.setFont(displayFont);
        results.setLineWrap(true);
        results.setWrapStyleWord(true);
        results.setEditable(false);

        playerWins = new JLabel("Player Wins: " + playerWinsCount);
        playerWins.setFont(displayFont);
        playerWins.setHorizontalAlignment(SwingConstants.CENTER);

        computerWins = new JLabel("Player Losses: " + playerLosesCount);
        computerWins.setFont(displayFont);
        computerWins.setHorizontalAlignment(SwingConstants.CENTER);

        ties = new JLabel("Ties: " + tiesCount);
        ties.setFont(displayFont);
        ties.setHorizontalAlignment(SwingConstants.CENTER);

        middlePanel.add(title);
        middlePanel.add(display);
        middlePanel.add(results);
        middlePanel.add(playerWins);
        middlePanel.add(computerWins);
        middlePanel.add(ties);
    }

    private void createBottomPanel()
    {
        bottomPanel = new JPanel();

        rock = new JButton("Rock");
        paper = new JButton("Paper");
        scissors = new JButton("Scissors");
        exit = new JButton("Exit");

        rockIcon = new ImageIcon("rock.png");
        paperIcon = new ImageIcon("paper.png");
        scissorsIcon = new ImageIcon("scissors.png");
        exitIcon = new ImageIcon("exit.png");

        rock.setIcon(rockIcon);
        rock.setPreferredSize(new Dimension(100, 100));
        paper.setIcon(paperIcon);
        paper.setPreferredSize(new Dimension(100, 100));
        scissors.setIcon(scissorsIcon);
        scissors.setPreferredSize(new Dimension(100, 100));
        exit.setIcon(exitIcon);
        exit.setPreferredSize(new Dimension(100, 100));

        bottomPanel.add(rock);
        bottomPanel.add(paper);
        bottomPanel.add(scissors);
        bottomPanel.add(exit);

        rock.addActionListener(e -> results.setText(getResults()));
        paper.addActionListener(e -> results.setText(getResults()));
        scissors.addActionListener(e -> results.setText(getResults()));
        exit.addActionListener(e -> System.exit(0));
    }

    private String getPlayerChoice()
    {
        final String[] playerChoice = new String[1];
        rock.addActionListener(e -> results.setText("Rock"));
        paper.addActionListener(e -> results.setText("Paper"));
        scissors.addActionListener(e -> results.setText("Scissors"));

        return playerChoice[0];
    }

    private String getResults()
    {
        String[] computerChoices = {"Rock", "Paper", "Scissors"};
        String computerChoice = computerChoices[(int) (Math.random() * 3)];
        String playerChoice = getPlayerChoice();
        String result = "Invalid choice";

        if (playerChoice.equals(computerChoice))
        {
            result = "It is a Tie";
            tiesCount++;
        }
        else if (playerChoice.equals("Rock") && computerChoice.equals("Scissors"))
        {
            result = "Rock crushes scissors. Player wins";
            playerWinsCount++;
        }
        else if (playerChoice.equals("Paper") && computerChoice.equals("Rock"))
        {
            result = "Paper covers rock. Player wins";
            playerWinsCount++;
        }
        else if (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))
        {
            result = "Scissors cuts paper. Player wins";
            playerWinsCount++;
        }
        else if (playerChoice.equals("Rock") && computerChoice.equals("Paper"))
        {
            result = "Paper covers rock. Computer wins";
            playerLosesCount++;
        }
        else if (playerChoice.equals("Paper") && computerChoice.equals("Scissors"))
        {
            result = "Scissors cuts paper. Computer wins";
            playerLosesCount++;
        }
        else if (playerChoice.equals("Scissors") && computerChoice.equals("Rock"))
        {
            result = "Rock crushes scissors. Computer wins";
            playerLosesCount++;
        }
        return result;
    }
}
