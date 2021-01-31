package passwordValidation

class PassValidator {

  def isValid(pass: String): Boolean = {
      var result: Boolean = false
      var space = 0
      var num = 0
      var small: Int = 0
      var cap: Int = 0
      var spec: Int = 0
      var other: Int = 0
      for (c <- pass) {
          if (c == ' ') space = space + 1

          else if (c >= 48 && c <= 57) num = num + 1

          else if (c >= 65 && c <= 90) cap = cap + 1

          else if (c >= 97 && c <= 122) small = small + 1

          else if ((c >= 33 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 126)) spec = spec + 1

          else other = other + 1
      }
      if (pass.length >= 8 && pass.length <= 15) result = true
      else result = false

      if (space > 0) result = false
      else result = true

      if (num == 0) result = false
      else result = true

      if (small == 0) result = false
      else result = true

      if (cap == 0) result = false
      else result = true

      if (spec == 0) result = false
      else result = true

      result


  }
}
