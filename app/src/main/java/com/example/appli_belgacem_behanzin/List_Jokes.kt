package com.example.appli_belgacem_behanzin

//création de la liste de blagues
object ListJokes {
    val mocked: List<String> = listOf(
        "Chuck Norris didn't like watching Aaron Hernandez play football. So he sent him to prison so he wouldn't have to see him play again.",
        "Chuck Norris's beard alone has experienced more than your entire body.",
        "wil murphy slapped Chuck Norris",
        "An apple a day keeps the doctor away\\\" Chuck Norris can keep the doctor away with a cheeseburger.",
        "Why does Chuck Norris lower your blood pressure? Because he's a beater blocker",
        "Chuck Norris has never lost \\\"The Game.\\",
        "Chuck Norris once had an alcohol abuse problem. He entered a rehab center and completed the 12 step recovery program in a 1/2 step.",
        "Chuck Norris eats haggis just for the fun.",
        "Chuck Norris fears nothing. But fear fears Chuck Norris.",
        "Chuck Norris snorts crushed-up glass."
    )
    val new_mocked :List<Joke> = mocked.map {
        val jokeValue = it
         Joke(value = jokeValue)
    }
}
