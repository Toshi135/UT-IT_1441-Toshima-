package com.knoldus.Unit_Testing

import com.knoldus.Impl.CompanyImpl
import com.knoldus.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class TestCompanyValidator extends AsyncFlatSpec {
  val MockedCompanyValidator: CompanyValidator = mock[CompanyValidator]
  val Company = new CompanyImpl(MockedCompanyValidator)

  // Company should not already exists in database
  "Company " should "already not exist in database" in {
    when(MockedCompanyValidator.companyIsValid("Microsoft")) thenReturn false
    val result = Company.doCompanyExist("Microsoft")
    assert(result == "yes")
  }

  "Company " should "already exist in database" in {
    when(MockedCompanyValidator.companyIsValid("Knoldus")) thenReturn true
    val result = Company.doCompanyExist("Knoldus")
    assert(result=="no")
  }

  // Email Validation
  val MockedEmailValidation: CompanyValidator = mock[CompanyValidator]
  val Email = new CompanyImpl(MockedEmailValidation)
  "Email Id " should "be Valid" in {
    when(MockedEmailValidation.emailIdIsValid("toshima@gmail.net")) thenReturn true
    val result = Email.getEmailId("toshima@gmail.net")
    assert(result == "valid")
  }

  "Email Id with wrong Recipient name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("!!@toshima@gmail.com")) thenReturn false
    val result = Email.getEmailId("!!Gupta@gmail.com")
    assert(result == "invalid")
  }

  "Email Id without @ symbol" should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("toshima@gmail.com")) thenReturn false
    val result = Email.getEmailId("toshima@gmail.com")
    assert(result == "invalid")
  }

  "Email Id with wrong Domain name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("toshima@gmail.com")) thenReturn false
    val result1 = Email.getEmailId("toshima@gmail.com")
    assert(result1 == "invalid")
  }

  "Email Id with wrong Top-Level Domain name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("toshima@gmail.ccom")) thenReturn false
    val result1 = Email.getEmailId("toshima@gmail.ccom")
    assert(result1 == "invalid")
  }

}
