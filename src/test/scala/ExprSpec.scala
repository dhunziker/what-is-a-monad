import org.scalatest.{FreeSpec, MustMatchers}

class ExprSpec extends FreeSpec with MustMatchers {

  "Example 1" - {
    import example1._

    "should eval val" in {
      Val(1).eval must be(1)
    }

    "should eval div" in {
      Div(Val(6), Val(2)).eval() must be(3)
    }

    "should eval nested expr" in {
      Div(Val(6), Div(Val(3), Val(1))).eval() must be(2)
    }

    "should fail on div by zero" in {
      an[ArithmeticException] must be thrownBy {
        Div(Val(6), Val(0)).eval()
      }
    }
  }

  "Example 2" - {
    import example2._

    "should eval val" in {
      Val(1).eval must be(Some(1))
    }

    "should eval div" in {
      Div(Val(6), Val(2)).eval() must be(Some(3))
    }

    "should eval nested expr" in {
      Div(Val(6), Div(Val(3), Val(1))).eval() must be(Some(2))
    }

    "should not fail on div by zero" in {
      Div(Val(6), Val(0)).eval() must be(None)
    }
  }

  "Example 3" - {
    import example3._

    "should eval val" in {
      Val(1).eval must be(Some(1))
    }

    "should eval div" in {
      Div(Val(6), Val(2)).eval() must be(Some(3))
    }

    "should eval nested expr" in {
      Div(Val(6), Div(Val(3), Val(1))).eval() must be(Some(2))
    }

    "should not fail on div by zero" in {
      Div(Val(6), Val(0)).eval() must be(None)
    }
  }

  "Example 4" - {
    import example4._

    "should eval val" in {
      Val(1).eval must be(Some(1))
    }

    "should eval div" in {
      Div(Val(6), Val(2)).eval() must be(Some(3))
    }

    "should eval nested expr" in {
      Div(Val(6), Div(Val(3), Val(1))).eval() must be(Some(2))
    }

    "should not fail on div by zero" in {
      Div(Val(6), Val(0)).eval() must be(None)
    }
  }
}
