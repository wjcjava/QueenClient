package com.ainisi.queenmirror.queenmirrorcduan.utilnomal;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

import java.util.HashMap;

/**
 * 支持普通上传,对OSS上传服务的封装
 *
 * @author jiangchao
 *         created at 2018/6/15 上午11:56
 */

public class OSSUtil {
    private static OSSUtil upLoadUtil;
    private OSS oss;
    private String bucket;
    private String callbackAddress;
    private ClientConfiguration conf;
    private STSGetterManager stsGetterManager;
    private Context mContext;

    /**
     * 初始化
     *
     * @return
     */
    public static OSSUtil getInstance() {
        if (null == upLoadUtil) {
            synchronized (OSSUtil.class) {
                if (null == upLoadUtil) {
                    upLoadUtil = new OSSUtil();
                }
            }
        }
        return upLoadUtil;
    }

    /**
     * 初始化oss(固定的 accessKeyId 与 accessKeySecret )
     *
     * @param context
     * @param accessKeyId
     * @param accessKeySecret
     * @param endPoint
     * @return
     */
    public OSSUtil initOSS(Context context, String accessKeyId, String accessKeySecret, String endPoint) {
        OSSPlainTextAKSKCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(accessKeyId, accessKeySecret);
        this.mContext = context;
        if (null == oss) {
            oss = new OSSClient(context, endPoint, credentialProvider, initConfiguration());
        }
        return upLoadUtil;
    }

    /**
     * 初始化oss(临时token)
     *
     * @param context     上下文
     * @param endPoint    域名
     * @param respContent 临时token
     * @return
     */
    public OSSUtil initOSS(Context context, String endPoint, OSSRespContent respContent) {
        //使用自己的获取STSToken的类
        if (null == stsGetterManager) {
            stsGetterManager = new STSGetterManager();
        }
        stsGetterManager.setOSSRespContent(respContent);

        this.mContext = context;
        if (null == oss) {
            oss = new OSSClient(context, endPoint, stsGetterManager, initConfiguration());
        }
        return upLoadUtil;
    }

    /**
     * 设置云储存空间名
     *
     * @param bucket
     * @return
     */
    public OSSUtil setBucket(String bucket) {
        this.bucket = bucket;
        return upLoadUtil;
    }

    /**
     * 上传图片
     *
     * @param object               定义的被上传的文件名
     * @param localFile            文件路径
     * @param userProgressCallback 上传文件时回调
     * @param userCallback         文件上传状态回调
     */
    public void asyncPutImage(String object,
                              String localFile, final OSSProgressCallback<PutObjectRequest> userProgressCallback
            , @NonNull final OSSCompletedCallback<PutObjectRequest, PutObjectResult> userCallback) {

        // 构造上传请求
        PutObjectRequest put = new PutObjectRequest(bucket, object, localFile);

        if (callbackAddress != null) {
            // 传入对应的上传回调参数，这里默认使用OSS提供的公共测试回调服务器地址
            put.setCallbackParam(new HashMap<String, String>() {
                {
                    put("callbackUrl", callbackAddress);
                    //callbackBody可以自定义传入的信息
                    put("callbackBody", "filename=${object}");
                }
            });
        }

        // 异步上传时可以设置进度回调
        if (userProgressCallback != null) {
            put.setProgressCallback(userProgressCallback);
        }

        oss.asyncPutObject(put, userCallback);
    }

    OSSAsyncTask task;


    /**
     * 上传图片
     *
     * @param object    定义的被上传的文件名
     * @param localFile 文件路径
     */
    public void asyncPutImage(String bucket, String object, String localFile) {
        PutObjectRequest put = new PutObjectRequest(bucket, object, localFile);
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
            }
        });
        task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, final PutObjectResult result) {
                L.e("PutObject", "UploadSuccess");
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                // Request exception
                if (clientExcepion != null) {
                    // Local exception, such as a network exception
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // Service exception
                }
            }
        });

// task.cancel(); // Cancel the task

// task.waitUntilFinished(); // Wait till the task is finished
    }


    /**
     * @param object
     * @param localFile            byte
     * @param userProgressCallback
     * @param userCallback
     */
    public void asyncPutImage(String object,
                              byte[] localFile, final OSSProgressCallback<PutObjectRequest> userProgressCallback
            , @NonNull final OSSCompletedCallback<PutObjectRequest, PutObjectResult> userCallback) {

        // 构造上传请求
        PutObjectRequest put = new PutObjectRequest(bucket, object, localFile);

        if (callbackAddress != null) {
            // 传入对应的上传回调参数，这里默认使用OSS提供的公共测试回调服务器地址
            put.setCallbackParam(new HashMap<String, String>() {
                {
                    put("callbackUrl", callbackAddress);
                    //callbackBody可以自定义传入的信息
                    put("callbackBody", "filename=${object}");
                }
            });
        }

        // 异步上传时可以设置进度回调
        if (userProgressCallback != null) {
            put.setProgressCallback(userProgressCallback);
        }

        oss.asyncPutObject(put, userCallback);
    }

    /**
     * @return
     */
    private ClientConfiguration initConfiguration() {
        if (null == conf) {
            conf = new ClientConfiguration();
            conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
            conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
            conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
            conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
        }
        return conf;
    }

    public void setCallbackAddress(String callbackAddress) {
        this.callbackAddress = callbackAddress;
    }
}
