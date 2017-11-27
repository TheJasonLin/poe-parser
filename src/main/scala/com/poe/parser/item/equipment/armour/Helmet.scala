package com.poe.parser.item.equipment.armour

import com.poe.parser.KnownInfo

class Helmet(
              knownInfo: KnownInfo
            ) extends Armour(knownInfo) {
  override def height(): Int = 2
}

object Helmet {
  val identifiers = Array(
    "Hat",
    "Helmet",
    "Burgonet",
    "Cap",
    "Tricorne",
    "Hood",
    "Pelt",
    "Circlet",
    "Cage",
    "Helm",
    "Sallet",
    "Bascinet",
    "Coif",
    "Crown",
    "Mask"
  )
}

