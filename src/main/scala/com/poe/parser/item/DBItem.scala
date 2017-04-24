package com.poe.parser.item

import org.mongodb.scala.bson.ObjectId

case class DBItem(
                   id: String,
                   className: String,
                   rarity: Int,
                   base: String,
                   width: Int,
                   height: Int,
                   // GGG Source Only
                   accountName: Option[String] = None,
                   lastCharacterName: Option[String] = None,
                   note: Option[String] = None,
                   stashName: Option[String] = None,
                   // Craftable Item
                   itemLevel: Option[Int] = None,
                   identified: Option[Boolean] = None,
                   quality: Option[Int] = None,
                   implicits: Option[Seq[Mod]] = None,
                   explicits: Option[Seq[Mod]] = None,
                   // Map Only
                   mapTier: Option[Int] = None,
                   // Talisman Only
                   talismanTier: Option[Int] = None,
                   // 2-H Variant Weapon Only
                   oneHanded: Option[Boolean] = None,
                   // Sword Only
                   thrusting: Option[Boolean] = None,
                   _id: ObjectId = new ObjectId()
                 )
