// Початок програми
fun main(args: Array<String>) {
    // Введення тексту користувачем
    println("Enter any text:")
    val input = readln()

    // Робота з текстом
    println("Text contains ${StringsProcessor.countWords(input)} word/words")
    println("Text contains ${StringsProcessor.countNumbers(input)} number/numbers")
    println("Text with only letters: ${StringsProcessor.clearNotLetters(input)}")
    println("Text with only single spaces: ${StringsProcessor.clearMultipleSpaces(input)}")
    println("Text with only capitalize words: ${StringsProcessor.leaveOnlyCapitalizedWords(input)}")
}