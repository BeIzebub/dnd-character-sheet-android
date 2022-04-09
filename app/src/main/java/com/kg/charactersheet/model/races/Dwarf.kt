package com.kg.charactersheet.model.races

import com.kg.charactersheet.model.Ability

abstract class Dwarf : Race() {

    init {
        abilityBonuses[Ability.CON] = 2
    }

    override val size: Size
        get() = Size.MEDIUM

    override val speed: Int
        get() = 25

    override val languages: List<String>
        get() = mutableListOf("Common", "Dwarvish")

    override val miscProficiencies: MutableList<String>
        get() = mutableListOf(
                "Battleaxe",
                "Handaxe",
                "Light hammer",
                "Warhammer",
                "Artisan's tools of your choice: smith's tools, brewer's tools, mason's tools"
        )

    override val miscBenefits: MutableList<String>
        get() = mutableListOf(
                "You have advantage on saving throws against poison and resistance against poison damage.",
                "You have double proficiency on history checks related to the origin of stonework"
        )

    override val darkVision: Boolean
        get() = true
}