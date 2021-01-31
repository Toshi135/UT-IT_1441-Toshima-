package com.knoldus.validator

import com.knoldus.models.{Company, Employee}
import com.knoldus.db.CompanyReadDto

class EmployeeValidator (companyReadDto: CompanyReadDto){

  def employeeIsValid(employee: Employee): Boolean  = ???

}
