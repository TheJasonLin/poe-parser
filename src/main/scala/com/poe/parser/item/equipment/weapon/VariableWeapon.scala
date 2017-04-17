package com.poe.parser.item.equipment.weapon

import com.poe.parser.KnownInfo

class VariableWeapon(
                      knownInfo: KnownInfo,
                      val oneHanded: Boolean
                    ) extends Weapon(knownInfo) {
  override def height(): Int = if (oneHanded) 3 else 4
  override def width(): Int = 2
}
