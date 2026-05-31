package com.example.volunteerhelp

import com.example.volunteerhelp.model.Campaign
import com.example.volunteerhelp.model.CampaignStatus
import com.example.volunteerhelp.model.CampaignType
import com.example.volunteerhelp.model.HelpRequest
import com.example.volunteerhelp.model.HelpRequestStatus
import com.example.volunteerhelp.model.ProfileStats
import com.example.volunteerhelp.model.Report
import com.example.volunteerhelp.model.User
import com.example.volunteerhelp.model.UserRole
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Test

class ModelDefaultsTest {
    @Test
    fun user_hasDonorRoleAndUnverifiedStateByDefault() {
        val user = User()

        assertEquals(UserRole.DONOR.name, user.role)
        assertFalse(user.isVerified)
        assertEquals(0, user.rating)
        assertNull(user.avatarUrl)
    }

    @Test
    fun campaign_hasFinancialActiveStateByDefault() {
        val campaign = Campaign()

        assertEquals(CampaignType.FINANCIAL.name, campaign.type)
        assertEquals(CampaignStatus.ACTIVE.name, campaign.status)
        assertEquals(0.0, campaign.currentAmount, 0.0)
        assertEquals(0.0, campaign.targetAmount, 0.0)
    }

    @Test
    fun helpRequest_hasPendingFinancialStateByDefault() {
        val request = HelpRequest()

        assertEquals(CampaignType.FINANCIAL.name, request.type)
        assertEquals(HelpRequestStatus.PENDING.name, request.status)
        assertEquals(0.0, request.amount, 0.0)
    }

    @Test
    fun report_hasEmptyContentByDefault() {
        val report = Report()

        assertEquals("", report.id)
        assertEquals("", report.campaignId)
        assertEquals("", report.description)
        assertNull(report.imageUrl)
    }

    @Test
    fun profileStats_hasZeroCountersByDefault() {
        val stats = ProfileStats()

        assertEquals(0, stats.totalCampaigns)
        assertEquals(0, stats.approvedHelpCount)
        assertEquals(0, stats.rating)
        assertEquals(0.0, stats.totalDonatedAmount, 0.0)
    }
}
