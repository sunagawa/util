import org.specs2.matcher.DataTables
import org.specs2.mutable.Specification

class CountriesSpec extends Specification with DataTables {
  "math" in {
    "a" | "b" | "c" |
      1 ! 2 ! 3 |> { (a: Int, b: Int, c: Int) =>
      a + b must_== c
    }
  }
}

