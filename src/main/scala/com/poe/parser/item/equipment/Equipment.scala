package com.poe.parser.item.equipment

import com.poe.parser.item.CraftableItem
import com.poe.parser.knowninfo.KnownInfo

class Equipment(
               knownInfo: KnownInfo
               ) extends CraftableItem(knownInfo) {

}

object Equipment {
  def getType(rarity: String, name: String): Option[String] = {

    None
  }
}
