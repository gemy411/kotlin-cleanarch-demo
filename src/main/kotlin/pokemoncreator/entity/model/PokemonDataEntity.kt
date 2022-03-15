package pokemoncreator.entity.model

data class PokemonDataEntity(
    val name: String,
    val description: String,
    val type: PokemonType,
    val power: Int,
    val color: PokemonColors,
)
