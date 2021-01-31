package com.knoldus.Impl

import com.knoldus.validator.EmailValidator

class EmailImpl (emailValidator: EmailValidator){

  val VerifiedEmail = "yes"
  val UnVerifiedEmail = "no"

  def getEmailId(email  :String) :String = {
    if(emailValidator.emailIdIsValid(email)) {
      println("Valid Email Id")
      VerifiedEmail
    }
    else {
      println("InValid Email Id")
      UnVerifiedEmail
    }
  }

}
