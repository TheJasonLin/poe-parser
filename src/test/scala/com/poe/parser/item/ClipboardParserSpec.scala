package com.poe.parser.item

import com.poe.parser.{ClipboardParser, KnownInfo}
import org.scalatest.{FlatSpec, Matchers}

class ClipboardParserSpec extends FlatSpec with Matchers {
  "parseKnownInfo" should "parse normal map" in {
    val clipboard: String = "Rarity: Normal\nArid Lake Map\n--------\nMap Tier: 3\n--------\nItem Level: 78\n--------\nTravel to this Map by using it in the Templar Laboratory or a personal Map Device. Maps can only be used once."

    val knownInfoOption: Option[KnownInfo] = ClipboardParser.parseKnownInfo(clipboard)
    assert(knownInfoOption.isDefined)
    val knownInfo = knownInfoOption.get
    assert(knownInfo.name == Option("Arid Lake"))
    assert(knownInfo.itemLevel == Option(78))
    assert(knownInfo.identified == Option(true))
    assert(knownInfo.quality == Option(0))
    assert(knownInfo.mapTier == Option(3))
    assert(knownInfo.talismanTier.isEmpty)
    assert(knownInfo.implicits.isEmpty)
    assert(knownInfo.explicits.isEmpty)
    assert(knownInfo.ownerInfo.isEmpty)
  }
}
