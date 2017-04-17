package com.poe.parser.item.equipment

import com.poe.parser.KnownInfo
import com.poe.parser.item.CraftableItem

class Equipment(
               knownInfo: KnownInfo
               ) extends CraftableItem(knownInfo) {

}

object Equipment {
  def getType(rarity: String, name: String): Option[String] = {

    None
  }
}
