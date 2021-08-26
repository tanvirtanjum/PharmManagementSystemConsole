import java.lang.*;

import home.*;

public class Start
{
  public static void main(String args[])
  {
    Home home = new Home();
    Option option = new Option(home);
    home.op = option;
    option.redirect();
  }
}
