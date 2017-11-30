package com.poe.parser.item.equipment

import com.poe.parser.knowninfo.KnownInfo

class Flask(
             knownInfo: KnownInfo
           ) extends Equipment(knownInfo) {
  override def height(): Int = 2
}
