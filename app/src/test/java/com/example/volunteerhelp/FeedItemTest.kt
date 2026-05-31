package com.example.volunteerhelp

import com.example.volunteerhelp.model.Campaign
import com.example.volunteerhelp.model.FeedItem
import com.example.volunteerhelp.model.Report
import org.junit.Assert.assertEquals
import org.junit.Test

class FeedItemTest {
    @Test
    fun campaignItem_usesCampaignCreatedAtAsSortTime() {
        val campaign = Campaign(id = "campaign-1", createdAt = 1_000L)

        val item = FeedItem.CampaignItem(campaign)

        assertEquals(1_000L, item.sortTime)
    }

    @Test
    fun reportItem_usesReportCreatedAtAsSortTime() {
        val report = Report(id = "report-1", createdAt = 2_000L)

        val item = FeedItem.ReportItem(report)

        assertEquals(2_000L, item.sortTime)
    }

    @Test
    fun feedItems_canBeSortedByNewestFirst() {
        val oldCampaign = FeedItem.CampaignItem(Campaign(id = "old-campaign", createdAt = 100L))
        val newestReport = FeedItem.ReportItem(Report(id = "newest-report", createdAt = 300L))
        val middleCampaign = FeedItem.CampaignItem(Campaign(id = "middle-campaign", createdAt = 200L))

        val sorted = listOf(oldCampaign, newestReport, middleCampaign).sortedByDescending { it.sortTime }

        assertEquals(listOf(newestReport, middleCampaign, oldCampaign), sorted)
    }
}
