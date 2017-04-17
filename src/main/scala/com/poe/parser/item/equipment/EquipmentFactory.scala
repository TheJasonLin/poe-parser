package com.poe.parser.item.equipment

import com.poe.parser.KnownInfo
import com.poe.parser.item.equipment.accessory.AccessoryFactory
import com.poe.parser.item.equipment.armour.ArmourFactory
import com.poe.parser.item.equipment.weapon.WeaponFactory

object EquipmentFactory {
  def create(knownInfo: KnownInfo): Option[Equipment] = {
    var equipmentOption: Option[Equipment] = None

//    // Flask
//    if(base.contains("Flask")) {
//      return Option(new Flask(rarity, base, name, itemLevel, identified, quality))
//    }
//    // Jewel
//    if(base.contains("Jewel")) {
//      return Option(new Jewel(rarity, base, name, itemLevel, identified))
//    }

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
