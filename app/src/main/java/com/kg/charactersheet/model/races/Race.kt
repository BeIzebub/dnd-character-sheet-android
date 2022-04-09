package com.kg.charactersheet.model.races

import com.kg.charactersheet.model.Ability
import com.kg.charactersheet.model.Skill

abstract class Race {

    protected val abilityBonuses = mutableMapOf<Ability, Int>()

    val statBonuses: Map<Ability, Int>
    get() = abilityBonuses

    abstract val size: Size

    abstract val speed: Int

    abstract val languages: List<String>

    abstract val skillProficiencies: List<Skill>

    abstract val miscProficiencies: List<String>

    abstract val miscBenefits: List<String>

    abstract val darkVision: Boolean


    abstract val maxHPBonus: Int
}

enum class Size(val title: String) {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large"),
    HUGE("Huge"),
    GARGANTUAN("Gargantuan")
}