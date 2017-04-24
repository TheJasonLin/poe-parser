package com.poe.parser.item

import com.poe.constants.Rarity
import com.poe.parser.KnownInfo

abstract class Item(knownInfo: KnownInfo) {
  val rarity: Rarity = knownInfo.rarity
  val base: String = knownInfo.base
  val name: Option[String] = knownInfo.name
  val id: Option[String] = knownInfo.id

  def width(): Int = 1
  def height(): Int = 1
  def className: String = this.getClass.getSimpleName

  override def toString: String = getClass + s"($base, $name, $rarity, ${width()}, ${height()})"

  def asDBItem: DBItem = {
    if(id.isEmpty) throw new IllegalArgumentException("id (from GGG) must be defined to create DB Object")
    DBItem(
      id.get, className, rarity.key, base, width(), height(),
      // Options
      knownInfo.accountName, knownInfo.lastCharacterName, knownInfo.note, knownInfo.stashName
    )
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