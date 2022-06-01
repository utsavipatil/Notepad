import java.awt.Font;

public class Format {
    GUI gui;
    Font arial , comicSansMS , timesNewRoman; 
    String selectedFont;

    public Format(GUI gui){
        this.gui = gui;
    }

    public void wordWrap(){

        if(!gui.wordWrapOn){
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap : ON");
        }else{
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap : OFF");
        }
    }

    public void createFont(int fontSize){

        arial = new Font("Arial" , Font.PLAIN , fontSize);
        comicSansMS = new Font("Comic Sans MS" , Font.PLAIN , fontSize);
        timesNewRoman = new Font("Times New Roman" , Font.PLAIN , fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font){
        selectedFont = font;

        switch (selectedFont) {
            case "Arial":   gui.textArea.setFont(arial);
                            break;
            case "Comic Sans MS" : gui.textArea.setFont(comicSansMS);     
                            break;
            case "Times New Roman" : gui.textArea.setFont(timesNewRoman);
                            break;
            default:
                break;
        }
    }
}
