package home;

import java.lang.*;
import java.util.*;

import entity.*;

public class Home
{
  public Option op;
  private int option;

  public Home()
  {
    System.out.println("\t\t\t\tWELCOME TO PHARMACY MANAGEMENT SYSTEM\n\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

  }

  public int display()
  {
    System.out.println("-----------------HOME-----------------");
    System.out.println("1. Employee Management");
    System.out.println("2. Medicine Management");
    System.out.println("3. Sell Medicine");
    System.out.println("4. Sales History");
    System.out.println("5. Exit");
    System.out.println("--------------------------------------");

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
          return option;
        }

        else if(option == 2)
        {
          return option;
        }

        else if(option == 3)
        {
          return option;
        }

        else if(option == 4)
        {
          return option;
        }

        else if(option == 5)
        {
          return option;
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
