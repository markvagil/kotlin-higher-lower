// Kotlin Higher Lower Game
// Made by Mark Vagil

import java.util.Scanner
// java scanner import

fun main() {
  // the main() function automatically runs when the program is run
  println("Welcome to the Kotlin Higher-Lower game!")
  println("")

  // Initializes the game class
  val game = Game()
  // calls the play_game() function from Game()
  game.play_game()
} 

class Game() {
    // This is the game class which holds all of the functions and variables for the game
  // These limits are inclusive
  val lower_limit = 1
  val upper_limit = 100
  var guessInt: Int = 0
  // Generates a random number within the limits
  val randomInt = (lower_limit..upper_limit).random()
  // turn the random integer into a string
  val randomStr = randomInt.toString()

  fun play_game() {
    // This function "plays" the game 

    // Gets input from user for their name
    println("Please enter your name: ")
    // reads line for player's name input
    var player_name = readLine()
    println("Let's play the game now $player_name!")

    // Uncomment this line if you want to see what the random number is
    // println("The random number is: $randomStr")

	  println("Guess which number I've chosen between $lower_limit to $upper_limit!")
    println("")

  do {
    // this loop continues until the user correctly guesses the number

    // calls function to get the guess from the user
    get_guess()

    // only allow the user to guess numbers between 1-100
    if (guessInt > 100 || guessInt < 1) {
      // this if statement actually works while get_guess() is working
      // for example if user enters out of bounds number, it will actually print
      println("You did not enter a valid integer, please try again.")
    }
    else if (guessInt > randomInt) {
      // If the guess is higher than the random number
      println("Lower")
    } 
    else if (guessInt < randomInt) {
      // If the guess is lower than the random number
      println("Higher")
    } 
  } while (guessInt != randomInt)

  // If the guess is correct then end the game
  println("")
  println("Congrats $player_name, you guessed the computer's number correctly.")
	println("You Win!")
  }

  fun get_guess() {
    // variable to hold player input
    var guess: Int
    
    // This entire do-while block was the hardest part of this program to validate the input from the user
    do {
      // this loop continues until the user enters a valid guess within the bounds
      print("Your guess: ")
      println("") 
      try {
        // Creates an instance which takes input from standard input (keyboard)
        var reader = Scanner(System.`in`)
        // Reads input from user and converts it to int type
        guess = reader.nextInt()
        // checks if guess is in bounds if int conversion was successful
        if (guess >= 1  || guess <= 100) {
          break
        }
      } 
      catch (e: java.util.InputMismatchException) {
        // catches input error, for example if user entered a string and not int
        println("ERROR")
      } 
      // prints warning to the user if they had an exception error
      println("You did not enter a valid integer between $lower_limit and $upper_limit, please try again.")
      // resets guess variable
      guess = 0
      
    } while (guess < 1 || guess > 100) 
    // sets player input equal to guessInt for data type purposes
    guessInt = guess
  }
}

/* Sources: 
https://www.rosettacode.org/wiki/Guess_the_number#Kotlin
https://www.techiedelight.com/convert-integer-to-string-kotlin/
https://stackoverflow.com/questions/50570262/how-to-convert-string-to-int-in-kotlin
https://www.programiz.com/kotlin-programming/input-output#:~:text=It%27s%20possible%20to%20take%20input,you%20can%20use%20Scanner%20object.&text=Then%2C%20you%20need%20to%20create%20Scanner%20object%20from%20this%20class.&text=Now%2C%20the%20reader%20object%20is,take%20input%20from%20the%20user.
https://kotlinlang.org/docs/basic-types.html#literal-constants
https://www.tutorialspoint.com/how-can-i-get-a-random-number-in-kotlin
https://stonesoupprogramming.com/2017/11/17/kotlin-string-formatting/
https://www.geeksforgeeks.org/kotlin-standard-input-output/
https://stackoverflow.com/questions/48116753/how-to-use-kotlin-when-to-find-if-a-string-is-numeric/48116988
https://www.programiz.com/kotlin-programming/input-output
https://www.techiedelight.com/determine-string-is-number-kotlin/
https://stackoverflow.com/questions/41283393/reading-console-input-in-kotlin
https://www.javatpoint.com/kotlin-try-catch
*/
