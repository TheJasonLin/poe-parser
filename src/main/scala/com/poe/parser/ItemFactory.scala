package com.poe.parser

import com.poe.constants.Rarity
import com.poe.parser.item._
import com.poe.parser.item.currency.CurrencyFactory
import com.poe.parser.item.equipment.EquipmentFactory
import com.poe.parser.item.equipment.accessory.Talisman

object ItemFactory {
  def create(knownInfo: KnownInfo): Item = {
    implicit
    val typeLineWords = knownInfo.typeLine.split(' ')
    if (knownInfo.rarity == Rarity.GEM) {
      return new Gem(knownInfo)
    } else if (knownInfo.rarity == Rarity.DIVINATION_CARD) {
      return new DivinationCard(knownInfo)
    } else if (knownInfo.mapTier.isDefined) {
        return new MapItem(knownInfo)
    } else if (knownInfo.talismanTier.isDefined) {
      return new Talisman(knownInfo)
    } else if (typeLineWords.contains("Leaguestone")) {
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

  def create(clipboard: String): Item = {
    val knownInfo: Option[KnownInfo] = ClipboardParser.parseKnownInfo(clipboard)
    if (knownInfo.isEmpty) {
      throw new IllegalArgumentException("couldn't parse KnownInfo from clipboard: " + clipboard)
    }
    create(knownInfo.get)
  }
}
