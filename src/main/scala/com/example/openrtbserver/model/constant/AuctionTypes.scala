package com.example.openrtbserver.model.constant

trait AuctionType extends Constant {
  final type Value = Int
}

object AuctionTypes extends Constants[AuctionType] {

  val values: List[AuctionType] =
    List(FirstPrice, SecondPricePlus, FixedDealPrice)

  case object FirstPrice extends AuctionType {
    def value: Int = 1
  }

  case object SecondPricePlus extends AuctionType {
    def value: Int = 2
  }

  case object FixedDealPrice extends AuctionType {
    def value: Int = 3
  }

}
