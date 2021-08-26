package business_logic;

import java.lang.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.net.*;

public class FileProccessor
{
  public void save(String write, String FileName)
  {
    try
    {
      //String loc = "C:\\Users\\tanju\\Desktop\\PharmManagementSystemConsole\\Data";
      String desktopPath = System.getProperty("user.home") + "/Desktop";
      desktopPath = desktopPath.replace("\\", "/");
      String loc = desktopPath+"\\PharmManagementSystemConsole\\Data";

      String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
      FileName = FileName+timeStamp+".txt";

      File file = new File(loc);
      FileWriter writer = new FileWriter(new File(file,FileName));
      file.createNewFile();
      writer.write(write);
      writer.flush();
      writer.close();
      System.out.println("\t\tFILE SAVED (Loc: ./DATA)");
    }

    catch(Exception ex)
    {
      System.out.println("\t\tFILE NOT CREATED");
    }
  }
}
