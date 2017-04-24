package com.poe.parser.item

import org.mongodb.scala.bson.ObjectId

object DBItem {
  def apply
  (
    className: String,
    rarity: Int,
    base: String
  ): DBItem = DBItem (
    new ObjectId(),
    className,
    rarity,
    base
  )
}

case class DBItem (
  _id: ObjectId,
  className: String,
  rarity: Int,
  base: String
)
