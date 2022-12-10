class StringsProcessor {
    // Функції незалежні, тому робимо їх статичними
    companion object {
        // Розбиваємо рядок на слова, відкидаємо числа та рахуємо кількість
        fun countWords(str: String): Int {
            val words = str.split("[\t ]+".toRegex())

            var wordsCounter = 0
            val numberPattern = Regex("^[+-]?[0-9]+|[+-]?[0-9]+[.,][0-9]+|[+-]?[.,][0-9]+$")
            for (word in words) {
                if (!numberPattern.matches(word))
                    wordsCounter++
            }

            return wordsCounter
        }

        // Рахуємо числа в форматах "D" "D.D" "D,D" ".D" ",D"
        fun countNumbers(str: String): Int {
            val words = str.split(" +".toRegex())

            var numbersCounter = 0
            val numberPattern = Regex("^[+-]?[0-9]+|[+-]?[0-9]+[.,][0-9]+|[+-]?[.,][0-9]+$")
            for (word in words) {
                if (numberPattern.matches(word))
                    numbersCounter++
            }

            return numbersCounter
        }

        //Відкидаємо все крім латинських літер, ігноруючи регістр
        fun clearNotLetters(str: String): String {
            return str.replace("[^a-z]".toRegex(RegexOption.IGNORE_CASE), "")
        }

        //Прибираємо зайві пробіли та табуляції
        fun clearMultipleSpaces(str: String): String {
            return str.replace("[ \t]+".toRegex(RegexOption.IGNORE_CASE), " ")
        }

        // Прибираємо всі слова, що не починаються з великої латинської літери
        fun leaveOnlyCapitalizedWords(str: String): String {
            val words = str.split("[\t ]+".toRegex())

            var resultStr = str;
            val notCapitalizedWordPattern = Regex("^[A-Z]{1}.*$")
            for (word in words) {
                if (!notCapitalizedWordPattern.matches(word))
                    resultStr = resultStr.replace(word, "")
            }

            return resultStr
        }
    }
}