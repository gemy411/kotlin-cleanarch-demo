package pokemoncreator.frameworksNdrivers.ui

import kotlinx.coroutines.*
import pokemoncreator.entity.model.PokemonColors
import pokemoncreator.entity.model.PokemonType
import pokemoncreator.frameworksNdrivers.di.Injector
import pokemoncreator.frameworksNdrivers.ui.model.PokemonUIModel
import pokemoncreator.interfaceadapters.view.PokemonView


class UIComponent: PokemonView {

    //region Do not open!
    var workIsDone = false
    private val uiScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val controller = Injector.getPokemonCreatorController(this)
    private var loadingJob : Job? = null
    private fun setWorkFinished() {
        uiScope.cancel()
        workIsDone = true
    }
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
        displayMessage("Welcome to Pokemon creator!")
        getPokemonCreationData("champion")
    }
    override fun onPokemonCreated(pokemonUIModel: PokemonUIModel) {
        stopLoading()
        displayMessage("Pokemon created successfully!!")
        displayMessage("Pokemon is: $pokemonUIModel")
    }

    override fun onWinnerComparisonReady(champion: PokemonUIModel, enemy: PokemonUIModel) {
        displayMessage("Calculating winner...")
        showLoading()
        controller.checkWinner(champion, enemy)
    }

    override fun getPokemonCreationData(prefix: String) {
        displayMessage("Please enter your $prefix Pokemon's name..")
        val name = readlnOrNull() ?: ""

        displayMessage("Now it's time for a poetic descriptive and non-self-destructive description..")
        val desc = readlnOrNull() ?: ""

        displayMessage("""
            Enter a Pokemon type from ${PokemonType.values().joinToString()}....
        """.trimIndent())
        val type = readlnOrNull() ?: ""

        displayMessage("How much power does it have??")
        val power = readlnOrNull()?.toIntOrNull() ?: 0

        displayMessage("""
            Enter a Pokemon color from ${PokemonColors.values().joinToString()}....
        """.trimIndent())
        val color = readlnOrNull() ?: ""

        showLoading()

        controller.createPokemon(
            name,
            desc,
            type,
            power,
            color,
        )
    }

    override fun displayMessage(message: String) {
        println(message)
    }

    override fun onWinnerComparisonDone() {
        stopLoading()
    }

    override fun onPokemonCreationFailed(errorMessage: String) {
        stopLoading()
        displayMessage("""
            Pokemon creation failed :( :( 
            Message: $errorMessage
        """.trimIndent())
    }

    override fun onAllWorkDone() {
        setWorkFinished()
    }
}