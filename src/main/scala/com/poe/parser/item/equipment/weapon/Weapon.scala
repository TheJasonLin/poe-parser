package com.poe.parser.item.equipment.weapon

import com.poe.parser.KnownInfo
import com.poe.parser.item.equipment.Equipment

class Weapon(
              knownInfo: KnownInfo
            ) extends Equipment(knownInfo) {

  override def height(): Int = 3
}
