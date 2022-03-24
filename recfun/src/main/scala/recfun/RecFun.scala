package recfun

object RecFun extends RecFunInterface :
  /*
    def main(args: Array[String]): Unit =
      println("Pascal's Triangle")
      for row <- 0 to 10 do
        for col <- 0 to row do
          print(s"${pascal(col, row)} ")
        println()
  */

  def main(args: Array[String]): Unit = {
    val xwinner = balance("(if (zero? x) max (/ 1 x))".toList)
    val winner = balance(":-)".toList)
    println("winner is " + winner)
  }

  /*var acc: Int = 0
   chars.foreach(c =>
     if (acc == 0 && c.equals(')')) {
       return false
     } else if (c.equals('(')) {
       acc += 1
     } else if (c.equals(')')) {
       acc -= 1
     }
   )
   acc == 0*/

  /*
  def copypastebalance(chars: List[Char]): Boolean = {
   
  
    //@tailrec
    def loop(chars: List[Char], acc: Int): Boolean = {
      if (chars.isEmpty) return acc == 0
      if (acc == 0 && chars.head.equals(')')) return false
      if (chars.head.equals('(')) loop(chars.tail, acc + 1)
      else if (chars.head.equals(')')) loop(chars.tail, acc - 1)
      else loop(chars.tail, acc)
    }
  
    if (chars.nonEmpty) loop(chars, 0) else false
  }
  */
  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c < r)  then 0
    if (c == 0 || c == r)  then 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceHelper(chars: List[Char], openBracesCount: Int): Boolean = {
      if chars.isEmpty then 
        openBracesCount == 0
      else if (chars.head == ')' && openBracesCount == 0) then
        false
      else if chars.head == '(' then
        balanceHelper(chars.tail, openBracesCount + 1)
      else if chars.head == ')' then
        balanceHelper(chars.tail, openBracesCount - 1)
      else
        balanceHelper(chars.tail, openBracesCount)
    }
    balanceHelper(chars, 0)
  }


  /*-
  Write a recursive function that counts how many different ways you can make change for an amount, given a list of coin denominations. 
  For example, there are 3 ways to give change for 4 if you have coins with denomination 1 and 2: 1+1+1+1, 1+1+2, 2+2.

Do this exercise by implementing the countChange function in RecFun.scala. This function takes an amount to change, and a list of unique denominations for the coins. Its signature is as follows:

def countChange(money: Int, coins: List[Int]): Int

Once again, you can make use of functions isEmpty, head and tail on the list of integers coins.

Hint: Think of the degenerate cases. How many ways can you give change for 0 dollars? How many ways can you give change for >0 dollars, if you have no coins?
   */

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) then  1
    else if (money < 0) then  0
    else if (money >0 && coins.isEmpty) then 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
