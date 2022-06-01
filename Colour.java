import java.awt.Color;

public class Colour {
    GUI gui;

    public Colour(GUI gui){
        this.gui = gui;
    }

    public void changeColour(String col){

        switch (col) {

            case "White": gui.window.getContentPane().setBackground(Color.white);
                          gui.textArea.setBackground(Color.white);
                          gui.textArea.setForeground(Color.black);
                          break;

            case "Black": gui.window.getContentPane().setBackground(Color.black);
                          gui.textArea.setBackground(Color.black);
                          gui.textArea.setForeground(Color.white);
                          break;
                          
            case "Blue": gui.window.getContentPane().setBackground(Color.blue);
                          gui.textArea.setBackground(Color.blue);
                          gui.textArea.setForeground(Color.white);
                          break;

        }
    }
}
