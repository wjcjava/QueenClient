package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by john on 2018/5/10.
 */

public class HomeIndustryBean implements Serializable{


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CategoryListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"052b2fcbe3e74cba9221e381d490b9f0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"银行保险","tabPic":null,"tabKeyword":"YHBX","tabDesc":"银行保险","tabSorts":"12","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"26264efa932944b89d2c739b84b6002b","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"休闲娱乐","tabPic":null,"tabKeyword":"XXYL","tabDesc":"休闲娱乐","tabSorts":"2","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"5db93f5c225a4856b72752c075644461","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"珠宝首饰","tabPic":null,"tabKeyword":"ZBSS","tabDesc":"珠宝首饰","tabSorts":"10","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"779c1c0dbb4c40fead0df9c1c18c7c3a","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"酒店","tabPic":null,"tabKeyword":"JD","tabDesc":"酒店","tabSorts":"8","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"7b3310c8702c49938642658220720c35","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"运动健身","tabPic":null,"tabKeyword":"YDJS","tabDesc":"运动健身","tabSorts":"5","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"aa35843c173a451a80053d269da0e874","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"教育培训","tabPic":null,"tabKeyword":"JYPX","tabDesc":"教育培训","tabSorts":"7","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"c93f724061614fbaa6d65f1403cb42ab","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"爱车服务","tabPic":null,"tabKeyword":"ACFW","tabDesc":"爱车服务","tabSorts":"6","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"d502b6c59b4e4ef08af60a6f76d87762","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"亲子","tabPic":null,"tabKeyword":"QZ","tabDesc":"亲子","tabSorts":"9","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"d5ecccbf6fd649b8aa43a1a135dd6605","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"旅游","tabPic":null,"tabKeyword":"LY","tabDesc":"旅游","tabSorts":"1","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"d6faa03eafc1495d9b915be5d3a14231","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"购物","tabPic":null,"tabKeyword":"GW","tabDesc":"购物","tabSorts":"4","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"de3cb2ab3c1b49b79329350cdf32fcd0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"医疗健康","tabPic":null,"tabKeyword":"YLJK","tabDesc":"医疗健康","tabSorts":"3","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"e6bca29a6ec54f1d849e93b8faed168e","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"幼儿培训","tabPic":null,"tabKeyword":"YEPX","tabDesc":"幼儿培训","tabSorts":"5","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"f5011adcb2474d329f72775ed7fb2574","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"婚庆摄影","tabPic":null,"tabKeyword":"HQSY","tabDesc":"婚庆摄影","tabSorts":"11","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null},"tabTypeLabel":null,"openFlagLabel":null}]}
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

    public static class BodyBean implements Serializable{
        private List<CategoryListDataBean> CategoryListData;

        public List<CategoryListDataBean> getCategoryListData() {
            return CategoryListData;
        }

        public void setCategoryListData(List<CategoryListDataBean> CategoryListData) {
            this.CategoryListData = CategoryListData;
        }

        public static class CategoryListDataBean implements Serializable{
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecCategory : {"id":"052b2fcbe3e74cba9221e381d490b9f0","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"4","tabName":"银行保险","tabPic":null,"tabKeyword":"YHBX","tabDesc":"银行保险","tabSorts":"12","fatherId":"0","allFathers":null,"categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null,"fatherName":null}
             * tabTypeLabel : null
             * openFlagLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcCategoryBean ecCategory;
            private Object tabTypeLabel;
            private Object openFlagLabel;

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

            public EcCategoryBean getEcCategory() {
                return ecCategory;
            }

            public void setEcCategory(EcCategoryBean ecCategory) {
                this.ecCategory = ecCategory;
            }

            public Object getTabTypeLabel() {
                return tabTypeLabel;
            }

            public void setTabTypeLabel(Object tabTypeLabel) {
                this.tabTypeLabel = tabTypeLabel;
            }

            public Object getOpenFlagLabel() {
                return openFlagLabel;
            }

            public void setOpenFlagLabel(Object openFlagLabel) {
                this.openFlagLabel = openFlagLabel;
            }

            public static class EcCategoryBean implements Serializable{
                /**
                 * id : 052b2fcbe3e74cba9221e381d490b9f0
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * tabType : 4
                 * tabName : 银行保险
                 * tabPic : null
                 * tabKeyword : YHBX
                 * tabDesc : 银行保险
                 * tabSorts : 12
                 * fatherId : 0
                 * allFathers : null
                 * categoryNo : null
                 * categoryBrief : null
                 * categoryRemarks : null
                 * openFlag : 0
                 * list : null
                 * fatherName : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String tabType;
                private String tabName;
                private String tabPic;
                private String tabKeyword;
                private String tabDesc;
                private String tabSorts;
                private String fatherId;
                private Object allFathers;
                private Object categoryNo;
                private Object categoryBrief;
                private Object categoryRemarks;
                private String openFlag;
                private Object list;
                private Object fatherName;
                private String cover;

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
                }

                public String getTabPic() {
                    return tabPic;
                }

                public void setTabPic(String tabPic) {
                    this.tabPic = tabPic;
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

                public String getTabType() {
                    return tabType;
                }

                public void setTabType(String tabType) {
                    this.tabType = tabType;
                }

                public String getTabName() {
                    return tabName;
                }

                public void setTabName(String tabName) {
                    this.tabName = tabName;
                }

                public String getTabKeyword() {
                    return tabKeyword;
                }

                public void setTabKeyword(String tabKeyword) {
                    this.tabKeyword = tabKeyword;
                }

                public String getTabDesc() {
                    return tabDesc;
                }

                public void setTabDesc(String tabDesc) {
                    this.tabDesc = tabDesc;
                }

                public String getTabSorts() {
                    return tabSorts;
                }

                public void setTabSorts(String tabSorts) {
                    this.tabSorts = tabSorts;
                }

                public String getFatherId() {
                    return fatherId;
                }

                public void setFatherId(String fatherId) {
                    this.fatherId = fatherId;
                }

                public Object getAllFathers() {
                    return allFathers;
                }

                public void setAllFathers(Object allFathers) {
                    this.allFathers = allFathers;
                }

                public Object getCategoryNo() {
                    return categoryNo;
                }

                public void setCategoryNo(Object categoryNo) {
                    this.categoryNo = categoryNo;
                }

                public Object getCategoryBrief() {
                    return categoryBrief;
                }

                public void setCategoryBrief(Object categoryBrief) {
                    this.categoryBrief = categoryBrief;
                }

                public Object getCategoryRemarks() {
                    return categoryRemarks;
                }

                public void setCategoryRemarks(Object categoryRemarks) {
                    this.categoryRemarks = categoryRemarks;
                }

                public String getOpenFlag() {
                    return openFlag;
                }

                public void setOpenFlag(String openFlag) {
                    this.openFlag = openFlag;
                }

                public Object getList() {
                    return list;
                }

                public void setList(Object list) {
                    this.list = list;
                }

                public Object getFatherName() {
                    return fatherName;
                }

                public void setFatherName(Object fatherName) {
                    this.fatherName = fatherName;
                }
            }
        }
    }
}
