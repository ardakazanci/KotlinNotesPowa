package functions_21.infix_functions


/*
Sample Infix Function

Kuralları
------------
en az 1 adet argüman olacak
vararg olamaz
bir class içerisinde kullanılmalıdır.

 */
class SofrwareDeveloper(val name: String, val favoriteLanguage: String) {

    private val softwareDeveloperList: MutableList<String> = mutableListOf()
    private val favoriteProgrammingLanguageList: MutableList<String> = mutableListOf()
    infix fun softwareDeveloperAdded(arg: String) {

        softwareDeveloperList.add(arg)

    }

    infix fun favoriteProgrammingLanguage(arg: String) {

        favoriteProgrammingLanguageList.add(arg)

    }


}