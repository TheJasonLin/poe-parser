package com.poe.parser.item.equipment.armour

import com.poe.parser.knowninfo.KnownInfo

class Glove(
             knownInfo: KnownInfo
           ) extends Armour(knownInfo) {
  override def height(): Int = 2
}

object Glove {
  val identifiers = Array(
    "Gauntlets",
    "Gloves",
    "Mitts"
  )
}
