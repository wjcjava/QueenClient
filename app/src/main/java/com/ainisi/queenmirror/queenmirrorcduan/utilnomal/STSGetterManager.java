package com.ainisi.queenmirror.queenmirrorcduan.utilnomal;

import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;

/**
 * 重载OSSFederationCredentialProvider
 * 自动加载从后台获取的AK、SK、token
 *
 * @author jiangchao
 *         created at 2018/6/17 上午12:50
 */

public class STSGetterManager extends OSSFederationCredentialProvider {

    private OSSRespContent OSSRespContent;

    @Override
    public OSSFederationToken getFederationToken() {
        try {
            String access_key_id = OSSRespContent.getBody().getAccessKeyId();
            String access_key_secret = OSSRespContent.getBody().getAccessKeySecret();
            String security_token = OSSRespContent.getBody().getSecurityToken();
            String expiration = OSSRespContent.getBody().getExpiration();
            return new OSSFederationToken(access_key_id, access_key_secret, security_token, expiration);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public OSSRespContent getOSSRespContent() {
        return OSSRespContent;
    }

    public void setOSSRespContent(OSSRespContent OSSRespContent) {
        this.OSSRespContent = OSSRespContent;
    }
}
