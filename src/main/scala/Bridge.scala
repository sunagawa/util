class Bridge {
  trait DrawingAPI {
    def drawCircle(x: Double, y: Double, radius: Double)
  }

  class DrawingAPI1 extends DrawingAPI {
    def drawCircle(x: Double, y: Double, radius: Double) = println(s"API #1 $x $y $radius")
  }

  class DrawingAPI2 extends DrawingAPI {
    def drawCircle(x: Double, y: Double, radius: Double) = println(s"API #2 $x $y $radius")
  }

  abstract class Shape(drawingAPI: DrawingAPI) {
    def draw()
    def resizePercentage(pct: Double)
  }

  class CircleShape(x: Double, y: Double, var radius: Double, drawingAPI: DrawingAPI)
    extends Shape(drawingAPI: DrawingAPI) {

    def draw() = drawingAPI.drawCircle(x, y, radius)

    def resizePercentage(pct: Double) { radius *= pct }
  }
}
