package com.example.openrtbserver.model

package object constant {

  /**
   * Simulates mapping between a value and a class.
   */
  trait Constant extends Product with Serializable {

    type Value

    /**
     * @return the underlying value of the constant
     */
    def value: Value

  }

  /**
   * @tparam A type of the constant
   */
  trait Constants[A <: Constant] {

    /**
     * @return all possible values
     */
    def values: Seq[A]

    /**
     * @param value the underlying value to find
     * @return the matching constant
     */
    def apply(value: A#Value): Option[A] =
      values.find(v ⇒ v.value == value)

  }

}
