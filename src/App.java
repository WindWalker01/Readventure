/*
	@Mendoza, Ruzzel P. BSCS ND1D Bataan Peninsula State University
	
	This class is responsible for managing all the states that the application might have.
	
 */

import java.util.Random;
import java.util.Scanner;

public class App {

    public AppState currentState;
    public Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int menuValue;

    public void InitTextUI() {
        System.out.println(
                        "\t\t\t██████╗ ███████╗ █████╗ ██████╗ ██╗   ██╗███████╗███╗   ██╗████████╗██╗   ██╗██████╗ ███████╗\r\n" + //
                        "\t\t\t██╔══██╗██╔════╝██╔══██╗██╔══██╗██║   ██║██╔════╝████╗  ██║╚══██╔══╝██║   ██║██╔══██╗██╔════╝\r\n" + //
                        "\t\t\t██████╔╝█████╗  ███████║██║  ██║██║   ██║█████╗  ██╔██╗ ██║   ██║   ██║   ██║██████╔╝█████╗  \r\n" + //
                        "\t\t\t██╔══██╗██╔══╝  ██╔══██║██║  ██║╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ██║   ██║██╔══██╗██╔══╝  \r\n" + //
                        "\t\t\t██║  ██║███████╗██║  ██║██████╔╝ ╚████╔╝ ███████╗██║ ╚████║   ██║   ╚██████╔╝██║  ██║███████╗\r\n" + //
                        "\t\t\t╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝\r\n" + //
                        "\t\t\t                                                                            ");
        System.out.println("Welcome to Readventure!\n");
        System.out.println("\tWhat should we do today?");
        System.out.println("\t[1] The Enchanted Forest (A Text Adventure Game).");
        System.out.println("\t[2] Play hangman!");
        System.out.println("\t[3] Fun fact!");

        System.out.println("\n\t4. Exit\n");

        System.out.print("Enter a number: ");
    }
    
    // This method is called when the application opened.
    public void Init() {
        System.out.println("\n\n\n\n");
        
        // Initialize the current state to the menu state.
        currentState = AppState.Menu;

        InitTextUI(); // Show the all the Text UI.
        
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

    // This method is called every frame of the application
    public void Play() {

        // This block of code determines what to do relative to the state of the application
        switch (currentState) {
            case Adventure:
                TextAdventurePlayer adventure = new TextAdventurePlayer(this, "resources\\EnchantedForestDialogues.json");
                adventure.Play();
                break;
            case FunFact:
                Fact funFact = new Fact(random, this);
                funFact.Play();
                break;
            case Hangman:
                Hangman hangman = new Hangman(random, this);
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

    // This method is called when the application Exits
    public void Destroy() {
        
        // When the player exits then we thank the player for playing
        System.out.println("\nThank you For Playing!");

        scanner.close();
    }

}
