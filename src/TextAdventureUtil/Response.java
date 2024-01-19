package TextAdventureUtil;

public class Response {

    public String text;
    public int nextDialoguePointer;



    public Response(String _text, int _nextDialogue){
        text = _text;
        nextDialoguePointer = _nextDialogue;
    }

}
