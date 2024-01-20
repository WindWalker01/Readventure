/*
	@Mendoza, Ruzzel P. BSCS ND1D Bataan Peninsula State University
	
	This class is responsible for reading and displaying all the contents of the "EnchantedForest" story line from a json file
	It also handles the user input and changing the screen to different state of the application
 */
import TextAdventureUtil.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
Legends for Dialogue Types:
       -1 - Ending dialogue
        0 - Does not have responses
        1 - The dialogue contains some responses

 */




public class TextAdventurePlayer {
	private Scanner scanner = new Scanner(System.in);
	private App appState;
	private int input;
	private Dialogue currentDialogue;
	private final List<Dialogue> dialogueList = new ArrayList<>();

	public TextAdventurePlayer(App _app, String _path) {
		appState = _app;

		ReadFileDialogue(_path);
		
	}

	public void Play() {
		
		// Set the current dialogue to the first Dialogue class in the dialogueList
		 currentDialogue = dialogueList.get(0);
		 
		 while (currentDialogue.dialogueType != -1) {
			 System.out.println("\n\n");
			 
			// Display the text of current dialogue
			 System.out.println(currentDialogue.text);
			 
			// Display every element of the response array list of the current dialogue
		    for (int i = 0; i < currentDialogue.response.size(); i++) {
				
				// If the current dialogue has no response available then just print the text without any numbering.
				if(currentDialogue.dialogueType != 1){
					
					System.out.println(currentDialogue.response.get(i).text);
				}else{
					
					// if the current dialogue has a response then print it with numbering.
					System.out.println((i + 1) + " : " + currentDialogue.response.get(i).text);
				}
		    }
			
			// Get the input of the user.
			 System.out.print("\nEnter a number to continue: ");
			input = scanner.nextInt();
			
			// Decrement the input by 1 because the first element of the array list is always 0
			input--;
			
			 // If the current dialogue has no responses available then we are just going to continue to the next dialogue.
			 if (currentDialogue.dialogueType == 0) {
				 
				 // We change the current dialogue to the address of the dialogue list
				 currentDialogue = dialogueList.get(currentDialogue.response.get(0).nextDialoguePointer - 1);
				 continue; // Then skip the current iteration;
			 }
			 
			 //Checks if the user inputs an invalid input
			 if (input < 0 || input > (currentDialogue.response.size() - 1)) {
				 System.out.println("Invalid Input!");
			 } else {
				 // Get the appropriate dialogue according to the input of the user
				 currentDialogue = dialogueList.get(currentDialogue.response.get(input).nextDialoguePointer - 1);
			 }

		 }

		 // If the story ends then change the state of the application to the menu screen.
		 appState.currentState = AppState.Menu;
		
		System.out.println("\n\n\n\n");
		 
	}

	
	/*
		Read all the contents needed from a Json File
		and Initializes all the dialogue class, and it's relative responses
		to the dialogue array list of the story.
	 */
	private void ReadFileDialogue(String _path) {
		try {
			//Create an object mapper to convert json data to java objects.
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(new File(_path));
			
			//Getting the root of the json file
			JsonNode dialoguesNode = jsonNode.get("Dialogues");

			// We iterate every dialogue json object.
			for (JsonNode dialogue : dialoguesNode) {
				
				// We created a temporary variables to store all the retrieved "Dialogue" data in the json file.
				String dialogueText = dialogue.get("Text").asText();
				int dialogueType = dialogue.get("DialogueType").asInt();
				int address = dialogue.get("Address").asInt();

				// Creating an instance of the dialogue class for us to store in the array list.
				Dialogue tmpDialogue = new Dialogue(dialogueText, dialogueType, address);

				// We then create another JSON node for the data for the "responses".
				JsonNode responsesNode = dialogue.get("responses");

				// We iterate every "responses" json object in the json file
				for (JsonNode response : responsesNode) {

					// We created a temporary variables to store all the retrieved "responses" data in the json file.
					String responseText = response.get("Text").asText();
					int responseDialoguePointer = response.get("DialoguePointerAddress").asInt();
					
					
					// We use the constructor of the "Response" class to create and instantiate a "Response" class
					// and then add it to the array list of "responses" to the recently created dialogue class.
					tmpDialogue.response.add(new Response(responseText, responseDialoguePointer));

				}

				// Add the dialogue class to the array list.
				dialogueList.add(tmpDialogue);
			}

		} catch (IOException e){
			
			// if we can't for whatever reason find the json file then
			// We will notify the user that the file can't be found
			System.out.println("JSON File not found");
			
			// then change the state of the app to the menu screen
			appState.currentState = AppState.Menu;
		}

	}

}

