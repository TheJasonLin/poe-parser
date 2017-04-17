package com.poe.parser.item

class Mod(val text: String, val values: Seq[Int]) {
  val averageValue: Int = values.sum / values.length
}

object Mod {
  def parse(modString: String): Mod = {
    val text: String = modString
      .replaceAll("[0-9]+", "#")
      .replaceAll("-", "+")

    val values: Seq[Int] = modString
      .replaceAll("[^-?0-9]+", " ")
      .trim()
      .split(" ")
      .toSeq
      .map((valueString: String) => {
        valueString.toInt
      })

    new Mod(text, values)
  }
}
