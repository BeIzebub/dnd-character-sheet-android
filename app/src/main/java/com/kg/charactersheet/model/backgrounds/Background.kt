package com.kg.charactersheet.model.backgrounds

import com.kg.charactersheet.model.Skill

abstract class Background {

    abstract val skillProficiencies: List<Skill>

    abstract val toolProficiencies: List<String>

    abstract val languages: List<String>

    abstract val miscBenefits: List<String>

    abstract val equipment: List<String>

    abstract val moneyCP: Long
}