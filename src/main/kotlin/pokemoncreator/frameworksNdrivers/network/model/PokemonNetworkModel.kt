package pokemoncreator.frameworksNdrivers.network.model

import pokemoncreator.entity.model.PokemonDataEntity

data class PokemonNetworkModel(
    val name: String,
    val description: String,
    val type: String,
    val power: Int,
    val color: String,
)

fun PokemonNetworkModel.toEntity() = PokemonDataEntity(
    name, description, type, power, color
)