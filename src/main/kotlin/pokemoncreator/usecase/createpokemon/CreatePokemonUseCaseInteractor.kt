package pokemoncreator.usecase.createpokemon

import pokemoncreator.usecase.createpokemon.model.CreatePokemonRequestModel
import pokemoncreator.usecase.createpokemon.ports.CreatePokemonInputPort
import pokemoncreator.usecase.createpokemon.ports.CreatePokemonOutputPort
import pokemoncreator.usecase.createpokemon.ports.PokemonCreator

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
