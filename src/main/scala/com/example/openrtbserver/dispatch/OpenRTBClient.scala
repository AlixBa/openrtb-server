package com.example.openrtbserver.dispatch

import com.example.openrtbserver.dispatch.serialization.{ BidRequestSerializer, BidResponseDeserializer }

import scalaz.\/

/**
 * Describes an OpenRTBClient.
 *
 * @tparam A type of the serialized BidRequest
 * @tparam B type of the serialized BidResponse
 */
trait OpenRTBClient[A, B] extends BidRequestSerializer[A] with BidResponseDeserializer[B] {

  /**
   * Sends a serialized BidRequest to the OpenRTB client.
   *
   * @param serialized the serialized BidRequest
   * @return the serialized BidResponse or an error
   */
  def send(serialized: A): DispatchError \/ B

}

/**
 * A common trait for all HTTP OpenRTB clients.
 *
 * @tparam A type of the serialized BidRequest
 * @tparam B type of the serialized BidResponse
 */
trait HTTPOpenRTBClient[A, B] extends OpenRTBClient[A, B] {

  /**
   * @return the HTTP method to use
   */
  def method: HttpMethod

  /**
   * @return the endpoint to query
   */
  def endpoint: HttpEndpoint

}

/**
 * A trait for Json over HTTP OpenRTB clients.
 */
trait JsonHTTPOpenRTBClient extends HTTPOpenRTBClient[JsonString, JsonString]