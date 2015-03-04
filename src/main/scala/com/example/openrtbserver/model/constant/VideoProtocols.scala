package com.example.openrtbserver.model.constant

trait VideoProtocol extends Constant {
  final type Value = Int
}

object VideoProtocols extends Constants[VideoProtocol] {

  val values: Seq[VideoProtocol] =
    List(VAST1, VAST2, VAST3, VAST1Wrapper, VAST2Wrapper, VAST3Wrapper)

  case object VAST1 extends VideoProtocol {
    def value: Int = 1
  }

  case object VAST2 extends VideoProtocol {
    def value: Int = 2
  }

  case object VAST3 extends VideoProtocol {
    def value: Int = 3
  }

  case object VAST1Wrapper extends VideoProtocol {
    def value: Int = 4
  }

  case object VAST2Wrapper extends VideoProtocol {
    def value: Int = 5
  }

  case object VAST3Wrapper extends VideoProtocol {
    def value: Int = 6
  }

}