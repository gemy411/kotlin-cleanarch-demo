package pokemoncreator.frameworksNdrivers.di

import pokemoncreator.frameworksNdrivers.network.remote.PokemonRemoteCreatorImpl
import pokemoncreator.interfaceadapters.controller.PokemonCreatorController
import pokemoncreator.interfaceadapters.gateway.PokemonCreatorImpl
import pokemoncreator.interfaceadapters.ports.PokemonView
import pokemoncreator.interfaceadapters.presenter.PokemonPresenter
import pokemoncreator.usecase.usecase.CreatePokemonUseCaseInteractor

object Injector {
    private fun getCreatePokemonUseCase(view: PokemonView): CreatePokemonUseCaseInteractor {
        val presenter = PokemonPresenter(view)
        val pokemonRemoteCreator = PokemonRemoteCreatorImpl()
        val pokemonCreator = PokemonCreatorImpl(pokemonRemoteCreator)
        return CreatePokemonUseCaseInteractor(pokemonCreator, presenter)
    }
    fun getPokemonCreatorController(view: PokemonView): PokemonCreatorController {
        val useCase = getCreatePokemonUseCase(view)
        return PokemonCreatorController(useCase)
    }
}