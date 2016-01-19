package com.example

private[example] object JStromBuffer {

  def empty(): JStromBuffer = InputJStromBuffer(Nil, Nil, "")

}

private[example] trait JStromBuffer {

  def openingTokens: List[Char]

  def closingTokens: List[Char]

  def all: String

}

/**
  * Represents a buffer that is being filled
  * @param openingTokens
  * @param closingTokens
  * @param all
  */
private[example] case class InputJStromBuffer(openingTokens: List[Char] = Nil,
                                              closingTokens: List[Char] = Nil,
                                              all: String) extends JStromBuffer


private[example] class CompleteJStromBuffer(override val all: String) extends JStromBuffer {
  override def openingTokens: List[Char] = Nil

  override def closingTokens: List[Char] = Nil

}
