package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * @author jiangchao
 * @Module.Name
 * @Create.Date 2018/6/11 下午3:13
 * @Update.By jiangchao
 * @Update.Content
 * @Update.Date 2018/6/11 下午3:13
 * @see
 */


public class DemoListModel {

    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"messList":[{"id":"1","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"messId":"1","messType":"1","receiverObject":"2","senderId":"","receiverId":"1094c9cdd90a42e8b7407642283c7dd2","ifRead":"1","messDetails":"内容测试详情","sendDate":"2018-06-14 17:00:20.0"}],"pageSum":1}
     */

    private boolean success;
    private String errorCode;
    private String msg;
    private BodyEntity body;

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

    public BodyEntity getBody() {
        return body;
    }

    public void setBody(BodyEntity body) {
        this.body = body;
    }

    public static class BodyEntity {
        /**
         * messList : [{"id":"1","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"messId":"1","messType":"1","receiverObject":"2","senderId":"","receiverId":"1094c9cdd90a42e8b7407642283c7dd2","ifRead":"1","messDetails":"内容测试详情","sendDate":"2018-06-14 17:00:20.0"}]
         * pageSum : 1
         */

        private int pageSum;
        private List<MessListEntity> messList;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<MessListEntity> getMessList() {
            return messList;
        }

        public void setMessList(List<MessListEntity> messList) {
            this.messList = messList;
        }

        public static class MessListEntity {
            /**
             * id : 1
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * messId : 1
             * messType : 1
             * receiverObject : 2
             * senderId :
             * receiverId : 1094c9cdd90a42e8b7407642283c7dd2
             * ifRead : 1
             * messDetails : 内容测试详情
             * sendDate : 2018-06-14 17:00:20.0
             */

            private String fansName;

            public String getFansName() {
                return fansName;
            }

            public void setFansName(String fansName) {
                this.fansName = fansName;
            }

            public MessListEntity(String fansName) {
                this.fansName = fansName;
            }
        }
    }
}
