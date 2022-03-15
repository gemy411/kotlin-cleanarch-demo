package pokemoncreator.usecase.usecase.ports

import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.usecase.usecase.model.CreatePokemonRequestModel

interface PokemonCreator {
    suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDataEntity
}