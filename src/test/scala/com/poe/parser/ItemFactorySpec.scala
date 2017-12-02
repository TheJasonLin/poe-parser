package com.poe.parser

import com.poe.constants.Rarity
import com.poe.parser.item.{Item, OwnerInfo}
import com.poe.parser.item.equipment.accessory.Ring
import com.poe.parser.item.equipment.weapon.Dagger
import com.poe.parser.knowninfo.KnownInfo
import org.scalatest.{FlatSpec, Matchers}

class ItemFactorySpec extends FlatSpec with Matchers {

  "create" should "create a ring" in {
    val ringInfo: KnownInfo = getGhoulTurnInfo

    val item: Item = ItemFactory.create(ringInfo)

    assert(item.isInstanceOf[Ring])
    val ring: Ring = item.asInstanceOf[Ring]
    assert(ring.name.equals(ringInfo.name))
    assert(ring.implicits.size == 1)
    assert(ring.explicits.size == 6)
  }

  "create" should "create a dagger" in {
    val daggerInfo = getCarrionStinger

    val item = ItemFactory.create(daggerInfo)

    assert(item.isInstanceOf[Dagger])
    val dagger: Dagger = item.asInstanceOf[Dagger]
    assert(dagger.implicits.size == 1)
    assert(dagger.explicits.size == 6)
    assert(dagger.itemLevel == 78)
  }

  private def getGhoulTurnInfo: KnownInfo = {
    val ringInfo: KnownInfo = new KnownInfo("Diamond Ring", Rarity.RARE)
    ringInfo.name = Option("Ghoul Turn")
    ringInfo.itemLevel = Option(77)
    ringInfo.identified = Option(true)
    ringInfo.implicits = Option(
      List(
        "29% increased Global Critical Strike Chance"
      )
    )
    ringInfo.explicits = Option(
      List(
        "Adds 3 to 40 Lightning Damage to Attacks",
        "+390 to Accuracy Rating",
        "+22 to maximum Energy Shield",
        "+13% to all Elemental Resistances",
        "+40% to Fire Resistance",
        "20% increased maximum Energy Shield"
      )
    )

    ringInfo
  }

  private def getCarrionStinger: KnownInfo = {
    val info: KnownInfo = new KnownInfo("Royal Skean", Rarity.RARE)
    info.name = Option("Carrion Stinger")
    info.itemLevel = Option(78)
    info.identified = Option(true)
    info.quality = Option(20)
    info.implicits = Option(
      List("30% increased Global Critical Strike Chance")
    )
    info.explicits = Option(
      List(
        "Adds 42 to 82 Fire Damage",
        "Adds 5 to 91 Lightning Damage to Spells",
        "19% increased Attack Speed",
        "107% increased Critical Strike Chance for Spells",
        "+23% to Global Critical Strike Multiplier",
        "43% increased Spell Damage"
      )
    )
    info.ownerInfo = Option(new OwnerInfo("foxlin", "SparkTrain", "~b/o 30 chaos", "$$", "Standard"))

    info
  }
}
