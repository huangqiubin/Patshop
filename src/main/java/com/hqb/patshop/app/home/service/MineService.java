package com.hqb.patshop.app.home.service;

import com.hqb.patshop.app.home.domain.BidOnLookResult;
import com.hqb.patshop.app.home.domain.BidSaleResult;
import com.hqb.patshop.app.home.domain.MineContentResult;

/**
 * 首页我的Service
 */

public interface MineService {

    MineContentResult mineContent(String userName);

    BidSaleResult bidSaleContent(String userName);

    BidOnLookResult bidOnLookContent(String userName);
}
