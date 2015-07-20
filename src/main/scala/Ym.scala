class Ym(y: Int, m: Int) {
  def toNum(): Int = {
    "%04d%02d".format(y, m).toInt
  }
  def toStr(): String = {
    "%04d%02d".format(y, m)
  }
  def getYear(): Int = y
  def getMonth(): Int = m
}
