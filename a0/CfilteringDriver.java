//**********************************************************
//Assignment0:
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

package driver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import a0.Cfiltering;

public class CfilteringDriver {

  /**
   * Reads user movie ratings from a text file, calculates similarity scores and
   * prints a score matrix.
   */
  public static void main(String[] args) {
    try {

      // open file to read
      String fileName;
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of input file? ");
      fileName = in.nextLine();
      FileInputStream fStream = new FileInputStream(fileName);
      BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

      // Read dimensions: number of users and number of movies
      int numberOfUsers = Integer.parseInt(br.readLine());
      int numberOfMovies = Integer.parseInt(br.readLine());
      System.out.println("For debugging:#Users = " + numberOfUsers);
      System.out.println("For debugging:#Movies= " + numberOfMovies);

      /*
       * create a new Cfiltering object that contains: a) 2d matrix
       * i.e.userMovieMatrix (#users*#movies) b) 2d matrix i.e. userUserMatrix
       * (#users*#users)
       */
      Cfiltering cfObject = new Cfiltering(numberOfUsers, numberOfMovies);

      // this is a blankline being read
      br.readLine();

      // read each line of movie ratings and populate the
      // userMovieMatrix
      String row;
      int counterRow = 0;
      int counterCol = 0;
      while ((row = br.readLine()) != null) {
        // allRatings is a list of all String numbers on one row
        String allRatings[] = row.split(" ");
        for (String singleRating : allRatings) {
          // make the String number into an integer
          int rating = Integer.parseInt(singleRating);
          // populate userMovieMatrix
          System.out.println("For debugging:Rating is :" + singleRating);
          // TODO: COMPLETE THIS I.E. POPULATE THE USER_MOVIE MATRIX
          cfObject.populateUserMovieMatrix(counterRow, counterCol, rating);
          counterCol++;
        }
        counterCol = 0;
        counterRow++;
      }
      // close the file
      System.out.println("For debugging:Finished reading file");
      fStream.close();

      /*
       * COMPLETE THIS ( I.E. CALL THE APPROPRIATE FUNCTIONS THAT DOES THE
       * FOLLOWING)
       */
      // TODO:1.) CALCULATE THE SIMILARITY SCORE BETWEEN USERS.
      cfObject.calculateSimilarityScore();
      // TODO:2.) PRINT OUT THE userUserMatrix
      System.out.print("\n\n");
      cfObject.printUserUserMatrix();
      System.out.print("\n\n");
      // TODO:3.) PRINT OUT THE MOST SIMILAR PAIRS OF USER AND THE MOST
      // DISSIMILAR
      System.out.println("The most similar pairs of users from above userUserMatrix are: ");
      cfObject.findAndprintMostSimilarPairOfUsers();
      System.out.print("\n\n");
      System.out.println("The most dissimilar pairs of users from above userUserMatrix are: ");
      cfObject.findAndprintMostDissimilarPairOfUsers();
      System.out.print("\n\n");
      // PAIR OF USERS.
    } catch (FileNotFoundException e) {
      System.err.println("Do you have the input file in the root folder "
          + "of your project?");
      System.err.print(e.getMessage());
    } catch (IOException e) {
      System.err.print(e.getMessage());
    }
  }

}
