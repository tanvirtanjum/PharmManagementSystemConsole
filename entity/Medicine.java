package entity;

import java.lang.*;
import java.util.*;
import java.io.*;
import home.*;
import business_logic.*;
import interfaces.*;

public class Medicine implements IMedicine
{
  int option;
  int count = 0;
  String id[] = new String[1];
  String name[] = new String[1];
  double price[] = new double[1];
  Home home;

  public Medicine(Home home)
  {
    this.home = home;
  }

  public void addMedicine()
  {
    int number;
    String cmd;
    Scanner sc = new Scanner(System.in);
    System.out.print("How Many Medicine You Want to Add (Type 0 to abort): ");
    try
    {
      cmd = sc.next();
      number = Integer.parseInt(cmd);
      System.out.println();

      if(number == 0)
      {
        this.display();
      }

      if(number > 0)
      {
        if(count < 1)
        {
          id = new String[number];
          name = new String[number];
          price = new double[number];

          for(int i=0; i<number; i++)
          {
            try
            {
              System.out.print("ID: ");
              id[i] = sc.next();
              System.out.print("NAME: ");
              name[i] = sc.next();
              System.out.print("PRICE: ");
              price[i] = sc.nextDouble();
              System.out.print('\n');
            }

            catch(Exception ex)
            {
              System.out.println("ERROR OCCURED");
              this.display();
            }

            count += 1;
          }
        }

        else
        {
          String nid[] = new String[number];
          String nname[] = new String[number];
          double nprice[] = new double[number];

          number = number + count;

          for(int i=0; i<number; i++)
          {
            if(i < count)
            {
              nid[i] = id[i];
              nname[i] = name[i];
              nprice[i] = price[i];
            }
            else
            {
              try
              {
                System.out.print("ID: ");
                nid[i] = sc.next();
                System.out.print("NAME: ");
                nname[i] = sc.next();
                System.out.print("PRICE: ");
                nprice[i] = sc.nextDouble();
                System.out.print('\n');
              }

              catch(Exception ex)
              {
                System.out.println("ERROR OCCURED");
                this.display();
              }
            }
            count += 1;
            System.out.println("\n");
          }
          id = nid;
          name = nname;
          price = nprice;
        }
        this.display();
      }
      sc = null;
    }

    catch(Exception ex)
    {
      System.out.println("INVALID INPUT.");
      sc = null;
      this.addMedicine();
    }
    sc = null;
  }

  public void showMedicine()
  {
    System.out.println("ID\t\t\tNAME\t\t\tPRICE");

    if(count > 0)
    {
      for(int i=0; i<count; i++)
      {
        System.out.println(id[i]+"\t\t\t"+name[i]+"\t\t\t"+price[i]);
      }
      this.display();
    }

    else
    {
      System.out.println("NO DATA FOUND");
      this.display();
    }
  }

  public void showMedicineForSale()
  {
    System.out.println("ID\t\t\tNAME\t\t\tPRICE");

    if(count > 0)
    {
      for(int i=0; i<count; i++)
      {
        System.out.println(id[i]+"\t\t\t"+name[i]+"\t\t\t"+price[i]);
      }
    }

    else
    {
      System.out.println("NO DATA FOUND");
    }
  }

  public void save()
  {
    String write = "ID\t\t\tNAME\t\t\tPRICE\n";
    String FileName = "MedicineList_";
    if(count > 0)
    {
      for(int i=0; i<count; i++)
      {
        write=write+id[i]+"\t\t\t"+name[i]+"\t\t\t"+price[i]+"\n";
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

  public void display()
  {
    System.out.println("-----------------MANAGE MEDICINE-----------------");
    System.out.println("1. ADD MEDICINE");
    System.out.println("2. SHOW MEDICINE");
    System.out.println("3. PRINT LIST");
    System.out.println("4. BACK TO HOME");
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
          this.addMedicine();
        }

        else if(option == 2)
        {
          this.showMedicine();
        }

        else if(option == 3)
        {
          this.save();
        }

        else if(option == 4)
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

  public boolean checkMed(String id)
  {
    boolean ret;
    if(count > 0)
    {
      ret = true;
      for(int i=0; i<count; i++)
      {
        if(this.id[i].equals(id) || this.id[i] == id)
        {
          ret = true;
        }

        else
        {
          ret = false;
        }
      }
      return ret;
    }

    else
    {
      return false;
    }
  }

  public double getPrice(String id)
  {
    double p=0;
    for(int i=0; i<count; i++)
    {
      if(this.id[i].equals(id))
      {
        p = this.price[i];
      }

      else
      {
        p = 0;
      }
    }
    return p;
  }
}
