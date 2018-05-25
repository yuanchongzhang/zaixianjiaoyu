package com.project.zaixianjiaoyu.model;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */

public class BannerModel {


    /**
     * banner : [{"img":"http://www.rongzecf.com/UF/Uploads/Ad/20170327140802100.jpg","url":"http://www.rongzecf.com","title":"融泽财富投资"},{"img":"http://www.rongzecf.com/UF/Uploads/Ad/20170327140802647.jpg","url":"http://www.rongzecf.com","title":"融泽财富投资"}]
     * banner_middle : [{"img":"http://www.rongzecf.com/UF/Uploads/Ad/20170327140958795.jpg","url":"http://www.rongzecf.com","title":"融泽财富投资"}]
     * borrow_list : [{"id":"28","borrow_name":"个人汽车抵押借款","borrow_interest_rate":"9.00","borrow_duration":"6","borrow_duration_cn":"个月","need":"0.00","progress":"100.00"}]
     * notice : [{"id":"163","title":"辽宁电视台邀请融泽财富给大家拜年","type_id":"361"},{"id":"127","title":"感恩八月，从业人员及机构资源区正式开通","type_id":"361"},{"id":"126","title":"专家顾问","type_id":"361"}]
     * friend_list : [{"link_img":"http://www.rongzecf.com/UF/Uploads/Friends/20170424112307303.png"},{"link_img":"http://www.rongzecf.com/UF/Uploads/Friends/2017042411242588.png"},{"link_img":"http://www.rongzecf.com/UF/Uploads/Friends/20170424112510770.jpg"},{"link_img":"http://www.rongzecf.com/UF/Uploads/Friends/20170424112528928.png"},{"link_img":"http://www.rongzecf.com/UF/Uploads/Friends/20170424112546264.png"}]
     * news_id : 412
     * status : 1
     */

    private String news_id;
    private String status;
    private List<BannerBean> banner;
    private List<BannerMiddleBean> banner_middle;
    private List<BorrowListBean> borrow_list;
    private List<NoticeBean> notice;
    private List<FriendListBean> friend_list;

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<BannerMiddleBean> getBanner_middle() {
        return banner_middle;
    }

    public void setBanner_middle(List<BannerMiddleBean> banner_middle) {
        this.banner_middle = banner_middle;
    }

    public List<BorrowListBean> getBorrow_list() {
        return borrow_list;
    }

    public void setBorrow_list(List<BorrowListBean> borrow_list) {
        this.borrow_list = borrow_list;
    }

    public List<NoticeBean> getNotice() {
        return notice;
    }

    public void setNotice(List<NoticeBean> notice) {
        this.notice = notice;
    }

    public List<FriendListBean> getFriend_list() {
        return friend_list;
    }

    public void setFriend_list(List<FriendListBean> friend_list) {
        this.friend_list = friend_list;
    }

    public static class BannerBean {
        /**
         * img : http://www.rongzecf.com/UF/Uploads/Ad/20170327140802100.jpg
         * url : http://www.rongzecf.com
         * title : 融泽财富投资
         */

        private String img;
        private String url;
        private String title;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class BannerMiddleBean {
        /**
         * img : http://www.rongzecf.com/UF/Uploads/Ad/20170327140958795.jpg
         * url : http://www.rongzecf.com
         * title : 融泽财富投资
         */

        private String img;
        private String url;
        private String title;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class BorrowListBean {
        /**
         * id : 28
         * borrow_name : 个人汽车抵押借款
         * borrow_interest_rate : 9.00
         * borrow_duration : 6
         * borrow_duration_cn : 个月
         * need : 0.00
         * progress : 100.00
         */

        private String id;
        private String borrow_name;
        private String borrow_interest_rate;
        private String borrow_duration;
        private String borrow_duration_cn;
        private String need;
        private String progress;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getBorrow_duration() {
            return borrow_duration;
        }

        public void setBorrow_duration(String borrow_duration) {
            this.borrow_duration = borrow_duration;
        }

        public String getBorrow_duration_cn() {
            return borrow_duration_cn;
        }

        public void setBorrow_duration_cn(String borrow_duration_cn) {
            this.borrow_duration_cn = borrow_duration_cn;
        }

        public String getNeed() {
            return need;
        }

        public void setNeed(String need) {
            this.need = need;
        }

        public String getProgress() {
            return progress;
        }

        public void setProgress(String progress) {
            this.progress = progress;
        }
    }

    public static class NoticeBean {
        /**
         * id : 163
         * title : 辽宁电视台邀请融泽财富给大家拜年
         * type_id : 361
         */

        private String id;
        private String title;
        private String type_id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }
    }

    public static class FriendListBean {
        /**
         * link_img : http://www.rongzecf.com/UF/Uploads/Friends/20170424112307303.png
         */

        private String link_img;

        public String getLink_img() {
            return link_img;
        }

        public void setLink_img(String link_img) {
            this.link_img = link_img;
        }
    }
}
