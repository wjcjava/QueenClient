package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

/**
 * Created by john on 2018/5/23.
 */

public class QueenDeiailsBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取女王详情成功
     * body : {"QueenCardData":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansQueenCard":{"id":"a02e6cd2c2c24d6e9a1224abe299be7c","isNewRecord":false,"remarks":null,"createDate":"2018-04-18 09:35:14","updateDate":"2018-04-18 09:35:14","custId":"123","cardNo":"123456","cardBalance":234,"enableFlag":"0","updatePgm":"111"},"enableFlagLabel":"有效"}}
     */

    private boolean success;
    private String errorCode;
    private String msg;
    private BodyBean body;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * QueenCardData : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansQueenCard":{"id":"a02e6cd2c2c24d6e9a1224abe299be7c","isNewRecord":false,"remarks":null,"createDate":"2018-04-18 09:35:14","updateDate":"2018-04-18 09:35:14","custId":"123","cardNo":"123456","cardBalance":234,"enableFlag":"0","updatePgm":"111"},"enableFlagLabel":"有效"}
         */

        private QueenCardDataBean QueenCardData;

        public QueenCardDataBean getQueenCardData() {
            return QueenCardData;
        }

        public void setQueenCardData(QueenCardDataBean QueenCardData) {
            this.QueenCardData = QueenCardData;
        }

        public static class QueenCardDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansQueenCard : {"id":"a02e6cd2c2c24d6e9a1224abe299be7c","isNewRecord":false,"remarks":null,"createDate":"2018-04-18 09:35:14","updateDate":"2018-04-18 09:35:14","custId":"123","cardNo":"123456","cardBalance":234,"enableFlag":"0","updatePgm":"111"}
             * enableFlagLabel : 有效
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsQueenCardBean ansQueenCard;
            private String enableFlagLabel;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public Object getRemarks() {
                return remarks;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public Object getCreateDate() {
                return createDate;
            }

            public void setCreateDate(Object createDate) {
                this.createDate = createDate;
            }

            public Object getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(Object updateDate) {
                this.updateDate = updateDate;
            }

            public AnsQueenCardBean getAnsQueenCard() {
                return ansQueenCard;
            }

            public void setAnsQueenCard(AnsQueenCardBean ansQueenCard) {
                this.ansQueenCard = ansQueenCard;
            }

            public String getEnableFlagLabel() {
                return enableFlagLabel;
            }

            public void setEnableFlagLabel(String enableFlagLabel) {
                this.enableFlagLabel = enableFlagLabel;
            }

            public static class AnsQueenCardBean {
                /**
                 * id : a02e6cd2c2c24d6e9a1224abe299be7c
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-04-18 09:35:14
                 * updateDate : 2018-04-18 09:35:14
                 * custId : 123
                 * cardNo : 123456
                 * cardBalance : 234
                 * enableFlag : 0
                 * updatePgm : 111
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String custId;
                private String cardNo;
                private String cardBalance;
                private String enableFlag;
                private String updatePgm;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public Object getRemarks() {
                    return remarks;
                }

                public void setRemarks(Object remarks) {
                    this.remarks = remarks;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public String getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(String updateDate) {
                    this.updateDate = updateDate;
                }

                public String getCustId() {
                    return custId;
                }

                public void setCustId(String custId) {
                    this.custId = custId;
                }

                public String getCardNo() {
                    return cardNo;
                }

                public void setCardNo(String cardNo) {
                    this.cardNo = cardNo;
                }

                public String getCardBalance() {
                    return cardBalance;
                }

                public void setCardBalance(String cardBalance) {
                    this.cardBalance = cardBalance;
                }

                public String getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(String enableFlag) {
                    this.enableFlag = enableFlag;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }
        }
    }
}
