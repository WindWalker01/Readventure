package TextAdventureUtil;

public class Response {

    public String text;
    public Dialogue nextDialougePointer;


    public Response(String _text, Dialogue _nextDialogue){
        text = _text;
        nextDialougePointer = _nextDialogue;
    }

}