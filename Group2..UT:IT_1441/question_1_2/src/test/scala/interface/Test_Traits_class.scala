package interface

import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class Test_Traits_class extends AsyncFlatSpec{
  val MockedTraits: Traits_method = mock[Traits_method]
  val trait_Impl = new Traits_impl()

  // Unit Test Cases to check given number is palindrome or not

  "Number = 153351 " should "palindrome " in {
    when(MockedTraits.palindrome(153351)) thenReturn true
    val result = trait_Impl.CheckPalindrome(153351)
    assert(result == "yes")
  }

  "Number = 15351 " should "palindrome " in {
    when(MockedTraits.palindrome(15351)) thenReturn true
    val result = trait_Impl.CheckPalindrome(15351)
    assert(result == "yes")
  }

  "Number = 15335 " should "not a palindrome " in {
    when(MockedTraits.palindrome(15335)) thenReturn false
    val result = trait_Impl.CheckPalindrome(15335)
    assert(result == "no")
  }

  "Number = 273351 " should "not a palindrome " in {
    when(MockedTraits.palindrome(273351)) thenReturn false
    val result = trait_Impl.CheckPalindrome(273351)
    assert(result == "no")
  }

  // Unit Test Cases to get the factorial of given number

  "Factorial of 5" should " be 120 " in {
    when(MockedTraits.factorial(5)) thenReturn 120
    val result = trait_Impl.getFactorial(5)
    assert(result == 120)
  }

  "Factorial of 8" should " be 40320 " in {
    when(MockedTraits.factorial(8)) thenReturn 40320
    val result = trait_Impl.getFactorial(8)
    assert(result == 40320)
  }



}
