package com.example.openrtbserver

import com.wix.accord.{ Failure, Result, RuleViolation, Success }

import scalaz.Scalaz._

package object validation {

  type IntOption = Option[Int]
  type FloatOption = Option[Float]
  type ValidationValue = Any
  type Name = String
  type Constraint = String
  type Description = Option[String]

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
   * @param condition the condition to test
   * @param value The value of the object which failed the validation rule
   * @param constraint A textual description of the constraint being violated
   * @param description The textual description of the object under validation
   * @return success or failure
   */
  def validate(condition: Boolean, value: ValidationValue,
               constraint: Constraint, description: Description): Result =
    condition.fold(Success, Failure(Set(new RuleViolation(value, constraint, description))))

  /**
   * Validates an Option to be undefined or positive.
   * This is widely used into the BidRequest and the BidResponse
   * models.
   *
   * @param opt the Option to validate
   * @param name the name of the option (property)
   * @return success or failure
   */
  def validateEmptyOrPositive[A](opt: Option[A], name: Name, `-1`: A)(implicit ev: A ⇒ Ordered[A]): Result =
    validate(opt.isEmptyOrGreaterThan(`-1`), opt, "expected positive.", Option(name))

  def validateEmptyOrPositiveInt(opt: IntOption, name: Name): Result =
    validateEmptyOrPositive(opt, name, -1)

  def validateEmptyOrPositiveFloat(opt: FloatOption, name: Name): Result =
    validateEmptyOrPositive(opt, name, -1F)

}