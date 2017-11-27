package com.poe.parser

import com.poe.constants.Rarity
import com.poe.parser.item.OwnerInfo


/**
  * A representation of all known information about an item. This should closely resemble the representation of an item
  * given by POE. The purpose is to standardize the information passed to the com.poe.parser.ItemFactory, which will handle parsing
  * and generating the appropriate meta data
  */
class KnownInfo (var base: String, var rarity: Rarity) {
  var id: Option[String] = None
  var name: Option[String] = None
  var itemLevel: Option[Int] = None
  var identified: Option[Boolean] = None
  var quality: Option[Int] = None
  var mapTier: Option[Int] = None
  var talismanTier: Option[Int] = None
  var implicits: Option[Seq[String]] = None
  var explicits: Option[Seq[String]] = None
  var ownerInfo: Option[OwnerInfo] = None

  def isMap: Boolean = {
    base.contains("Map")
  }

  def isTalisman: Boolean = {
    base.contains("Talisman")
  }

  def isLeaguestone: Boolean = {
    base.contains("Leaguestone")
  }
}
