package com.example.openrtbserver.model.constant

trait VideoStartDelay extends Constant {
  final type Value = Int
}

object VideoStartDelays extends Constants[VideoStartDelay] {

  val values: Seq[VideoStartDelay] =
    List(PreRoll, GenericMidRoll, GenericPostRoll)

  case object PreRoll extends VideoStartDelay {
    def value: Int = 0
  }

  case object GenericMidRoll extends VideoStartDelay {
    def value: Int = -1
  }

  case object GenericPostRoll extends VideoStartDelay {
    def value: Int = -2
  }

  /**
   * There is no upper bound for this constant.
   */
  case class MidRoll(value: Int) extends VideoStartDelay

  override def apply(value: Int): Option[VideoStartDelay] = {
    super.apply(value) match {
      case s @ Some(_)       ⇒ s
      case None if value > 0 ⇒ Option(MidRoll(value))
      case _                 ⇒ None
    }
  }
}