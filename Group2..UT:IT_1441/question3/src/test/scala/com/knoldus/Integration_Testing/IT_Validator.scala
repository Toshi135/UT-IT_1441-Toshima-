package com.knoldus.Integration_Testing

import com.knoldus.Impl.{CompanyImpl, EmailImpl, UserImpl}
import com.knoldus.db.CompanyReadDto
import com.knoldus.validator.{CompanyValidator, EmailValidator, UserValidator}
import org.scalatest.flatspec.AsyncFlatSpec

class IT_Validator extends AsyncFlatSpec {

  // Testing the CompanyImpl & CompanyValidator
  val companyReadDto = new CompanyReadDto()
  val companyValidator: CompanyValidator = new CompanyValidator(companyReadDto)
  val companyImpl = new CompanyImpl(companyValidator)

  // Company should not already exists in database
  "A Company " should "not already exist in Database " in {
    val result = companyImpl.doCompanyExist("Microsoft")
    assert(result=="yes")
  }

  "A Company" should "already exists in Database " in {
    val result  = companyImpl.doCompanyExist("Knoldus")
    assert(result=="no")
  }

  // Email Validation
  "Email Id " should "be Valid" in {
    val result = companyImpl.getEmailId("gupta@gmail.net")
    assert(result == "valid")
  }

  "Email Id with wrong Recipient name " should "be invalid" in {
    val result = companyImpl.getEmailId("!!toshima@gmail.com")
    assert(result == "invalid")
  }

  // Testing the UserImpl and UserValidator
  val userValidator: UserValidator = new UserValidator(companyReadDto)
  val userImpl = new UserImpl(userValidator)

  // Checks if company exists in database
  "A Company " should "exists in Database " in {
    val result = userImpl.doCompanyExist("Knoldus")
    assert(result == "yes")
  }

  "A Company " should "not exist in Database " in {
    val result = userImpl.doCompanyExist("Microsoft")
    assert(result == "no")
  }

  // Email Validation
  " A email " should "be Invalid without @ symbol" in {
    val result = userImpl.getEmailId("toshimasharma.com")
    assert(result == "invalid")
  }

  "A email " should "be Invalid wrong domain name" in {
    val result = userImpl.getEmailId("toshimasharma.com")
    assert(result == "invalid")
  }

  // Testing the Email Validator
  val emailValidator: EmailValidator = new EmailValidator
  val emailImpl = new EmailImpl(emailValidator)

  // Email Validation
  "A email " should "Invalid with wrong Top-Level Domain Name " in {
    val result = emailImpl.getEmailId("toshima@gmail.ccom")
    assert(result=="no")
  }
}
