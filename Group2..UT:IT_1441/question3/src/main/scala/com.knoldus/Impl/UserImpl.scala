package com.knoldus.Impl

import com.knoldus.validator.UserValidator

class UserImpl (userValidator: UserValidator){
  val CompanyExists = "yes"
  val CompanyNotExist = "no"
  val ValidEmailId = "valid"
  val InValidEmailId = "invalid"

  def doCompanyExist(company: String): String = {
    if (userValidator.companyExists(company: String)) {
      println("Company Exists")
      CompanyExists
    } else {
      println("Company Not Exists")
      CompanyNotExist
    }
  }

  def getEmailId(email: String): String = {
    if (userValidator.emailIdIsValid(email)) {
      println("Valid Email Id")
      ValidEmailId
    }
    else {
      println("InValid Email Id")
      InValidEmailId
    }
  }

}
