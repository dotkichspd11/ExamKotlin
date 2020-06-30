package ExamKotlin

import ExamKotlin.EmployFulltime
import ExamKotlin.EmployParttime

import java.util.function.Consumer
fun main(){
    val listEmployParttime : MutableList<EmployParttime> = mutableListOf()
    val listEmployFulltime : MutableList<EmployFulltime> = mutableListOf()
    while (true){
        println("-----------------------")
        println("0. Exit")
        println("1. Add Employ Part time")
        println("2. Add Employ Full time")
        println("3. Print Employ Part time list")
        println("4. Print Employ Full time list")
        println("5. Print Salary Employ Part time")
        println("6. Print Salary Employ Full time")
        println("7. Sum Salary Partime")
        println("8. Sum Salary Fulltime")
        println("9. Print Filter Name Or Id")
        println("10. Sum Salary Part time")
        println("11. Sum Salary Full time")
        print("Choose your number: ")
        var n : Int ?= readLine()!!.toInt()
        var quit : Boolean = false
        when(n){
            0 -> quit = true
            1 -> {
                var employpart = addEmployPart()
                if (employpart.id != -1)
                    listEmployParttime.add(employpart)
            }
            2 -> {
                var employfull = addEmployFull()
                if (employfull.id != -1)
                    listEmployFulltime.add(employfull)
            }
            3 -> printListEmployParttime(listEmployParttime)
            4 -> printListEmployFulltime(listEmployFulltime)
            5 -> printEmployParttimeSalary(listEmployParttime)
            6 -> printEmployFulltimeSalary(listEmployFulltime)
            7 -> getSumSalaryOfEmployParttime(listEmployParttime)
            8 -> getSumSalaryOfEmployFulltime(listEmployFulltime)
            9 -> {
                print("Enter name or id: ")
                var str : String = readLine()!!
                searchNameOrId(str,listEmployParttime,listEmployFulltime)
            }
            10 -> sortEmployPartListByName(listEmployParttime)
            11 -> sortEmployFullListByName(listEmployFulltime)

            else -> println("Please choose number again!")
        }
        if (quit) {
            println("Goodbye, see you again!")
            break
        }
    }
}
fun addEmployPart() : EmployParttime{
    var employpart : EmployParttime = EmployParttime()
    try {
        print("Enter employ part time id: ")
        employpart.id = readLine()!!.toInt()
        print("Enter employ part time name: ")
        employpart.name = readLine()!!.toString()
        print("Enter employ part time phone: ")
        employpart.numberPhone = readLine()!!.toString()
        print("Enter employ part time address: ")
        employpart.address = readLine()!!.toString()
        print("Enter employ part time salary: ")
        employpart.salary = readLine()!!.toDouble()
        print("Enter timeHours: ")
        employpart.timeHours = readLine()!!.toInt()
//        print("Enter mark2: ")
//        student.mark2 = readLine()!!.toDouble()
    } catch (e: NumberFormatException){
        println("Got errors when enter the input")
        employpart.id = -1
        return employpart
    }
    return employpart;
}
fun addEmployFull() : EmployFulltime{
    var employfull:EmployFulltime = EmployFulltime();
    try {
        println("Enter employ full time Id :")
        employfull.id = readLine()!!.toInt();
        println("Enter employ full time Name :")
        employfull.name = readLine()!!.toString();
        println("Enter employ full time number phone :")
        employfull.numberPhone = readLine()!!.toString();
        println("Enter employ full time address :")
        employfull.address = readLine()!!.toString();
        println("Enter employ full time Salary :")
        employfull.salary = readLine()!!.toDouble();
        println("Enter numberWorkDay :")
        employfull.numberWorkDay = readLine()!!.toInt();
    }catch (e : NumberFormatException){
        println("Got errors when enter the input")
        employfull.id = -1
        return employfull
    }
    return employfull;
}
fun printListEmployParttime(list: MutableList<EmployParttime>){
    println("-----List EmPloy Part time------")
    list.forEach(Consumer {
        println("Id:" + it.id + "\tName:" + it.name + "\tNumberPhone:" + it.numberPhone
                + "\tAddress:" + it.address + "\tSalary:" + it.salary + "\tTimeHours:" + it.timeHours)
    })
}
fun printListEmployFulltime(list : MutableList<EmployFulltime>){
    println("-----List EmPloy Full time------")
    list.forEach(Consumer {
        println("Id:" + it.id + "\tName:" + it.name + "\tNumberPhone:" + it.numberPhone
                + "\tAddress:" + it.address + "\tSalary:" + it.salary + "\tNumberWorkDay:" + it.numberWorkDay)
    })
}
fun printEmployParttimeSalary(list: MutableList<EmployParttime>){
    println("-----List Employ Part time Salary ------")
    list.forEach(Consumer {
        println("Id:" + it.id + "\tName:" + it.name + "\tSalary:" + (it.timeHours * 120000))
    })
}
fun printEmployFulltimeSalary(list: MutableList<EmployFulltime>){
    println("-----List Employ Full time Salary ------")
    list.forEach(Consumer {
        println("Id:" + it.id + "\tName:" + it.name + "\tSalary:" + (it.numberWorkDay * 150000))
    })
}
fun getSumSalaryOfEmployParttime(list: MutableList<EmployParttime>){
    println("-----List Salary of Employ Part time------")
    list.forEach(Consumer {
        println("Name:" + it.name + "\tSalary:" + (it.salary * it.timeHours) )
    })
}
fun getSumSalaryOfEmployFulltime(list: MutableList<EmployFulltime>){
    println("-----List Salary of Employ Full time------")
    list.forEach(Consumer {
        println("Name:" + it.name + "\tSalary:" + (it.salary * it.numberWorkDay))
    })
}
fun searchNameOrId(str : String,listEmployParttime: MutableList<EmployParttime>, listEmployFulltime: MutableList<EmployFulltime>){
    var readOnlyEmployPart : List<EmployParttime>
    var readOnlyEmployFull : List<EmployFulltime>
    try {
        val num = str.toInt();
        readOnlyEmployPart = listEmployParttime.filter {
            it.id.equals(num);
        }
        readOnlyEmployFull = listEmployFulltime.filter {
            it.id.equals(num);
        }
    }catch (e : NumberFormatException){
        readOnlyEmployPart = listEmployParttime.filter {
            it.id.equals(str)
        }
        readOnlyEmployFull = listEmployFulltime.filter{
            it.id.equals(str)
        }
    }
    println("----Employ Part time-----")
    readOnlyEmployPart.forEach(Consumer {
        println("Id:" + it.id + "\tName:" + it.name + "\tPhone:" + it.numberPhone
                + "\tAddress:" + it.address + "\tSalary:" + it.salary + "\tTimeHours:" + it.timeHours)

    })
    println("----Employ Full time-----")
    readOnlyEmployFull.forEach(Consumer {
        println("Id:" + it.id + "\tName:" + it.name + "\tPhone:" + it.numberPhone
                + "\tAddress:" + it.address + "\tSalary:" + it.salary + "\tNumberWorkDay:" + it.numberWorkDay)
    })

}
fun sortEmployPartListByName(list: MutableList<EmployParttime>){
    println("Sort success")
    list.sortBy { employpart -> employpart.name }
    list.forEach(Consumer {
        println("Id:" + it.id + "\tName:" + it.name + "\tPhone:" + it.numberPhone
                + "\tAddress:" + it.address + "\tSalary:" + it.salary + "\tTimeHours:" + it.timeHours)
    })
}
fun sortEmployFullListByName(list: MutableList<EmployFulltime>){
    println("Sort success")
    list.sortBy { employfull -> employfull.name }
    list.forEach(Consumer {
        println("Id:" + it.id + "\tName:" + it.name + "\tPhone:" + it.numberPhone
                + "\tAddress:" + it.address + "\tSalary:" + it.salary + "\tNumberWorkDay:" + it.numberWorkDay)
    })
}