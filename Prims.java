public class Prims 
{    
    public static void main (String[] args) 
    {
        int count=0, usedCount=0, totalWeight=0;
        Node[] nodeList = new Node[15];
        Edge[] edgeList = new Edge[22];
        Edge[] usedEdgeList = new Edge[22];

        nodeList[0] =  new Node("A");    nodeList[1] = new Node("B");
        nodeList[2] =  new Node("C");    nodeList[3] = new Node("D");
        nodeList[4] =  new Node("E");    nodeList[5] = new Node("F");
        nodeList[6] =  new Node("G");    nodeList[7] = new Node("H");
        nodeList[8] =  new Node("I");    nodeList[9] = new Node("J");
        nodeList[10] = new Node("K");    nodeList[11] = new Node("L");
        nodeList[12] = new Node("M");    nodeList[13] = new Node("N");
        nodeList[14] = new Node("O");

        nodeList[0].visit();

        edgeList[0] = new Edge(0,1,2);     edgeList[1] = new Edge(0,9,7);
        edgeList[2] = new Edge(1,9,5);     edgeList[3] = new Edge(1,14,3);
        edgeList[4] = new Edge(14,2,2);    edgeList[5] = new Edge(14,6,3);
        edgeList[6] = new Edge(2,6,1);     edgeList[7] = new Edge(6,10,2);
        edgeList[8] = new Edge(2,10,2);    edgeList[9] = new Edge(10,7,5);
        edgeList[10] = new Edge(7,4,1);    edgeList[11] = new Edge(4,8,9);
        edgeList[12] = new Edge(8,10,15);  edgeList[13] = new Edge(12,7,3);
        edgeList[14] = new Edge(7,5,4);    edgeList[15] = new Edge(5,12,1);
        edgeList[16] = new Edge(13,5,1);   edgeList[17] = new Edge(3,13,2);
        edgeList[18] = new Edge(3,11,1);   edgeList[19] = new Edge(11,5,2);
        edgeList[20] = new Edge(11,9,5);   edgeList[21] = new Edge(9,3,3);

        System.out.println(" (v1, v2, weight)");
        System.out.println("------------------");
        
        while(count<15)
        {
            int tempEdge=0, tempValue=100;            
            count=0; 
            
            for(int i=0;i<22;i++) //find edge with smallest weight
            {
                if(!(edgeList[i].isCycle() || edgeList[i].isUsed())) //checks for used edges / cycles
                {
                    if(nodeList[edgeList[i].first()].isVisited() && nodeList[edgeList[i].second()].isVisited())  //check for new cycles
                    {
                        edgeList[i].makeCycle();
                    }
                    else if(nodeList[edgeList[i].first()].isVisited() || nodeList[edgeList[i].second()].isVisited())
                    {
                        if(edgeList[i].weight() < tempValue) //edge smallest weight & location
                        {
                            tempEdge = i;
                            tempValue = edgeList[i].weight();
                        }
                    }
                }
            }
            
            nodeList[edgeList[tempEdge].first()].visit();  //visit v1 on smallest weighted edge
            nodeList[edgeList[tempEdge].second()].visit(); //visit v2 on smallest weighted edge
            
            edgeList[tempEdge].makeUsed(); //mark as used
            usedEdgeList[usedCount] = new Edge(edgeList[tempEdge].first(),edgeList[tempEdge].second(),edgeList[tempEdge].weight()); //array filled with used edges

            System.out.println("   (" + usedEdgeList[usedCount].first() + ", " + usedEdgeList[usedCount].second() + ", " + usedEdgeList[usedCount].weight() + ")");
            
            totalWeight += usedEdgeList[usedCount].weight(); //add weight of current used edge to total      
            usedCount++; //increase used edge count
            
            for(int j=0; j<15;j++) //checks if all nodes are visited
            {
                if(nodeList[j].isVisited())
                {
                    count++;
                }
            }
        }
        System.out.println("------------------");
        System.out.println("Total Weight = " + totalWeight);
    }
}