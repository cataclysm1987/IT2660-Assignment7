import java.io.IOException;
import java.util.Scanner;

public class Assignment7 {

    public static void main(final String[] args) throws IOException {
        System.out.println("Hello world - this is assignment 7 in Java!");
        System.out.println("Let's create a list of 10 students with random ids and GPAs.");
        String studentlist[] = new String[]{"Bob", "Mike", "Katie", "Jenny", "Steven", "Roger", "Stacy", "Allison", "Joe", "Kelly"};
        BinaryTree binary = new BinaryTree();
        System.out.println("Now let's add to the binary tree.");
        binary.treeins(studentlist);
        System.out.println("Now let's display the sorted binary tree by traversing and logging each name to the console.");
        binary.inorderRec(binary.root);
        EnterMenuState(binary, new Scanner(System.in));
        System.out.println("That's all. Thanks for joining me!");
    }

    public static void EnterMenuState(BinaryTree tree, Scanner in) {
        // Menu state begins prompts for new actions. Actions 1 - 5 update list. Action
        // 6 exits program.
        
        int action = -1;
        while (action != 6) {
            System.out.println("Welcome to the main menu.");
            System.out.println("Please enter a number for one of the following actions: 1 to insert new student, 2 to fetch a student by Id, 3 to delete a student, 4 to update a student, 5 to output all students and 6 to exit the program.");
            action = in.nextInt();
            while (action < 1 || action > 6) {
                System.out.println("Invalid input. Please select an option from the above choices.");
                action = in.nextInt();
            }
            if (action == 1) {
                System.out.println("Insert a new student. Make sure the student name is not duplicate. Enter the student's name: ");
                String student = in.next();
                tree.insert(student);
            }
            if (action == 2) {
                System.out.println("Fetch a student's information. Please enter the student name.");
                String student = in.next();
                Node search = tree.search(tree.root, student);
                tree.displayStudent(search);
            }
            if (action == 3) {
                System.out.println("Delete a student. Please enter the student name.");
                String studentid = in.next();
                tree.delete(studentid);
            }
            if (action == 4) {
                System.out.println("Update a student. Please enter the Student Id you wish to update.");
                String studentid = in.next();
                Node student = tree.search(tree.root, studentid);
                tree.displayStudent(student);
                tree.updateStudent(student, in);
            }
            if (action == 5) {
                System.out.println("Output sorted list of all students: ");
                tree.inorderRec(tree.root);
            }
        }
    }

}