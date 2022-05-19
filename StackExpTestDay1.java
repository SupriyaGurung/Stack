import java.util.Stack;

public class StackExpTestDay1
{
 public static double evalAns(String exp)
 {
  Stack<String> s = new Stack<String>();
  for(int i=0; i<exp.length(); i++)
  {
    if("0123456789".indexOf(exp.substring(i,i+1))>0)
    {
      s.push(exp.substring(i,i+1));
    }
    else if("+-/*%^".indexOf(exp.substring(i,i+1))>=0)
    {
      Double second = Double.valueOf(s.pop());
      Double first = Double.valueOf(s.pop());
      System.out.print(s);
      if(exp.substring(i,i+1).equals("-"))
      {
        s.push(first-second+"");
      }
      else if(exp.substring(i,i+1).equals("+"))
      {
        s.push(first+second+"");
      }
      else if(exp.substring(i,i+1).equals("*"))
      {
        s.push(first*second+"");
      }
      else if(exp.substring(i,i+1).equals("/"))
      {
        s.push(first/second+"");
      }
      else if(exp.substring(i,i+1).equals("^"))
      {
        s.push(Math.pow(first, second)+"");
      }
      else if(exp.substring(i,i+1).equals("%"))
      {
        s.push(first%second + "");
      }
    }
    else if(exp.substring(i,i+1).equals("!"))
    {
      double third = Double.valueOf(s.pop());
      double t=1.0;
      for(double r = third; r > 0; r--)
      {
        t = t*r;
      }
      s.push(t+"");
    }
    
  }
  return Double.valueOf(s.pop());
 }
 
  public static void main(String[] args)
  {
    double answer, yourAns;
    String exp;
  int c=0, w=0;
    
    exp = "256++";
    System.out.println("Testing Post-fix Single Digit Operation");
    System.out.println("Operations tested: +,-,*,/,%,^,!");
    System.out.println("Testing 2+5+6");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 13;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }
    
    System.out.println();
    exp = "256*+9-";
    System.out.println("Testing 2+5*6-9");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 23;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }
    
    System.out.println();
    exp = "111+3^+2/";
    System.out.println("Testing (1+(1+1)^3)/2");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 4.5;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
    exp = "12+3*23+%";
    System.out.println("Testing (1+2)*3%(2+3)");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 4;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
    exp = "473%-!";
    System.out.println("Testing (4-7%3)!");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 6;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
  System.out.println("Number of correct answer: " + c);
  System.out.println("Number of incorect answer: " + w);
  System.out.println("Accuracy: " + Math.round((double)c/(c+w)*100)/100 + "%");
  }
}
