class Ymd(y: Int, m: Int, d: Int) extends Ym(y, m) {
  override def toStr(): String = "%04d%02d%02d".format(y, m, d)
  def getDay(): Int = d
}
