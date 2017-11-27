package com.poe.parser

import com.poe.constants.Rarity
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
    assert(knownInfo.quality.contains(0))
    assert(knownInfo.mapTier.contains(3))
    assert(knownInfo.talismanTier.isEmpty)
    assert(knownInfo.implicits.isEmpty)
    assert(knownInfo.explicits.isEmpty)
    assert(knownInfo.ownerInfo.isEmpty)
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
    assert(knownInfo.quality.contains(0))
    assert(knownInfo.mapTier.contains(2))
    assert(knownInfo.talismanTier.isEmpty)
    assert(knownInfo.implicits.isEmpty)
    assert(knownInfo.explicits == expectedExplicits)
    assert(knownInfo.ownerInfo.isEmpty)
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
    assert(knownInfo.mapTier.contains(10))
    assert(knownInfo.talismanTier.isEmpty)
    assert(knownInfo.implicits.isEmpty)
    assert(knownInfo.explicits == expectedExplicits)
    assert(knownInfo.ownerInfo.isEmpty)
  }
}
