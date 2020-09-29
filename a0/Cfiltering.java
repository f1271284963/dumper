package a0;
// **********************************************************
// Assignment0:
//UTOR user_name:
//UT Student #:
//Author:
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

public class Cfiltering {
  // this is a 2d matrix i.e. user*movie
  private int userMovieMatrix[][];
  // this is a 2d matrix i.e. user*movie
  private float userUserMatrix[][];

  /**
   * Default Constructor.
   */
  public Cfiltering() {
    // this is 2d matrix of size 1*1
    userMovieMatrix = new int[1][1];
    // this is 2d matrix of size 1*1
    userUserMatrix = new float[1][1];
  }

  /*
   * TODO:COMPLETE THIS I.E. APPROPRIATELY CREATE THE userMovieMatrix AND
   * userUserMatrix WITH CORRECT DIMENSIONS.
   */
  /**
   * Constructs an object which contains two 2d matrices, one of size
   * users*movies which will store integer movie ratings and one of size
   * users*users which will store float similarity scores between pairs of
   * users.
   * 
   * @param numberOfUsers Determines size of matrix variables.
   * @param numberOfMovies Determines size of matrix variables.
   */
  public Cfiltering(int numberOfUsers, int numberOfMovies) {
 // this is 2d matrix of size numberOfUsers*numberOfMovies
    userMovieMatrix = new int[numberOfUsers][numberOfMovies];
    // this is 2d matrix of size numberOfUsers*numberOfUsers
    userUserMatrix = new float[numberOfUsers][numberOfUsers];
  }

  /**
   * The purpose of this method is to populate the UserMovieMatrix. As input
   * parameters it takes in a rowNumber, columnNumber and a rating value. The
   * rating value is then inserted in the UserMovieMatrix at the specified
   * rowNumber and the columnNumber.
   * 
   * @param rowNumber The row number of the userMovieMatrix.
   * @param columnNumber The column number of the userMovieMatrix.
   * @param ratingValue The ratingValue to be inserted in the userMovieMatrix
   */
  public void populateUserMovieMatrix(int rowNumber, int columnNumber,
      int ratingValue) {

    userMovieMatrix[rowNumber][columnNumber] = ratingValue;
  }
  /*
   * Helper function, to calculate similarity score for a pair of users.
   * 
   * */
  public float calculateSimilarityScorePairOfUser(int user1, int user2) {
    int sum = 0;
    
    for (int j=0;j<userMovieMatrix[user1].length;j++) {
      sum = sum + ((userMovieMatrix[user1][j] - userMovieMatrix[user2][j])*(userMovieMatrix[user1][j] - userMovieMatrix[user2][j]));
    }
    
    return (float) (1/(1+Math.sqrt(sum)));
  }
  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC. Add/remove
   * 
   * @param AND
   * 
   * @return as required below.
   */
  /**
   * Determines how similar each pair of users is based on their ratings. This
   * similarity value is represented with with a float value between 0 and 1,
   * where 1 is perfect/identical similarity. Stores these values in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void calculateSimilarityScore() {
    for (int i=0;i<userUserMatrix[0].length;i++) {
      for (int j=0;j<userUserMatrix[0].length;j++) {
        userUserMatrix[i][j] = calculateSimilarityScorePairOfUser(i, j);
      }
    }
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * Prints out the similarity scores of the userUserMatrix, with each row and
   * column representing each/single user and the cell position (i,j)
   * representing the similarity score between user i and user j.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void printUserUserMatrix() {
    System.out.println("userUserMatrix is:");
    for (int i=0;i<userUserMatrix.length;i++) {
      System.out.print("[");
      for (int j=0;j<userUserMatrix.length;j++) {
        if(j==userUserMatrix.length-1) {
          System.out.printf("%.4f", userUserMatrix[i][j]);
        }
        else {
          System.out.printf("%.4f", userUserMatrix[i][j]);
          System.out.print(", ");
        }
      }
      System.out.print("]\n");
    }
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * This function finds and prints the most similar pair of users in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */

  public void findAndprintMostSimilarPairOfUsers() {
    float highestSC = 0;
    
    // Initialize userPairs array with -1
    int userPairs[][];
    userPairs = new int[userUserMatrix.length*userUserMatrix.length][2];
    
    for(int i=0;i<userPairs.length;i++) {
      for (int j=0;j<2;j++) {
        userPairs[i][j] = -1;
      }
    }
    
    // Find highest similarity score
    for (int i=0;i<userUserMatrix.length;i++) {
      for (int j=0;j<userUserMatrix.length;j++) {
        if ((userUserMatrix[i][j] >= highestSC) && (i != j)) {
          highestSC = userUserMatrix[i][j];
        }
      }
    }
    
    int k = 0;
    int a = 0;
    // Find repeats of highest similarity score and populate userPairs
    for (int i=0;i<userUserMatrix.length;i++) {
      for (int j=a;j<userUserMatrix.length;j++) {
        if ((userUserMatrix[i][j] == highestSC) && (i != j)) {
          userPairs[k][0] = i;
          userPairs[k][1] = j;
          k++;
        }
      }
      a++;
    }
    
    // Print out the pairs
    for(int i=0;i<userPairs.length;i++) {
       if (userPairs[i][0] != -1) {
         if (i<k-1) {
           System.out.print("User" + (userPairs[i][0] + 1) + " and User" + (userPairs[i][1] + 1) + ",\n");
         }
         else {
           System.out.print("User" + (userPairs[i][0] + 1) + " and User" + (userPairs[i][1] + 1) + "\n");
         }
       }
    }
    System.out.print("with a similarity score of ");
    System.out.printf("%.4f\n", highestSC);
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * This function finds and prints the most dissimilar pair of users in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void findAndprintMostDissimilarPairOfUsers() {
    float lowestSC = 1;
    
    // Initialize userPairs array with -1
    int userPairs[][];
    userPairs = new int[userUserMatrix.length*userUserMatrix.length][2];
    
    for(int i=0;i<userPairs.length;i++) {
      for (int j=0;j<2;j++) {
        userPairs[i][j] = -1;
      }
    }
    
    // Find lowest similarity score
    for (int i=0;i<userUserMatrix.length;i++) {
      for (int j=0;j<userUserMatrix.length;j++) {
        if ((userUserMatrix[i][j] <= lowestSC) && (i != j)) {
          lowestSC = userUserMatrix[i][j];
        }
      }
    }
    
    int k = 0;
    int a = 0;
    // Find repeats of lowest similarity score and populate userPairs
    for (int i=0;i<userUserMatrix.length;i++) {
      for (int j=a;j<userUserMatrix.length;j++) {
        if ((userUserMatrix[i][j] == lowestSC) && (i != j)) {
          userPairs[k][0] = i;
          userPairs[k][1] = j;
          k++;
        }
      }
      a++;
    }
    
    // Print out the pairs
    for(int i=0;i<userPairs.length;i++) {
       if (userPairs[i][0] != -1) {
         if (i<k-1) {
           System.out.print("User" + (userPairs[i][0] + 1) + " and User" + (userPairs[i][1] + 1) + ",\n");
         }
         else {
           System.out.print("User" + (userPairs[i][0] + 1) + " and User" + (userPairs[i][1] + 1) + "\n");
         }
       }
    }
    System.out.print("with a similarity score of ");
    System.out.printf("%.4f\n", lowestSC);
  }
}
