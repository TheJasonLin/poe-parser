package com.poe.parser.item.equipment.armour

import com.poe.parser.item.equipment.Equipment
import com.poe.parser.knowninfo.KnownInfo

class Armour(
              knownInfo: KnownInfo
            ) extends Equipment(knownInfo) {
  override def width(): Int = 2
}