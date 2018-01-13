package example1

trait Expr {
  def eval(): Int
}

case class Val(n: Int) extends Expr {
  override def eval(): Int = n
}

case class Div(x: Expr, y: Expr) extends Expr {
  override def eval(): Int = x.eval() / y.eval()
}
