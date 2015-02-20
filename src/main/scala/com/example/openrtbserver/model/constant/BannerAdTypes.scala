package com.example.openrtbserver.model.constant

trait BannerAdType extends Constant {
  final type Value = Int
}

object BannerAdTypes extends Constants[BannerAdType] {

  val values: List[BannerAdType] =
    List(XHTMLTextAd, XHTMLBannerAd, JavaScriptAd, Iframe)

  case object XHTMLTextAd extends BannerAdType {
    def value: Int = 1
  }

  case object XHTMLBannerAd extends BannerAdType {
    def value: Int = 2
  }

  case object JavaScriptAd extends BannerAdType {
    def value: Int = 3
  }

  case object Iframe extends BannerAdType {
    def value: Int = 4
  }

}
