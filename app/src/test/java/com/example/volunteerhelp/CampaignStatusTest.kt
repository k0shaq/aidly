package com.example.volunteerhelp

import com.example.volunteerhelp.model.CampaignStatus
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CampaignStatusTest {
    @Test
    fun fromStorage_mapsLegacyCompletedToGoalReached() {
        assertEquals(CampaignStatus.GOAL_REACHED, CampaignStatus.fromStorage(CampaignStatus.COMPLETED.name))
    }

    @Test
    fun fromStorage_mapsUnknownValueToActive() {
        assertEquals(CampaignStatus.ACTIVE, CampaignStatus.fromStorage("UNKNOWN_STATUS"))
    }

    @Test
    fun label_returnsUkrainianStatusText() {
        assertEquals("Активний", CampaignStatus.label(CampaignStatus.ACTIVE.name))
        assertEquals("Ціль досягнуто", CampaignStatus.label(CampaignStatus.GOAL_REACHED.name))
        assertEquals("Закрито", CampaignStatus.label(CampaignStatus.CLOSED.name))
        assertEquals("Звіт додано", CampaignStatus.label(CampaignStatus.REPORTED.name))
    }

    @Test
    fun canBeClosed_allowsActiveAndGoalReachedOnly() {
        assertTrue(CampaignStatus.canBeClosed(CampaignStatus.ACTIVE.name))
        assertTrue(CampaignStatus.canBeClosed(CampaignStatus.GOAL_REACHED.name))
        assertFalse(CampaignStatus.canBeClosed(CampaignStatus.CLOSED.name))
        assertFalse(CampaignStatus.canBeClosed(CampaignStatus.REPORTED.name))
    }

    @Test
    fun canReceiveReport_allowsClosedAndGoalReachedOnly() {
        assertTrue(CampaignStatus.canReceiveReport(CampaignStatus.CLOSED.name))
        assertTrue(CampaignStatus.canReceiveReport(CampaignStatus.GOAL_REACHED.name))
        assertFalse(CampaignStatus.canReceiveReport(CampaignStatus.ACTIVE.name))
        assertFalse(CampaignStatus.canReceiveReport(CampaignStatus.REPORTED.name))
    }
}
