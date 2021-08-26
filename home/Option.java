package home;

import java.lang.*;
import java.util.*;

import entity.*;

public class Option
{
  public Home home;
  public Employee e;
  public Medicine m;
  public SellMedicine sm;
  public History h;

  public Option(Home home)
  {
    this.home = home;
    e = new Employee(this.home);
    m = new Medicine(this.home);
    sm = new SellMedicine(this.home);
    h = new History(this.home);
  }

  public void redirect()
  {
    int destination = home.display();

    while(true)
    {
      if(destination == 1)
      {
        e.display();
      }

      if(destination == 2)
      {
        m.display();
      }

      if(destination == 3)
      {
        sm.display();
      }

      if(destination == 4)
      {
        h.display();
      }

      if(destination == 5)
      {
        break;
      }
    }
  }
}
