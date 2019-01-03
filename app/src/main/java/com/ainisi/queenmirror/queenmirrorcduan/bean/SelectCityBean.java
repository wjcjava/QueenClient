package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class SelectCityBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CityListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"1d436cc3c3984c189aff6ef671f1f011","isNewRecord":false,"remarks":"","createDate":"2018-05-03 13:09:00","updateDate":"2018-05-03 13:09:00","parentIds":"0,1,96d85c39cdc346f78b0424a39fa33680,","name":"宁波市","sort":30,"code":"","type":"3","parentId":"96d85c39cdc346f78b0424a39fa33680"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"364a832bee8a42afa333e338813330de","isNewRecord":false,"remarks":"","createDate":"2015-12-24 21:38:02","updateDate":"2018-05-03 13:06:35","parentIds":"0,1,c11497c3311a4be29253f29bd59ab485,","name":"南京市","sort":30,"code":"","type":"3","parentId":"c11497c3311a4be29253f29bd59ab485"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"3f70bd7e2ce6446b9692a3808f716029","isNewRecord":false,"remarks":"","createDate":"2018-05-03 13:07:09","updateDate":"2018-05-03 13:07:09","parentIds":"0,1,c11497c3311a4be29253f29bd59ab485,","name":"苏州市","sort":30,"code":"","type":"3","parentId":"c11497c3311a4be29253f29bd59ab485"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"b7752a98deb74b779fbd772e2b453671","isNewRecord":false,"remarks":"","createDate":"2018-05-03 13:05:14","updateDate":"2018-05-03 13:05:14","parentIds":"0,1,90ecd439eb3845db97a627d9242145e8,","name":"上海市","sort":30,"code":"021","type":"3","parentId":"90ecd439eb3845db97a627d9242145e8"},"typeLabel":null,"parentId":"0"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":null,"sort":30,"area":{"id":"de5430bf008e4f71b7f6d78fd763186a","isNewRecord":false,"remarks":"","createDate":"2018-05-03 13:08:19","updateDate":"2018-05-03 13:08:19","parentIds":"0,1,96d85c39cdc346f78b0424a39fa33680,","name":"杭州市","sort":30,"code":"","type":"3","parentId":"96d85c39cdc346f78b0424a39fa33680"},"typeLabel":null,"parentId":"0"}]}
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
        private List<CityListDataBean> CityListData;

        public List<CityListDataBean> getCityListData() {
            return CityListData;
        }

        public void setCityListData(List<CityListDataBean> CityListData) {
            this.CityListData = CityListData;
        }

        public static class CityListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * parentIds : null
             * name : null
             * sort : 30
             * area : {"id":"1d436cc3c3984c189aff6ef671f1f011","isNewRecord":false,"remarks":"","createDate":"2018-05-03 13:09:00","updateDate":"2018-05-03 13:09:00","parentIds":"0,1,96d85c39cdc346f78b0424a39fa33680,","name":"宁波市","sort":30,"code":"","type":"3","parentId":"96d85c39cdc346f78b0424a39fa33680"}
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
                 * id : 1d436cc3c3984c189aff6ef671f1f011
                 * isNewRecord : false
                 * remarks :
                 * createDate : 2018-05-03 13:09:00
                 * updateDate : 2018-05-03 13:09:00
                 * parentIds : 0,1,96d85c39cdc346f78b0424a39fa33680,
                 * name : 宁波市
                 * sort : 30
                 * code :
                 * type : 3
                 * parentId : 96d85c39cdc346f78b0424a39fa33680
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private String createDate;
                private String updateDate;
                private String parentIds;
                private String name;
                private int sort;
                private String code;
                private String type;
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

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
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

                public String getParentIds() {
                    return parentIds;
                }

                public void setParentIds(String parentIds) {
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

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
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
