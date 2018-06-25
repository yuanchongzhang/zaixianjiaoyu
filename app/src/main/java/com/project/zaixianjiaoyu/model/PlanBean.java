package com.project.zaixianjiaoyu.model;

import java.util.List;

public class PlanBean {


    /**
     * Result : true
     * data : [{"gTrainPlanID":"9ceee80c-ac65-e811-88c8-842b2b00642e","cTrainPlanName":"201806","gEnterpriseID":"efd169b3-ab65-e811-88c8-842b2b00642e"},{"gTrainPlanID":"81a58ce4-1276-e811-bca8-842b2b00642e","cTrainPlanName":"201806培训计划","gEnterpriseID":"efd169b3-ab65-e811-88c8-842b2b00642e"}]
     * ErrorMessage :
     */

    private boolean Result;
    private String ErrorMessage;
    private List<DataBean> data;

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean Result) {
        this.Result = Result;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * gTrainPlanID : 9ceee80c-ac65-e811-88c8-842b2b00642e
         * cTrainPlanName : 201806
         * gEnterpriseID : efd169b3-ab65-e811-88c8-842b2b00642e
         */

        private String gTrainPlanID;
        private String cTrainPlanName;
        private String gEnterpriseID;

        public String getGTrainPlanID() {
            return gTrainPlanID;
        }

        public void setGTrainPlanID(String gTrainPlanID) {
            this.gTrainPlanID = gTrainPlanID;
        }

        public String getCTrainPlanName() {
            return cTrainPlanName;
        }

        public void setCTrainPlanName(String cTrainPlanName) {
            this.cTrainPlanName = cTrainPlanName;
        }

        public String getGEnterpriseID() {
            return gEnterpriseID;
        }

        public void setGEnterpriseID(String gEnterpriseID) {
            this.gEnterpriseID = gEnterpriseID;
        }
    }
}
