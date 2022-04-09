package com.kg.charactersheet.model.races

import com.kg.charactersheet.model.Ability
import com.kg.charactersheet.model.Skill

class HillDwarf : Dwarf(){


    init {
        abilityBonuses[Ability.WIS] = 1
    }

    override val skillProficiencies: List<Skill>
        get() = listOf()


    override val maxHPBonus: Int
        get() = 1
}