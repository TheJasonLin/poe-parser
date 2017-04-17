package com.poe.parser.item

import com.poe.parser.KnownInfo

/**
  * All Gems by default have itemLevel 1
  * All Gems by default are identified
  */
class Gem(
         knownInfo: KnownInfo
         ) extends CraftableItem(knownInfo) {

}