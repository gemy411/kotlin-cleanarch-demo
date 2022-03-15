package pokemoncreator.interfaceadapters.ports

import pokemoncreator.ui.model.PokemonUIModel

interface PokemonView {
    fun onPokemonCreated(pokemonUIModel: PokemonUIModel)
    fun onPokemonCreationFailed(errorMessage: String)
}