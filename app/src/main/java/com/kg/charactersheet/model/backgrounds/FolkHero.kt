package com.kg.charactersheet.model.backgrounds

import com.kg.charactersheet.model.Skill

class FolkHero : Background() {

    override val skillProficiencies: List<Skill>
        get() = listOf(Skill.ANIMAL_HANDLING, Skill.SURVIVAL)
    override val toolProficiencies: List<String>
        get() = listOf(
                "One type of artisan's tools",
                "Land vehicles"
        )
    override val languages: List<String>
        get() = listOf()
    override val miscBenefits: List<String>
        get() = listOf("You can find help, shelter with other common folk")
    override val equipment: List<String>
        get() = listOf(
                "A set of artisan's tools of your choice",
                "Shovel",
                "Iron pot",
                "Common clothes"
        )

    override val moneyCP: Long
        get() = 100
}