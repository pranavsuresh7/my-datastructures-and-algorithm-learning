import java.util.Scanner;
import java.util.stream.Stream;

class node{
    int data;
    node next;
    node prev;
    public node(int data){
        this.data = data;
    }
}


public class doubleLinkedList{
    node head_ref;
    void insert_first(int data){
        node nval = new node(data);
        nval.next = head_ref;
        nval.prev = null;
        if(head_ref!=null){
            head_ref.prev = nval;
        }
        head_ref = nval;
    }
    void displaynode(){
        node temp = head_ref;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    void insertAtanyNode(int pos,int data){
        node temp = head_ref;
        int i = 1;
        while(temp!=null && i<pos-1){
            temp=temp.next;
            i=i+1;  
        }
        node nval = new node(data);
        nval.next = temp.next;
        temp.next = nval;
        nval.prev = temp;
        if(nval.next!=null) nval.next.prev = nval;
    }
    void deleteAtAnyNode(int pos){
        // node temp = head_ref;
        node current = head_ref;
        int i = 1;
        while(current!=null && i<pos-1) {
            current = current.next;
            i = i+1;
        }
        
        if(current.next.next!=null){
            current.next = current.next.next;
            current.next.prev = current; 
        }
        if(current.next.next==null){
            current.next = null;
            // if the position to be deleted is last make last node next to null
        }
         
    }
    
    // void deletelast(){
        
    // }

    public static void main(String[] args){
        int i=1,val;
        doubleLinkedList nwlink = new doubleLinkedList();
        Scanner inp = new Scanner(System.in);
        while(i==1){
            System.out.println("enter the element");
            val = inp.nextInt();
            nwlink.insert_first(val);
            System.out.println("do you want to continue ?then press 1");
            i = inp.nextInt();
        }
        System.out.println("displaying linkedlist");
        nwlink.displaynode();
        System.out.println("Hey buddy enter the position");
        int pos = inp.nextInt();
        System.out.println("Hey also enter the data dude");
        int data = inp.nextInt();
        nwlink.insertAtanyNode(pos,data);
        System.out.println("displaying linkedlist");
        nwlink.displaynode();
        System.out.println("enter the position to delete");
        int dl = inp.nextInt();
        nwlink.deleteAtAnyNode(dl);
        System.out.println("displaying linkedlist");
        nwlink.displaynode();
        inp.close();
    }
}