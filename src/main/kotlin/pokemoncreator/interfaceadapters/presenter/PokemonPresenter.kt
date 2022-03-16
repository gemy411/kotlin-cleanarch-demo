package pokemoncreator.interfaceadapters.presenter

import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.frameworksNdrivers.ui.model.PokemonUIModel
import pokemoncreator.frameworksNdrivers.ui.model.toUI
import pokemoncreator.interfaceadapters.ports.PokemonView
import pokemoncreator.usecase.checkwinner.ports.CheckWinnerOutPutPort
import pokemoncreator.usecase.createpokemon.ports.CreatePokemonOutputPort

class PokemonPresenter(private val pokemonView: PokemonView): CreatePokemonOutputPort, CheckWinnerOutPutPort {

    private var champion: PokemonUIModel? = null
    private var enemy: PokemonUIModel? = null

    override fun onWinnerDecided(pokemon: PokemonDataEntity) {
        val mPokemon = pokemon.toUI()
        pokemonView.onWinnerComparisonDone()
        if (mPokemon == champion) pokemonView.displayMessage("Your champion won!")
        else pokemonView.displayMessage("Your champion lost!")
        pokemonView.onAllWorkDone()
    }

    override fun onFinishedCreatingPokemon(pokemon: PokemonDataEntity) {
        try {

            val pokemonUIModel = pokemon.toUI()
            pokemonView.onPokemonCreated(pokemonUIModel)
            if (champion == null) {
                champion = pokemonUIModel
                pokemonView.getPokemonCreationData("enemy")
            } else if (enemy == null ) {
                enemy = pokemonUIModel
                pokemonView.onWinnerComparisonReady(champion!!, enemy!!)
            } else {
                pokemonView.onWinnerComparisonReady(champion!!, enemy!!)
            }
        } catch (e: Exception) {
            pokemonView.onPokemonCreationFailed(e.message ?: "Something went wrong!")
            pokemonView.displayMessage("Please try again :D")
            if (champion == null) {
                pokemonView.getPokemonCreationData("champion")
            } else if (enemy == null ) {
                pokemonView.getPokemonCreationData("enemy")
            }
        }
    }

    override fun onFailed(errorMessage: String) {
        pokemonView.onPokemonCreationFailed(errorMessage)
    }
}