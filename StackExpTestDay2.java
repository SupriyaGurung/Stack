import java.util.Stack;

public class StackExpTestDay2
{
  public static String infix2Postfix(String infix)
  {
    String str = "";
    Stack<String> s = new Stack<String>();
    for(int i= 0; i<infix.length(); i++)
    {
      if("0123456789".indexOf(infix.substring(i,i+1)) >= 0)
      {
        str += infix.substring(i,i+1);
        
      }
      else if("+-*/%^!()".indexOf(infix.substring(i,i+1)) >= 0)
      {
        if(infix.substring(i,i+1).equals("("))
        {
          s.push(infix.substring(i,i+1));
        }
        else if(infix.substring(i,i+1).equals(")"))
        {
          while(!s.peek().equals("("))
          {
            str += s.pop();
          }
          s.pop();
        }
        else 
        {
          while(!s.empty() && priority(infix.substring(i,i+1))<= priority(s.peek()))
          {
            str += s.pop();
          }
          s.push(infix.substring(i,i+1));
        }
      }
    }
    while(!s.empty())
    {
      str += s.pop();
    }
    return str;
  }

  
  public static int priority(String str)
  {
    if(str.equals("+") || str.equals("-"))
    {
      return 1;
    }
    else if(str.equals("*") || str.equals("/") || str.equals("%"))
    {
      return 2;
    }
    else if(str.equals("^"))
    {
      return 3;
    }
    else if(str.equals("!"))
    {
      return 4;
    }
    else
    {
      return -1;
    }
  }
 
  public static void main(String[] args)
  {
    String answer, yourAns;
    String exp;
    int c=0, w=0;
    
    exp = "2+5+6";
    answer = "25+6+";
    System.out.println("Testing infix to postfix conversion for Single Digit Operation");
    System.out.println("Operations tested: +,-,*,/,%,^,!");
    System.out.println("Testing " + exp);
    yourAns = infix2Postfix(exp);
    if(yourAns.equals(answer)){
      System.out.println("Pass");
      c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
      w++;
    }
    
    System.out.println();
    exp = "2+5*6-9";
    answer = "256*+9-";
    System.out.println("Testing " + exp);
    yourAns = infix2Postfix(exp);
    if(yourAns.equals(answer)){
      System.out.println("Pass");
      c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
      w++;
    }
    
    System.out.println();
    exp = "(1+(1+1)^3)/2";
    answer = "111+3^+2/";
    System.out.println("Testing " + exp);
    yourAns = infix2Postfix(exp);
    if(yourAns.equals(answer)){
      System.out.println("Pass");
      c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
      w++;
    }
        
   System.out.println();
    exp = "(1+2)*3%(2+3)";
    answer = "12+3*23+%";
    System.out.println("Testing " + exp);
    yourAns = infix2Postfix(exp);
    if(yourAns.equals(answer)){
      System.out.println("Pass");
      c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
      w++;
    }

   System.out.println();
    exp = "(4-7%3)!";
    answer = "473%-!";
    System.out.println("Testing " + exp);
    yourAns = infix2Postfix(exp);
    if(yourAns.equals(answer)){
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
