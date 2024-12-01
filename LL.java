import java.util.ArrayList;
import java.util.Scanner;

class node
{
    int data;
    node next;
    node(int data)
    {
        this.data = data;
        next = null;
    }
}


class LinkedList
{
    node head;

    LinkedList()
    {
        head = null;
    }


    public void add(int data )
    {
        addlast(data);
    }

    public void add(int data , boolean last )
    {
        if(last == true)
        {
            addlast(data);
            return;
        }
        addfirst(data);
    }








    private void addlast(int data)
    {
        if( head == null )
        {
            head = new node(data);
            return;
        }


        node curr = head;

        while( curr.next !=null  )
        {
            curr = curr.next;
        }

        curr.next = new node(data);

    }

    private void addfirst(int data)
    {
        node newnode = new node(data);

        newnode.next = head;

        head = newnode;

    }

    public void add(int data , int index)
    {
        
    }


    public void remove(int index)
    {

        // null case
        if(head ==null)
        {
            System.out.println("LL is empty");
            return;
        }

        // first node
        if(head.next == null)
        {
            if(index ==0)
            {
                head = null;
                return;
            }
            System.out.println("invalis index");
            return;
        }

        // remove first
        if(index ==0)
        {
            head = head.next;
            return;
        }



        //reaching node
        node curr = head;

        for(int i =0 ; i<index-1 ; i++)
        {
            if(curr.next == null)
            {
                System.out.println("Invalid index");
                return;
            }
            curr = curr.next;
        }

        if(curr.next == null)
        {
            System.out.println("Invalid index");
            return;
        }


        curr.next = curr.next.next;





    }





    public void remove()
    {
        removelast();
    }

    public void remove(boolean last)
    {
        if(last)
        {
            removelast();
            return;
        }
        removefirst();
    }


    private void removelast()
    {
        if(head == null)
        {
            System.out.println("LL is empty");
            return;
        }


        //first case

        if(head.next == null)
        {
            head = null;
            return;
        }

        node curr = head;

        while(curr.next.next != null)
        {
            curr = curr.next;
        }

        curr.next = null;


    }


    void removefirst()
    {
        if(head == null)
        {
            System.out.println("LL is empty");
            return;
        }
        head = head.next;
    }





    public void print()
    {
        if(head == null)
        {
            System.err.println("LL is empty");
            return;
        }

        node curr = head;

        ArrayList<Integer> arr = new ArrayList<>();



        while(curr != null)
        {
            arr.add(curr.data);
            curr = curr.next;
        }


        System.out.println(arr);







    }






}



public class LL
{
    public static void main(String[] args) 
    {
        LinkedList ll = new LinkedList();

        Scanner sc = new Scanner(System.in);


        while(true)
        {

            ll.print();


            System.out.println("1.Addfirst\n2.Addlast\n3.Removefirst\n4.Removelast\n5.Removeindex\n6.Exit");
            System.out.print("Enter option :");
            int opt = sc.nextInt();

            int data,index;


            switch (opt) 
            {
                case 1:
                    System.out.print("Enter value :");
                    data = sc.nextInt();
                    ll.add(data , false);
                    break;
                case 2:
                    System.out.print("Enter value :");
                    data = sc.nextInt();
                    ll.add(data , true);
                    break;
                case 3:
                    ll.remove(false);
                    break;
                case 4:
                    ll.remove(true);
                    break;
                case 5:
                    index = sc.nextInt();
                    ll.remove(index);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }

            System.out.print("\033[H\033[2J"); // Escape codes to clear the screen
            System.out.flush();



        }


    }
}