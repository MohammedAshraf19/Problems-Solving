import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        LinkedList<String> li = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            String num = s.next();
            li.push(num);
        }
        
        while (q-- != 0)
        {            
            int q1 = s.nextInt();
            if (q1 == 1)
            {
                String q2 = s.next();
                searchForIndex(li, q2);
            }
            else if (q1 == 2)
            {
                if (li.isEmpty())
                    System.out.println(0);
                else
                    printFromLeft(li);
            }
            else
            {
                if (li.isEmpty())
                    System.out.println(0);
                else
                    printFromRight(li);
            }
        }
    }
    
    public static void printFromRight(LinkedList<String> li)
    {
        Iterator<String> it = li.iterator();
        while (it.hasNext()){            
            System.out.print(it.next() +" ");
        }
        System.out.println();
    }
    
    public static void printFromLeft(LinkedList<String> li)
    {
        ListIterator<String> it = li.listIterator(0);
        while (it.hasNext()){    
            it.next();
        }
        while (it.hasPrevious()){            
            System.out.print(it.previous()+" ");
        }
        System.out.println();
    }
    public static void searchForIndex(LinkedList<String> li, String remov)
    {
        ListIterator<String> it = li.listIterator(0);
        while (it.hasNext()){    
            it.next();
        }
        while (it.hasPrevious())
        {            
            if (it.previous().equals(remov))
            {
                it.remove();
                return;
            }
        }
        System.out.println("Not found");
        
    }
}