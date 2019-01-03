package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.util.List;

/**
 * Created by john on 2018/5/28.
 */

public class ProblemDataBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取常见问题列表按分类成功
     * body : {"QaListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecQa":{"id":"14fa9ad1cb114d60a04f08c119321833","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"qaType":"1","qaQuestion":"埃文斯的股份","qaAnswer":"去WAESDGF","topClicks":2,"enableFlag":"0"},"qaTypeLabel":null,"enableFlagLabel":null}]}
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
        private List<QaListDataBean> QaListData;

        public List<QaListDataBean> getQaListData() {
            return QaListData;
        }

        public void setQaListData(List<QaListDataBean> QaListData) {
            this.QaListData = QaListData;
        }

        public static class QaListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecQa : {"id":"14fa9ad1cb114d60a04f08c119321833","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"qaType":"1","qaQuestion":"埃文斯的股份","qaAnswer":"去WAESDGF","topClicks":2,"enableFlag":"0"}
             * qaTypeLabel : null
             * enableFlagLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcQaBean ecQa;
            private Object qaTypeLabel;
            private Object enableFlagLabel;

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

            public EcQaBean getEcQa() {
                return ecQa;
            }

            public void setEcQa(EcQaBean ecQa) {
                this.ecQa = ecQa;
            }

            public Object getQaTypeLabel() {
                return qaTypeLabel;
            }

            public void setQaTypeLabel(Object qaTypeLabel) {
                this.qaTypeLabel = qaTypeLabel;
            }

            public Object getEnableFlagLabel() {
                return enableFlagLabel;
            }

            public void setEnableFlagLabel(Object enableFlagLabel) {
                this.enableFlagLabel = enableFlagLabel;
            }

            public static class EcQaBean {
                /**
                 * id : 14fa9ad1cb114d60a04f08c119321833
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * qaType : 1
                 * qaQuestion : 埃文斯的股份
                 * qaAnswer : 去WAESDGF
                 * topClicks : 2
                 * enableFlag : 0
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String qaType;
                private String qaQuestion;
                private String qaAnswer;
                private int topClicks;
                private String enableFlag;

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

                public String getQaType() {
                    return qaType;
                }

                public void setQaType(String qaType) {
                    this.qaType = qaType;
                }

                public String getQaQuestion() {
                    return qaQuestion;
                }

                public void setQaQuestion(String qaQuestion) {
                    this.qaQuestion = qaQuestion;
                }

                public String getQaAnswer() {
                    return qaAnswer;
                }

                public void setQaAnswer(String qaAnswer) {
                    this.qaAnswer = qaAnswer;
                }

                public int getTopClicks() {
                    return topClicks;
                }

                public void setTopClicks(int topClicks) {
                    this.topClicks = topClicks;
                }

                public String getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(String enableFlag) {
                    this.enableFlag = enableFlag;
                }
            }
        }
    }
}
