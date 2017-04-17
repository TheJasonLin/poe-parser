package com.poe.parser.item.equipment.armour

import com.poe.parser.KnownInfo

class Shield(
              knownInfo: KnownInfo
            ) extends Armour(knownInfo) {
  override def height(): Int = 3
}

object Shield {
  val identifiers = Array(
    "Shield",
    "Buckler",
    "Bundle"
  )
}
