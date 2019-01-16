/*
Michael Rios
COSC 600
Professor Harry Zhou
Project 5
Algorithm 
Build tree and test

Purpose: to build and manipulate trees

 */

package project.pkg5;

import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class Project5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        treefunctions myTree = new treefunctions();//manipulates tree
        //treefunctions T2 = new treefunctions();
        int num;
        Scanner sc = new Scanner(System.in);
        treenode T1 = null; //these will be the root of each tree
        treenode T2 = null;
        treenode T3 = null;
        treenode temp = null;
        
        
        System.out.println("please enter a number(s), use -1 to end");
        num = sc.nextInt();//get first number
        
        
        while (num != -1)//build tree T1
        {
            
            T1 = myTree.insert(T1, num); //inserts number

            num = sc.nextInt(); //gets next number
       
        }    
        
       // System.out.println(myTree.min(node).data); //used for testing
        
        System.out.println("T1 Inorder");//prints out T1 inorder
        myTree.Inorder(T1);
        System.out.println();
        
        int leaves = myTree.leaves(T1, 0); //Counts leaves in T1 

        System.out.println("\nYou have " + leaves + " leaves");
        
        
        T2 = myTree.swap(T1);//swaps the nodes in T1 assigns value to T2 unfortunatley 
        //leaves T1 permanetly chnaged, not sure if this is supposed to happen 
        
        System.out.println("\nT2 Postorder");//prints out T2 postorder
        myTree.Postorder(T2);
        System.out.println();
        
        /*System.out.println("\nT2 Inorder\n");//prints out T2 inorder
        myTree.Inorder(T2);
        System.out.println(); JUST FOR TESTING*/
      
        System.out.println("Are T1 and T2 equal??\n");
        if (myTree.compare(T1, T2)){//compares T1 and T2
            System.out.println("\nT1 = T2");//If they are equal prints this 
        }
        else {
            System.out.println("\nT1 != T2");
        }//note I do not think T1 and T2 are supposed to be equal so I had the 
        //function print out all the step to make sure it is working correctly.
        //the compare function is working correcting the swap function may be doing
        //more than it is supposed to
        
        
        System.out.println("\nPlease enter a number(s), use -1 to end sequence");//builds T3
        num = sc.nextInt();
        
        while (num != -1)
        {
            T3 = myTree.insert(T3, num);
            
            num = sc.nextInt();   
        } 

        //System.out.println("\nInorder\n"); //Just for Testing
        //myTree.Inorder(T3);
        
        System.out.println("Are T1 and T3 equal??\n");
        if (myTree.compare(T1, T3))//compare T1 and T3
            System.out.println("T1 = T3");
        else
            System.out.println("T1 != T3");//again T3 is equal the the original T1
        //but my sawp function change the orginal T1
       
        
        
        System.out.println("\nAn attempt at deleting 15 from T3 does not work for unknown reasons");
        T3 = myTree.delete(T3, 15);//This is supposed to delete 15 from the T3
        //but it does not work, it find 15 just fine.  I experimented and it allowed
        //me to chnage the value of 15 but it will not allow me to reassign the node and I am not sure why
        //I used print statements to follow the function it seems fine, I even tried just deleting
        //a leaf node but no luck
        
        System.out.println("\nT3 Inorder, with 15 still there for unknown reasons\n");//prints out T3 in order the 15 mocks me
        myTree.Inorder(T3);
    
        
        System.out.println("\n\nan attempt at printing the 5th node from T3, does not work " + myTree.nodeNumberInorder(T3));//this is supposed to print out the 
        //5th node of T3 using Inorder, it does not work.  I think I am missing something fairly 
        //obvious.  There will be more explanation in the function
    
    }
    
}
