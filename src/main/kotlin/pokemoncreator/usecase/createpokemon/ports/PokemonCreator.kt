package pokemoncreator.usecase.createpokemon.ports

import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.usecase.createpokemon.model.CreatePokemonRequestModel

interface PokemonCreator {
    suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDataEntity
}