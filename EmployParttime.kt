package ExamKotlin

class EmployParttime:Person {

    var timeHours : Int = 0

    constructor(id: Int, name: String, numberPhone: String, address: String, salary: Double, timeHours: Int) : super(id, name, numberPhone, address, salary) {
        this.timeHours = timeHours
    }

    constructor(timeHours: Int) : super() {
        this.timeHours = timeHours
    }

    constructor() : super()

    fun getSalary(){
        salary = (timeHours*120000).toDouble()
    }
}
