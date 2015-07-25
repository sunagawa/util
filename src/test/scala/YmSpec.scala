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

  "overwrap" in {
    val period = new Period(new Ym(2015, 1), new Ym(2015, 12))
    period.isOverwrapped(new Period(new Ym(2015, 1), new Ym(2015, 12))) === true
    period.isOverwrapped(new Period(new Ym(2015, 1), new Ym(2015, 1))) === true
    period.isOverwrapped(new Period(new Ym(2015, 12), new Ym(2015, 12))) === true
    period.isOverwrapped(new Period(new Ym(2014, 12), new Ym(2015, 2))) === true
    period.isOverwrapped(new Period(new Ym(2015, 11), new Ym(2016, 1))) === true
    period.isOverwrapped(new Period(new Ym(2000, 1), new Ym(2014, 12))) === false
    period.isOverwrapped(new Period(new Ym(2016, 1), new Ym(2020, 12))) === false
  }

  "mutually_exclusive" in {
    val period = new Period(new Ym(2015, 1), new Ym(2015, 12))
    period.isMutuallyExclusive(new Period(new Ym(2015, 1), new Ym(2015, 12))) === false
    period.isMutuallyExclusive(new Period(new Ym(2015, 1), new Ym(2015, 1))) === false
    period.isMutuallyExclusive(new Period(new Ym(2015, 12), new Ym(2015, 12))) === false
    period.isMutuallyExclusive(new Period(new Ym(2014, 12), new Ym(2015, 2))) === false
    period.isMutuallyExclusive(new Period(new Ym(2015, 11), new Ym(2016, 1))) === false
    period.isMutuallyExclusive(new Period(new Ym(2000, 1), new Ym(2014, 12))) === true
    period.isMutuallyExclusive(new Period(new Ym(2016, 1), new Ym(2020, 12))) === true
  }


}
