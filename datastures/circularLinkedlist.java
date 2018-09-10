import java.util.Scanner;
class circularLink{
    circularLink next;
    int data;
    public circularLink(int data){
        this.data = data;
    }
    
}
public class circularLinkedlist{
    circularLink head;
    circularLink current;
    void insertAtlast(int data){
        circularLink nval = new circularLink(data);
        // at the starting point current will be zero
       if(current==null){
            current = nval; 
            head = nval;
            current.next = head;
       }
       else{
            current.next = nval;
            nval.next = head;
            current=nval;     
           
       }
    }
    void displaynode(){
        circularLink temp = head;
        while(true){
            if(temp.next==head)
               {
                System.out.println("this is the node"+temp.data);
                    break;
                }
            System.out.println("this is the node"+temp.data);
            temp = temp.next;
            
        }
    }
    void insertAtfirst(int data){
        circularLink nval = new circularLink(data);
        if(current==null){
            current = nval;
            current.next = nval;
            head = nval;
        }
        else{
            current.next = nval;
            nval.next = head;
            head = nval;  
        }
    }
    void insertAtany(int data,int pos){
        circularLink temp = head;
        circularLink nval = new circularLink(data);
        int i = 1;
        if(current==null)
            return;
        while(i<pos-1){
            i++;
            temp = temp.next;
        }
        
        
        
        nval.next = temp.next;
        temp.next = nval;
    }
    void deleteAny(int pos){
        circularLink temp = head;
        int i = 1;
        if(temp==null)
            return;
        while(i<pos-1){
            i++;
            temp = temp.next;
        }
        temp.next = temp.next.next;  
    }

    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        circularLinkedlist nwlink = new circularLinkedlist();
        int i = 0;
        int data;
        while(i==0){
            System.out.println("enter the data");
            data = inp.nextInt();
            nwlink.insertAtlast(data);
            System.out.println("press 0 for continue");
            i = inp.nextInt();
        }
        nwlink.displaynode();
        System.out.println("enter the value to be entered to list");
        int nvalue = inp.nextInt();
        nwlink.insertAtfirst(nvalue);
        nwlink.displaynode();
        System.out.println("enter the position");
        int pos = inp.nextInt();
        System.out.println("enter the data");
        int datval = inp.nextInt();
        nwlink.insertAtany(datval, pos);
        nwlink.displaynode();

        
    }
}