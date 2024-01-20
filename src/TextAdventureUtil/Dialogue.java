/*
	@Mendoza, Ruzzel P. BSCS ND1D Bataan Peninsula State University
	
	This class is responsible for storing all the necessary data that a dialogue can have.
	
	in hindsight this class is just a POD (Plain Ol' Data)
 */


package TextAdventureUtil;

import java.util.ArrayList;
import java.util.List;

public class Dialogue {

    public String text;

    public int dialogueType;
    public int address;
    public List<Response> response = new ArrayList<>();

    public Dialogue(String _text, int _dialogueType, int _address){

        text = _text;
        dialogueType = _dialogueType;
        address = _address;
    }

}
