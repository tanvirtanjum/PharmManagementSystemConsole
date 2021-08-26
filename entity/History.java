package entity;

import java.lang.*;
import java.util.*;
import java.io.*;
import home.*;
import business_logic.*;
import interfaces.*;

public class History implements IHistory
{
  Home home;
  int option;

  String sid[] = new String[1];
  String name[] = new String[1];
  String mid[] = new String[1];
  int quant[] = new int[1];
  double price[] = new double[1];

  public History(Home home)
  {
    this.home = home;
  }

  public void display()
  {
    System.out.println("-----------------SELLING HISTORY-----------------");
    System.out.println("1. SHOW HISTORY");
    System.out.println("2. PRINT");
    System.out.println("3. BACK TO HOME");
    System.out.println("-------------------------------------------------");
    while(true)
    {
      System.out.print("\t\t**Enter An Option: ");
      try
      {
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();
        System.out.println();

        if(option == 1)
        {
          this.show();
        }

        else if(option == 2)
        {
          this.save();
        }

        else if(option == 3)
        {
          home.op.redirect();
        }

        else
        {
          System.out.println("INVALID REQUEST.\nTRY AGAIN.");
          this.display();
        }
      }

      catch(Exception ex)
      {
        System.out.println("INVALID REQUEST.\nTRY AGAIN.");
        this.display();
      }
    }
  }

  public void show()
  {
    System.out.println("\t\tLIST");
    System.out.println("REFERENCE ID\t\tCUSTOMER NAME\t\tMEDICINE ID\t\tQUANTITY\t\tPAID AMMOUT");
    for(int i=0; i<=home.op.sm.i; i++)
    {
      System.out.println(sid[i]+"\t\t\t"+name[i]+"\t\t\t"+mid[i]+"\t\t\t"+quant[i]+"\t\t\t"+price[i]);
    }
    this.display();
  }

  public void save()
  {
    String write = "REFERENCE ID\tCUSTOMER NAME\tMEDICINE ID\tQUANTITY\tPAID AMMOUT\n";
    String FileName = "History_";
    if(home.op.sm.i > 0)
    {
      for(int i=0; i<home.op.sm.i; i++)
      {
        write=write+sid[i]+"\t\t"+name[i]+"\t\t"+mid[i]+"\t\t"+quant[i]+"\t\t"+price[i]+"\n";
      }
      FileProccessor fp = new FileProccessor();
      fp.save(write, FileName);
      this.display();
    }

    else
    {
      write=write+"NO DATA FOUND";
      FileProccessor fp = new FileProccessor();
      fp.save(write, FileName);
      this.display();
    }
  }

  public void add(String sid[], String name[], String mid[], int quant[], double price[])
  {
    this.sid = sid;
    this.name = name;
    this.mid = mid;
    this.quant = quant;
    this.price =  price;
  }
}
