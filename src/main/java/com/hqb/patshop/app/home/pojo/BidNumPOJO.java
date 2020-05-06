package com.hqb.patshop.app.home.pojo;

/**
 * 我的参拍、围观、足迹中间层
 * 为了避免返回大量不必要的数据
 * 做一层中间层
 */
public class BidNumPOJO {
    //参拍
    private int bidNum;
    //围观
    private int onLooks;
    //足迹
    private int footPrint;

    public int getBidNum() {
        return bidNum;
    }

    public void setBidNum(int bidNum) {
        this.bidNum = bidNum;
    }

    public int getOnLooks() {
        return onLooks;
    }

    public void setOnLooks(int onLooks) {
        this.onLooks = onLooks;
    }

    public int getFootPrint() {
        return footPrint;
    }

    public void setFootPrint(int footPrint) {
        this.footPrint = footPrint;
    }

    @Override
    public String toString() {
        return "BidNumPOJO{" +
                "bidNum=" + bidNum +
                ", onLooks=" + onLooks +
                ", footPrint=" + footPrint +
                '}';
    }
}
