package com.poe.parser.item.equipment.weapon

import com.poe.parser.knowninfo.KnownInfo

class Wand(
            knownInfo: KnownInfo
          ) extends Weapon(knownInfo) {

}

object Wand {
  val identifiers = Array(
    "Wand",
    "Horn"
  )
}
