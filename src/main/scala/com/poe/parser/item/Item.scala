package com.poe.parser.item

import com.poe.constants.Rarity
import com.poe.parser.KnownInfo

abstract class Item(knownInfo: KnownInfo) {
  if (knownInfo != null) {

  }
  val rarity: Rarity = knownInfo.rarity
  val base: String = knownInfo.base
  val name: Option[String] = knownInfo.name
  val id: Option[String] = knownInfo.id
  val ownerInfo: Option[OwnerInfo] = knownInfo.ownerInfo

  def width(): Int = 1
  def height(): Int = 1
  def className: String = this.getClass.getSimpleName

  override def toString: String = getClass + s"($base, $name, $rarity, ${width()}, ${height()})"

  def asDBItem: DBItem = {
    if(id.isEmpty) throw new IllegalArgumentException("id (from GGG) must be defined to create DB Object")

    val dBOwnerInfo: Option[DBOwnerInfo] = if (ownerInfo.isDefined) Option(ownerInfo.get.asDBOwnerInfo) else None
    DBItem(id.get, className, rarity.key, base, name, width(), height(), dBOwnerInfo)
  }
}

object Item {
  def matchesIdentifier(base: String, identifiers: Array[String]): Boolean = {
    val baseWords = base.split(" ")
    baseWords.exists((baseWord) => {
      identifiers.contains(baseWord)
    })
  }
}