
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private static List<List<Integer>>adj;
    public Graph(List<List<Integer>> adj){
        this.adj=adj;
    }

    public void bfsTraversal(){
        boolean[] visited=new boolean[adj.size()+1];
        visited[0]=true;
        Queue<Integer> q=new LinkedList<>();
        System.out.print("BFS:\t");
        q.add(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int i=q.poll();
            for(int x:adj.get(i-1)){
                if(!visited[x]) {
                    q.add(x);
                    visited[x]=true;
                }
            }
            System.out.print(i+"\t");
        }
    }

    public void dfsTraversal(){
        boolean[] visited=new boolean[adj.size()+1];
        visited[0]=true;
        List<Integer> result=new ArrayList<>();
        result.add(1);
        dfsTraversal(1,visited,result);
        System.out.print("DFS:\t");
        for(int x:result) System.out.print(x+"\t");
    }
    private void dfsTraversal(int node,boolean[] visited,List<Integer> result){
            visited[node]=true;
            for(int x:adj.get(node-1)){
                if(!visited[x]) {
                    result.add(x);
                    //visited[x]=true;
                    dfsTraversal(x,visited,result);
                }
            }
    }


    public static void main(String[] args) {
        List<List<Integer>> l1 = new ArrayList<>(
                List.of(
                        List.of(2, 3),
                        List.of(4, 1),
                        List.of(1, 6),
                        List.of(2, 5, 10),
                        List.of(4, 9),
                        List.of(3, 7, 8),
                        List.of(6, 8),
                        List.of(6, 7),
                        List.of(10, 5),
                        List.of(4, 9)
                )
        );

        Graph g1=new Graph(l1);
        g1.bfsTraversal();
        System.out.println();
        g1.dfsTraversal();

        List<List<Integer>> l2 = new ArrayList<>(
                List.of(
                        List.of(2, 3,4),
                        List.of(1,4,5),
                        List.of(1,4),
                        List.of(1,2,3),
                        List.of(2)
                )
        );

        System.out.println();
        Graph g2 =new Graph(l2);
        g2.bfsTraversal();
        System.out.println();
        g2.dfsTraversal();

    }

}
