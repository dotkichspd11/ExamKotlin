package ExamKotlin

class EmployFulltime:Person{
    var numberWorkDay: Int =0

    constructor(id: Int, name: String, numberPhone: String, address: String, salary: Double, numberWorkDay: Int) : super(id, name, numberPhone, address, salary) {
        this.numberWorkDay = numberWorkDay
    }

    constructor() : super()
    constructor(numberWorkDay: Int) : super() {
        this.numberWorkDay = numberWorkDay
    }

    fun getSalary(){
        salary = (numberWorkDay*150000).toDouble()
    }
}