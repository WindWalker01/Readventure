/*
	@Mendoza, Ruzzel P. BSCS ND1D Bataan Peninsula State University
	
	This class is responsible for storing a response of a single dialogue that might display to the user.
	
	in hindsight this class is just a POD (Plain Ol' Data)
 */

package TextAdventureUtil;

public class Response {
    
    public String text;
    public int nextDialogueAddress;
    
    
    
    public Response(String _text, int _nextDialogue){
        text = _text;
        nextDialogueAddress = _nextDialogue;
    }
    
}
