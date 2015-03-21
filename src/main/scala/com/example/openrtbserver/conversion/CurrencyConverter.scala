package com.example.openrtbserver.conversion

import com.example.openrtbserver.model.types._

/**
 * Trait used to convert price between currencies
 */
trait CurrencyConverter {

  /**
   * Converts the price from [fromCurrency] to [toCurrency].
   */
  def convert(price: BidPrice, from: Currency, to: Currency): BidPrice

}
