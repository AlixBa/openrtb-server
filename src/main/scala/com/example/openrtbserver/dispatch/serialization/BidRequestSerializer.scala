package com.example.openrtbserver.dispatch.serialization

import com.example.openrtbserver.dispatch.DispatchError
import com.example.openrtbserver.model.bidrequest.BidRequest

import scalaz.\/

/**
 * Logic to serialize a BidRequest into a `A`.
 *
 * @tparam A type of the serialized BidRequest
 */
trait BidRequestSerializer[A] {

  /**
   * Logic to transform a BidRequest into a `A`.
   *
   * @param bidRequest the BidRequest to serialize
   * @return the serialized BidRequest or an error
   */
  def serialize(bidRequest: BidRequest): DispatchError \/ A

}