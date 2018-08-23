import java.util.Scanner;

class node{
    node next;
    int data;
    public node(int data){
        this.data = data;
    } 
    public void DisplayNode(){
        System.out.println(data);
    }
}

public class LinkedList{
    
    node first;
    public void insertLink(int data){
        node nwlink = new node(data);
        nwlink.next = first;
        first = nwlink;
    }
    
    public void displayList(){
        node current = first;
        while(current!=null){
            current.DisplayNode();
            current = current.next;
        }
    
    }
    public void insertLinkAtAnyNode(int element,int position){
        node current = first;
        int i =0;
        while(current!=null){
            i++;
            
            // first = first.next;
            if(i==position){
                node nwlinkval = new node(element);
                nwlinkval.next = current.next;
                current.next = nwlinkval;
            }
            current = current.next; 

        }
    
    }
    public void deleteAtany(int e){
        node temp = first;
        if(e==0){
            temp = temp.next;
            return;
        }
        for(int i=1;temp!=null && i<e-1;i++){
            temp = temp.next;
        }
        node current = temp.next.next;
        temp = current;           
    }


    
    
   public static void main(String[] args){
        LinkedList nwlllist = new LinkedList();
        
       
        System.out.println("enter the number to linkedlist");
        Scanner inp = new Scanner(System.in);
        int datatolink = inp.nextInt();
        nwlllist.insertLink(datatolink);
        nwlllist.displayList();       
        int i = 1;
        
    
        while(i==1){
            System.out.println("enter the number");
            int kl = inp.nextInt();
            nwlllist.insertLink(kl);
            System.out.println("Do you want to continue");
            i = inp.nextInt();         
        }
        nwlllist.displayList();
        System.out.println("enter the position");
        int p;
        p = inp.nextInt();
        nwlllist.deleteAtany(p);
        nwlllist.displayList();
        int j,k;
        System.out.println("enter the number at position");
        j = inp.nextInt();
        System.out.println("enter position");
        k = inp.nextInt();
        nwlllist.insertLinkAtAnyNode(j,k);
        System.out.println("going to display");
        nwlllist.displayList();
   }
}