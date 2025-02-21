import javax.swing.*;
import java.awt.*;

public class RockPaperScissorsFrame extends JFrame
{
    // Panels for the main frame
    JPanel mainPanel;
    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;

    // Buttons for the game
    JButton rock;
    JButton paper;
    JButton scissors;
    JButton exit;

    // Fonts for the title, display, and record
    Font titleFont = new Font("Arial", Font.BOLD, 20);
    Font displayFont = new Font("Times New Roman", Font.PLAIN, 15);
    Font recordFont = new Font("Courier New", Font.ITALIC, 20);

    // Labels for the title, display, and counts of player wins, player losses, and ties
    JLabel title;
    JLabel display;
    JLabel playerWins;
    JLabel playerLoses;
    JLabel ties;

    // Text area for the past games
    JTextArea pastGames;

    // Image icon for the title to give the frame a little more flair
    ImageIcon titleIcon;

    // Scroll pane for the text area
    JScrollPane scroll;

    // Counts for the player wins, player losses, and ties
    private int playerWinsCount = 0;
    private int playerLosesCount = 0;
    private int tiesCount = 0;

    // Array to hold the player's choice
    final String[] playerChoice = new String[1];

    // Constructor for the RockPaperScissorsFrame class
    public RockPaperScissorsFrame()
    {
        // create the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // create the top, middle, and bottom panels. the methods for creating these panels are below
        createTopPanel();
        createMiddlePanel();
        createBottomPanel();

        // add the panels to the main panel, as well as give the frame a title and set the default close operation
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

    //Method to create the top panel which contains the title and the title icon
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

    //Method to create the middle panel which contains the display, past games, and the player wins, player losses, and ties
    private void createMiddlePanel()
    {
        middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));

        // This is the display label that will display the title of the past games
        display = new JLabel("Past Games");
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setHorizontalAlignment(SwingConstants.CENTER);
        display.setAlignmentX(Component.CENTER_ALIGNMENT);

        // This is the text area that will display the past games. It is a text area that is not editable and is wrapped in a scroll pane.
        pastGames = new JTextArea(5, 10);
        pastGames.setFont(displayFont);
        pastGames.setLineWrap(true);
        pastGames.setWrapStyleWord(true);
        pastGames.setEditable(false);
        scroll = new JScrollPane(pastGames, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // These are the labels that will display the player wins, player losses, and ties. They are initialized to 0.
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


        /*
        If a text area is added to a panel as well as a scroll pane, the text area will be displayed
        and you don't need to add the text area to the scroll pane. The scroll pane will automatically
        display the text area.
         */

        // add components to middlePanel
        middlePanel.add(display);
        middlePanel.add(scroll);
        middlePanel.add(playerWins);
        middlePanel.add(playerLoses);
        middlePanel.add(ties);
    }

    //Method to create the bottom panel which contains the rock, paper, scissors, and exit buttons
    private void createBottomPanel()
    {
        bottomPanel = new JPanel();

        // Buttons for the game are created here.
        rock = new JButton("Rock");
        paper = new JButton("Paper");
        scissors = new JButton("Scissors");
        exit = new JButton("Exit");

        // The buttons are added to the bottom panel here, and they are initialized to the images of rock, paper, scissors, and exit.
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

        // Action listeners for the buttons are created here. The action listeners will call the getResults method and update the player wins, player losses, and ties.
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

    // Method to get the results of the game. The player choice is passed in as a parameter. The computer choice is randomly generated.
    private void getResults(String playerChoice)
    {
        // Array to hold the computer's choice of rock, paper, or scissors is created here. The computer's choice is randomly generated.
        String[] computerChoices = {"Rock", "Paper", "Scissors"};
        String computerChoice = computerChoices[(int) (Math.random() * 3)];
        String result = "Invalid choice";

        // The results of each possible game are determined here. The results are displayed in the text area.
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
        // The results of the game are added to the text area here and a new line is added.
        pastGames.append(result + "\n");
    }
}
