package pokemoncreator.interfaceadapters.view

import pokemoncreator.ui.model.PokemonUIModel

interface PokemonView {
    fun onPokemonCreated(pokemonUIModel: PokemonUIModel)
    fun onPokemonCreationFailed(errorMessage: String)
}