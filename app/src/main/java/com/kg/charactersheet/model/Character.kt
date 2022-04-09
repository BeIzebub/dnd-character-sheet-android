package com.kg.charactersheet.model

import com.kg.charactersheet.model.backgrounds.Background
import com.kg.charactersheet.model.classes.Klass
import com.kg.charactersheet.model.races.Race

class Character(
        val name: String, val background: Background, val race: Race, val lvl1Class: Klass,
        startingStr: Int = 8,
        startingDex: Int = 8,
        startingCon: Int = 8,
        startingInt: Int = 8,
        startingWiz: Int = 8,
        startingCha: Int = 8
) {

    private var proficiencyBonus = 2

    private val classes = mutableListOf<Klass>()

    private val skillProficiencies = mutableListOf<Skill>()

    private val abilityScores = mutableMapOf<Ability, Int>()

    init {
        abilityScores[Ability.STR] = startingStr
        abilityScores[Ability.DEX] = startingDex
        abilityScores[Ability.CON] = startingCon
        abilityScores[Ability.INT] = startingInt
        abilityScores[Ability.WIS] = startingWiz
        abilityScores[Ability.CHA] = startingCha

        race.statBonuses.forEach {
            changeAbilityScoreBy(it.key, it.value)
        }

        skillProficiencies.addAll(background.skillProficiencies)
        race.skillProficiencies.forEach {
            if (skillProficiencies.contains(it)) {
                //TODO(implement this case - user can freely choose any other skill)
            } else {
                skillProficiencies.add(it)
            }
        }
        // TODO: class features should be added here too
    }

    val passivePerception
        get() = 10 + getAbilityModifier(Ability.WIS)

    val armorClass: Int
        get() {
            var ac = 10 + getAbilityModifier(Ability.DEX)
//            if (hasArmor) {
//                ac = armor.ac(getAbilityModifier(Ability.DEX))
//            } else {
//                ac += classBonus
//            }
            return ac
        }


    // can be used for shield/mage armor/magic items etc
    private var acBonus = 0
    val acWithBonus
        get() = armorClass + acBonus

    fun addACBonus(bonus: Int) {
        acBonus = bonus
    }

    fun removeACBonus() {
        acBonus = 0
    }

    fun getAbilityScore(ability: Ability) = abilityScores[ability]!!

    fun getAbilityModifier(ability: Ability) = (abilityScores[ability]!! - 10) / 2

    fun getSkillBonus(skill: Skill) = getAbilityModifier(skill.ability) +
            if (skillProficiencies.contains(skill)) proficiencyBonus else 0

    fun setAbilityScore(ability: Ability, score: Int) {
        abilityScores[ability] = score
    }

    fun changeAbilityScoreBy(ability: Ability, change: Int) {
        setAbilityScore(ability, getAbilityScore(ability) + change)
    }
}

enum class Ability {
    STR,
    DEX,
    CON,
    INT,
    WIS,
    CHA
}

enum class Skill(val title: String, val ability: Ability) {

    ATHLETICS("Athletics", Ability.STR),

    ACROBATICS("Acrobatics", Ability.DEX),
    SLEIGHT_OF_HAND("Sleight of hand", Ability.DEX),
    STEALTH("Stealth", Ability.DEX),

    ARCANA("Arcana", Ability.INT),
    HISTORY("History", Ability.INT),
    INVESTIGATION("Investigation", Ability.INT),
    NATURE("Nature", Ability.INT),
    RELIGION("Religion", Ability.INT),

    ANIMAL_HANDLING("Animal Handling", Ability.WIS),
    INSIGHT("Insight", Ability.WIS),
    MEDICINE("Medicine", Ability.WIS),
    PERCEPTION("Perception", Ability.WIS),
    SURVIVAL("Survival", Ability.WIS),

    DECEPTION("Deception", Ability.CHA),
    INTIMIDATION("Intimidation", Ability.CHA),
    PERFORMANCE("Performance", Ability.CHA),
    PERSUASION("Persuasion", Ability.CHA)
}