import org.specs2.matcher.DataTables
import org.specs2.mutable.Specification

class YmdSpec extends Specification with DataTables {

  "toNum" in {
    new Ymd(1025, 8, 15).toNum() mustEqual 10250815
    new Ymd(25, 8, 15).toNum() mustEqual 250815
    new Ymd(1000, 12, 5).toNum() mustEqual 10001205
  }

  "toStr" in {
    new Ymd(1025, 8, 15).toStr() mustEqual "10250815"
    new Ymd(25, 8, 15).toStr() mustEqual "00250815"
    new Ymd(1000, 12, 5).toStr() mustEqual "10001205"
  }

  "overwrap" in {
    "fromY" | "fromM" | "fromD" | "toY" | " toM" | " toD" | " result" |
      2015 ! 1 ! 1 ! 2015 ! 1 ! 1 ! true |
      2015 ! 12 ! 31 ! 2015 ! 12 ! 31 ! true |
      2014 ! 12 ! 31 ! 2014 ! 12 ! 31 ! false |
      2016 ! 1 ! 1 ! 2016 ! 1 ! 1 ! false |> { (fromY: Int, fromM: Int, fromD: Int, toY: Int, toM: Int, toD: Int, result: Boolean) =>
        new Period[Ymd](new Ymd(2015, 1, 1), new Ymd(2015, 12, 31))
          .isOverwrapped(
            new Period[Ymd](new Ymd(fromY, fromM, fromD), new Ymd(toY, toM, toD))) === result
      }
  }

  "mutually_exclusive" in {
    "fromY" | "fromM" | "fromD" | "toY" | " toM" | " toD" | " result" |
      2015 ! 1 ! 1 ! 2015 ! 1 ! 1 ! false |
      2015 ! 12 ! 31 ! 2015 ! 12 ! 31 ! false |
      2014 ! 12 ! 31 ! 2014 ! 12 ! 31 ! true |
      2016 ! 1 ! 1 ! 2016 ! 1 ! 1 ! true |> { (fromY: Int, fromM: Int, fromD: Int, toY: Int, toM: Int, toD: Int, result: Boolean) =>
      new Period[Ymd](new Ymd(2015, 1, 1), new Ymd(2015, 12, 31))
        .isMutuallyExclusive(
          new Period[Ymd](new Ymd(fromY, fromM, fromD), new Ymd(toY, toM, toD))) === result
    }
  }
}
