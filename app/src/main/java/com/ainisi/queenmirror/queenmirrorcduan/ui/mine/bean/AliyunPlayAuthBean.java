package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

/**
 * Created by jiangchao on 2018/9/10 下午5:18.
 */


public class AliyunPlayAuthBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 成功
     * body : {"playAuth":"eyJTZWN1cml0eVRva2VuIjoiQ0FJUzN3SjFxNkZ0NUIyeWZTaklyNG5sZVBETTJKZHo0SVdSTm1ENWtWVTdTUDUrbGFMUGx6ejJJSGhKZVhOdkJPMGV0ZjQrbVdCWTdQY1lsck1xRWM0Y0ZCR1ZNWklwczhzTHExcjRKcExGc3QySjZyOEpqc1Y2bCsxc3YxcXBzdlhKYXNEVkVma3VFNVhFTWlJNS8wMGU2TC8rY2lyWVhEN0JHSmFWaUpsaFE4MEtWdzJqRjFSdkQ4dFhJUTBRazYxOUszemRaOW1nTGlidWkzdnhDa1J2MkhCaWptOHR4cW1qL015UTV4MzFpMXYweStCM3dZSHRPY3FjYThCOU1ZMVdUc3Uxdm9oemFyR1Q2Q3BaK2psTStxQVU2cWxZNG1YcnM5cUhFa0ZOd0JpWFNaMjJsT2RpTndoa2ZLTTNOcmRacGZ6bjc1MUN0L2ZVaXA3OHhtUW1YNGdYY1Z5R0dOLzZuNU9aUXJ6emI0WmhKZWVsQVJtWGpJRFRiS3VTbWhnL2ZIY1dPRGxOZjljY01YSnFBWFF1TUdxQ2QvTDlwdzJYT2x6NUd2WFZnUHRuaTRBSjVsSHA3TWVNR1YrRGVMeVF5aDBFSWFVN2EwNDQvNWVUWWFwazFNVWFnQUU3LzFvMytZSm1CdCtCL1J0YUttSE9KOWd4eDhTbldLSmtCWEpXVzJqU1ViTnpIdXFEODlSNmhOZ3VoZlZxWjJSWXorU1ZNMGhOZ3U0THhtL0oxUzNhWW93ZkFGNDBhZEMrbnhlRnlIZkt0ejZ2VVVabDk1dWZNdnZ0NVl6ZStDZEdGbWFxaHlVY1pJQmgyTE1ZcU40V2VrSklLWVlseWFkTmxDd1RYY2gxT1E9PSIsIkF1dGhJbmZvIjoie1wiQ2FsbGVyXCI6XCJ2NFRZMzNLTEpEM1JzaVJRTk1vaVJvMS9aQjVjWmVmRGdXZnRsUTRWckJrPVxcclxcblwiLFwiRXhwaXJlVGltZVwiOlwiMjAxOC0wOS0xMFQwOToxODowM1pcIixcIk1lZGlhSWRcIjpcIjZlOGM4ZWU3MTJhZjRjZWVhNjhlY2JkZmZiYjZiZTUzXCIsXCJTaWduYXR1cmVcIjpcInRGUVlpVUtZN20zYllpYTM3blZMQUx3RUFBQT1cIn0iLCJWaWRlb01ldGEiOnsiU3RhdHVzIjoiTm9ybWFsIiwiVmlkZW9JZCI6IjZlOGM4ZWU3MTJhZjRjZWVhNjhlY2JkZmZiYjZiZTUzIiwiVGl0bGUiOiJPSyIsIkNvdmVyVVJMIjoiaHR0cDovL3Yuaml5dWFuZXQuY29tLzZlOGM4ZWU3MTJhZjRjZWVhNjhlY2JkZmZiYjZiZTUzL2NvdmVycy82YTJkMjQzNjk5OTM0NDAxOGJjODUxNjg3NDJiYTQwMi0wMDAwMS5qcGciLCJEdXJhdGlvbiI6Ny44NDl9LCJBY2Nlc3NLZXlJZCI6IlNUUy5OSlAzSng1SFJXR3o0Rkh1VW5EcVJ6Z2R1IiwiUGxheURvbWFpbiI6InYuaml5dWFuZXQuY29tIiwiQWNjZXNzS2V5U2VjcmV0IjoiRXladGNCdHhMVkdSMUxyYmJoWGpISndYdFZpQnp3TTlHZzVyemFaOUI0WlEiLCJSZWdpb24iOiJjbi1zaGFuZ2hhaSIsIkN1c3RvbWVySWQiOjEyOTE5NTk0MTE1NzQyMTF9"}
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
         * playAuth : eyJTZWN1cml0eVRva2VuIjoiQ0FJUzN3SjFxNkZ0NUIyeWZTaklyNG5sZVBETTJKZHo0SVdSTm1ENWtWVTdTUDUrbGFMUGx6ejJJSGhKZVhOdkJPMGV0ZjQrbVdCWTdQY1lsck1xRWM0Y0ZCR1ZNWklwczhzTHExcjRKcExGc3QySjZyOEpqc1Y2bCsxc3YxcXBzdlhKYXNEVkVma3VFNVhFTWlJNS8wMGU2TC8rY2lyWVhEN0JHSmFWaUpsaFE4MEtWdzJqRjFSdkQ4dFhJUTBRazYxOUszemRaOW1nTGlidWkzdnhDa1J2MkhCaWptOHR4cW1qL015UTV4MzFpMXYweStCM3dZSHRPY3FjYThCOU1ZMVdUc3Uxdm9oemFyR1Q2Q3BaK2psTStxQVU2cWxZNG1YcnM5cUhFa0ZOd0JpWFNaMjJsT2RpTndoa2ZLTTNOcmRacGZ6bjc1MUN0L2ZVaXA3OHhtUW1YNGdYY1Z5R0dOLzZuNU9aUXJ6emI0WmhKZWVsQVJtWGpJRFRiS3VTbWhnL2ZIY1dPRGxOZjljY01YSnFBWFF1TUdxQ2QvTDlwdzJYT2x6NUd2WFZnUHRuaTRBSjVsSHA3TWVNR1YrRGVMeVF5aDBFSWFVN2EwNDQvNWVUWWFwazFNVWFnQUU3LzFvMytZSm1CdCtCL1J0YUttSE9KOWd4eDhTbldLSmtCWEpXVzJqU1ViTnpIdXFEODlSNmhOZ3VoZlZxWjJSWXorU1ZNMGhOZ3U0THhtL0oxUzNhWW93ZkFGNDBhZEMrbnhlRnlIZkt0ejZ2VVVabDk1dWZNdnZ0NVl6ZStDZEdGbWFxaHlVY1pJQmgyTE1ZcU40V2VrSklLWVlseWFkTmxDd1RYY2gxT1E9PSIsIkF1dGhJbmZvIjoie1wiQ2FsbGVyXCI6XCJ2NFRZMzNLTEpEM1JzaVJRTk1vaVJvMS9aQjVjWmVmRGdXZnRsUTRWckJrPVxcclxcblwiLFwiRXhwaXJlVGltZVwiOlwiMjAxOC0wOS0xMFQwOToxODowM1pcIixcIk1lZGlhSWRcIjpcIjZlOGM4ZWU3MTJhZjRjZWVhNjhlY2JkZmZiYjZiZTUzXCIsXCJTaWduYXR1cmVcIjpcInRGUVlpVUtZN20zYllpYTM3blZMQUx3RUFBQT1cIn0iLCJWaWRlb01ldGEiOnsiU3RhdHVzIjoiTm9ybWFsIiwiVmlkZW9JZCI6IjZlOGM4ZWU3MTJhZjRjZWVhNjhlY2JkZmZiYjZiZTUzIiwiVGl0bGUiOiJPSyIsIkNvdmVyVVJMIjoiaHR0cDovL3Yuaml5dWFuZXQuY29tLzZlOGM4ZWU3MTJhZjRjZWVhNjhlY2JkZmZiYjZiZTUzL2NvdmVycy82YTJkMjQzNjk5OTM0NDAxOGJjODUxNjg3NDJiYTQwMi0wMDAwMS5qcGciLCJEdXJhdGlvbiI6Ny44NDl9LCJBY2Nlc3NLZXlJZCI6IlNUUy5OSlAzSng1SFJXR3o0Rkh1VW5EcVJ6Z2R1IiwiUGxheURvbWFpbiI6InYuaml5dWFuZXQuY29tIiwiQWNjZXNzS2V5U2VjcmV0IjoiRXladGNCdHhMVkdSMUxyYmJoWGpISndYdFZpQnp3TTlHZzVyemFaOUI0WlEiLCJSZWdpb24iOiJjbi1zaGFuZ2hhaSIsIkN1c3RvbWVySWQiOjEyOTE5NTk0MTE1NzQyMTF9
         */

        private String playAuth;

        public String getPlayAuth() {
            return playAuth;
        }

        public void setPlayAuth(String playAuth) {
            this.playAuth = playAuth;
        }
    }
}
