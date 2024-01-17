/*
 * Ruzzel
 */

public class Main {
    public static void main(String[] args) {

        App application = new App();

        application.Init();
        while (application.currentState != AppState.Exit) {
            application.Play();
        }

        application.Destroy();
    }
}
