package com.poe.parser.item.equipment.weapon

import com.poe.parser.item.equipment.Equipment
import com.poe.parser.knowninfo.KnownInfo

class Weapon(
              knownInfo: KnownInfo
            ) extends Equipment(knownInfo) {

  override def height(): Int = 3
}
