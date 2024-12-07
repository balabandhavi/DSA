public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }

    private void display(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data+" --->");
            current=current.next;
        }
        System.out.print(" null");
        System.out.println();
    }

    private int findLength(){
        int count=0;
        ListNode current=head;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
    }

    private void insertInBegin(int value){
        ListNode newNode=new ListNode(value);
        newNode.next=head;
        head=newNode;
    }

    private void insertInEnd(int value){
        ListNode endNode=new ListNode(value);
        ListNode current =head;
        if(head==null){
            head=endNode;
            return;
        }
        while(current.next!=null){
            current=current.next;
        }
        current.next=endNode;
    }

    private void insertAtPosition(int value,int position){
        if(position>this.findLength()+1){
            return;
        }
        ListNode node=new ListNode(value);
        if(position==1){
            node.next=head;
            head=node;
            return ;
        }
        ListNode previous=head;
        int count=1;
        while(count<position-1){
            previous=previous.next;
            count++;
        }
        ListNode current=previous.next;
        node.next=current;
        previous.next=node;
    }


    private void deleteFirst(){
        if(this.head==null){
            return;
        }
        ListNode temp=head;
        head=head.next;
        temp.next=null;

        System.out.println("Removed head :"+ temp.data);
    }

    private void deleteEnd(){
        if(head==null||head.next==null){
            return ;
        }
        ListNode current=head;
        ListNode previous=null;
        while(current.next!=null){
            previous=current;
            current=current.next;
        }
        previous.next=null;
        System.out.println("Removed last node "+current.data);
    }

    private void deleteAtPosition(int position){
        if(position==1){
            head=head.next;
        }else{
            ListNode previous=head;
            int count=1;
            while(count<position-1){
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;
            previous.next=current.next;

        }
    }

    public boolean searchElement(int value){
        ListNode current=head;
        while(current!=null){
            if(current.data==value){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    private ListNode reverseSLL(){
        ListNode current=head;
        ListNode previous =null;
        ListNode next=null;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }
    

    public static void main(String[] args) {
        SinglyLinkedList sl1=new SinglyLinkedList();
        sl1.head=new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third =new ListNode(8);
        ListNode fourth=new ListNode(11);

        sl1.head.next=second;
        second.next=third;
        third.next=fourth;

        sl1.display(sl1.head);// 10-->1-->8-->11-->null

        sl1.insertInBegin(25);
        sl1.display(sl1.head); // 25-->10-->1-->8-->11-->null

        sl1.insertInEnd(7);
        sl1.display(sl1.head); // 25-->10-->1-->8-->11-->7--->null

        sl1.insertAtPosition(5,5);
        sl1.display(sl1.head); // 25-->10-->1-->8-->5-->11-->7--->null

        sl1.insertAtPosition(8,8);
        sl1.display(sl1.head); // 25-->10-->1-->8-->5-->11-->7--->8--->null


        sl1.insertAtPosition(10,10);
        sl1.display(sl1.head); // 25-->10-->1-->8-->5-->11-->7--->8--->null

        sl1.deleteFirst();
        sl1.display(sl1.head);//10-->1-->8-->5-->11-->7--->8--->null

        sl1.deleteEnd();
        sl1.display(sl1.head); //10-->1-->8-->5-->11-->7--->null

        sl1.deleteAtPosition(4);
        sl1.display(sl1.head);//10-->1-->8-->11-->7--->null

        System.out.println("The element 5 is present?"+sl1.searchElement(5));

        SinglyLinkedList rsl1=new SinglyLinkedList();
        rsl1.head= sl1.reverseSLL();

        System.out.println("The original list is ");
        sl1.display(sl1.head);

        System.out.println("The reversed list is ");
        rsl1.display(rsl1.head);//7--->11-->8-->1--->10---->null
    }
}
