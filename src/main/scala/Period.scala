class Period(from: Moment, to: Moment) {
  def isOverwrapped(period: Period): Boolean = {
    !isMutuallyExclusive(period)
  }
  def isMutuallyExclusive(period: Period): Boolean = {
    (this.to.getMoment() < period.getFrom().getMoment()) || (period.getTo().getMoment() < this.from.getMoment())
  }
  def getFrom() = from
  def getTo() = to
}
