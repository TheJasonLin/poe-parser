package com.poe.parser.item.equipment.weapon

import com.poe.parser.KnownInfo
import com.poe.parser.item.Item

object WeaponFactory {
  def create(knownInfo: KnownInfo): Option[Weapon] = {
    val base = knownInfo.base
    if (base.contains("Bow")) {
      return Option(new Bow(knownInfo))
    }

    if (Item.matchesIdentifier(base, Axe.identifiers)) {
      if (Axe.oneHandedBases.contains(base)) {
        return Option(new Axe(knownInfo, true))
      } else {
        return Option(new Axe(knownInfo, false))
      }
    }

    if (Item.matchesIdentifier(base, Claw.identifiers)) {
      return Option(new Claw(knownInfo))
    }

    if (
      Item.matchesIdentifier(base, Dagger.identifiers) ||
        Dagger.oneHandedBases.contains(base)
    ) {
      return Option(new Dagger(knownInfo))
    }

    if (Item.matchesIdentifier(base, Mace.identifiers)) {
      val matchesOneHandedIdentifier = Item.matchesIdentifier(base, Mace.oneHandedIdentifiers)
      val matchesOneHandedBase = Mace.oneHandedBases.contains(base)
      if (matchesOneHandedIdentifier || matchesOneHandedBase) {
        return Option(new Mace(knownInfo, true))
      } else {
        return Option(new Mace(knownInfo, false))
      }
    }

    if (Item.matchesIdentifier(base, Staff.identifiers)) {
      return Option(new Staff(knownInfo))
    }

    if (
      Item.matchesIdentifier(base, Sword.identifiers)
        && !Sword.identifierExceptions.contains(base)
    ) {
      if (Item.matchesIdentifier(base, Sword.oneHandedIdentifiers) || Sword.oneHandedBases.contains(base)) {
        //it's one handed, but need to figure out if it's a thrusting sword or regular
        val isThrusting: Boolean = Item.matchesIdentifier(base, Sword.thrustingIdentifiers)
        return Option(new Sword(knownInfo, true, isThrusting))
      } else {
        return Option(new Sword(knownInfo, false, false))
      }
    }

    if (Item.matchesIdentifier(base, Wand.identifiers)) {
      return Option(new Wand(knownInfo))
    }

    None
  }
}
