package TextAdventureUtil;

import java.util.ArrayList;
import java.util.List;

public class Dialogue {

    public String text;

    public int responseType;
    public List<Response> response = new ArrayList<>();

    public Dialogue(String _text, int _responseType){

        text = _text;

        responseType = _responseType;
    }

}
