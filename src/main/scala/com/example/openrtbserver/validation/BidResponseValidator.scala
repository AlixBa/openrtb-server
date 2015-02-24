package com.example.openrtbserver.validation

import com.example.openrtbserver.model.bidresponse.{ Bid, BidResponse, SeatBid }
import com.example.openrtbserver.validation.bidresponse.BidValidators
import com.wix.accord.Validator

/**
 * Trait for all the validations done on a
 * BidResponse level.
 */
trait BidResponseValidator {

  def bidResponseValidators: List[Validator[BidResponse]] = List()

  def seatBidValidators: List[Validator[SeatBid]] = List()

  def bidValidators: List[Validator[Bid]] =
    List(BidValidators.`price`, BidValidators.Size)

}