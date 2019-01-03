package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class LoginBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 登录成功
     * body : {"apiAnsCustBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansCustBasic":{"id":"ef488bc5182a4e3cb6a097903652d05a","isNewRecord":false,"remarks":null,"createDate":"2018-06-20 10:18:39","updateDate":"2018-06-20 10:18:39","contractConfirm":"0","cellPhone":"13405024815","deviceToken":"Aud22RtBrz4OtAcEUQ7Qk9elX2eF5qLilPYngsRBHa5g","userName":"13405024815","userPass":"02eaf3a6d2b2afebb5a00c78ebe1579b","wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":1529461119000,"nickName":null,"loginIp":"192.168.50.246","logininTime":1529489054000,"loginoutTime":null,"loginFlag":"1","recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":"ApiUserRegisterController"},"nameIdentifyLabel":null,"sexLabel":null,"loginFlagLabel":null,"delFlagLabel":null,"contractConfirmLabel":null},"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1Mjk2MzAyNTMsInVzZXJJRCI6ImVmNDg4YmM1MTgyYTRlM2NiNmEwOTc5MDM2NTJkMDVhIiwiaWF0IjoxNTI5NTQzODUzfQ.fqHskWcoiySBSfNfXSf2Zf4b7kA1MNbfcktcVn0nR8s","userId":"ef488bc5182a4e3cb6a097903652d05a"}
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
         * apiAnsCustBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansCustBasic":{"id":"ef488bc5182a4e3cb6a097903652d05a","isNewRecord":false,"remarks":null,"createDate":"2018-06-20 10:18:39","updateDate":"2018-06-20 10:18:39","contractConfirm":"0","cellPhone":"13405024815","deviceToken":"Aud22RtBrz4OtAcEUQ7Qk9elX2eF5qLilPYngsRBHa5g","userName":"13405024815","userPass":"02eaf3a6d2b2afebb5a00c78ebe1579b","wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":1529461119000,"nickName":null,"loginIp":"192.168.50.246","logininTime":1529489054000,"loginoutTime":null,"loginFlag":"1","recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":"ApiUserRegisterController"},"nameIdentifyLabel":null,"sexLabel":null,"loginFlagLabel":null,"delFlagLabel":null,"contractConfirmLabel":null}
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1Mjk2MzAyNTMsInVzZXJJRCI6ImVmNDg4YmM1MTgyYTRlM2NiNmEwOTc5MDM2NTJkMDVhIiwiaWF0IjoxNTI5NTQzODUzfQ.fqHskWcoiySBSfNfXSf2Zf4b7kA1MNbfcktcVn0nR8s
         * userId : ef488bc5182a4e3cb6a097903652d05a
         */

        private ApiAnsCustBasicBean apiAnsCustBasic;
        private String token;
        private String userId;

        public ApiAnsCustBasicBean getApiAnsCustBasic() {
            return apiAnsCustBasic;
        }

        public void setApiAnsCustBasic(ApiAnsCustBasicBean apiAnsCustBasic) {
            this.apiAnsCustBasic = apiAnsCustBasic;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public static class ApiAnsCustBasicBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansCustBasic : {"id":"ef488bc5182a4e3cb6a097903652d05a","isNewRecord":false,"remarks":null,"createDate":"2018-06-20 10:18:39","updateDate":"2018-06-20 10:18:39","contractConfirm":"0","cellPhone":"13405024815","deviceToken":"Aud22RtBrz4OtAcEUQ7Qk9elX2eF5qLilPYngsRBHa5g","userName":"13405024815","userPass":"02eaf3a6d2b2afebb5a00c78ebe1579b","wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":1529461119000,"nickName":null,"loginIp":"192.168.50.246","logininTime":1529489054000,"loginoutTime":null,"loginFlag":"1","recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":"ApiUserRegisterController"}
             * nameIdentifyLabel : null
             * sexLabel : null
             * loginFlagLabel : null
             * delFlagLabel : null
             * contractConfirmLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsCustBasicBean ansCustBasic;
            private Object nameIdentifyLabel;
            private Object sexLabel;
            private Object loginFlagLabel;
            private Object delFlagLabel;
            private Object contractConfirmLabel;

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

            public AnsCustBasicBean getAnsCustBasic() {
                return ansCustBasic;
            }

            public void setAnsCustBasic(AnsCustBasicBean ansCustBasic) {
                this.ansCustBasic = ansCustBasic;
            }

            public Object getNameIdentifyLabel() {
                return nameIdentifyLabel;
            }

            public void setNameIdentifyLabel(Object nameIdentifyLabel) {
                this.nameIdentifyLabel = nameIdentifyLabel;
            }

            public Object getSexLabel() {
                return sexLabel;
            }

            public void setSexLabel(Object sexLabel) {
                this.sexLabel = sexLabel;
            }

            public Object getLoginFlagLabel() {
                return loginFlagLabel;
            }

            public void setLoginFlagLabel(Object loginFlagLabel) {
                this.loginFlagLabel = loginFlagLabel;
            }

            public Object getDelFlagLabel() {
                return delFlagLabel;
            }

            public void setDelFlagLabel(Object delFlagLabel) {
                this.delFlagLabel = delFlagLabel;
            }

            public Object getContractConfirmLabel() {
                return contractConfirmLabel;
            }

            public void setContractConfirmLabel(Object contractConfirmLabel) {
                this.contractConfirmLabel = contractConfirmLabel;
            }

            public static class AnsCustBasicBean {
                /**
                 * id : ef488bc5182a4e3cb6a097903652d05a
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-06-20 10:18:39
                 * updateDate : 2018-06-20 10:18:39
                 * contractConfirm : 0
                 * cellPhone : 13405024815
                 * deviceToken : Aud22RtBrz4OtAcEUQ7Qk9elX2eF5qLilPYngsRBHa5g
                 * userName : 13405024815
                 * userPass : 02eaf3a6d2b2afebb5a00c78ebe1579b
                 * wechatId : null
                 * wechatToken : null
                 * qqId : null
                 * qqToken : null
                 * completeFlag : null
                 * headPic : null
                 * lastName : null
                 * firstName : null
                 * idCard : null
                 * nameIdentify : null
                 * sex : null
                 * birthday : null
                 * registerDate : 1529461119000
                 * nickName : null
                 * loginIp : 192.168.50.246
                 * logininTime : 1529489054000
                 * loginoutTime : null
                 * loginFlag : 1
                 * recommendUser : null
                 * recommendCode : null
                 * updatBy : null
                 * updatePgm : ApiUserRegisterController
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String contractConfirm;
                private String cellPhone;
                private String deviceToken;
                private String userName;
                private String userPass;
                private Object wechatId;
                private Object wechatToken;
                private Object qqId;
                private Object qqToken;
                private Object completeFlag;
                private String headPic;
                private Object lastName;
                private Object firstName;
                private Object idCard;
                private Object nameIdentify;
                private Object sex;
                private Object birthday;
                private long registerDate;
                private Object nickName;
                private String loginIp;
                private long logininTime;
                private Object loginoutTime;
                private String loginFlag;
                private Object recommendUser;
                private Object recommendCode;
                private Object updatBy;
                private String updatePgm;

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
                }

                public String getHeadPic() {
                    return headPic;
                }

                public void setHeadPic(String headPic) {
                    this.headPic = headPic;
                }

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

                public String getContractConfirm() {
                    return contractConfirm;
                }

                public void setContractConfirm(String contractConfirm) {
                    this.contractConfirm = contractConfirm;
                }

                public String getCellPhone() {
                    return cellPhone;
                }

                public void setCellPhone(String cellPhone) {
                    this.cellPhone = cellPhone;
                }

                public String getDeviceToken() {
                    return deviceToken;
                }

                public void setDeviceToken(String deviceToken) {
                    this.deviceToken = deviceToken;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getUserPass() {
                    return userPass;
                }

                public void setUserPass(String userPass) {
                    this.userPass = userPass;
                }

                public Object getWechatId() {
                    return wechatId;
                }

                public void setWechatId(Object wechatId) {
                    this.wechatId = wechatId;
                }

                public Object getWechatToken() {
                    return wechatToken;
                }

                public void setWechatToken(Object wechatToken) {
                    this.wechatToken = wechatToken;
                }

                public Object getQqId() {
                    return qqId;
                }

                public void setQqId(Object qqId) {
                    this.qqId = qqId;
                }

                public Object getQqToken() {
                    return qqToken;
                }

                public void setQqToken(Object qqToken) {
                    this.qqToken = qqToken;
                }

                public Object getCompleteFlag() {
                    return completeFlag;
                }

                public void setCompleteFlag(Object completeFlag) {
                    this.completeFlag = completeFlag;
                }

                public Object getLastName() {
                    return lastName;
                }

                public void setLastName(Object lastName) {
                    this.lastName = lastName;
                }

                public Object getFirstName() {
                    return firstName;
                }

                public void setFirstName(Object firstName) {
                    this.firstName = firstName;
                }

                public Object getIdCard() {
                    return idCard;
                }

                public void setIdCard(Object idCard) {
                    this.idCard = idCard;
                }

                public Object getNameIdentify() {
                    return nameIdentify;
                }

                public void setNameIdentify(Object nameIdentify) {
                    this.nameIdentify = nameIdentify;
                }

                public Object getSex() {
                    return sex;
                }

                public void setSex(Object sex) {
                    this.sex = sex;
                }

                public Object getBirthday() {
                    return birthday;
                }

                public void setBirthday(Object birthday) {
                    this.birthday = birthday;
                }

                public long getRegisterDate() {
                    return registerDate;
                }

                public void setRegisterDate(long registerDate) {
                    this.registerDate = registerDate;
                }

                public Object getNickName() {
                    return nickName;
                }

                public void setNickName(Object nickName) {
                    this.nickName = nickName;
                }

                public String getLoginIp() {
                    return loginIp;
                }

                public void setLoginIp(String loginIp) {
                    this.loginIp = loginIp;
                }

                public long getLogininTime() {
                    return logininTime;
                }

                public void setLogininTime(long logininTime) {
                    this.logininTime = logininTime;
                }

                public Object getLoginoutTime() {
                    return loginoutTime;
                }

                public void setLoginoutTime(Object loginoutTime) {
                    this.loginoutTime = loginoutTime;
                }

                public String getLoginFlag() {
                    return loginFlag;
                }

                public void setLoginFlag(String loginFlag) {
                    this.loginFlag = loginFlag;
                }

                public Object getRecommendUser() {
                    return recommendUser;
                }

                public void setRecommendUser(Object recommendUser) {
                    this.recommendUser = recommendUser;
                }

                public Object getRecommendCode() {
                    return recommendCode;
                }

                public void setRecommendCode(Object recommendCode) {
                    this.recommendCode = recommendCode;
                }

                public Object getUpdatBy() {
                    return updatBy;
                }

                public void setUpdatBy(Object updatBy) {
                    this.updatBy = updatBy;
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
