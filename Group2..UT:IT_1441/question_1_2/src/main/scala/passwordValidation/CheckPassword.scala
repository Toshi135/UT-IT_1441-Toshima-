package passwordValidation

class CheckPassword(validPass :PassValidator) {
  val VerifiedPass = "yes"
  val UnVerifiedPass = "no"
  def getPass(password  :String) :String = {
    if(validPass.isValid(password)) {
      println("Valid Password")
      VerifiedPass
    }
    else {
      println("InValid Password")
      UnVerifiedPass
    }
  }

}
