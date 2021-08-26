package entity;

import java.lang.*;
import java.util.*;
import java.io.*;
import home.*;
import business_logic.*;
import interfaces.*;


public class Employee implements IEmployee
{
  int option;
  int count = 0;
  String id[] = new String[1];
  String name[] = new String[1];
  double salary[] = new double[1];
  Home home;

  public Employee(Home home)
  {
    this.home = home;
  }

  public void addEmployee()
  {
    int number;
    String cmd;
    Scanner sc = new Scanner(System.in);
    System.out.print("\t\t**How Many Employee You Want to Add (Type 0 to abort): ");
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
          salary = new double[number];

          for(int i=0; i<number; i++)
          {
            try
            {
              System.out.print("ID: ");
              id[i] = sc.next();
              System.out.print("NAME: ");
              name[i] = sc.next();
              System.out.print("SALARY: ");
              salary[i] = sc.nextDouble();
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
          double nsalary[] = new double[number];

          number = number + count;

          for(int i=0; i<number; i++)
          {
            if(i < count)
            {
              nid[i] = id[i];
              nname[i] = name[i];
              nsalary[i] = salary[i];
            }
            else
            {
              try
              {
                System.out.print("ID: ");
                nid[i] = sc.next();
                System.out.print("NAME: ");
                nname[i] = sc.next();
                System.out.print("SALARY: ");
                nsalary[i] = sc.nextDouble();
              }

              catch(Exception ex)
              {
                System.out.println("ERROR OCCURED");
                this.display();
              }
            }
            count += 1;
          }
          id = nid;
          name = nname;
          salary = nsalary;
        }
        this.display();
      }
      sc = null;
    }

    catch(Exception ex)
    {
      System.out.println("INVALID INPUT.");
      sc = null;
      this.addEmployee();
    }
    sc = null;
  }

  public void showEmployee()
  {
    System.out.println("ID\t\t\tNAME\t\t\tSALARY");

    if(count > 0)
    {
      for(int i=0; i<count; i++)
      {
        System.out.println(id[i]+"\t\t\t"+name[i]+"\t\t\t"+salary[i]);
      }
      this.display();
    }

    else
    {
      System.out.println("NO DATA FOUND");
      this.display();
    }
  }

  public void save()
  {
    String write = "ID\t\t\tNAME\t\t\tSALARY\n";
    String FileName = "EmployeeList_";
    if(count > 0)
    {
      for(int i=0; i<count; i++)
      {
        write=write+id[i]+"\t\t\t"+name[i]+"\t\t\t"+salary[i]+"\n";
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
    System.out.println("-----------------MANAGE EMPLOYEE-----------------");
    System.out.println("1. ADD EMPLOYEE");
    System.out.println("2. SHOW EMPLOYEE");
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
          this.addEmployee();
        }

        else if(option == 2)
        {
          this.showEmployee();
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
}
