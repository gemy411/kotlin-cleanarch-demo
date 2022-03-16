package pokemoncreator.entity.rules

import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.entity.model.PokemonType.*

fun PokemonDataEntity.canBeat(otherPokemon: PokemonDataEntity): Boolean {
    val higherPower = this.power > otherPokemon.power
    val classUpperHand = when (this.type) {
        FIRE  -> otherPokemon.type != FIRE
        EARTH -> otherPokemon.type == WATER
        WATER -> otherPokemon.type != FIRE
    }
    return listOf(higherPower, classUpperHand)[(0..1).random()]
}