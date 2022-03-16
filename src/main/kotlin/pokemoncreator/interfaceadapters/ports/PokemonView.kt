package pokemoncreator.interfaceadapters.ports

import pokemoncreator.frameworksNdrivers.ui.model.PokemonUIModel

interface PokemonView {
    fun onPokemonCreated(pokemonUIModel: PokemonUIModel)
    fun onPokemonCreationFailed(errorMessage: String)
    fun onAllWorkDone()
    fun onWinnerComparisonReady(champion: PokemonUIModel, enemy: PokemonUIModel)
    fun onWinnerComparisonDone()
    fun getPokemonCreationData(prefix: String)
    fun displayMessage(message: String)
}