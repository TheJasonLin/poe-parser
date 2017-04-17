package com.poe.parser.item.equipment.armour

import com.poe.parser.KnownInfo
import com.poe.parser.item.equipment.Equipment

class Armour(
              knownInfo: KnownInfo
            ) extends Equipment(knownInfo) {
  override def width(): Int = 2
}