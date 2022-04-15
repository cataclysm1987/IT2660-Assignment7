import java.util.Random;

public class Node {
    String name;
    int id;
    double gpa;
    Node left, right;
 
    public Node(String item)
    {
        name = item;
        Random r = new Random();
        gpa = 1.0 + ((4.0 - 1.0) * r.nextDouble());
        id = r.nextInt(10000000);
        left = right = null;
    }

    public Node(String item, double gradepointaverage, int studentid)
    {
        name = item;
        gpa = gradepointaverage;
        id = studentid;
        left = right = null;
    }


}