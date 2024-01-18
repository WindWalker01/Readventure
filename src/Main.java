/*
 * Ruzzel
 */

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        App application = new App();

        application.Init();
        while (application.currentState != AppState.Exit) {
            try {

                application.Play();
            }catch (InputMismatchException e){
                System.out.println("Invalid Input");
            }
        }

        application.Destroy();
    }
}
