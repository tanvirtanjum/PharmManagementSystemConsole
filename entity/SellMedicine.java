package entity;

import java.lang.*;
import java.util.*;
import java.io.*;
import home.*;
import business_logic.*;
import interfaces.*;

public class SellMedicine implements ISellMedicine
{
  Home home;
  int option;
  int i = 0;

  public SellMedicine(Home home)
  {
    this.home = home;
  }

  public void display()
  {
    System.out.println("-----------------SELLING POINT-----------------");
    System.out.println("1. SELL");
    System.out.println("2. CHECK HISTORY");
    System.out.println("3. BACK TO HOME");
    System.out.println("------------------------------------------------");
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
          this.sell();
        }

        else if(option == 2)
        {
          this.home.op.h.display();
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

  public void sell()
  {
    System.out.println("\t\tLIST");
    home.op.m.showMedicineForSale();

    Scanner sc = new Scanner(System.in);
    String sid[] = new String[1];
    String name[] = new String[1];
    String mid[] = new String[1];
    int quant[] = new int[1];
    double price[] = new double[1];
    char ch;

    while(true)
    {
      try
      {
        System.out.print("\n\nPress 1 to Continue 0 to Exit: ");
        ch = sc.next().charAt(0);

        if(ch == '1')
        {
          System.out.print("Sales Reference ID. ");
          sid[i] = sc.next();
          System.out.print("Customer Name: ");
          name[i] = sc.next();
          System.out.print("Medicine ID. ");
          mid[i] = sc.next();
          System.out.print("Quantity: ");
          quant[i] = sc.nextInt();

          if(home.op.m.checkMed(mid[i]) == true)
          {
            price[i] = quant[i]*home.op.m.getPrice(sid[i]);
            home.op.h.sid[i] = sid[i];
            home.op.h.name[i] = name[i];
            home.op.h.mid[i] = mid[i];
            home.op.h.quant[i] = quant[i];
            home.op.h.price[i] = price[i];
            this.save(sid[i], name[i],  mid[i], quant[i], price[i]);

            //home.op.h.add(sid, name,  mid, quant, price);
            //this.display();
            i += 1;
          }
          else
          {
            System.out.println("ERROR: Check Medicine ID.");
          }
        }

        else if(ch == '0')
        {
          home.op.h.add(sid, name,  mid, quant, price);
          this.display();
        }

        else
        {
          System.out.println("INVALID INPUT");
          this.sell();
        }
      }

      catch(Exception ex)
      {
        System.out.println("ERROR OCCURED");
        this.sell();
      }
    }

  }

  public void save(String id, String name, String mid, int quant, double price)
  {
    String write = "Invoice Reference: "+id+"\nCustomer Name: "+name+"\nMedicine ID. "+mid+"\nBuying Quantity: "+quant+"\n\tPaid Ammount:"+price+" (BDT)";
    String FileName = "Invoice_"+id;
    FileProccessor fp = new FileProccessor();
    fp.save(write, FileName);
    //this.display();
  }
}
