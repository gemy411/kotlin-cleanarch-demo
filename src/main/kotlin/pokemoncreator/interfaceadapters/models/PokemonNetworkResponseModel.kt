package pokemoncreator.interfaceadapters.models

import pokemoncreator.entity.model.PokemonColors
import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.entity.model.PokemonType

data class PokemonNetworkResponseModel(
    val name: String,
    val description: String,
    val type: String,
    val power: Int,
    val color: String,
)

fun PokemonNetworkResponseModel.toEntity() = PokemonDataEntity(
    name,
    description,
    PokemonType.values().find { it.name.lowercase() == type.lowercase() } ?: throw IllegalArgumentException("Type not supported!"),
    power,
    PokemonColors.values().find { it.name.lowercase() == color.lowercase() } ?: throw IllegalArgumentException("Color not supported!"),
)