package com.example.openrtbserver.model.constant

trait SourceRelationship extends Constant {
  final type Value = Int
}

object SourceRelationships extends Constants[SourceRelationship] {

  val values: List[SourceRelationship] =
    List(Indirect, Direct)

  case object Indirect extends SourceRelationship {
    def value: Int = 0
  }

  case object Direct extends SourceRelationship {
    def value: Int = 1
  }

}