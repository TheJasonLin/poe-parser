package com.poe.parser.item.equipment

import com.poe.parser.item.equipment.accessory.AccessoryFactory
import com.poe.parser.item.equipment.armour.ArmourFactory
import com.poe.parser.item.equipment.weapon.WeaponFactory
import com.poe.parser.knowninfo.KnownInfo

object EquipmentFactory {
  def create(knownInfo: KnownInfo): Option[Equipment] = {
    var equipmentOption: Option[Equipment] = None

    if (knownInfo.typeLine.contains("Flask")) {
      return Option(new Flask(knownInfo))
    }

    if (knownInfo.typeLine.contains("Jewel")) {
      return Option(new Jewel(knownInfo))
    }

    // Accessory
    equipmentOption = AccessoryFactory.create(knownInfo)
    if (equipmentOption.isDefined) return equipmentOption

    // Armour
    equipmentOption = ArmourFactory.create(knownInfo)
    if (equipmentOption.isDefined) return equipmentOption

    // Weapon
    equipmentOption = WeaponFactory.create(knownInfo)
    if(equipmentOption.isDefined) return equipmentOption

    None
  }
}
