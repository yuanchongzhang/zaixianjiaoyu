package com.project.zaixianjiaoyu.model;

import java.util.List;

/**
 * Created by Administrator on 2017/1/23.
 */

public class Contains {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 1
         * transfer_price : 1000.00
         * status : 1
         * money : 1024.99
         * period : 3
         * borrow_name : 余钱宝第一期
         * borrow_interest_rate : 10.00
         * period_cn : 期
         */

        private String id;
        private String transfer_price;
        private String status;
        private String money;
        private String period;
        private String borrow_name;
        private String borrow_interest_rate;
        private String period_cn;

        @Override
        public String toString() {
            return "ListBean{" +
                    "id='" + id + '\'' +
                    ", transfer_price='" + transfer_price + '\'' +
                    ", status='" + status + '\'' +
                    ", money='" + money + '\'' +
                    ", period='" + period + '\'' +
                    ", borrow_name='" + borrow_name + '\'' +
                    ", borrow_interest_rate='" + borrow_interest_rate + '\'' +
                    "period_cn='" + period_cn + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTransfer_price() {
            return transfer_price;
        }

        public void setTransfer_price(String transfer_price) {
            this.transfer_price = transfer_price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getBorrow_name() {
            return borrow_name;
        }

        public void setBorrow_name(String borrow_name) {
            this.borrow_name = borrow_name;
        }

        public String getBorrow_interest_rate() {
            return borrow_interest_rate;
        }

        public void setBorrow_interest_rate(String borrow_interest_rate) {
            this.borrow_interest_rate = borrow_interest_rate;
        }

        public String getPeriod_cn() {
            return period_cn;
        }

        public void setPeriod_cn(String period_cn) {
            this.period_cn = period_cn;
        }
    }


    @Override
    public String toString() {
        return "Contains{" +
                "list='" + list + '\'' +
                '}';
    }

}
