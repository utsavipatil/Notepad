import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class File {
    GUI gui;
    String fileName;
    String fileAddress;

    public File(GUI gui){
        this.gui = gui;
    }

    public File(String string) {
    }

    public void newFile(){          /* New File */
        gui.textArea.setText(""); //Create Empty new file
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void open(){              /* Open */
        FileDialog fd = new FileDialog(gui.window , "Open" , FileDialog.LOAD); //Load a pop up for file path
        fd.setVisible(true);

        if(fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            //BufferedReader = A class which reads text from a character-input stream
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName)); //An Address to read file
            
            gui.textArea.setText("");

            String line = null;

            while((line = br.readLine()) != null){
                gui.textArea.append(line + "\n");
            }
            br.close();

        } catch (Exception e) {
            System.out.println("File Not Opened!!!");
        }
    }

    public void save(){             /* Save */

        if(fileName == null){
            saveAs();
        
        }else{
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText()); //Write file 
                gui.window.setTitle(fileName); //File name
                fw.close();

            } catch (Exception e) {
                System.out.println("Something wrong happened!!!");
            }    
        }
    }

    public void saveAs(){           /* Save As */

        FileDialog fd = new FileDialog(gui.window , "Save" , FileDialog.SAVE); 
        fd.setVisible(true);

        if(fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName); //File name
        }

        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText()); //Write file 
            fw.close();

        } catch (Exception e) {
            System.out.println("Something wrong happened!!!");
        }
    }

    public void exit(){
        System.exit(0);
    }
}
