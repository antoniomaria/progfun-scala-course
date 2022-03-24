//package objsets
import objsets.Tweet
import objsets.Empty
import objsets.NonEmpty
import objsets.TweetSet


object TestSetsApp {
  val set1: objsets.Empty = objsets.Empty()
  val set2 = set1.incl(Tweet("a", "a body", 20))
  val set3 = set2.incl(Tweet("b", "b body", 20))
  val c = Tweet("c", "c body", 7)
  val set4c = set3.incl(c)
  
  val d = Tweet("d", "d body", 9)
  val set4d = set3.incl(d)
  val set5 = set4c.incl(d)

  def asSet(tweets: TweetSet): Set[Tweet] =
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res

  def size(set: TweetSet): Int = asSet(set).size
  
  
  @main
  def start() = {
    println("hola")
    val a = "3 body"
    val b = "3 aody"
    println ("winner is "  + (a < b ))
    
    //val winner = set4c.filter(tw => tw.user == "a")
    //set4c.most
    
    
    println ("most retweet is  " + set4c.mostRetweeted)
    
    
  }

}
