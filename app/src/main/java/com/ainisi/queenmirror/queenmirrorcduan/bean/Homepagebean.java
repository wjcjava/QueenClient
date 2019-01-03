package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/6/29.
 */

public class Homepagebean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"DistrictListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"101345e1ff1f45f99c7c76d90417ec6a","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"常熟市","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"275e8c0e1ac34bf5a8313470da493ed6","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"吴中区","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"337289fd68bb4af980141cae1446869f","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"相城区","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"35bcf3686b924abab7792355b49e3300","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"吴江区","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"695e9e2928594ff783ccb040362981a0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"高新区","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"75264cc64883495ea2906efd982e2c24","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"工业园区","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"82940b2f6a3b4730b05bfe55e4af7a1d","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"其他","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"856f3d41203041279c942f6acd5873d3","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"昆山市","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"92fb5d2fa8aa48ecab1c0fd2b8fb980d","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"太仓市","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"db3913d4bfd44c8dbaa373b49624781d","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"姑苏区","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"f98bb05841e14d709ea8b96c7ac6360c","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"张家港市","sort":30,"code":null,"type":null,"parentId":"0"},"typeLabel":null,"parentId":"0"}]}
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
        private List<DistrictListDataBean> DistrictListData;

        public List<DistrictListDataBean> getDistrictListData() {
            return DistrictListData;
        }

        public void setDistrictListData(List<DistrictListDataBean> DistrictListData) {
            this.DistrictListData = DistrictListData;
        }

        public static class DistrictListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * parentIds : null
             * name : null
             * sort : 30
             * area : {"id":"101345e1ff1f45f99c7c76d90417ec6a","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"常熟市","sort":30,"code":null,"type":null,"parentId":"0"}
             * typeLabel : null
             * parentId : 0
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object parentIds;
            private Object name;
            private int sort;
            private AreaBean area;
            private Object typeLabel;
            private String parentId;

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

            public Object getParentIds() {
                return parentIds;
            }

            public void setParentIds(Object parentIds) {
                this.parentIds = parentIds;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public AreaBean getArea() {
                return area;
            }

            public void setArea(AreaBean area) {
                this.area = area;
            }

            public Object getTypeLabel() {
                return typeLabel;
            }

            public void setTypeLabel(Object typeLabel) {
                this.typeLabel = typeLabel;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public static class AreaBean {
                /**
                 * id : 101345e1ff1f45f99c7c76d90417ec6a
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * parentIds : null
                 * name : 常熟市
                 * sort : 30
                 * code : null
                 * type : null
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object parentIds;
                private String name;
                private int sort;
                private Object code;
                private Object type;
                private String parentId;

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

                public Object getParentIds() {
                    return parentIds;
                }

                public void setParentIds(Object parentIds) {
                    this.parentIds = parentIds;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public Object getCode() {
                    return code;
                }

                public void setCode(Object code) {
                    this.code = code;
                }

                public Object getType() {
                    return type;
                }

                public void setType(Object type) {
                    this.type = type;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }
            }
        }
    }
}
