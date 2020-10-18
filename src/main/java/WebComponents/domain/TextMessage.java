package WebComponents.domain;

public class TextMessage {
    public String text;

    public TextMessage(){super();}

    public TextMessage(String text){
        super();
        this.text = text;
    }

    @Override
    public String toString(){
        String ret = "The text message content is (" + text + ")";
        return ret;
    }
}
