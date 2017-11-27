package com.poe.parser.item.equipment.armour

import com.poe.parser.KnownInfo
import com.poe.parser.item.Item
import com.poe.parser.item.equipment.Equipment

object ArmourFactory {
  def create(knownInfo: KnownInfo): Option[Equipment] = {
    val base = knownInfo.typeLine
    if(Item.matchesIdentifier(base, Helmet.identifiers)) {
      return Option(new Helmet(knownInfo))
    }

    if(Item.matchesIdentifier(base, Boot.identifiers)) {
      return Option(new Boot(knownInfo))
    }

    if(Item.matchesIdentifier(base, Glove.identifiers)) {
      return Option(new Glove(knownInfo))
    }

    if(Item.matchesIdentifier(base, Shield.identifiers)) {
      return Option(new Helmet(knownInfo))
    }

    if(Item.matchesIdentifier(base, BodyArmour.identifiers) || BodyArmour.baseNames.contains(base)) {
      return Option(new BodyArmour(knownInfo))
    }

    None
  }
}
