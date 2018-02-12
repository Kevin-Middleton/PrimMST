public class Node
{
    private String name = "";
    private boolean isVisited = false;
    
    public Node(String name)
    {
        this.name = name;
    }

    public void visit()
    {
        isVisited = true;
    }
    
    public boolean isVisited()
    {
        return isVisited;
    }
    
    public String name()
    {
        return name;
    }
}
