package pokemoncreator.usecase.usecase.model

data class CreatePokemonRequestModel(
    val name: String,
    val description: String,
    val type: String,
    val power: Int,
    val color: String,
)