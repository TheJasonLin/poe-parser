package com.poe.parser.item

class OwnerInfo (
                val accountName: String,
                val lastCharacterName: String,
                val note: String,
                val stashName: String
                ) {
  def asDBOwnerInfo: DBOwnerInfo = {
    DBOwnerInfo(accountName, lastCharacterName, note, stashName)
  }
}
