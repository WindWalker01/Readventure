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
