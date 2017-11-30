package com.poe.parser.item.equipment.weapon

import com.poe.parser.item.DBItem
import com.poe.parser.knowninfo.KnownInfo

class VariableWeapon(
                      knownInfo: KnownInfo,
                      val oneHanded: Boolean
                    ) extends Weapon(knownInfo) {
  override def height(): Int = if (oneHanded) 3 else 4
  override def width(): Int = 2

  override def asDBItem: DBItem = {
    super.asDBItem.copy(
      oneHanded = Option(oneHanded)
    )
  }
}
