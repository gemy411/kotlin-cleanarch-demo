package pokemoncreator.usecase.interactor

import pokemoncreator.usecase.interactor.model.CreatePokemonRequestModel
import pokemoncreator.usecase.interactor.ports.CreatePokemonInputPort
import pokemoncreator.usecase.interactor.ports.CreatePokemonOutputPort
import pokemoncreator.usecase.interactor.ports.PokemonCreator

class CreatePokemonUseCaseInteractor(
    private val pokemonCreator: PokemonCreator,
    private val outputPort: CreatePokemonOutputPort
): CreatePokemonInputPort {

    override suspend fun execute(createPokemonRequestModel: CreatePokemonRequestModel) {
        try {
            val pokemon = pokemonCreator.createPokemon(createPokemonRequestModel)
            outputPort.onFinishedCreatingPokemon(pokemon)
        } catch (e: Exception) {
            outputPort.onFailed(e.message ?: "Domain error!")
        }
    }
}