package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/6/2.
 */

public class PreferentialBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"FeatureKeysListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecTab":{"id":"d84fd92e6ff54eeab74153e9f363b806","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabName":"111","openFlag":"0","tabCategory":"1","belongCate":"001b2f5ba54041eaa2c18de791b99045","belongCateName":null},"tabCategoryLabel":null,"openFlagLabel":null}]}
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
        private List<FeatureKeysListDataBean> FeatureKeysListData;

        public List<FeatureKeysListDataBean> getFeatureKeysListData() {
            return FeatureKeysListData;
        }

        public void setFeatureKeysListData(List<FeatureKeysListDataBean> FeatureKeysListData) {
            this.FeatureKeysListData = FeatureKeysListData;
        }

        public static class FeatureKeysListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecTab : {"id":"d84fd92e6ff54eeab74153e9f363b806","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabName":"111","openFlag":"0","tabCategory":"1","belongCate":"001b2f5ba54041eaa2c18de791b99045","belongCateName":null}
             * tabCategoryLabel : null
             * openFlagLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcTabBean ecTab;
            private Object tabCategoryLabel;
            private Object openFlagLabel;

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

            public EcTabBean getEcTab() {
                return ecTab;
            }

            public void setEcTab(EcTabBean ecTab) {
                this.ecTab = ecTab;
            }

            public Object getTabCategoryLabel() {
                return tabCategoryLabel;
            }

            public void setTabCategoryLabel(Object tabCategoryLabel) {
                this.tabCategoryLabel = tabCategoryLabel;
            }

            public Object getOpenFlagLabel() {
                return openFlagLabel;
            }

            public void setOpenFlagLabel(Object openFlagLabel) {
                this.openFlagLabel = openFlagLabel;
            }

            public static class EcTabBean {
                /**
                 * id : d84fd92e6ff54eeab74153e9f363b806
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * tabName : 111
                 * openFlag : 0
                 * tabCategory : 1
                 * belongCate : 001b2f5ba54041eaa2c18de791b99045
                 * belongCateName : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String tabName;
                private String openFlag;
                private String tabCategory;
                private String belongCate;
                private Object belongCateName;

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

                public String getTabName() {
                    return tabName;
                }

                public void setTabName(String tabName) {
                    this.tabName = tabName;
                }

                public String getOpenFlag() {
                    return openFlag;
                }

                public void setOpenFlag(String openFlag) {
                    this.openFlag = openFlag;
                }

                public String getTabCategory() {
                    return tabCategory;
                }

                public void setTabCategory(String tabCategory) {
                    this.tabCategory = tabCategory;
                }

                public String getBelongCate() {
                    return belongCate;
                }

                public void setBelongCate(String belongCate) {
                    this.belongCate = belongCate;
                }

                public Object getBelongCateName() {
                    return belongCateName;
                }

                public void setBelongCateName(Object belongCateName) {
                    this.belongCateName = belongCateName;
                }
            }
        }
    }
}
