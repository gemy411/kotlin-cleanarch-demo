package pokemoncreator.frameworksNdrivers.di

import pokemoncreator.frameworksNdrivers.network.remote.PokemonRemoteCreatorImpl
import pokemoncreator.interfaceadapters.controller.PokemonCreatorController
import pokemoncreator.interfaceadapters.gateway.PokemonCreatorImpl
import pokemoncreator.interfaceadapters.ports.PokemonView
import pokemoncreator.interfaceadapters.presenter.PokemonPresenter
import pokemoncreator.usecase.checkwinner.CheckWinnerPokemonInteractor
import pokemoncreator.usecase.createpokemon.CreatePokemonUseCaseInteractor

object Injector {
    var presenter: PokemonPresenter? = null
    private fun getPresenter(view: PokemonView) : PokemonPresenter {
        if (presenter == null) {
            presenter = PokemonPresenter(view)
        }
        return presenter!!
    }
    private fun getCreatePokemonUseCase(view: PokemonView): CreatePokemonUseCaseInteractor {
        val pokemonRemoteCreator = PokemonRemoteCreatorImpl()
        val pokemonCreator = PokemonCreatorImpl(pokemonRemoteCreator)
        return CreatePokemonUseCaseInteractor(pokemonCreator, getPresenter(view))
    }
    private fun getCheckWinnerUseCase(view: PokemonView): CheckWinnerPokemonInteractor {
        return CheckWinnerPokemonInteractor(getPresenter(view))
    }
    fun getPokemonCreatorController(view: PokemonView): PokemonCreatorController {
        val createPokemonUseCase = getCreatePokemonUseCase(view)
        val checkWinnerUseCase = getCheckWinnerUseCase(view)
        return PokemonCreatorController(createPokemonUseCase, checkWinnerUseCase)
    }
}