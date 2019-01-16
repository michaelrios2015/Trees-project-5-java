/*
Michael Rios
COSC 600
Professor Harry Zhou
Project 5
 */

package project.pkg5;


public class treefunctions {

    public treenode insert(treenode t, int k){//builds tree or just inserts new node
        if (t == null)//we are either starting a new tree or have reached the bottom level
        {
            treenode newNode = new treenode();//declare new node
            newNode.data = k; //assign value to node
            newNode.left=null; //set its right and left pointer to null
            newNode.right=null;  
            return newNode;
        }
        else if( k > t.data)//the new value is bigger then current nodes value 
            { 
                //System.out.println("here II");
                t.right = insert(t.right,k);//send it to the right side of tree
                return t;
            }
	else{t.left = insert(t.left, k);//the new value is smaller then current nodes value
		          return t;}//send it to the left side of tree
}
    
public treenode delete(treenode t, int num){//not working for reasons unknown
        
             treenode temp = new treenode();
    
        if (t != null)//keep going till no more nodes
        {
            if (t.data == num && t.right == null && t.left == null){//we have found the node it has no children
                System.out.println(t.data + " = " + num +" no children");//for testing
                t = null;//set t to null to delete, should work does not
                return t;
            }
            else if (t.data == num && t.right == null && t.left != null){//we have found the node it has a left child
                System.out.println(t.data + " = " + num +" left child");//for testing
                t = t.left;}//set t to t.left
            else if (t.data == num && t.right != null && t.left == null){//we have found the node it has a right child
                 System.out.println(t.data + " = " + num +" right child");
                t = t.right;}//set t to t.right
            else if (t.data == num && t.right != null && t.left != null)//we have found the node it has two children
            {    
                 System.out.println(t.data + " = " + num+" 2 children");
                //treenode temp;
                 temp = min(t.right); //find the smallest node on the right side, store it in temp ;
                 t = temp;//assigns temp to T
                 temp = temp.right;//if the smallest value on the right side had a child 
                 //this would assign its child to its space
                  return t;
            }
            else if (t.data > num ){//number is less than the node
                 System.out.println(t.data + " > " + num);//just to test
            
                delete(t.left, num);}//recursive call to left side of tree
            else{ 
                 System.out.println(t.data + " > " + num);//number is greater  than the node
                delete(t.right, num);} //recursive call to right side of tree
            
              return t; 
        }
        
        return t; 
}

public treenode min ( treenode  t ) {//finds the smallest node by going as far left as possible
	if ( t == null ) return null;
	else 
	     if ( t. left == null ) return t;
	     else return min ( t.left );
}

public int nodeNumberInorder(treenode t){//an attempt to modify the Inorder function to 
                                         //find the 5th element of the tree.  It does not work 
                                          //I tried using a counter but the recursive calls mess up the count
                                          //I am not sure how to fix it and believe I am missing something fairly obvious
        //int[] myIntArray = new int[40];
        int i = 0;
        if(t != null && i > 5){
		nodeNumberInorder(t.left);
		//myIntArray[i] = t.data;
		i++;
                nodeNumberInorder(t.right);
                i++;
        }

       return t.data;
}

public void Inorder(treenode t){//prints tree Inorder through recursive calls
	if(t != null){
		Inorder(t.left);
		System.out.print(" " + t.data);
		Inorder(t.right);}
}

public void Postorder(treenode t){//prints tree Postorder through recursive calls
	if(t != null){
		Postorder(t.left);
		Postorder(t.right);
		System.out.print(" " + t.data);}
}


public void Preorder(treenode t){//prints tree Preorder through recursive calls
	if(t != null){
		System.out.print(" " + t.data);
                Preorder(t.left);
		Preorder(t.right);
	}
}

public int leaves(treenode t, int leaves){//finds number of leaves in a tree
    //int leaves = 0;
    if(t != null){//tree is still there
	if (t.right == null & t.left == null){//node has no children it is a leaf
            leaves ++;
            //return leaves;
            //System.out.println("leaves =  " + leaves + "\n");
        }
    //return leaves;
    
    leaves = leaves(t.left, leaves);//checks all nodes recuresively
    leaves = leaves(t.right, leaves);
    }//System.out.println("You have " + leaves + " leaves\n");

    return leaves;
}

    public treenode swap(treenode t){//swaps left and right nodes in tree recursively
        if (t != null)//while tree still there
        {
            treenode temp = new treenode();
            temp = swap(t.right);//hold right nodes in temp node
            t.right = swap(t.left);  //recursively swaps all right nodes with left
            t.left = temp;//swaps left nodes with right
            //return t;
        }
        
        return t; 
}

    public boolean compare(treenode t1, treenode t2){//compares trees to check if they are equal
         
            if (t1 != t2)//the nodes are not equal, return false 
                return false;
            if (t1 !=null && t2 != null)  //tree still exists
            {
                compare(t1.right, t2.right);//compare all right nodes
                compare(t1.left, t2.left);//compare all left nodes
                System.out.print("\nt1 = " + t1.data + " ,t2 = " + t2.data);// used to make sure function is operating
                                                                            //correctly
            }
            else 
                return false;
            
            //System.out.print("\n t1 = " + t1.data + " ,t2 = " + t2.data);
            return true;
                
}    
    
}
