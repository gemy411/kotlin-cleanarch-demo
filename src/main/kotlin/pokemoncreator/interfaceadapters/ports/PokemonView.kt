package pokemoncreator.interfaceadapters.ports

import pokemoncreator.frameworksNdrivers.ui.model.PokemonUIModel

interface PokemonView {
    fun onPokemonCreated(pokemonUIModel: PokemonUIModel)
    fun onPokemonCreationFailed(errorMessage: String)
}