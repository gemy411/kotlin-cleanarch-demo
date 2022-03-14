package pokemoncreator.interfaceadapters.presenter

import pokemoncreator.domain.model.PokemonDomainModel
import pokemoncreator.domain.usecase.ports.CreatePokemonOutputPort
import pokemoncreator.interfaceadapters.view.PokemonView
import pokemoncreator.ui.model.toUI

class PokemonPresenter(private val pokemonView: PokemonView): CreatePokemonOutputPort {

    override fun onFinishedCreatingPokemon(pokemon: PokemonDomainModel) {
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