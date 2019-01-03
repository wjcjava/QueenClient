package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class AgreementBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 成功！
     * body : {"protocal":{"id":"1","isNewRecord":false,"remarks":"faef","createDate":null,"updateDate":null,"title":"tt","content":"&lt;span style=&quot;background-color: rgb(255, 0, 0);&quot;&gt;中文乱码&lt;br&gt;&lt;span style=&quot;font-weight: bold;&quot;&gt;&lt;/span&gt;&lt;span style=&quot;font-style: italic;&quot;&gt;&lt;span style=&quot;font-weight: bold;&quot;&gt;&lt;/span&gt;&lt;/span&gt;&lt;/span&gt;"}}
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
         * protocal : {"id":"1","isNewRecord":false,"remarks":"faef","createDate":null,"updateDate":null,"title":"tt","content":"&lt;span style=&quot;background-color: rgb(255, 0, 0);&quot;&gt;中文乱码&lt;br&gt;&lt;span style=&quot;font-weight: bold;&quot;&gt;&lt;/span&gt;&lt;span style=&quot;font-style: italic;&quot;&gt;&lt;span style=&quot;font-weight: bold;&quot;&gt;&lt;/span&gt;&lt;/span&gt;&lt;/span&gt;"}
         */

        private ProtocalBean protocal;

        public ProtocalBean getProtocal() {
            return protocal;
        }

        public void setProtocal(ProtocalBean protocal) {
            this.protocal = protocal;
        }

        public static class ProtocalBean {
            /**
             * id : 1
             * isNewRecord : false
             * remarks : faef
             * createDate : null
             * updateDate : null
             * title : tt
             * content : &lt;span style=&quot;background-color: rgb(255, 0, 0);&quot;&gt;中文乱码&lt;br&gt;&lt;span style=&quot;font-weight: bold;&quot;&gt;&lt;/span&gt;&lt;span style=&quot;font-style: italic;&quot;&gt;&lt;span style=&quot;font-weight: bold;&quot;&gt;&lt;/span&gt;&lt;/span&gt;&lt;/span&gt;
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private Object createDate;
            private Object updateDate;
            private String title;
            private String content;

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

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
