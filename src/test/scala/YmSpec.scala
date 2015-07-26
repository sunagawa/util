import org.specs2.matcher.DataTables
import org.specs2.mutable.{Tables, Specification}

class YmSpec extends Specification with DataTables {

  "toNum" in {
    new Ym(1025, 8).toNum() mustEqual 102508
    new Ym(25, 8).toNum() mustEqual 2508
    new Ym(1000, 12).toNum() mustEqual 100012
  }

  "toStr" in {
    new Ym(25, 8).toStr() mustEqual "002508"
    new Ym(1985, 8).toStr() mustEqual "198508"
  }

  "overwrap" in {
    "fromY" | "fromM" | "toY" | "toM" | "result" |
      2015 ! 1 ! 2015 ! 12 ! true |
      2015 ! 1 ! 2015 ! 1 ! true |
      2015 ! 12 ! 2015 ! 12 ! true |
      2014 ! 12 ! 2015 ! 2 ! true |
      2015 ! 11 ! 2016 ! 2 ! true |
      2000 ! 1 ! 2014 ! 12 ! false |
      2016 ! 1 ! 2020 ! 12 ! false |> { (fromY: Int, fromM: Int, toY: Int, toM: Int, result: Boolean) =>
      val isEqual =
        new Period(new Ym(2015, 1), new Ym(2015, 12))
          .isOverwrapped(new Period(new Ym(fromY, fromM), new Ym(toY, toM)))
      isEqual must beEqualTo(result)
    }
  }

  "mutually_exclusive" in {
    "fromY" | "fromM" | "toY" | "toM" | "result" |
      2015 ! 1 ! 2015 ! 12 ! false |
      2015 ! 1 ! 2015 ! 1 ! false |
      2015 ! 12 ! 2015 ! 12 ! false |
      2014 ! 12 ! 2015 ! 2 ! false |
      2015 ! 11 ! 2016 ! 2 ! false |
      2000 ! 1 ! 2014 ! 12 ! true |
      2016 ! 1 ! 2020 ! 12 ! true |> { (fromY: Int, fromM: Int, toY: Int, toM: Int, result: Boolean) =>
      val isEqual =
        new Period(new Ym(2015, 1), new Ym(2015, 12))
          .isMutuallyExclusive(new Period(new Ym(fromY, fromM), new Ym(toY, toM)))
      isEqual must beEqualTo(result)
    }
    1 must beEqualTo(1)
  }
}
