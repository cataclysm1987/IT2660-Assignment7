import java.util.Scanner;

public class BinaryTree {
    Node root;
 
    BinaryTree(String name)
    {
        root = new Node(name);
    }
 
    BinaryTree()
    {
        root = null;
    }

    void insert(String name)
    {
        root = insertRec(root, name);
    }

    Node insertRec(Node root, String name)
    {
        if (root == null)
        {
            root = new Node(name);
            return root;
        }

        int compare = name.compareTo(root.name);
        if (compare < 0)
            root.left = insertRec(root.left, name);
        else if (compare > 0)
            root.right = insertRec(root.right, name);
        else if (compare == 0){
            System.out.println("Duplicate name found. Cannot insert student record.");
        }
        return root;
    }

    void displayStudent(Node student){
        if (student != null){
            System.out.println("Student name: " + student.name + ". Student GPA: " + student.gpa + ". Student Id: " + student.id);
        } else {
            System.out.println("Cannot display student. Student value was not found.");
        }
        
    }

    void updateStudent(Node student, Scanner in){
        if (student == null){
            System.out.println("Cannot update student. Student value was not found.");
        } else {
            System.out.println("Enter the student's GPA.");
            double gpa = in.nextDouble();
            while (gpa < 0 || gpa > 4){
                System.out.println("Invalid GPA. Please enter a value between 0 and 4.");
                gpa = in.nextDouble();
            }
            student.gpa = gpa;
        }
    }

    public Node search(Node root, String name)
    {
    if (root==null){
        return root;
    }

    

    int compare = name.compareTo(root.name);
    if (compare < 0){
        return search(root.left, name);
    } else if (compare > 0){
        return search(root.right, name);
    } else {
        return root;
    }
    
    }

    void delete(String name) 
    { 
        root = deleteRec(root, name); 
    }
 

    Node deleteRec(Node root, String name)
    {
        if (root == null)
            return root;
 
        int compare = name.compareTo(root.name);
        if (compare < 0)
            root.left = deleteRec(root.left, name);
        else if (compare > 0)
            root.right = deleteRec(root.right, name);
 
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.name = minValue(root.right);
            root.right = deleteRec(root.right, root.name);
        }
 
        return root;
    }

    String minValue(Node root)
    {
        String minv = root.name;
        while (root.left != null)
        {
            minv = root.left.name;
            root = root.left;
        }
        return minv;
    }

    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.name + " ");
            inorderRec(root.right);
        }
    }
    void treeins(String arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            insert(arr[i]);
        }
         
    }
 
}