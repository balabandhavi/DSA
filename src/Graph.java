
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private  List<List<Integer>>adj;
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

    private boolean detectCycle(int source,boolean[] visited){
        visited[source]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(source,-1));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int current=p.vertex;
            int parent=p.parent;
            for(int children: adj.get(current-1)){
                if(!visited[children]){
                    visited[children]=true;
                    q.add(new Pair(children,current));
                }else if(children!=parent) return true;
            }
        }
        return false;
    }

    public boolean isCycle(){
        boolean[] visited=new boolean[adj.size()+1];
        for(int i=1;i< visited.length;++i){
            if(!visited[i]){
                if(detectCycle(i,visited)) return true;
            }
        }
        return false;
    }


    class Pair{
        int vertex;
        int parent;

        public Pair(int vertex,int parent) {
            this.vertex = vertex;
            this.parent=parent;
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
        System.out.println("\nIs this garph a cycle? "+g1.isCycle());

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
        System.out.println("\nIs this garph a cycle? "+g2.isCycle());

        List<List<Integer>> l3 = new ArrayList<>(
                List.of(
                        List.of(2),
                        List.of(1,3),
                        List.of(2),
                        List.of(5),
                        List.of(4)
                )
        );

        System.out.println();
        Graph g3 =new Graph(l3);
        g3.bfsTraversal();
        System.out.println();
        g3.dfsTraversal();
        System.out.println("\nIs this garph a cycle? "+g3.isCycle());

        List<List<Integer>> l4 = new ArrayList<>(
                List.of(
                        List.of(),
                        List.of(3),
                        List.of(2,4),
                        List.of(3)
                )
        );

        System.out.println();
        Graph g4 =new Graph(l4);
        g4.bfsTraversal();
        System.out.println();
        g4.dfsTraversal();
        System.out.println("\nIs this garph a cycle? "+g4.isCycle());
    }

}
