

package recfun

import munit._
import org.junit.runner.RunWith

//@RunWith(munit.MUnitRunner)
// https://youtrack.jetbrains.com/issue/SCL-18603
class MyHelloTest extends munit.FunSuite {

  test("hello") {
    val myList = List(1,2,3)
    val obtained = 43
    val expected = 43
    assertEquals(obtained, expected)
  }
  

}
