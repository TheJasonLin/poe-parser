package com.poe.parser

import com.poe.constants.Rarity
import com.poe.parser.item.Item
import com.poe.parser.item.equipment.accessory.Ring
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.immutable.HashSet

class ItemFactorySpec extends FlatSpec with Matchers {
  "AcessoryFactory" should "create a ring" in {
    val ringInfo: KnownInfo = getGhoulTurnInfo

    val item: Item = ItemFactory.create(ringInfo)

    assert(item.isInstanceOf[Ring])
    val ring: Ring = item.asInstanceOf[Ring]
    assert(ring.name.equals(ringInfo.name))
    assert(ring.implicits.size == 1)
    assert(ring.explicits.size == 6)
  }

  def getGhoulTurnInfo: KnownInfo = {
    val ringInfo: KnownInfo = new KnownInfo("Diamond Ring", Rarity.RARE)
    ringInfo.name = Option("Ghoul Turn")
    ringInfo.itemLevel = Option(77)
    ringInfo.identified = Option(true)
    ringInfo.implicits = Option(
      HashSet(
        "29% increased Global Critical Strike Chance"
      )
    )
    ringInfo.explicits = Option(
      HashSet(
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
}
