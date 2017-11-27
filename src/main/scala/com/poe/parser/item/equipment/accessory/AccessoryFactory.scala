package com.poe.parser.item.equipment.accessory

import com.poe.parser.KnownInfo

object AccessoryFactory {
  def create(knownInfo: KnownInfo): Option[Accessory] = {
    val baseWords: Seq[String] = knownInfo.typeLine.split(' ')
    if (baseWords.contains("Amulet")) {
      return Option(new Amulet(knownInfo))
    } else if(baseWords.contains("Talisman")) {
      return Option(new Talisman(knownInfo))
    } else if (baseWords.contains("Ring")) {
      return Option(new Ring(knownInfo))
    } else if (baseWords.contains("Belt") || baseWords.contains("Sash")) {
      return Option(new Belt(knownInfo))
    } else if (baseWords.contains("Quiver")) {
      return Option(new Quiver(knownInfo))
    }
    None
  }
}
