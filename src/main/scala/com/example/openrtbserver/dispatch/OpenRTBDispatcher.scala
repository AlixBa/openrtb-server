package com.example.openrtbserver.dispatch

import com.example.openrtbserver.model.bidrequest.BidRequest
import com.example.openrtbserver.model.bidresponse.BidResponse

import scalaz.\/

/**
 * The RTBDispatcher object takes care of dispatching a BidRequest
 * to an OpenRTB client.
 */
object OpenRTBDispatcher {

  /**
   * Dispatches a BidRequest to an OpenRTB client.
   *
   * @tparam A type of the serialized BidRequest
   * @tparam B type of the serialized BidResponse
   *
   * @param bidRequest the BidRequest to send
   * @param client the OpenRTB client to communicate with
   * @return the deserialized BidResponse (if any)
   */
  def dispatch[A, B](bidRequest: BidRequest, client: OpenRTBClient[A, B]): DispatchError \/ BidResponse = {
    client
      .serialize(bidRequest)
      .flatMap(client.send)
      .flatMap(client.deserialize)
  }

}