package com.example.openrtbserver.dispatch

import com.example.openrtbserver.dispatch.serialization.{ BidRequestSerializer, BidResponseDeserializer }
import com.example.openrtbserver.model.bidrequest.BidRequest
import com.example.openrtbserver.model.bidresponse.BidResponse
import org.scalatest.WordSpec

import scalaz.{ -\/, \/, \/- }

class OpenRTBDispatcherSpec extends WordSpec {

  import com.example.openrtbserver.dispatch.Fixtures._

  "dispatch" should {

    "return an error if the serializer returns an error" in {
      val client = new Client with LeftSerializer with RightDeserializer
      val bidResponseOrError: \/[DispatchError, BidResponse] = OpenRTBDispatcher.dispatch(null, client)

      assert(bidResponseOrError.isLeft)
    }

    "return an error if the broker returns an error" in {
      val client =
        new OpenRTBClient[String, String] with LeftSerializer with RightDeserializer {
          def send(serialized: String): DispatchError \/ String = -\/(new DispatchError {})
        }
      val bidResponseOrError: \/[DispatchError, BidResponse] = OpenRTBDispatcher.dispatch(null, client)

      assert(bidResponseOrError.isLeft)
    }

    "return an error if the deserializer returns an error" in {
      val client = new Client with RightSerializer with LeftDeserializer
      val bidResponseOrError: \/[DispatchError, BidResponse] = OpenRTBDispatcher.dispatch(null, client)

      assert(bidResponseOrError.isLeft)
    }

    "return a BidResponse if everything is ok" in {
      val client = new Client with RightSerializer with RightDeserializer
      val bidResponseOrError: \/[DispatchError, BidResponse] = OpenRTBDispatcher.dispatch(null, client)

      assert(bidResponseOrError.isRight)
    }

  }

}

object Fixtures {

  trait LeftSerializer extends BidRequestSerializer[JsonString] {
    def serialize(bidRequest: BidRequest): DispatchError \/ JsonString = -\/(new DispatchError {})
  }

  trait RightSerializer extends BidRequestSerializer[JsonString] {
    def serialize(bidRequest: BidRequest): DispatchError \/ JsonString =
      \/-("SerializedBidRequest")
  }

  trait LeftDeserializer extends BidResponseDeserializer[JsonString] {
    def deserialize(serialized: JsonString): DispatchError \/ BidResponse =
      -\/(new DispatchError {})
  }

  trait RightDeserializer extends BidResponseDeserializer[JsonString] {
    def deserialize(serialized: JsonString): DispatchError \/ BidResponse =
      \/-(null)
  }

  trait Client extends JsonHTTPOpenRTBClient {
    def endpoint: HttpEndpoint = ""

    def method: HttpEndpoint = ""

    def send(serialized: JsonString): DispatchError \/ JsonString = \/-(serialized)
  }

}