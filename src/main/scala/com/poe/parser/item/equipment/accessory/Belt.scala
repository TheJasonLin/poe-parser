package com.poe.parser.item.equipment.accessory

import com.poe.parser.knowninfo.KnownInfo

class Belt(
            knownInfo: KnownInfo
          ) extends Accessory(knownInfo: KnownInfo) {
  override def width(): Int = 2
}