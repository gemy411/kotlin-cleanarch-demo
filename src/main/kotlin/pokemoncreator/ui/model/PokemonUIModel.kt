package pokemoncreator.ui.model

import pokemoncreator.domain.model.PokemonDomainModel
import pokemoncreator.interfaceadapters.controller.PokemonColors
import pokemoncreator.interfaceadapters.controller.PokemonType

data class PokemonUIModel(
    val name: String,
    val description: String,
    val type: PokemonType,
    val power: Int,
    val color: PokemonColors,
)

fun PokemonDomainModel.toUI() = PokemonUIModel(
    name = name ,
    description = description,
    type = PokemonType.values().find { it.name.lowercase() == type.lowercase() }!!,
    power = power,
    color = PokemonColors.values().find { it.name.lowercase() == color.lowercase() }!!
)