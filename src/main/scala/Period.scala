class Period[T<:Moment](from: T, to: T) {
  def isOverwrapped(period: Period[T]): Boolean = {
    !isMutuallyExclusive(period)
  }
  def isMutuallyExclusive(period: Period[T]): Boolean = {
    (this.to.getMoment() < period.getFrom().getMoment()) || (period.getTo().getMoment() < this.from.getMoment())
  }
  def getFrom() = from
  def getTo() = to
}
