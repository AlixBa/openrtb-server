package com.example.openrtbserver

import com.wix.accord.{ GroupViolation, RuleViolation, Violation }

package object validation {

  /**
   * Enriches a set of Violation.
   *
   * @param violations the set to enrich
   */
  implicit class RichViolationSet(violations: Set[Violation]) {

    /**
     * Flattens all GroupViolation to a list of RuleViolation children.
     *
     * @return all RuleViolation children of the GroupViolation in param violations.
     */
    def flattenAsRuleViolation: List[RuleViolation] = {
      def flatten(violations: List[Violation]): List[RuleViolation] = {
        violations match {
          case Nil                         ⇒ List.empty
          case (a: RuleViolation) :: rest  ⇒ flatten(rest) ::: List(a)
          case (a: GroupViolation) :: rest ⇒ flatten(a.children.toList) ++ flatten(rest)
          case _                           ⇒ List.empty
        }
      }

      flatten(violations.toList)
    }

  }

}
