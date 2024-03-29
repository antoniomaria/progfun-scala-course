package patmat

class HuffmanSuite extends munit.FunSuite :

  import Huffman.*

  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }


  test("weight of a larger tree (10pts)") {
    new TestTrees :
      assertEquals(weight(t1), 5)
  }


  test("chars of a larger tree (10pts)") {
    new TestTrees :
      assertEquals(chars(t2), List('a', 'b', 'd'))
  }

  test("times of a char list") {
    new TestTrees :
      assertEquals(times(List('a', 'b', 'd', 'a')), ('a', 2) :: ('b', 1) :: ('d', 1):: Nil)
  }

  test("string2chars hello world") {
    assertEquals(string2Chars("hello, world"), List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }


  test("make ordered leaf list for some frequency table (15pts)") {
    assertEquals(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))), List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }


  test("combine of some leaf list (15pts)") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assertEquals(combine(leaflist), List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
  }

  test("decode should produce a list of character") {
    new TestTrees :
      assertEquals(decode(t1, 1:: 1:: 1:: Nil), List('b', 'b', 'b'))     
  }

  test("decode and encode a very short text should be identity (10pts)") {
    new TestTrees :
      assertEquals(decode(t1, encode(t1)("ab".toList)), "ab".toList)
  }

  test("resolve secret") {
    new TestTrees :
      assertEquals(decodedSecret, "huffmanestcool".toList)
  }

  test("quick encode should encode a char list") {
    new TestTrees :
      assertEquals(quickEncode(t1)(List('b', 'b', 'b')) , List(1, 1, 1))
  }

  import scala.concurrent.duration.*

  override val munitTimeout = 10.seconds
