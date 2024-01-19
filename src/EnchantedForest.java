import TextAdventureUtil.*;

import java.io.File;
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

public class EnchantedForest {
	private Scanner scanner = new Scanner(System.in);
	private App appState;
	
	private Dialogue currentDialogue;
	private List<Dialogue> dialogueList = new ArrayList<>();
	
	
	private int dialogueCount;
	
	private int input;
	
	public EnchantedForest(App _app) {
		appState = _app;
		
		ReadFileDialogue("resources/Enchanted-Forest-Dialogues/EnchantedForestDialogues.json");
		
		System.out.println(dialogueList.get(0).text);
		
		
	}
	
	
	
	public void Play() {
		// currentDialogue = dialogues.get(0);
		// System.out.println(node5.responseType);
		// while (currentDialogue.responseType != 2) {
		// System.out.println("\n\n");
		// System.out.println(currentDialogue.text);
		//
		// for (int i = 0; i < currentDialogue.response.size(); i++) {
		//
		// System.out.println((i + 1) + " : " + currentDialogue.response.get(i).text);
		// }
		//
		//
		// try{
		//
		// input = scanner.nextInt();
		// }catch (InputMismatchException e){
		// System.out.println("Invalid Input");
		// input = 0;
		// continue;
		// }
		//
		// input--;
		//
		//
		//
		// if (currentDialogue.responseType == 0) {
		// currentDialogue = currentDialogue.response.get(0).nextDialougePointer;
		// continue;
		// }
		//
		// if (input < 0 || input > (currentDialogue.response.size() - 1)) {
		// System.out.println("Invalid Input!");
		// } else {
		// currentDialogue = currentDialogue.response.get(input).nextDialougePointer;
		//
		// }
		//
		// }
		//
		// appState.currentState = AppState.Menu;
		
		
		ReadFileDialogue("resources/Enchanted-Forest-Dialogues/Dialogue1.txt");
		
		
		int tmp = scanner.nextInt();
		
	}
	
	private void ReadFileDialogue(String _path) {
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(new File(_path));
			
			JsonNode dialoguesNode = jsonNode.get("Dialogues");
			
			
			for(JsonNode dialogue : dialoguesNode){
				
				String dialogueText = dialogue.get("Text").asText();
				int dialogueType = dialogue.get("DialogueType").asInt();
				int address = dialogue.get("Address").asInt();
				
				System.out.println("Text: " + dialogueText);
				System.out.println("DialogueType: " + dialogueType);
				System.out.println("Address: " + address);
				
				Dialogue tmpDialogue = new Dialogue(dialogueText, dialogueType, address);
				
				JsonNode responsesNode = dialogue.get("responses");
				
				for(JsonNode response: responsesNode){
					String responseText = response.get("Text").asText();
					int responseDialoguePointer = response.get("DialoguePointerAddress").asInt();
					
					System.out.println("Response Text: " + responseText);
					System.out.println("Pointer Address: " + responseDialoguePointer);
					
					tmpDialogue.response.add(new Response(responseText, responseDialoguePointer));
					
				}
				
				
				
				dialogueList.add(tmpDialogue);
				System.out.println();
			}
			
			
		}catch (Exception e){
//			e.printStackTrace();
		}
		
	}
	
	
}
