package com.example.openrtbserver.model.constant

trait NoBidCode extends Constant {
  final type Value = Int
}

object NoBidCodes extends Constants[NoBidCode] {

  val values: Seq[NoBidCode] =
    List(UnknownError, TechnicalError, InvalidRequest, KnownWebSpider, SuspectedNonHuman,
      CloudOrDataCenterOrProxy, UnsupportedDevice, BlockedPublisherOrSite, UnmatchedUser)

  case object UnknownError extends NoBidCode {
    def value: Int = 0
  }

  case object TechnicalError extends NoBidCode {
    def value: Int = 1
  }

  case object InvalidRequest extends NoBidCode {
    def value: Int = 2
  }

  case object KnownWebSpider extends NoBidCode {
    def value: Int = 3
  }

  case object SuspectedNonHuman extends NoBidCode {
    def value: Int = 4
  }

  case object CloudOrDataCenterOrProxy extends NoBidCode {
    def value: Int = 5
  }

  case object UnsupportedDevice extends NoBidCode {
    def value: Int = 6
  }

  case object BlockedPublisherOrSite extends NoBidCode {
    def value: Int = 7
  }

  case object UnmatchedUser extends NoBidCode {
    def value: Int = 8
  }

}