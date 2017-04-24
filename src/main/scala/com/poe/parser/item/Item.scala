package com.poe.parser.item

import com.poe.constants.Rarity
import com.poe.parser.KnownInfo

abstract class Item(knownInfo: KnownInfo) {
  val rarity: Rarity = knownInfo.rarity
  val base: String = knownInfo.base
  val name: Option[String] = knownInfo.name

  def width(): Int = 1
  def height(): Int = 1
  def className: String = this.getClass.getSimpleName

  override def toString: String = getClass + s"($base, $name, $rarity, $width(), $height())"

  def asDBItem: DBItem = DBItem(className, rarity.key, base)
}

object Item {
  def matchesIdentifier(base: String, identifiers: Array[String]): Boolean = {
    val baseWords = base.split(" ")
    baseWords.exists((baseWord) => {
      identifiers.contains(baseWord)
    })
  }
}