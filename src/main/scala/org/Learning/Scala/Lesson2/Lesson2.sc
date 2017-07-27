// lab Exercises

def isvowel ( ch : Char) = {
    if( (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u') ) "given char is a vowel"
    else "Not a Vowel"
}

def isvowel2(ch:Char) =  ch == 'a'|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'

def isvowel3(ch:Char) = "aeiou".contains(ch)

isvowel('e')
isvowel2('r')
isvowel2('a')
isvowel3('r')
isvowel3('o')

def vowels(s:String) = {
  val str = s.toLowerCase()
  var result:String = " "
  for( x <- str)  {
    if (isvowel3(x) )
      result += x
  }
  result
}

vowels("Esakki")

// This solution is free from var we have to follow the below one
def vowelsyield(str:String) =
    for (x <-str if isvowel3(x) ) yield x

vowelsyield("Eeeesakki")
vowelsyield("aeiou")

// repeat the Vowels functino with the recursive fashion

def vowelsrec(S:String):String = {
  val str = S.toLowerCase()
  if (str.length == 0) " "
  else {
    val ch:Char = str(0)
    val rest = str.substring(1)
    if( isvowel2(ch)) ch + rest else rest
  }

}

val r = vowelsrec("eki")


def vowelsWhile(s:String) = {

  var i =0
  var result = " "
  while(i < s.length) {
    val ch =s(i)
    if (isvowel3(ch))  result += ch
    i += 1
  }
  result
}

val whileresult = vowelsWhile("esakki")


def favvowels(Str:String , vowelchar:String="aeiou",ignoreCase:Boolean = true) = {

  var s =" "
  if(ignoreCase)  s = Str.toLowerCase() else   s = Str

  for( ch <- s  if (isvowel4(ch,vowelchar)))  yield ch
}


favvowels("esAkki")
favvowels("EsZZAkki","aezziouk",true)


def isvowel4(ch:Char,vowelChar:String) = vowelChar.contains(ch)












