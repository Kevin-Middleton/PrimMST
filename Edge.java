
public class Edge
{
    private int first, second, weight;
    private boolean isCycle = false;
    private boolean isUsed = false;
    public Edge(int first, int second, int weight)
    {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    public void makeCycle()
    {
        isCycle = true;
    }
    
    public boolean isCycle()
    {
        return isCycle;
    }

    public void makeUsed()
    {
        isUsed = true;
    }
    
    public boolean isUsed()
    {
        return isUsed;
    }
        
    public int first()
    {
        return first;
    }
    
    public int second()
    {
        return second;
    }
    
    public int weight()
    {
        return weight;
    }   
}
