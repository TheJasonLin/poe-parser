package com.poe.parser

import com.poe.constants.Rarity
import com.poe.parser.knowninfo.{KnownInfo, MapInfo}
import org.scalatest.{FlatSpec, Matchers}

class ClipboardParserSpec extends FlatSpec with Matchers {
  "parseKnownInfo" should "parse normal map" in {
    val clipboard: String = "Rarity: Normal\nArid Lake Map\n--------\nMap Tier: 3\n--------\nItem Level: 78\n--------\nTravel to this Map by using it in the Templar Laboratory or a personal Map Device. Maps can only be used once."

    val knownInfoOption: Option[KnownInfo] = ClipboardParser.parseKnownInfo(clipboard)
    assert(knownInfoOption.isDefined)
    val knownInfo = knownInfoOption.get

    assert(knownInfo.rarity == Rarity.NORMAL)
    assert(knownInfo.typeLine == "Arid Lake Map")
    assert(knownInfo.name.isEmpty)
    assert(knownInfo.itemLevel.contains(78))
    assert(knownInfo.identified.contains(true))
    assert(knownInfo.quality.isEmpty)
    val expectedMapInfo = MapInfo(3, 0, 0, 0)
    assert(knownInfo.mapInfo.contains(expectedMapInfo))
    assert(knownInfo.talismanTier.isEmpty)
    assert(knownInfo.implicits.isEmpty)
    assert(knownInfo.explicits.isEmpty)
    assert(knownInfo.ownerInfo.isEmpty)
    assert(!knownInfo.corrupted)
  }

  "parseKnownInfo" should "parse magic map" in {
    val clipboard: String = "Rarity: Magic\nMirrored Factory Map of Impotence\n--------\nMap Tier: 2\nItem Quantity: +28% (augmented)\nItem Rarity: +14% (augmented)\nMonster Pack Size: +10% (augmented)\n--------\nItem Level: 69\n--------\nMonsters reflect 13% of Elemental Damage\nPlayers have 15% less Area of Effect\n--------\nTravel to this Map by using it in the Templar Laboratory or a personal Map Device. Maps can only be used once."

    val knownInfoOption: Option[KnownInfo] = ClipboardParser.parseKnownInfo(clipboard)
    assert(knownInfoOption.isDefined)
    val knownInfo = knownInfoOption.get

    val expectedExplicits: Option[Seq[String]] = Option(Array(
      "Monsters reflect 13% of Elemental Damage",
      "Players have 15% less Area of Effect"
    ))

    assert(knownInfo.rarity == Rarity.MAGIC)
    assert(knownInfo.typeLine == "Mirrored Factory Map of Impotence")
    assert(knownInfo.name.isEmpty)
    assert(knownInfo.itemLevel.contains(69))
    assert(knownInfo.identified.contains(true))
    assert(knownInfo.quality.isEmpty)
    val expectedMapInfo = MapInfo(2, 28, 14, 10)
    assert(knownInfo.mapInfo.contains(expectedMapInfo))
    assert(knownInfo.talismanTier.isEmpty)
    assert(knownInfo.implicits.isEmpty)
    assert(knownInfo.explicits == expectedExplicits)
    assert(knownInfo.ownerInfo.isEmpty)
    assert(!knownInfo.corrupted)
  }

  "parseKnownInfo" should "parse rare map" in {
    val clipboard: String = "Rarity: Rare\nGrim Waste\nShaped Dunes Map\n--------\nMap Tier: 10\nItem Quantity: +75% (augmented)\nItem Rarity: +36% (augmented)\nMonster Pack Size: +24% (augmented)\nQuality: +5% (augmented)\n--------\nItem Level: 81\n--------\nArea is inhabited by 2 additional Rogue Exiles\nPlayers are Cursed with Temporal Chains\nSlaying Enemies close together can attract monsters from Beyond\n+20% Monster Chaos Resistance\n+30% Monster Elemental Resistance\nPlayers gain 40% reduced Flask Charges\n--------\nTravel to this Map by using it in the Templar Laboratory or a personal Map Device. Maps can only be used once."

    val knownInfoOption: Option[KnownInfo] = ClipboardParser.parseKnownInfo(clipboard)
    assert(knownInfoOption.isDefined)
    val knownInfo = knownInfoOption.get

    val expectedExplicits: Option[Seq[String]] = Option(Array(
      "Area is inhabited by 2 additional Rogue Exiles",
      "Players are Cursed with Temporal Chains",
      "Slaying Enemies close together can attract monsters from Beyond",
      "+20% Monster Chaos Resistance",
      "+30% Monster Elemental Resistance",
      "Players gain 40% reduced Flask Charges"
    ))

    assert(knownInfo.rarity == Rarity.RARE)
    assert(knownInfo.typeLine == "Shaped Dunes Map")
    assert(knownInfo.name.contains("Grim Waste"))
    assert(knownInfo.itemLevel.contains(81))
    assert(knownInfo.identified.contains(true))
    assert(knownInfo.quality.contains(5))
    val expectedMapInfo = MapInfo(10, 75, 36, 24)
    assert(knownInfo.mapInfo.contains(expectedMapInfo))
    assert(knownInfo.talismanTier.isEmpty)
    assert(knownInfo.implicits.isEmpty)
    assert(knownInfo.explicits == expectedExplicits)
    assert(knownInfo.ownerInfo.isEmpty)
    assert(!knownInfo.corrupted)
  }

  "parseKnownInfo" should "parse corrupted map" in {
    val clipboard: String = "Rarity: Rare\nRapture Caress\nEmbroidered Gloves\n--------\nQuality: +8% (augmented)\nEnergy Shield: 55 (augmented)\n--------\nRequirements:\nLevel: 36\nInt: 54\n--------\nSockets: W-W B \n--------\nItem Level: 42\n--------\nTrigger Word of Flames on Hit\n--------\n1 Life Regenerated per second\n+15 to maximum Mana\n11% increased Energy Shield\n+22 to maximum Energy Shield\n+20% to Cold Resistance\n+26% to Lightning Resistance\n--------\nCorrupted"
    val knownInfoOption: Option[KnownInfo] = ClipboardParser.parseKnownInfo(clipboard)
    assert(knownInfoOption.isDefined)
    val knownInfo = knownInfoOption.get
    assert(knownInfo.corrupted)
  }

  "parseKnownInfo" should "parse Stack of Chromatic Orb" in {
    val clipboard: String = "Rarity: Currency\nChromatic Orb\n--------\nStack Size: 15/20\n--------\nReforges the colour of sockets on an item\n--------\nRight click this item then left click a socketed item to apply it.\nShift click to unstack."

    val knownInfoOption: Option[KnownInfo] = ClipboardParser.parseKnownInfo(clipboard)
    assert(knownInfoOption.isDefined)
    val knownInfo = knownInfoOption.get

    assert(knownInfo.stackSize.isDefined)
    val stackSize = knownInfo.stackSize.get
    assert(stackSize.size == 15)
    assert(stackSize.max == 20)
  }
}
