package pokemoncreator.interfaceadapters.presenter

import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.interfaceadapters.ports.PokemonView
import pokemoncreator.ui.model.toUI
import pokemoncreator.usecase.usecase.ports.CreatePokemonOutputPort

class PokemonPresenter(private val pokemonView: PokemonView): CreatePokemonOutputPort {

    override fun onFinishedCreatingPokemon(pokemon: PokemonDataEntity) {
        try {
            pokemonView.onPokemonCreated(pokemon.toUI())
        } catch (e: Exception) {
            pokemonView.onPokemonCreationFailed(e.message ?: "Something went wrong!")
        }
    }

    override fun onFailed(errorMessage: String) {
        pokemonView.onPokemonCreationFailed(errorMessage)
    }
}