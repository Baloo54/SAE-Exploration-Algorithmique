public class Arc
{
    private String dest;
    private double cout;

    public Arc(String d, double c)
    {
        this.dest=d;
        this.cout = c < 0 ? -c : c;
    }
    
}