class Ym(y: Int, m: Int) extends Moment {
  def toStr(): String = "%04d%02d".format(y, m)
  def toNum(): Int = toStr().toInt
  def getYear(): Int = y
  def getMonth(): Int = m
  override def getMoment(): Int = toNum()
}
