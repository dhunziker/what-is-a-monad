# what-is-a-monad

Scala implementation of [What is a Monad? - Computerphile](https://www.youtube.com/watch?v=t1e8gqXLbsU).

In this quick tutorial the author shows how to evaluate basic expressions (values and divisions), what the potential problems are and how the `Maybe` monad (`Option` in Scala) can help to solve them.

* Example 1: 
  * Fails for division by zero
* Example 2:
  * Introduction of `Option`
* Example 3:
  * Introduction of the `>>=` operator (essentially `Option.flatMap`)
* Example 4:
  * Simplification using `for` comprehension