package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/5/14.
 */

public class LabelBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"HotSearchKeysListData":[{"id":"46f8638d4975463e865364ce4ff505db","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"ecSearchKey":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"keyIndustry":null,"keyObject":null,"keyCategory":"052b2fcbe3e74cba9221e381d490b9f0","keyName":"213","keyAb":"123","keyClicks":12,"hotFlag":"1","keySorts":0,"keyCategoryName":null},"hotFlagLabel":null}]}
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
        private List<HotSearchKeysListDataBean> HotSearchKeysListData;

        public List<HotSearchKeysListDataBean> getHotSearchKeysListData() {
            return HotSearchKeysListData;
        }

        public void setHotSearchKeysListData(List<HotSearchKeysListDataBean> HotSearchKeysListData) {
            this.HotSearchKeysListData = HotSearchKeysListData;
        }

        public static class HotSearchKeysListDataBean {
            /**
             * id : 46f8638d4975463e865364ce4ff505db
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecSearchKey : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"keyIndustry":null,"keyObject":null,"keyCategory":"052b2fcbe3e74cba9221e381d490b9f0","keyName":"213","keyAb":"123","keyClicks":12,"hotFlag":"1","keySorts":0,"keyCategoryName":null}
             * hotFlagLabel : null
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcSearchKeyBean ecSearchKey;
            private Object hotFlagLabel;

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

            public EcSearchKeyBean getEcSearchKey() {
                return ecSearchKey;
            }

            public void setEcSearchKey(EcSearchKeyBean ecSearchKey) {
                this.ecSearchKey = ecSearchKey;
            }

            public Object getHotFlagLabel() {
                return hotFlagLabel;
            }

            public void setHotFlagLabel(Object hotFlagLabel) {
                this.hotFlagLabel = hotFlagLabel;
            }

            public static class EcSearchKeyBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * keyIndustry : null
                 * keyObject : null
                 * keyCategory : 052b2fcbe3e74cba9221e381d490b9f0
                 * keyName : 213
                 * keyAb : 123
                 * keyClicks : 12
                 * hotFlag : 1
                 * keySorts : 0
                 * keyCategoryName : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object keyIndustry;
                private Object keyObject;
                private String keyCategory;
                private String keyName;
                private String keyAb;
                private int keyClicks;
                private String hotFlag;
                private int keySorts;
                private Object keyCategoryName;

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

                public Object getKeyIndustry() {
                    return keyIndustry;
                }

                public void setKeyIndustry(Object keyIndustry) {
                    this.keyIndustry = keyIndustry;
                }

                public Object getKeyObject() {
                    return keyObject;
                }

                public void setKeyObject(Object keyObject) {
                    this.keyObject = keyObject;
                }

                public String getKeyCategory() {
                    return keyCategory;
                }

                public void setKeyCategory(String keyCategory) {
                    this.keyCategory = keyCategory;
                }

                public String getKeyName() {
                    return keyName;
                }

                public void setKeyName(String keyName) {
                    this.keyName = keyName;
                }

                public String getKeyAb() {
                    return keyAb;
                }

                public void setKeyAb(String keyAb) {
                    this.keyAb = keyAb;
                }

                public int getKeyClicks() {
                    return keyClicks;
                }

                public void setKeyClicks(int keyClicks) {
                    this.keyClicks = keyClicks;
                }

                public String getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(String hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public int getKeySorts() {
                    return keySorts;
                }

                public void setKeySorts(int keySorts) {
                    this.keySorts = keySorts;
                }

                public Object getKeyCategoryName() {
                    return keyCategoryName;
                }

                public void setKeyCategoryName(Object keyCategoryName) {
                    this.keyCategoryName = keyCategoryName;
                }
            }
        }
    }
}
