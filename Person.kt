package ExamKotlin

open class Person {
    var id : Int = 0
    var name : String = ""
    var numberPhone : String =""
    var address : String =""
    var salary : Double = 0.0

    constructor()
    constructor(id: Int, name: String, numberPhone: String, address: String, salary: Double) {
        this.id = id
        this.name = name
        this.numberPhone = numberPhone
        this.address = address
        this.salary = salary
    }

}