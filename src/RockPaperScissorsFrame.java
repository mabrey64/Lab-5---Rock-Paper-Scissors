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
    Font buttonFont = new Font("Courier New", Font.ITALIC, 15);
    Font displayFont = new Font("Times New Roman", Font.PLAIN, 15);

    JLabel title;
    JLabel display;
    JLabel playerWins;
    JLabel computerWins;
    JLabel ties;

    JTextArea results;

    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorsIcon;

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

    }

    private void createMiddlePanel()
    {
        
    }

    private void createBottomPanel()
    {
        
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
