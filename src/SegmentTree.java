import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SegmentTree {
    private static List<Integer> list;
    private Node root;

    public SegmentTree(List<Integer> list){
        this.list=list;
        root=buildSegmentTree(0,list.size()-1);
    }

    private static class Node{
        private int start;
        private int end;
        private int val;
        private Node left;
        private Node right;

        public Node(){
            this.val=0;
            this.left=null;
            this.right=null;
        }
    }

    private  static Node buildSegmentTree(int start,int end){
        if(start==end){
            Node leaf=new Node();
            leaf.val=list.get(start);
            leaf.left=null;
            leaf.right=null;
            leaf.start=start;
            leaf.end=end;
            return leaf;
        }

        Node node=new Node();
        node.start=start;
        node.end=end;
        int mid=(start+end)/2;

        node.left=buildSegmentTree(start,mid);
        node.right=buildSegmentTree(mid+1,end);
        node.val=node.left.val+ node.right.val;
        return node;
    }

    public void update(int index,int value){
        update(root,index,value);
    }
    private int update(Node node,int index,int value){
        if(node.start <= index && node.end>= index){
            if(node.start==index && node.end==index){
                node.val=value;
            }else{
                int leftValue=update(node.left,index,value);
                int rightValue=update(node.right,index,value);
                node.val=leftValue+rightValue;
            }
        }
        return node.val;
    }

    public int querySum(int start, int end){

        return this.querySum(this.root,start,end);
    }
    private int querySum(Node node,int start,int end){
        if(node.start <= start && node.end >= end){
                return node.val;
        }else if((node.start > end || node.end<start) ) return 0;
         else{
             return this.querySum(node.left,start,end)+this.querySum(node.right.start,end);
        }
    }

    public void display(){
        Queue<Node> q=new LinkedList<>();
        q.add(this.root);
        while(!q.isEmpty()){
             int n=q.size();
             while(n>0){
                 Node current=q.poll();
                 if(current.left!=null) q.add(current.left);
                 if(current.right!=null) q.add(current.right);
                 System.out.print(current.val+"\t");
                 --n;
             }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        SegmentTree s=new SegmentTree(a);
        System.out.println(s.querySum(0,2));
        //s.display();
        s.update(1,2);
        //s.display();
        System.out.println(s.querySum(0,2));

    }
}
