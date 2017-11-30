package com.poe.parser.item.equipment.armour

import com.poe.parser.knowninfo.KnownInfo

class Boot(
            knownInfo: KnownInfo
          ) extends Armour(knownInfo) {
  override def height(): Int = 2
}

object Boot {
  val identifiers = Array(
    "Greaves",
    "Boots",
    "Shoes",
    "Slippers"
  )
}
