package com.poe.parser

import com.poe.constants.Rarity
import com.poe.parser.item._
import com.poe.parser.item.currency.CurrencyFactory
import com.poe.parser.item.equipment.EquipmentFactory

object ItemFactory {
  def create(knownInfo: KnownInfo): Item = {
    implicit
    val baseWords = knownInfo.base.split(' ')
    if (knownInfo.rarity == Rarity.GEM && knownInfo.quality.isDefined) {
      return new Gem(knownInfo)
    } else if (knownInfo.rarity == Rarity.DIVINATION_CARD) {
      return new DivinationCard(knownInfo)
    } else if (knownInfo.mapTier.isDefined) {
        return new MapItem(knownInfo)
    } else if (baseWords.contains("Leaguestone")) {
      return new Leaguestone(knownInfo)
    }
    var itemOption: Option[Item] = None

    itemOption = CurrencyFactory.create(knownInfo)
    if(itemOption.isDefined) return itemOption.get

    // All com.poe.parser.item.equipment.Equipment has itemLevel
    if(knownInfo.itemLevel.isDefined) {
      itemOption = EquipmentFactory.create(knownInfo)
      if(itemOption.isDefined) return itemOption.get
    }

    new UnknownItem(knownInfo)
  }
}
