package interfaces;

import java.lang.*;
import java.util.*;
import java.io.*;
import home.*;
import business_logic.*;

public interface IHistory
{
  public void display();

  public void show();

  public void save();

  public void add(String sid[], String name[], String mid[], int quant[], double price[]);
}
