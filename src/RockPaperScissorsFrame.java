import javax.swing.*;
import java.awt.*;

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
    Font recordFont = new Font("Courier New", Font.ITALIC, 20);

    JLabel title;
    JLabel display;
    JLabel playerWins;
    JLabel playerLoses;
    JLabel ties;

    JTextArea pastGames;

    ImageIcon titleIcon;

    JScrollPane scroll;

    private int playerWinsCount = 0;
    private int playerLosesCount = 0;
    private int tiesCount = 0;

    final String[] playerChoice = new String[1];

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
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 3, screenHeight / 3);

        // sets the frame to be visible and adds the mainPanel to the frame
        setVisible(true);
        add(mainPanel);
    }

    private void createTopPanel()
    {
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        title = new JLabel("Care for a duel of Rock, Paper, Scissors?");
        title.setFont(titleFont);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        titleIcon = new ImageIcon("duel.jpg");
        titleIcon.setImage(titleIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        topPanel.add(title);
        topPanel.add(new JLabel(titleIcon));
    }

    private void createMiddlePanel()
    {
        middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));

        display = new JLabel("Past Games");
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setHorizontalAlignment(SwingConstants.CENTER);
        display.setAlignmentX(Component.CENTER_ALIGNMENT);

        pastGames = new JTextArea(5, 10);
        pastGames.setFont(displayFont);
        pastGames.setLineWrap(true);
        pastGames.setWrapStyleWord(true);
        pastGames.setEditable(false);

        scroll = new JScrollPane(pastGames, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        playerWins = new JLabel("Player Wins: " + playerWinsCount);
        playerWins.setFont(displayFont);
        playerWins.setFont(recordFont);
        playerWins.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerWins.setHorizontalAlignment(SwingConstants.CENTER);

        playerLoses = new JLabel("Player Losses: " + playerLosesCount);
        playerLoses.setFont(displayFont);
        playerLoses.setFont(recordFont);
        playerLoses.setHorizontalAlignment(SwingConstants.CENTER);
        playerLoses.setAlignmentX(Component.CENTER_ALIGNMENT);

        ties = new JLabel("Ties: " + tiesCount);
        ties.setFont(displayFont);
        ties.setFont(recordFont);
        ties.setHorizontalAlignment(SwingConstants.CENTER);
        ties.setAlignmentX(Component.CENTER_ALIGNMENT);


        // add components to middlePanel
        /*
        If a text area is added to a panel as well as a scroll pane, the text area will be displayed
        and you don't need to add the text area to the scroll pane. The scroll pane will automatically
        display the text area.
         */
        middlePanel.add(display);
        middlePanel.add(scroll);
        middlePanel.add(playerWins);
        middlePanel.add(playerLoses);
        middlePanel.add(ties);
    }

    private void createBottomPanel()
    {
        bottomPanel = new JPanel();

        rock = new JButton("Rock");
        paper = new JButton("Paper");
        scissors = new JButton("Scissors");
        exit = new JButton("Exit");

        rock = new JButton(new ImageIcon("rock.jpg"));
        rock.setContentAreaFilled(false);
        rock.setBorderPainted(false);
        rock.setFocusPainted(false);
        rock.setPreferredSize(new Dimension(100, 100));

        paper = new JButton(new ImageIcon("paper.jpg"));
        paper.setContentAreaFilled(false);
        paper.setBorderPainted(false);
        paper.setFocusPainted(false);
        paper.setPreferredSize(new Dimension(100, 100));

        scissors = new JButton(new ImageIcon("scissors.jpg"));
        scissors.setContentAreaFilled(false);
        scissors.setBorderPainted(false);
        scissors.setFocusPainted(false);
        scissors.setPreferredSize(new Dimension(100, 100));

        exit = new JButton(new ImageIcon("exit.png"));
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.setPreferredSize(new Dimension(100, 100));

        bottomPanel.add(rock);
        bottomPanel.add(paper);
        bottomPanel.add(scissors);
        bottomPanel.add(exit);


        rock.addActionListener(e -> {
            getResults("Rock");
            playerWins.setText("Player Wins: " + playerWinsCount);
            playerLoses.setText("Player Losses: " + playerLosesCount);
            ties.setText("Ties: " + tiesCount);
        });
        paper.addActionListener(e -> {
            getResults("Paper");
            playerWins.setText("Player Wins: " + playerWinsCount);
            playerLoses.setText("Player Losses: " + playerLosesCount);
            ties.setText("Ties: " + tiesCount);
        });
        scissors.addActionListener(e -> {
            getResults("Scissors");
            playerWins.setText("Player Wins: " + playerWinsCount);
            playerLoses.setText("Player Losses: " + playerLosesCount);
            ties.setText("Ties: " + tiesCount);
        });
        exit.addActionListener(e -> System.exit(0));
    }


    private void getResults(String playerChoice)
    {
        String[] computerChoices = {"Rock", "Paper", "Scissors"};
        String computerChoice = computerChoices[(int) (Math.random() * 3)];
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
        pastGames.append(result + "\n");
    }
}
