import java.util.Random;
import java.util.Scanner;

public class App {

    public AppState currentState;
    public Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int menuValue;

    public void InitTextUI() {
        System.out.println(
                        "\t\t\t██████╗ ██████╗  █████╗ ██╗███╗   ██╗███████╗██████╗  █████╗ ██████╗ ██╗  ██╗\r\n" + //
                        "\t\t\t██╔══██╗██╔══██╗██╔══██╗██║████╗  ██║██╔════╝██╔══██╗██╔══██╗██╔══██╗██║ ██╔╝\r\n" + //
                        "\t\t\t██████╔╝██████╔╝███████║██║██╔██╗ ██║███████╗██████╔╝███████║██████╔╝█████╔╝ \r\n" + //
                        "\t\t\t██╔══██╗██╔══██╗██╔══██║██║██║╚██╗██║╚════██║██╔═══╝ ██╔══██║██╔══██╗██╔═██╗ \r\n" + //
                        "\t\t\t██████╔╝██║  ██║██║  ██║██║██║ ╚████║███████║██║     ██║  ██║██║  ██║██║  ██╗\r\n" + //
                        "\t\t\t╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝╚══════╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝\r\n" + //
                        " \t\t\t                                                                            ");
        System.out.println("\n");

        System.out.println("Welcome to BrainSpark!\n");
        System.out.println("\tWhat should we do today?");
        System.out.println("\t1. The Enchanted Forest (A Text Adventure Game).");
        System.out.println("\t2. Play hangman!");
        System.out.println("\t3. Fun fact!");

        System.out.println("\n\t4. Exit\n");

        System.out.print("Enter the number: ");
    }

    private void SetState() {
        // Prompt the user for what kind of State we want to change.
        menuValue = scanner.nextInt();

        // Change the state according to the input of the user.
        switch (menuValue) {
            case 1:
                currentState = AppState.Adventure;
                break;
            case 2:
                currentState = AppState.Hangman;
                break;
            case 3:
                currentState = AppState.FunFact;
                break;
            case 4:
                currentState = AppState.Exit;
                break;
            default:
                System.err.println("Not Defined");
                break;
        }
    }

    public void Init() {
        // Initialize the current state to the menu state.
        currentState = AppState.Menu;

        InitTextUI(); // Show the all the Text UI.

        SetState(); // And change the state according to the user's input

    }

    public void Play() {

        switch (currentState) {
            case Adventure:
                // Todo: ajsdiwiqjdmaskciwjdmqwkdniwqhjeiqwei
                EnchantedForest adventure = new EnchantedForest(scanner, this);
                adventure.Play();
                break;
            case FunFact:
                Fact funFact = new Fact(scanner, random, this);
                funFact.Play();
                break;
            case Hangman:
                Hangman hangman = new Hangman(scanner, random, this);
                hangman.Play();
                break;
            case Menu:
                Init();
                break;
            default:
                System.err.println("Not Defined");
                break;
        }

    }

    public void Destroy() {
        System.out.println("\nThank you For Playing!");

        scanner.close();
    }

}
