package com.example

import play.api.libs.json.{JsValue, Json}
import scala.util.{Success, Try}

object JStrom {

  private final val OpeningCharacters: Seq[Char] = Seq('[', '{')
  private final val ClosingCharacters: Seq[Char] = Seq(']', '}')

  def apply(inputStream: Stream[Char]) = new JStrom(inputStream)

}

class JStrom(inputStream: Stream[Char]) {
  import scala.collection.mutable
  type TokenStack = mutable.Stack[Char]

  def parse: Stream[JsValue] = {

    inputStream.scanLeft(JStromBuffer.empty()){
      // Last one was complete, easy return a new one
      case (completeBuffer: CompleteJStromBuffer, char) if isOpeningChar(char) =>
        InputJStromBuffer(openingTokens = char :: Nil, all = char.toString)

      // First character, easy
      case (buffer @ InputJStromBuffer(Nil, Nil, x), char)
        if isOpeningChar(char) && x.isEmpty =>
        buffer.copy(openingTokens = char :: Nil, all = char.toString)

      // Last character, easy
      case (buffer @ InputJStromBuffer(openings, closings, x), char)
        if isClosingChar(char) && openings.size - 1 == closings.size =>
        new CompleteJStromBuffer(x + char)

      // Last one was partial, hmmm
      case (buffer @ InputJStromBuffer(openings, _, all), char)
        if isOpeningChar(char) =>
        buffer.copy(openingTokens = char :: openings, all = all + char)

      // Last one was partial, hmmm
      case (buffer @ InputJStromBuffer(_, closings, all), char)
        if isClosingChar(char) =>
        buffer.copy(closingTokens = char :: closings, all = all + char)

      // All other things
      case (buffer @ InputJStromBuffer(_, _, all), char) =>
        buffer.copy(all = all + char)

    } collect {
      case complete: CompleteJStromBuffer =>
        Try( Json parse complete.all)
    } collect { case Success(j) => j }
  }

  private def isOpeningChar(char: Char): Boolean = {
    JStrom.OpeningCharacters contains char
  }

  private def isClosingChar(char: Char): Boolean = {
    JStrom.ClosingCharacters contains char
  }

}
