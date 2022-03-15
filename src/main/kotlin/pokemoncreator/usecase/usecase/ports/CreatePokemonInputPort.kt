package pokemoncreator.usecase.usecase.ports

import pokemoncreator.usecase.usecase.model.CreatePokemonRequestModel

interface CreatePokemonInputPort {
    suspend fun execute(createPokemonRequestModel: CreatePokemonRequestModel)
}