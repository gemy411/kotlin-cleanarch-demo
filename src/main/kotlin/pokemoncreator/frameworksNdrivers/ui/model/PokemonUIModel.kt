package pokemoncreator.frameworksNdrivers.ui.model

import pokemoncreator.entity.model.PokemonColors
import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.entity.model.PokemonType

data class PokemonUIModel(
    val name: String,
    val description: String,
    val type: PokemonType,
    val power: Int,
    val color: PokemonColors,
)

fun PokemonDataEntity.toUI() = PokemonUIModel(
    name = name ,
    description = description,
    type = type,
    power = power,
    color = color,
)