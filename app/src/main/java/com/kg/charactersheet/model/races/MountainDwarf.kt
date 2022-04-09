package com.kg.charactersheet.model.races

import com.kg.charactersheet.model.Ability
import com.kg.charactersheet.model.Skill

class MountainDwarf : Dwarf() {


    init {
        abilityBonuses[Ability.STR] = 2
        miscProficiencies.add("Light armor")
        miscProficiencies.add("Medium Armor")
    }

    override val skillProficiencies: List<Skill>
        get() = listOf()


    override val maxHPBonus: Int
        get() = 0
}