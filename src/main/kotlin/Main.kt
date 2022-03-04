import java.io.File
import java.io.BufferedReader


fun String.fullTrim() = trim().replace("\uFEFF", "")

fun calculateSD(numArray: MutableList<Double>): Double {
    var sum = 0.0
    var standardDeviation = 0.0

    for (num in numArray) {
        sum += num
    }

    val mean = sum / 10

    for (num in numArray) {
        standardDeviation += Math.pow(num - mean, 2.0)
    }

    return Math.sqrt(standardDeviation / 10)
}

fun main(args: Array<String>) {
    // 1 Взять свою фамилию латинскими буквами, сконвертировать каждый символ в фамилии в число (код по таблице
    // ASCII, используя методы типа Char). Посчитать сумму полученных чисел.
    var lastname: String = "Kristal"
    var res: Int = 0
    for (item in lastname.toCharArray()){
        res += item.toInt()
    }
    println("Name: $res")
    
    // 2
    val a: Int = res%10

    val bufferedReader: BufferedReader =
        File("C:\\MIPT\\PROG\\Kotlin\\HW\\task_1\\ks-2022-1-st2257st2257-main\\data\\numbers.txt").bufferedReader()
    val data: List<String> = bufferedReader.use { it.readText() }.split("\n")
    val data_a = mutableListOf(data[a*100].fullTrim().toDouble())
    for (i in 1 until 100){
        data_a.add(data[a*100+i].fullTrim().toDouble())
    }

    data_a.sort()
    val average: Double = data_a.sum()/100
    val variance: Double = calculateSD(data_a)
    val median:  Double = data_a[50]
    println("average: $average")
    println("variance: $variance")
    println("median: $median")

    // 3
    val new_data = mutableListOf(data[0].fullTrim().toDouble())
    for (i in 1 until data.size-1){
        new_data.add(data[i].fullTrim().toDouble())
    }

    new_data.sort()
    val res_data: MutableList<Double> = mutableListOf((data.first().fullTrim().toDouble() +
            data.first().fullTrim().toDouble())/2)
    for (i in 1 until (data.size/2-1)){
        res_data.add((data[i].fullTrim().toDouble() +
                data[(data.size/2-1)-i].fullTrim().toDouble())/2)
    }
    val res_average: Double = res_data.sum()/(res_data.size)
    val res_variance: Double = calculateSD(res_data)
    val res_median:  Double = res_data[res_data.size/2]

    println("res_average: $res_average")
    println("res_variance: $res_variance")
    println("res_median: $res_median")

    var Res: String = ""
    for (i in 0 until res_data.size){
        Res += res_data[i].toString() + "\n"
    }
    File("C:\\MIPT\\PROG\\Kotlin\\HW\\task_1\\ks-2022-1-st2257st2257-main\\data\\new_numbers.txt").writeText(Res)
    // 4


    println("Hello World!")
}