package com.poe.parser.item.currency

import com.poe.parser.item.{Item, StackSize}
import com.poe.parser.knowninfo.KnownInfo

class Currency(
                knownInfo: KnownInfo
              ) extends Item(knownInfo) {
  val stackSize: Option[StackSize] = knownInfo.stackSize
}