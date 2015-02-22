package com.example.openrtbserver

import com.wix.accord.{Failure, Result, RuleViolation, Success}

import scalaz.Scalaz._

package object validation {

  /**
   * Enriches Option[A] type.
   *
   * @param xOpt the Option[A] to enrich
   */
  implicit class RichOption[A](xOpt: Option[A])(implicit ev: A => Ordered[A]) {

    def isEmptyOrGreaterThan(v: A): Boolean =
      xOpt.fold(true)(_ > v)

    def isEmptyOrLowerThan(v: A): Boolean =
      xOpt.fold(true)(_ < v)

  }

  /**
   * Common use case in validation.
   *
   * @param o an object to pass as context
   * @param condition the condition to test
   * @param constraint the constraint related to the condition
   * @return success or failure
   */
  def validate(o: Any, condition: Boolean, constraint: String): Result =
    condition.fold(Success, Failure(Set(new RuleViolation(o, constraint, None))))

  /**
   * Validates an Option[A] to be undefined or positive.
   * This is widely used into the BidRequest and the BidResponse
   * models.
   *
   * @tparam A ordered type
   * @param o an object to pass as context
   * @param xOpt the Option to validate
   * @param name the name of the option (property)
   * @return success or failure
   */
  def validateEmptyOrPositive[A](o: Any, xOpt: Option[A], name: String)(implicit ev: A => Ordered[A]): Result = {
    val `-1`: A = (-1).asInstanceOf[A]
    val constraint: String = s"$name should be positive."

    validate(o, xOpt.isEmptyOrGreaterThan(`-1`), constraint)
  }

}