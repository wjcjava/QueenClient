package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * 作者：linxi on 2018/10/30 09:50
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class UserInfoListBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"list":[{"gpOrderId":"58262f49036c476ca394597041f45914","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"8091e7eef8f24eba8cfd948a06290ebb","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"72446f2cd00b472cb0235ffbfa8af259","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"89e08f73dd544efdb8146073291f9337","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"17e9133629b14be59059a9e968411bfe","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"a870f6d1f1ab4e0f9f83ecf283884b9e","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"e99fe5dcf892460097863af2967297d4","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"4bfe5bdf7a8a4b019a2031b9731bf055","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"e14e5d553e49409787c5ffa044250e58","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"7e35eb4c66014ae28938cdaaa60bf8c3","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"3ee950dc3e134d669d1fd67d49494849","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"5bb366e89d7a416793a7e129867840c1","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"49b3dac301f44b19b5e46aad070646b8","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"ba3eb1db3c6b44d19a2dfd24a184c86f","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"},{"gpOrderId":"7de907f484bb45ffae1967c7b1f2fe56","headPic":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg","cellPhone":"150****4634"}]}
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

        public static class ListBean {
            /**
             * gpOrderId : 58262f49036c476ca394597041f45914
             * headPic : https://nwptest.oss-cn-hangzhou.aliyuncs.com/img/2018-10-08/1538975090240.jpg
             * cellPhone : 150****4634
             */

            private String gpOrderId;
            private String headPic;
            private String cellPhone;

            public String getGpOrderId() {
                return gpOrderId;
            }

            public void setGpOrderId(String gpOrderId) {
                this.gpOrderId = gpOrderId;
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public String getCellPhone() {
                return cellPhone;
            }

            public void setCellPhone(String cellPhone) {
                this.cellPhone = cellPhone;
            }
        }
    }
}
