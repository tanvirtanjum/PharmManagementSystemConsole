package interfaces;

import java.lang.*;
import java.util.*;
import java.io.*;
import home.*;
import business_logic.*;

public interface IMedicine
{
  public void addMedicine();

  public void showMedicine();

  public void showMedicineForSale();

  public void save();

  public void display();

  public boolean checkMed(String id);

  public double getPrice(String id);
}
