import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCode {
    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;

    public HuffmanCode(String feeder) throws Exception {
        HashMap<Character,Integer> frequency=new HashMap<>();
        for(Character c:feeder.toCharArray()){
            frequency.put(c, frequency.getOrDefault(c,0)+1);
        }
        Heap<Node> minHeap= new Heap<>();
        Set<Map.Entry<Character,Integer>> entrySet=frequency.entrySet();
        for(Map .Entry<Character,Integer> entry:entrySet){
            Node node=new Node(entry.getKey(),entry.getValue());
            minHeap.insert(node);
        }
        while(minHeap.size()!=1){
            Node first=minHeap.remove();
            Node second= minHeap.remove();

            Node newNode=new Node('\0', first.cost+second.cost);
            newNode.left=first;
            newNode.right=second;
            minHeap.insert(newNode);
        }
        Node ft=minHeap.remove();
        encoder=new HashMap<>();
        decoder=new HashMap<>();
        this.initEncoderDecoder(ft," ");
    }

    private class Node implements Comparable<Node>{
        Character data;
        int cost;
        Node left;
        Node right;

        public Node (Character data,int cost){
            this.data=data;
            this.cost=cost;
            this.left=null;
            this.right=null;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

    private void initEncoderDecoder(Node node,String osf){
        if(node==null) return;

        if(node.left==null && node.right==null){
            encoder.put(node.data,osf);
            decoder.put(osf,node.data);
        }
        initEncoderDecoder(node.left,osf+"0");
        initEncoderDecoder(node.right,osf+"1");
    }

    public String encode(String source){
        String ans="";
        for(int i=0;i<source.length();++i){
            ans=ans+encoder.get(source.charAt(i));
        }
        return ans;
    }

    public String decode(String codeString){
        String key = "";
        String ans="";
        for(int i=0;i<codeString.length();++i){
            key+=codeString.charAt(i);
            if(decoder.containsKey(key)){
                ans=ans+decoder.get(key);
                key="";
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        String str="abbccda";
        HuffmanCode hf=new HuffmanCode(str);
        String cs=hf.encode(str);
        System.out.println(cs);
        String dc= hf.decode(cs);
        System.out.println(dc);
    }
}
