package interfaces;

import java.lang.*;
import java.util.*;
import java.io.*;
import home.*;
import business_logic.*;

public interface ISellMedicine
{
  public void display();

  public void sell();

  public void save(String id, String name, String mid, int quant, double price);
}
