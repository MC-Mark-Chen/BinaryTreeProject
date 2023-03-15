import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Creates and processes a binary tree.
 *
 * @author Mark Chen
 */
public class TreeCreation
{
    /** Reads each line of test data */
    public static void main(String[] args) throws FileNotFoundException
    {
        File text = new File("/Users/mark/Library/CloudStorage/OneDrive-个人/AP CSA/Coding Assignments/BinarySearchTree.txt");
        Scanner input = new Scanner(text);
        
        while(input.hasNextLine())
        {
            Node root = createTree(input.nextLine());
            System.out.println(onlyLeftChild(root));
            System.out.println(onlyRightChild(root));
            System.out.println(preOrder(root));
            System.out.println(postOrder(root));
            System.out.println();
        }
    }
    
    public static Node createTree(String word)
    {
        int idx = 1;
        Node root = new Node(word.substring(0, 1), 0);
        while(idx < word.length())
        {
            root.insert(word.substring(idx, idx + 1));
            idx++;
        }
        return root;
    }
    
    public static String onlyLeftChild(Node n)
    {
        if(n.hasLeft() && !n.hasRight())
        {
            return onlyLeftChild(n.getLeft()) + n.getLetter();
        }
        else if(!n.hasLeft() && n.hasRight())
        {
            return onlyLeftChild(n.getRight());
        }
        else if(!n.hasLeft() && !n.hasRight())
        {
            return "";
        }
        return onlyLeftChild(n.getLeft()) + onlyLeftChild(n.getRight());
    }
    
    public static String onlyRightChild(Node n)
    {
        if(n.hasLeft() && !n.hasRight())
        {
            return onlyRightChild(n.getLeft());
        }
        else if(!n.hasLeft() && n.hasRight())
        {
            return n.getLetter() + onlyRightChild(n.getRight());
        }
        else if(!n.hasLeft() && !n.hasRight())
        {
            return "";
        }
        return onlyRightChild(n.getLeft()) + onlyRightChild(n.getRight());
    }
    
    public static String postOrder(Node n)
    {
        if(n.hasLeft() && !n.hasRight())
        {
            return postOrder(n.getLeft()) + n.getLetter();
        }
        else if(!n.hasLeft() && n.hasRight())
        {
            return postOrder(n.getRight()) + n.getLetter();
        }
        else if(!n.hasLeft() && !n.hasRight())
        {
            return n.getLetter();
        }
        return postOrder(n.getLeft()) + postOrder(n.getRight()) + n.getLetter();
    }
    
    public static String preOrder(Node n)
    {
        if(n.hasLeft() && !n.hasRight())
        {
            return n.getLetter() + preOrder(n.getLeft());
        }
        else if(!n.hasLeft() && n.hasRight())
        {
            return n.getLetter() + preOrder(n.getRight());
        }
        else if(!n.hasLeft() && !n.hasRight())
        {
            return n.getLetter();
        }
        return n.getLetter() + preOrder(n.getLeft()) + preOrder(n.getRight());
    }
}