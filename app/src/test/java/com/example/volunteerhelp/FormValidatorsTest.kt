package com.example.volunteerhelp

import com.example.volunteerhelp.util.FormLimits
import com.example.volunteerhelp.util.FormValidators
import org.junit.Assert.assertThrows
import org.junit.Test

class FormValidatorsTest {
    @Test
    fun validateName_acceptsValidName() {
        FormValidators.validateName("Олександр")
    }

    @Test
    fun validateName_rejectsBlankName() {
        assertThrows(IllegalArgumentException::class.java) {
            FormValidators.validateName("")
        }
    }

    @Test
    fun validateName_rejectsTooLongName() {
        val longName = "A".repeat(FormLimits.NAME_MAX + 1)

        assertThrows(IllegalArgumentException::class.java) {
            FormValidators.validateName(longName)
        }
    }

    @Test
    fun validateUsername_acceptsAllowedCharactersAndLength() {
        FormValidators.validateUsername("aidly.user_123")
    }

    @Test
    fun validateUsername_rejectsTooShortUsername() {
        val shortUsername = "a".repeat(FormLimits.USERNAME_MIN - 1)

        assertThrows(IllegalArgumentException::class.java) {
            FormValidators.validateUsername(shortUsername)
        }
    }

    @Test
    fun validateUsername_rejectsUnsupportedCharacters() {
        assertThrows(IllegalArgumentException::class.java) {
            FormValidators.validateUsername("волонтер")
        }
    }

    @Test
    fun validateCity_acceptsValidCity() {
        FormValidators.validateCity("Київ")
    }

    @Test
    fun validateCity_rejectsBlankCity() {
        assertThrows(IllegalArgumentException::class.java) {
            FormValidators.validateCity("")
        }
    }

    @Test
    fun validateMax_rejectsValueOverLimit() {
        assertThrows(IllegalArgumentException::class.java) {
            FormValidators.validateMax("abcd", max = 3, fieldName = "Поле")
        }
    }
}
