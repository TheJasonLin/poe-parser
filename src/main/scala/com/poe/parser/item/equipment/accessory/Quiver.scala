package com.poe.parser.item.equipment.accessory

import com.poe.parser.KnownInfo

class Quiver(
              knownInfo: KnownInfo
            ) extends Accessory(knownInfo) {
  override def width(): Int = 2
  override def height(): Int = 3
}
