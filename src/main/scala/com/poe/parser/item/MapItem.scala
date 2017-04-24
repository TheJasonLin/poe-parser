package com.poe.parser.item

import com.poe.parser.KnownInfo

class MapItem(
               knownInfo: KnownInfo
             ) extends CraftableItem(knownInfo) {
  val tier: Int = knownInfo.mapTier.get

  override def toString: String = super.toString() + s"[Tier: $tier]"

  override def asDBItem: DBItem = {
    super.asDBItem.copy(
      mapTier = Option(tier)
    )
  }
}