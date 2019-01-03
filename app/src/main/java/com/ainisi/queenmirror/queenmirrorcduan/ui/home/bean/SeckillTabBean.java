package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：linxi on 2018/9/28 10:21
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class SeckillTabBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"list":[{"id":"1","beginTime":"2018-10-09 10:01:24","endTime":"2018-10-10 02:41:24","state":"已秒杀","stateType":3,"countDownBeginTime":"00:00:00","countDownEndTime":"00:00:00"},{"id":"2","beginTime":"2018-10-10 10:02:11","endTime":"2018-10-11 02:42:11","state":"秒杀中","stateType":3,"countDownBeginTime":"00:00:00","countDownEndTime":"16:14:46"},{"id":"3","beginTime":"2018-10-10 23:02:11","endTime":"2018-10-11 15:42:11","state":"即将秒杀","stateType":3,"countDownBeginTime":"12:34:46","countDownEndTime":"29:14:46"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * id : 1
             * beginTime : 2018-10-09 10:01:24
             * endTime : 2018-10-10 02:41:24
             * state : 已秒杀
             * stateType : 3
             * countDownBeginTime : 00:00:00
             * countDownEndTime : 00:00:00
             */

            private String id;
            private String beginTime;
            private String endTime;
            private String state;
            private int stateType;
            private String countDownBeginTime;
            private String countDownEndTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getBeginTime() {
                return beginTime;
            }

            public void setBeginTime(String beginTime) {
                this.beginTime = beginTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getStateType() {
                return stateType;
            }

            public void setStateType(int stateType) {
                this.stateType = stateType;
            }

            public String getCountDownBeginTime() {
                return countDownBeginTime;
            }

            public void setCountDownBeginTime(String countDownBeginTime) {
                this.countDownBeginTime = countDownBeginTime;
            }

            public String getCountDownEndTime() {
                return countDownEndTime;
            }

            public void setCountDownEndTime(String countDownEndTime) {
                this.countDownEndTime = countDownEndTime;
            }
        }
    }
}
