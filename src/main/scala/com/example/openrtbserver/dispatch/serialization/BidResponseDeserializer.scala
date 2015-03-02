package com.example.openrtbserver.dispatch.serialization

import com.example.openrtbserver.dispatch.DispatchError
import com.example.openrtbserver.model.bidresponse.BidResponse

import scalaz.\/

/**
 * Logic to deserialize a BidResponse into a `B`.
 *
 * @tparam B type of the serialized BidResponse
 */
trait BidResponseDeserializer[B] {

  /**
   * Logic to transform a serialized BidResponse into a `B`.
   *
   * @param serialized the serialized BidResponse
   * @return the deserialized BidResponse or an error
   */
  def deserialize(serialized: B): DispatchError \/ BidResponse

}