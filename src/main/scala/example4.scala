package example4

trait Expr {
  def eval(): Option[Int]
}

case class Val(n: Int) extends Expr {
  override def eval(): Option[Int] = Some(n)
}

case class Div(x: Expr, y: Expr) extends Expr {
  override def eval(): Option[Int] = {
    for {
      n <- x.eval()
      m <- y.eval()
      result <- safediv(n, m)
    } yield result
  }

  private def safediv(n: Int, m: Int): Option[Int] = {
    if (m == 0) {
      None
    } else {
      Some(n / m)
    }
  }
}
