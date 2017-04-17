package com.poe.parser.item.equipment.accessory

import com.poe.parser.KnownInfo

class Talisman(
              knownInfo: KnownInfo
              ) extends Amulet(knownInfo) {
  val talismanTier: Int = knownInfo.talismanTier.get
  override def toString: String = super.toString + s"[talismanTier: $talismanTier]"
}
