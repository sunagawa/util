import org.specs2.mutable.Specification

class YmSpec extends Specification {

  "toNum" in {
    new Ym(1025, 8).toNum() mustEqual 102508
    new Ym(25, 8).toNum() mustEqual 2508
    new Ym(1000, 12).toNum() mustEqual 100012
  }
  "toStr" in {
    new Ym(25, 8).toStr() mustEqual "002508"
    new Ym(1985, 8).toStr() mustEqual "198508"
  }
}
