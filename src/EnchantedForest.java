import TextAdventureUtil.Dialogue;
import TextAdventureUtil.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnchantedForest {

    private Scanner scanner;
    private App appState;

    private Dialogue currentDialogue;

    Dialogue node1 = new Dialogue("Once upon a time, in a small village surrounded by towering mountains" +
            "and dense forests, there lived a curious and brave child. One" +
            "day, while exploring the outskirts of the village, you stumbled upon a" +
            "hidden path that led deep into the heart of the enchanted forest.", 0);
    Dialogue node2 = new Dialogue("As you ventured further, the trees seemed to whisper secrets, and" +
            "colorful butterflies danced around. Suddenly, a wise old owl named" +
            "Oliver appeared on a branch, hooting a friendly greeting.", 0);
    Dialogue node3 = new Dialogue("\"Hello, young adventurer! Welcome to the Magical Forest,\" said Oliver." +
            "\"I sense you are on a quest. Are you ready to embark on a magical\n" +
            "journey?\"", 1);
    Dialogue node4 = new Dialogue("Hmm. That is understandable young adventurer.", 0);
    Dialogue node5 = new Dialogue("But best be cautious. The magical forest can be unpredictable," +
            "and you may encounter challenges on your own. If you change your mind," +
            "I'll be here to guide you.", 0);
    Dialogue node6 = new Dialogue("As you walked away from the enchanted path, the forest remained quiet," +
            "and the magical creatures kept to themselves. The village beckoned in" +
            "the distance, and you returned home, leaving the mysteries of the\n" +
            "Magical Forest undiscovered.", 0);
    Dialogue node7 = new Dialogue("The end of this tale would focus on the importance of bravery, curiosity, " +
            "and the choices we make, even if they lead us back to familiar paths. It would also leave open the possibility for another " +
            "day when you might decide to embark on the magical adventure with Oliver's guidance....\n", 0);
    Dialogue node8 = new Dialogue("The End.\n", 2);
    Dialogue node9 = new Dialogue("Excited, you nodded and Oliver continued, \n", 1);
    Dialogue node10 = new Dialogue("To find the hidden treasure" +
            "of the forest, you must make important choices. Each choice will" +
            "take you to a different part of the magical realm.", 1);
    Dialogue node11 = new Dialogue("As you approached the whispering grove, you met a big talking tree. The tree " +
            "smiles at you and challenged you to a riddle game. If you solved the riddle, then the tree promised to reveal the " +
            "way to the next part of the forest!", 0);
    Dialogue node12 = new Dialogue("I have lungs, but I never breathe," +
            "I have a beard, but I never shave." +
            "I wear a crown, but I am no king," +
            "And whispers fill my ears, though I have no string.\n", 1);
    Dialogue node13 = new Dialogue("The tree laughs at you. \"That's wrong!\" it says and offers you to try to guess again.", 1);
    Dialogue node14 = new Dialogue("\"hehehe, that is correct! your smarter than you looks aren't cha\"", 0);
    Dialogue node15 = new Dialogue("The big talking tree offers you to take two different routes to find the hidden treasure.\n", 1);
    Dialogue node16 = new Dialogue(
            "As you approached the Sparkling Pond, a mischievous water sprite appeared. The sprite giggled and challenged Alex to a riddle game. " +
            "If Alex solved the riddles, the sprite promised to reveal the way to the next part of the forest.", 0);
    Dialogue node17 = new Dialogue("I fall from the sky, but I haven't wings. I kiss the earth, but I hold no sting. What am I?", 1);
    Dialogue node18 = new Dialogue("The water sprite laughs at you. \"That's wrong!\" it says and offers you to try to guess again.", 1);
    Dialogue node19 = new Dialogue("\"hehehe, that is correct! your smarter than you looks aren't cha\"", 0);
    Dialogue node20 = new Dialogue("The Water sprites offers you to take two different routes to find the hidden treasure.", 1);
    Dialogue node21 = new Dialogue("What happened to you?", 0);
    Dialogue node32 = new Dialogue("What happened to you?", 0);

    private List<Dialogue> dialogues = new ArrayList<>();

    public EnchantedForest(Scanner _scanner, App _app){
        scanner = _scanner;
        appState = _app;

        //TODO: Complete The story for this one and just hard code the living shit out of the dialogue nodes
        //TODO: Don't need to implement reading from a file literally just HARD CODE IT
        node1.response.add(new Response("Enter any number to continue... ", node2));
        dialogues.add(node1);

        node2.response.add(new Response("Enter any number to continue... ", node3));
        dialogues.add(node2);

        node3.response.add(new Response("You bet I am!", node9));
        node3.response.add(new Response("No, that's boring.", node4));
        dialogues.add(node3);

        node4.response.add(new Response("Enter any number to continue... ", node5));
        dialogues.add(node4);

        node5.response.add(new Response("Enter any number to continue... ", node6));
        dialogues.add(node5);

        node6.response.add(new Response("Enter any number to continue... ", node7));
        dialogues.add(node6);

        node7.response.add(new Response("Enter any number to continue... ", node8));
        dialogues.add(node7);

        dialogues.add(node8);

        node9.response.add(new Response("Enter any number to continue... ", node10));
        dialogues.add(node9);

        node10.response.add(new Response("Go to the The Sparkling Pond", node16));
        node10.response.add(new Response("Go to the Whispering Grove", node11));
        dialogues.add(node10);

        node11.response.add(new Response("Enter any number to continue... ", node12));
        dialogues.add(node11);

        node12.response.add(new Response("Ground", node13));
        node12.response.add(new Response("Forest", node13));
        node12.response.add(new Response("Tree", node14));
        dialogues.add(node12);

        node13.response.add(new Response("Enter any number to continue... " , node12));
        dialogues.add(node13);

        node14.response.add(new Response("Enter any number to continue... ", node15));
        dialogues.add(node14);

        node15.response.add(new Response("Enter the Mysterious Cave", node21));
        node15.response.add(new Response("Climb the Rainbow Tree", node32));
        dialogues.add(node15);

        node16.response.add(new Response("Enter any number to continue... ", node17));
        dialogues.add(node16);

        node17.response.add(new Response("Water", node18));
        node17.response.add(new Response("Rain", node19));
        node17.response.add(new Response("Clouds", node18));
        dialogues.add(node17);

        node18.response.add(new Response("Enter any number to continue... ", node17));
        dialogues.add(node18);

        node19.response.add(new Response("Enter any number to continue... ", node20));
        dialogues.add(node19);

        node20.response.add(new Response("Enter the Mysterious Cave", node21));
        node20.response.add(new Response("Climb the Rainbow Tree", node32));
        dialogues.add(node20);




    }

    public void Play(){

        currentDialogue = dialogues.get(0);
        System.out.println(node5.responseType);

        while (currentDialogue.responseType != 2) {
            System.out.println("\n\n");
            System.out.println(currentDialogue.text);

            for (int i = 0; i < currentDialogue.response.size(); i++) {

                System.out.println((i + 1) + " : " + currentDialogue.response.get(i).text);
            }

            int response = scanner.nextInt();
            response--;


            if(currentDialogue.responseType == 0){
                currentDialogue = currentDialogue.response.get(0).nextDialougePointer;
                continue;
            }

            if (response < 0 || response > (currentDialogue.response.size() - 1)) {
                System.out.println("Invalid Input!");
            } else {
                currentDialogue = currentDialogue.response.get(response).nextDialougePointer;

            }


        }

        appState.currentState = AppState.Menu;



    }
}
