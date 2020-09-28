package a0;

//**********************************************************
//Assignment0:
//UTOR user_name: kongsu
//UT Student #: 1004304790
//Author: Kong Su Tong
//
//
//Honor Code: I pledge that this program represents my own
//program code and that I have coded on my own. I received
//help from no one in designing and debugging my program.
//I have also read the plagarism section in the course info
//sheet of CSC B07 and understand the consequences. Note that 
//we will be running all your quizzes and assignments for plagarism 
//check starting sometime in November of 2020. If you do not complete this honor
//code, we will give you no credit and award you 0% for this component. 


/*
 * 
 */
public class Rearranging {
	/*
	 * TODO: You are asked to complete the method
	 * rearranging. This method takes in as input an 
	 * array of ints and returns back nothing (void).
	 * You cannot change the function 
	 * signature of this method. 
	 */
	public static void rearranging(int[] items)
	{
  	  // i - head; j - tail
	  int i=0, j=items.length-1;
	  
	  // Sort the tail to all +
  	  while(i != j) {
  	    // head is - or 0, arranged by default, establish new head
  	    if(items[i]<=0) {
  	      i++;
  	      continue;
  	    }
  	    // tail is +, arranged by default, establish new tail
  	    if(items[j]>0) {
  	      j--;
  	      continue;
  	    }
  	    // head is +, move to tail, establish new tail
  	    if(items[i]>0) {
  	      swap(i, j, items);
  	      j--;
  	      continue;
  	    }
  	    // tail is - or 0, move to head, establish new head
  	    if(items[j]<=0) {
  	      swap(i, j, items);
  	      i++;
  	      continue;
  	    }
  	  }
  	 
  	  // reset head and tail
  	  i=0;
  	  j=items.length-1;
  	  
  	  // Sort 0 and -
  	  while(i != j) {
        // skip over all + tails
  	    if(items[j]>0) {
  	      j--;
  	      continue;
  	    }
  	    // head is -, arranged by default, establish new head
        if(items[i]<0) {
          i++;
          continue;
        }
        // tail is 0, arranged by default, establish new tail
        if(items[j]==0) {
          j--;
          continue;
        }
        // head is 0, move to tail, establish new tail
        if(items[i]==0) {
          swap(i, j, items);
          j--;
          continue;
        }
        // tail is - move to head, establish new head
        if(items[j]<0) {
          swap(i, j, items);
          i++;
          continue;
        }
  	  }
	}
	
	/*
	 * TODO: You are asked to complete the method
	 * swap. This method takes in as input two ints
	 * and an array of ints. The int i and int j 
	 * are the index i and index j in the array items.
	 * You are asked to swap the value at the index i in items
	 * with the value at the index j. You cannot change the function 
	 * signature of this method. 
	 */
	private static void swap(int i,int j,int[] items)
	{
		int temp = items[j];
		
		items[j] = items[i];
		items[i] = temp;
	}

	public static void main(String[] args) {
		/* You can modify the main function in any way you like.
		 * We will not mark your main function.  
		 */
		int [] items={0,8,9,-5,-1,2,2,0,0,7,-3,0,0,8,-5,-2,0,-6,-8,0,0,-10};
		/*
		 * printing the values in the items before 
		 * calling the method rearranging
		 */
		for(int item:items)
		{
			System.out.print(item);
		}
		
		System.out.print("\n");
		//calling the rearranging method
		Rearranging.rearranging(items);
		/*
		 * printing the values in the items after 
		 * calling the method rearranging
		 */
		for(int item:items)
		{
			System.out.print(item);
		}
	}
}
