package com.poe.parser.item.equipment.armour

import com.poe.parser.item.Item
import com.poe.parser.item.equipment.Equipment
import com.poe.parser.knowninfo.KnownInfo

object ArmourFactory {
  def create(knownInfo: KnownInfo): Option[Equipment] = {
    val typeLine = knownInfo.typeLine
    if(Item.matchesIdentifier(typeLine, Helmet.identifiers)) {
      return Option(new Helmet(knownInfo))
    }

    if(Item.matchesIdentifier(typeLine, Boot.identifiers)) {
      return Option(new Boot(knownInfo))
    }

    if(Item.matchesIdentifier(typeLine, Glove.identifiers)) {
      return Option(new Glove(knownInfo))
    }

    if(Item.matchesIdentifier(typeLine, Shield.identifiers)) {
      return Option(new Shield(knownInfo))
    }

    if(Item.matchesIdentifier(typeLine, BodyArmour.identifiers) || BodyArmour.baseNames.contains(typeLine)) {
      return Option(new BodyArmour(knownInfo))
    }

    None
  }
}
