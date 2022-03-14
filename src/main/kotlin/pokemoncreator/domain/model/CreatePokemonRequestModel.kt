package pokemoncreator.domain.model

data class CreatePokemonRequestModel(
    val name: String,
    val description: String,
    val type: String,
    val power: Int,
    val color: String,
)