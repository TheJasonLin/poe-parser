package com.poe.parser

import com.poe.constants.{Clipboard, Rarity, RarityFactory}

object ClipboardParser {
  def parseKnownInfo(clipboard: String): Option[KnownInfo] = {
    if (!isValid(clipboard)) {
      return None
    }

    val rarity = parseRarity(clipboard)
    val typeLine = parseTypeLine(clipboard)
    val name = parseName(clipboard)
    val itemLevel = parseItemLevel(clipboard)
    val identified = parseIdentified(clipboard)
    val quality = parseQuality(clipboard)

    val knownInfo = new KnownInfo(typeLine, rarity)

    knownInfo.name = name
    knownInfo.itemLevel = itemLevel
    knownInfo.identified = Option(identified)
    knownInfo.quality = Option(quality)
    if (knownInfo.isMap) {
      knownInfo.mapTier = parseMapTier(clipboard)
    }
    if (knownInfo.isTalisman) {
      knownInfo.talismanTier = parseTalismanTier(clipboard)
    }
    setMods(clipboard, knownInfo)

    Option(knownInfo)
  }

  private def isValid(clipboard: String): Boolean = {
    // should be at least 3 lines
    clipboard.split('\n').length > 2
  }

  private def parseRarity(clipboard: String): Rarity = {
    val spaceIndex = clipboard.indexOf(' ')
    val newLineIndex = clipboard.indexOf('\n')
    val rarityString = clipboard.substring(spaceIndex + 1, newLineIndex)
    val rarityOptional: Option[Rarity] = RarityFactory.getByString(rarityString)
    if (rarityOptional.isDefined) {
      rarityOptional.get
    } else {
      throw new IllegalArgumentException("rarity couldn't be parsed")
    }
  }

  private def parseTypeLine(clipboard: String): String = {
    val lines: Array[String] = clipboard.split('\n')
    var typeLineIndex = 1
    if (hasName(clipboard)) {
      typeLineIndex = 2
    }
    lines(typeLineIndex)
  }

  private def parseName(clipboard: String): Option[String] = {
    val lines: Array[String] = clipboard.split('\n')
    if (!hasName(clipboard)) {
      return None
    }
    Option(lines(1))
  }

  private def parseItemLevel(clipboard: String): Option[Int] = {
    parseNumericAttribute(clipboard, "Item Level: ")
  }

  /**
    * Parses the quality. Defaults to 0 if not found.
    * @param clipboard
    * @return
    */
  private def parseQuality(clipboard: String): Int = {
    val label = "Quality: +"
    val labelIndex: Int = clipboard.indexOf(label)
    if(labelIndex < 0) {
      0
    } else {
      val valueIndex: Int = labelIndex + label.length
      val endIndex: Int = clipboard.indexOf("%", valueIndex)
      if(endIndex < 0) {
        0
      } else {
        val qualityString = clipboard.substring(valueIndex, endIndex)
        Integer.parseInt(qualityString)
      }
    }
  }

  private def hasName(clipboard: String): Boolean = {
    val lines: Array[String] = clipboard.split('\n')
    lines(2) != Clipboard.Divider
  }


  private def parseMapTier(clipboard: String): Option[Int] = {
    parseNumericAttribute(clipboard, "Map Tier: ")
  }

  private def parseNumericAttribute(clipboard: String, label: String): Option[Int] = {
    val labelStartIndex = clipboard.indexOf(label)
    if(labelStartIndex < 0) {
      None
    } else {
      val labelLength = label.length()
      val valueStartIndex = labelStartIndex + labelLength
      val valueEndIndex = clipboard.indexOf('\n', valueStartIndex)
      val valueText: String = clipboard.substring(valueStartIndex, valueEndIndex)
      val value = Integer.parseInt(valueText)
      Option(value)
    }
  }

  private def parseIdentified(clipboard: String): Boolean = {
    !clipboard.contains("Unidentified")
  }

  private def parseTalismanTier(clipboard: String): Option[Int] = {
    parseNumericAttribute(clipboard, "Talisman Tier: ")
  }

  private def setMods(clipboard: String, knownInfo: KnownInfo) = {
    val sections = getSections(clipboard)

    if (knownInfo.isMap) {
      setMapMods(sections, knownInfo)
    }
  }

  private def setMapMods(sections: Seq[String], knownInfo: KnownInfo): Unit = {
    val itemLevelSectionIndex = findSectionIndex(sections, "Item Level: ")
    val mapDescriptionIndex = findSectionIndex(sections, "Travel to this Map by using it in the Templar Laboratory or a personal Map Device. Maps can only be used once.")

    if (itemLevelSectionIndex == -1 || mapDescriptionIndex == -1 || (itemLevelSectionIndex + 1) >= mapDescriptionIndex) {
      return
    }

    // assume that no maps have implicits

    // assume explicits are always before description
    val explicitModSection = sections(mapDescriptionIndex - 1)
    val modStrings = explicitModSection.split("\\n")
    knownInfo.explicits = Option(modStrings)
  }

  private def getSections(clipboard: String): Seq[String] = {
    clipboard.split(Clipboard.Divider).map((section: String) => section.trim)
  }

  private def findSectionIndex(sections: Seq[String], needle: String): Int = {
    for (i <- sections.indices) {
      if (sections(i).contains(needle)) {
        return i
      }
    }
    -1
  }
}
