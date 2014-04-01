import android.util.Log;

import java.io.*;

/**
 * Created by Richard on 4/1/14.
 */
public class ToolBox {

  /* Method to write to a raw text file in Android. Returns a boolean for notifying user of success/failure. */
  public boolean writeFile(String filename, String data){
    try{
      File file = new File(filename);

      /* Create file if it doesn't exist. */
      if (!file.exists()) file.createNewFile();

      /* Create file writer and buffered writer */
      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(data);
      bw.close();
      return true;

    }catch(IOException e){
      Log.e(null,e.getMessage());
      return false;
    }
  }

  /* Method to read from a raw text file in Android. Returns the string read or an error message. */
  public String readFile(String filename){

    String out = null;
    try {
      FileReader fr = new FileReader(filename);
      BufferedReader br = new BufferedReader(fr);
      String sCurrentLine;
      while((sCurrentLine = br.readLine()) != null){
        out += sCurrentLine;
      }
    } catch(FileNotFoundException e){
      out = "FNF";
      Log.e("Reader",e.getMessage());
    } catch(IOException e){
      out = "IOE";
      Log.e("Reader", e.getMessage());
    }
    return out;
  }

  /* More pain in the butt methods will be added later as I see fit. */

  /* End Class */
}
