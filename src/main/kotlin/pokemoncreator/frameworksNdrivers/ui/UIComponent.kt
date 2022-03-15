package pokemoncreator.frameworksNdrivers.ui

import kotlinx.coroutines.*
import pokemoncreator.frameworksNdrivers.di.Injector
import pokemoncreator.frameworksNdrivers.ui.model.PokemonUIModel
import pokemoncreator.interfaceadapters.models.PokemonColors
import pokemoncreator.interfaceadapters.models.PokemonType
import pokemoncreator.interfaceadapters.ports.PokemonView


class UIComponent: PokemonView {

    //region Do not open!
    private val uiScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private var loadingJob : Job? = null
    private fun showLoading() {
        loadingJob?.cancel()
        loadingJob = uiScope.launch {
            val fullString = "Loading........"
            var index = 0
            while (true) {
                ensureActive()
                delay(200L)
                index++
                val mIndex = index % fullString.length.minus(1)
                val stringEdge = if (mIndex < 7) mIndex.plus(7) else mIndex
                print(fullString.substring(0, stringEdge).plus("\r"))
            }
        }
    }
    private fun stopLoading() {
        loadingJob?.cancel()
        loadingJob = null
    }
    //endregion

    init {
        println("Welcome to Pokemon creator!")

        println("Please start by entering the Pokemon's name..")
        val name = readlnOrNull()

        println("Now it's time for a poetic descriptive and non-self-destructive description..")
        val desc = readlnOrNull() ?: ""

        println("""
            Enter a Pokemon type from ${PokemonType.values().joinToString()}....
        """.trimIndent())
        val type = readlnOrNull() ?: ""

        println("How much power does it have??")
        val power = readlnOrNull()?.toIntOrNull() ?: 0

        println("""
            Enter a Pokemon color from ${PokemonColors.values().joinToString()}....
        """.trimIndent())
        val color = readlnOrNull() ?: ""

        showLoading()

        Injector.getPokemonCreatorController(this).createPokemon(
            name ?: "No name",
            desc,
            type,
            power,
            color,
        )
    }


    override fun onPokemonCreated(pokemonUIModel: PokemonUIModel) {
        stopLoading()
        println("Pokemon created successfully!!")
        println("Pokemon is: $pokemonUIModel")
    }

    override fun onPokemonCreationFailed(errorMessage: String) {
        stopLoading()
        println("""
            Pokemon creation failed :( :( 
            Message: $errorMessage
        """.trimIndent())
    }
}