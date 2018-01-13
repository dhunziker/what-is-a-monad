package example2

trait Expr {
  def eval(): Option[Int]
}

case class Val(n: Int) extends Expr {
  override def eval(): Option[Int] = Some(n)
}

case class Div(x: Expr, y: Expr) extends Expr {
  override def eval(): Option[Int] = {
    x.eval() match {
      case None => None
      case Some(n) => y.eval() match {
        case None => None
        case Some(m) => safediv(n, m)
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
