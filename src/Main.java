/*
	@Mendoza, Ruzzel P. BSCS ND1D Bataan Peninsula State University
	
	This class is responsible for the entry point of the application
 */

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        // We create and instantiate a new Application
        App application = new App();

        // We Initialize all the necessary components of the applications
        
        application.Init();
        
        // While the current state of the application is not Exit then just continue running the application
        while (application.currentState != AppState.Exit) {
            application.Play();
            
        }

        // if the loop breaks then that means the current state of the application is now Exit
        // Meaning we exited the application
        application.Destroy();
    }
}
