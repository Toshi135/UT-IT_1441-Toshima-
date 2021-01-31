package interface
class Traits_impl extends Traits_method {

  def CheckPalindrome(value: Int): String = {
    if(palindrome(value)){
      println("Given number "+value+" is palindrome")
      "yes"
    }
    else {
      println("Given number "+value+" is not palindrome")
      "no"
    }
  }

  def getFactorial(value: Int): Long ={
    val res = factorial(value)
    println("factorial of given value "+value+" = "+res )
    res
  }

}
