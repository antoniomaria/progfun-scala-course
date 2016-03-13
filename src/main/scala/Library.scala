/*
 * by 'antoniomaria' at '12.3.2016 22:52' with Gradle 2.11
 *
 * @author antoniomaria, @date 12.3.2016 22:52
 */
class Library {
  
  def pascal(n: Int, p: Int): Int = (n, p) match {
    case (n, 0)             => 1
    case (n, p) if (n == p) => 1
    case (n, p) if (p <= n) => pascal(n - 1, p - 1) + pascal(n - 1, p)
    case everythingElse     => 0
  }
  
  def balance(chars: List[Char]): Boolean = {
    def process(chars: List[Char], openParenthesis: Integer): Boolean = {
      if (chars.isEmpty) openParenthesis == 0
      else {
        var c = chars.head;
        if (openParenthesis < 0) false
        else if (c == '(') {
          process(chars.tail, openParenthesis + 1)
        } else if (c == ')') {
          process(chars.tail, openParenthesis - 1)
        } else
          process(chars.tail, openParenthesis)
      }
    }
    process(chars, 0)
  }
}
