package com.knoldus.Impl

import com.knoldus.validator.CompanyValidator

class CompanyImpl(companyValidator: CompanyValidator) {
  val CompanyNotExists = "yes"
  val CompanyExist = "no"
  val ValidEmailId = "valid"
  val InValidEmailId = "invalid"

  def doCompanyExist(company: String): String = {
    if (companyValidator.companyIsValid(company: String)) {
      println("Company already exists")
      CompanyExist
    } else {
      println("Company not already exists")
      CompanyNotExists
    }
  }

  def getEmailId(email: String): String = {
    if (companyValidator.emailIdIsValid(email)) {
      println("Valid Email Id")
      ValidEmailId
    }
    else {
      println("InValid Email Id")
      InValidEmailId
    }
  }

}
