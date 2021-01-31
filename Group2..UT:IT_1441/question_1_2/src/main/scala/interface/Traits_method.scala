package interface

trait Traits_method {
  def palindrome(number: Int):Boolean ={
    var store = number
    var reversed_num = 0
    while(store>0){
      var temp = store % 10
      store = store/10
      reversed_num = reversed_num*10+temp
    }
    if(reversed_num == number) return true

    false
  }

  def factorial(number:Int):Long ={
    var result:Long = 1
    var temp = number
    while(temp > 0){
      result = result * temp
      temp = temp - 1
    }
    result

  }

}
