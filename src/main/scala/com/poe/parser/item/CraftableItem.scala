package com.poe.parser.item

import com.poe.parser.KnownInfo

abstract class CraftableItem(
                            knownInfo: KnownInfo
                   ) extends Item(knownInfo) {
  val itemLevel: Int = knownInfo.itemLevel.get
  val identified: Boolean = knownInfo.identified.get
  val quality: Option[Int] = knownInfo.quality

  def parseMods(modStrings: Set[String]): Set[Mod] = {
    modStrings.map((modString: String) => {
      Mod.parse(modString)
    })
  }

  val implicits: Set[Mod] = if(knownInfo.implicits.isDefined) parseMods(knownInfo.implicits.get) else Set.empty[Mod]
  val explicits: Set[Mod] = if(knownInfo.explicits.isDefined) parseMods(knownInfo.explicits.get) else Set.empty[Mod]

  override def toString: String = super.toString() + s"[ilvl: $itemLevel, id: $identified, quality: $quality]"
}
