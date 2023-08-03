package GraphAlgiro;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {//一个无向图

    private ArrayList<String> vertexListl ;//存储图当中的定点
    private int[][] edges ;
    private int numofEdges ;//边的数量


    //先编写一个构造器
    public Graph(int n) {//传入有多少个顶点在里面
        this.vertexListl = new ArrayList<String>(n);//创建具有n个点的一条链表
        this.edges = new int[n][n];//创建边长为n的一个二维矩阵
        this.numofEdges = n;//边的数量就是n
    }

    //往图中插入一个节点
    public void insertVertex(String v){
        vertexListl.add(v);
    }

    //往图中添加一个边的关系
    public void insertEdge(int v1 ,int v2 ,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numofEdges++;
    }
    // 返回节点的个数
    public int getNumofEdges(){
        return vertexListl.size();
    }

    public int getnumofEdges(){
        return numofEdges;
    }
    //返回某个节点对应的数据
    public String getValueByIndex(int i){
        return vertexListl.get(i);
    }
    //返回节点A1和A2之间的边权值
    public int getWeight(int A1, int A2){
        return edges[A1][A2];
    }

    //显示当前图的情况，也就是把矩阵打印出来
    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }
    public static void main(String[] args) {
        int n =5;
        String Vertex[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String vertex : Vertex) {
            graph.insertVertex(vertex);
        }

        //添加边进去
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();


    }
}
