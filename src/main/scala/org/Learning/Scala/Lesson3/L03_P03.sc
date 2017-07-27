//Group By method

val src = List ("Please",
  "take",
  "a",
  "look",
  "at",
  "the",
  "important",
  "information",
  "in",
  "this",
  "header.",
  "We",
  "encourage",
  "you",
  "to",
  "keep",
  "this",
  "file",
  "on",
  "your",
  "own",
  "disk,",
  "keeping",
  "an",
  "electronic",
  "path",
  "open",
  "for",
  "the",
  "next",
  "readers.",
  "Do",
  "not",
  "remove",
  "this")

val grp_firstLetter = src.groupBy(_.substring(0,1))
//grp_firstLetter: scala.collection.immutable.Map[String,List[String]]

val grp_length = src.groupBy(_.length)
//grp_length: scala.collection.immutable.Map[Int,List[String]]




