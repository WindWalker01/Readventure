import java.util.Random;
import java.util.Scanner;

public class Fact {

    Scanner scanner = new Scanner(System.in);
    App state;
    Random random;

    // Store all the fun facts in an array so that I can pick it in random
    String[] funFacts = {
            "Honey never spoils. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still perfectly edible.",
            "A single rainforest can produce 20% of the Earth's oxygen.",
            "Cows have best friends and can become stressed when they are separated from them.",
            "The world's largest desert is not the Sahara, but Antarctica. A desert is defined by its low precipitation, and Antarctica fits the bill.",
            "Octopuses have three hearts and blue blood.",
            "The Eiffel Tower can be 15 cm taller during the summer due to the expansion of the iron when it's hot.",
            "The longest recorded flight of a chicken is 13 seconds.",
            "A group of flamingos is called a \"flamboyance.\"",
            "Bananas are berries, but strawberries aren't!",
            "The original name for the butterfly was \"flutterby.\"",
            "There is a species of jellyfish known as Turritopsis dohrnii, also called the \"immortal jellyfish,\" which can revert its cells back to their earliest form and start its life cycle anew.",
            "The shortest war in history lasted only 38 minutes between Britain and Zanzibar in 1896.",
            "The Great Wall of China is not visible from the Moon without aid, contrary to popular belief.",
            "The fingerprints of koala bears are so indistinguishable from humans that they have, on occasion, been confused at crime scenes.",
            "The oldest known vegetable is the pea, dating back to around 9750 BC.",
            "Sloths can rotate their heads almost 270 degrees.",
            "A group of owls is called a \"parliament.\"",
            "The average person will spend six months of their life waiting for red lights to turn green.",
            "The world's largest pizza ever made was 131 feet in diameter and weighed over 51,000 pounds.",
            "A sneeze travels at about 100 miles per hour.",
            "The longest recorded hiccuping spree lasted 68 years!",
            "The original name for the search engine Google was \"Backrub.\"",
            "The longest word in the English language without a vowel is \"rhythms.\"",
            "Dolphins have names for each other and can call out for specific individuals.",
            "The Earth has more than 80,000 different species of ants.",
            "The inventor of the Frisbee was turned into a Frisbee. Walter Morrison's ashes were turned into a limited-edition Frisbee after he passed away.",
            "The fingerprints of a koala are so similar to humans that they could be confused at a crime scene.",
            "The world's smallest mammal is the bumblebee bat, weighing less than a penny.",
            "Honeybees can recognize human faces.",
            "The \"sixth sick sheik's sixth sheep's sick\" is one of the toughest tongue twisters in the English language.",
    };

    public Fact(Random _random, App _app) {
        state = _app;
        random = _random;
    }

    public void Play() {

        // Give the fun fact and asks the user if he wants another more.
        GetFunFact();
        int response = scanner.nextInt();

        // if he wants another one then the response is going to be 1. It will loop
        // until the user enters a number that is not equal to one.
        while (response == 1) {
            GetFunFact();
            response = scanner.nextInt();
        }

        state.currentState = AppState.Menu;
    }

    private void GetFunFact() {

        // Get the fun fact by giving an array of a random index.
        System.out.println("\n\n" + funFacts[random.nextInt(funFacts.length - 1)]);

        // Prompt the user if the user wants another fun fact
        System.out.println("\nWant to hear more?");
        System.out.println("1. Yes");
        System.out.println("2. No (Go back to the menu screen)");

        System.out.print("\nEnter a number: ");

    }
}
