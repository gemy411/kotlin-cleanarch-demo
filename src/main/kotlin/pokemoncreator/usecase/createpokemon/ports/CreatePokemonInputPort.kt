package pokemoncreator.usecase.createpokemon.ports

import pokemoncreator.usecase.createpokemon.model.CreatePokemonRequestModel

interface CreatePokemonInputPort {
    suspend fun execute(createPokemonRequestModel: CreatePokemonRequestModel)
}
