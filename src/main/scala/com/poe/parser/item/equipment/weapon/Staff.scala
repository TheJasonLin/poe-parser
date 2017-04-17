package com.poe.parser.item.equipment.weapon

import com.poe.parser.KnownInfo

class Staff(
             knownInfo: KnownInfo
           ) extends Weapon(knownInfo) {
  override def height(): Int = 4

  override def width(): Int = 2
}

object Staff {
  val identifiers = Array(
    "Branch",
    "Staff",
    "Quarterstaff",
    "Lathi"
  )
}
