package example3

trait Expr {
  def eval(): Option[Int]
}

case class Val(n: Int) extends Expr {
  override def eval(): Option[Int] = Some(n)
}

case class Div(x: Expr, y: Expr) extends Expr {
  override def eval(): Option[Int] = {
    x.eval() >>= (n =>
      y.eval() >>= (m =>
        safediv(n, m)))
  }

  implicit class OptionOps(m: Option[Int]) {
    def >>=(f: Int => Option[Int]) = {
      m match {
        case None => None
        case Some(x) => f(x)
      }
    }
  }

  private def safediv(n: Int, m: Int): Option[Int] = {
    if (m == 0) {
      None
    } else {
      Some(n / m)
    }
  }
}
