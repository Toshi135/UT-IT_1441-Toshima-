package passwordValidator
import passwordValidation.{PassValidator,CheckPassword}
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpe

class TestPass extends AsyncFlatSpec{
  val MockedValidation: PassValidator = mock(classOf[PassValidator])
  val password = new CheckPassword(MockedValidation)

  // Unit Test Cases for Email Validation

  "Password with every condition" should "be Valid" in {
    when(MockedValidation.isValid("Toshima@1234")) thenReturn true
    val result = password.getPass("Toshima@1234")
    assert(result == "yes")
  }

  "Password with blank space" should "be invalid" in {
    when(MockedValidation.isValid("Toshima")) thenReturn false
    val result = password.getPass("Toshima")
    assert(result == "no")
  }

  "Password without special symbol" should "be invalid" in {
    when(MockedValidation.isValid("Toshima1234")) thenReturn false
    val result = password.getPass("Toshima1234")
    assert(result == "no")
  }

  "Password without a single small letter" should "be invalid" in {
    when(MockedValidation.isValid("TOSHIMA1234")) thenReturn false
    val result1 = password.getPass("TOSHIMA1234")
    assert(result1 == "no")
  }

  "Password without Capital letter" should "be invalid" in {
    when(MockedValidation.isValid("toshima1234")) thenReturn false
    val result1 = password.getPass("toshima1234")
    assert(result1 == "no")
  }

  "Password length less then 8 letters" should "be invalid" in {
    when(MockedValidation.isValid("Toshima123")) thenReturn false
    val result1 = password.getPass("Toshima123")
    assert(result1 == "no")
  }

  "Password length more then 15 letters" should "be invalid" in {
    when(MockedValidation.isValid("Toshimaaaaaaaaaa1234569874")) thenReturn false
    val result1 = password.getPass("Toshimaaaaaaaaaaaa1234569874")
    assert(result1 == "no")
  }
  "Password" should "be Valid" in {
    when(MockedValidation.isValid("Toshim@12345")) thenReturn true
    val result = password.getPass("Toshim@12345")
    assert(result == "yes")
  }
}
