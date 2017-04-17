package com.poe.parser.item.currency

import com.poe.parser.KnownInfo

object CurrencyFactory {
  def create(knownInfo: KnownInfo): Option[Currency] = {
    if(knownInfo.base.contains("Essence")) {
      return Option(new Essence(knownInfo))
    }

    val basicCurrencyIndex = BasicCurrency.identifiers.indexOf(knownInfo.base)
    if(basicCurrencyIndex >= 0) {
      return Option(new BasicCurrency(knownInfo))
    }

    None
  }
}
