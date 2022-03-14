package pokemoncreator.interfaceadapters.presenter

import pokemoncreator.domain.usecase.ports.CreatePokemonOutputPort
import pokemoncreator.interfaceadapters.view.PokemonView

class PokemonPresenter(private val pokemonView: PokemonView): CreatePokemonOutputPort {

    override fun onFinishedCreatingPokemon(success: Boolean) {
        if (success) {
            pokemonView.hideError()
        } else {
            pokemonView.showError()
        }
    }
}