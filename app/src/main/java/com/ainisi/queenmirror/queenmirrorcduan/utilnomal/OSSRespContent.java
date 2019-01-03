package com.ainisi.queenmirror.queenmirrorcduan.utilnomal;

import java.io.Serializable;

/**
 * @author jiangchao
 * @Module.OSS - STS
 * @Create.Date 2018/6/7 下午4:34
 * @Update.By jiangchao
 * @Update.Content
 * @Update.Date 2018/6/7 下午4:34
 * @see
 */


public class OSSRespContent  implements Serializable{


    /**
     * success : true
     * errorCode : 0
     * msg : 临时上传凭证已生成
     * body : {"accessKeyId":"STS.NHGv71CU9yf9nKJcKiVwXk3c9","accessKeySecret":"85e2PogcwCaz6Lnmep6CbUrZuVeBkyo44yfcxMdooDrc","securityToken":"CAISkwJ1q6Ft5B2yfSjIr4vyPY2FrooYzqTSbG37h0s8Wvh0hPbI2zz2IHlPeXBgAeoWv/Uwnm5W5/YelqB6T55OSAmcNZIoATCIVtblMeT7oMWQweEuuv/MQBquaXPS2MvVfJ+OLrf0ceusbFbpjzJ6xaCAGxypQ12iN+/m6/Ngdc9FHHP7D1x8CcxROxFppeIDKHLVLozNCBPxhXfKB0ca3WgZgGhku6Ok2Z/euFiMzn+Ck7VE/tWsc8T9NpQzYM0mCu3YhrImKvDztwdL8AVP+atMi6hJxCzKpNn1ASMKuk7barqMqI0+fVAjOPZrS/Je3/H4lOxlvOvIjJjwyBtLMuxTXj7WWIe62szAFfMC1RS/5j42URqAARPKSHVQUGEMvyD32HeGmnk7jZm4u1g41sEBIMdbxon8Ix1fn2qsoL8DS3txnXZrqaR2YAIVctm6PL3nYoUqFWIR/gQ411bmEe2ZcJl48ZWcAYdzQ52LxcpwqYxLobTm4CPh+4pgjL4cil/YNJQ+3kEmIXLuLJ6ZmfFlMfm5DtTP","expiration":"2018-06-07 19:07:16"}
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

    public static class BodyEntity implements Serializable{
        /**
         * accessKeyId : STS.NHGv71CU9yf9nKJcKiVwXk3c9
         * accessKeySecret : 85e2PogcwCaz6Lnmep6CbUrZuVeBkyo44yfcxMdooDrc
         * securityToken : CAISkwJ1q6Ft5B2yfSjIr4vyPY2FrooYzqTSbG37h0s8Wvh0hPbI2zz2IHlPeXBgAeoWv/Uwnm5W5/YelqB6T55OSAmcNZIoATCIVtblMeT7oMWQweEuuv/MQBquaXPS2MvVfJ+OLrf0ceusbFbpjzJ6xaCAGxypQ12iN+/m6/Ngdc9FHHP7D1x8CcxROxFppeIDKHLVLozNCBPxhXfKB0ca3WgZgGhku6Ok2Z/euFiMzn+Ck7VE/tWsc8T9NpQzYM0mCu3YhrImKvDztwdL8AVP+atMi6hJxCzKpNn1ASMKuk7barqMqI0+fVAjOPZrS/Je3/H4lOxlvOvIjJjwyBtLMuxTXj7WWIe62szAFfMC1RS/5j42URqAARPKSHVQUGEMvyD32HeGmnk7jZm4u1g41sEBIMdbxon8Ix1fn2qsoL8DS3txnXZrqaR2YAIVctm6PL3nYoUqFWIR/gQ411bmEe2ZcJl48ZWcAYdzQ52LxcpwqYxLobTm4CPh+4pgjL4cil/YNJQ+3kEmIXLuLJ6ZmfFlMfm5DtTP
         * expiration : 2018-06-07 19:07:16
         */

        private String accessKeyId;
        private String accessKeySecret;
        private String securityToken;
        private String expiration;

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }

        public String getSecurityToken() {
            return securityToken;
        }

        public void setSecurityToken(String securityToken) {
            this.securityToken = securityToken;
        }

        public String getExpiration() {
            return expiration;
        }

        public void setExpiration(String expiration) {
            this.expiration = expiration;
        }
    }
}
