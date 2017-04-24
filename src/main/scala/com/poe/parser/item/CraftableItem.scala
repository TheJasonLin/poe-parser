package com.poe.parser.item

import com.poe.parser.KnownInfo

abstract class CraftableItem(
                            knownInfo: KnownInfo
                   ) extends Item(knownInfo) {
  val itemLevel: Int = knownInfo.itemLevel.get
  val identified: Boolean = knownInfo.identified.get
  val quality: Option[Int] = knownInfo.quality

  def parseMods(modStrings: Seq[String]): Seq[Mod] = {
    modStrings.map((modString: String) => {
      Mod.parse(modString)
    })
  }

  val implicits: Seq[Mod] = if(knownInfo.implicits.isDefined) parseMods(knownInfo.implicits.get) else Seq.empty[Mod]
  val explicits: Seq[Mod] = if(knownInfo.explicits.isDefined) parseMods(knownInfo.explicits.get) else Seq.empty[Mod]

  override def toString: String = super.toString() + s"[ilvl: $itemLevel, id: $identified, quality: $quality]"
}
