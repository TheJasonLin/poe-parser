package com.poe.parser.item.currency

import com.poe.parser.knowninfo.KnownInfo

object CurrencyFactory {
  def create(knownInfo: KnownInfo): Option[Currency] = {
    if(knownInfo.typeLine.contains("Essence")) {
      return Option(new Essence(knownInfo))
    }

    val basicCurrencyIndex = BasicCurrency.identifiers.indexOf(knownInfo.typeLine)
    if(basicCurrencyIndex >= 0) {
      return Option(new BasicCurrency(knownInfo))
    }

    None
  }
}
