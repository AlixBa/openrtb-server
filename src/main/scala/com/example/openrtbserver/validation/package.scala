package com.example.openrtbserver

import com.wix.accord.{ Failure, Result, RuleViolation, Success }

import scalaz.Scalaz._

package object validation {

  type ContextObject = Any

  /**
   * Enriches Option[A] type.
   *
   * @param opt the Option[A] to enrich
   */
  implicit class RichOption[A](opt: Option[A]) {

    def isEmptyOrGreaterThan(v: A)(implicit ev: A ⇒ Ordered[A]): Boolean =
      opt.fold(true)(_ > v)

    def isEmptyOrLowerThan(v: A)(implicit ev: A ⇒ Ordered[A]): Boolean =
      opt.fold(true)(_ > v)

  }

  /**
   * Common use case in validation.
   *
   * @param o an object to pass as context
   * @param condition the condition to test
   * @param constraint the constraint related to the condition
   * @return success or failure
   */
  def validate(o: ContextObject, condition: Boolean, constraint: String): Result =
    condition.fold(Success, Failure(Set(new RuleViolation(o, constraint, None))))

  /**
   * Validates an Option to be undefined or positive.
   * This is widely used into the BidRequest and the BidResponse
   * models.
   *
   * @param o an object to pass as context
   * @param opt the Option to validate
   * @param name the name of the option (property)
   * @return success or failure
   */
  def validateEmptyOrPositive[A](
    o:     ContextObject,
    opt:   Option[A],
    name:  String,
    value: A
  )(implicit ev: A ⇒ Ordered[A]): Result = {
    val constraint: String = s"$name should be positive."
    validate(o, opt.isEmptyOrGreaterThan(value), constraint)
  }

  def validateEmptyOrPositiveInt(o: ContextObject, opt: Option[Int], name: String): Result =
    validateEmptyOrPositive(o, opt, name, -1)

  def validateEmptyOrPositiveFloat(o: ContextObject, opt: Option[Float], name: String): Result =
    validateEmptyOrPositive(o, opt, name, -1F)

}