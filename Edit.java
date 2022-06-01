import java.util.Calendar;
import java.util.GregorianCalendar;

public class Edit {
    GUI gui;
    public Edit(GUI gui){
        this.gui = gui;
    }

    public void editText(String command){
        switch (command) {
            case "Copy to Stack": gui.stack.push(gui.textArea.getSelectedText());
                                  break;

            case "Copy (Ctrl + C)" : gui.str = gui.textArea.getSelectedText();
                                        break;

            case "Cut to Stack" : gui.stack.push(gui.textArea.getSelectedText());
                                  gui.i = gui.textArea.getText().indexOf(gui.str);
                                  gui.textArea.replaceRange("", gui.i, gui.i + gui.str.length());
                                  break;

            case "Cut (Ctrl + X)"  : gui.str = gui.textArea.getSelectedText();
                                     gui.i = gui.textArea.getText().indexOf(gui.str);
                                     gui.textArea.replaceRange("", gui.i, gui.str.length());
                                     break;

            case "Paste from Stack" : gui.pos = gui.textArea.getCaretPosition();    //Get Position of Cursor
                                      try {
                                          gui.textArea.insert((String)gui.stack.pop(), gui.pos);
                                      } catch (Exception e) {
                                          gui.textArea.insert("", gui.pos);
                                      }
                                      break;

            case "Paste (Ctrl + V)" : gui.pos = gui.textArea.getCaretPosition();
                                      gui.textArea.insert(gui.str, gui.pos);

            case "Time & Date"   : gui.gcalendar = new GregorianCalendar();
                                    String hour = String.valueOf(gui.gcalendar.get(Calendar.HOUR));
                                    String min = String.valueOf(gui.gcalendar.get(Calendar.MINUTE));
                                    String sec = String.valueOf(gui.gcalendar.get(Calendar.SECOND));
                                    String date = String.valueOf(gui.gcalendar.get(Calendar.DATE));
                                    String month = String.valueOf(gui.gcalendar.get(Calendar.MONTH));
                                    String year = String.valueOf(gui.gcalendar.get(Calendar.YEAR));

                                    if (Integer.parseInt(hour) < 10)
                                        hour = "0" + hour;

                                    if (Integer.parseInt(min) < 10)
                                        min = "0" + min;

                                    if (Integer.parseInt(sec) < 10)
                                        sec = "0" + sec;

                                    if (Integer.parseInt(date) < 10)
                                        date = "0" + date;

                                    if (Integer.parseInt(month) < 10)
                                        month = "0" + month;

                                    if (Integer.parseInt(year) < 10)
                                        year = "0" + year;

                                    String total = "Time :- " + hour + ":" + min + ":" + sec + "    Date :- " + date + "/" + month + "/" + year;
                                    int loc = gui.textArea.getCaretPosition();
                                    gui.textArea.insert(total, loc); 
                                    break;
        }
    }
}
