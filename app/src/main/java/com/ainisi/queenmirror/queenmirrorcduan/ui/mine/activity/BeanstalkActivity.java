package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;


import android.content.res.Resources;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import java.lang.reflect.Field;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的（魔豆（选择时间））
 */
public class BeanstalkActivity extends BaseNewActivity implements HttpCallBack {

    private static final int TELVERSION = 0;
    @Bind(R.id.datepicker)
    DatePicker datePicker;
    @Bind(R.id.tv_date)
    TextView date;
    @Bind(R.id.title_title)
    TextView dateTitle;
    @Bind(R.id.title_right)
    TextView rightTitle;
    @Bind(R.id.re_branstalk)
    RelativeLayout branstalkmoth;
    @Bind(R.id.tv_moth)
    TextView monte;
    @Bind(R.id.layout_date)
    LinearLayout linearDate;
    @Bind(R.id.ed_starttime)
    EditText startTime;
    @Bind(R.id.ed_endtime)
    EditText endtime;
    @Bind(R.id.re_datepicker)
    RelativeLayout redatepicker;
    @Bind(R.id.view_one)
    View viewone;
    private boolean isClick;
    private Calendar c;

    @Override
    public int getLayoutId() {
        return R.layout.activity_beanstalk;
    }

    @Override
    public void initView() {
        initText();
        initDate();
    }


    private void initText() {
        dateTitle.setText(R.string.Selectiontime);
        rightTitle.setText(R.string.complete);
    }

    private void initDate() {
        initTime();
        hidePicker(datePicker);
    }

    private void initTime() {
        //可以对每个时间域单独修改
        c = Calendar.getInstance();
        date.setText(c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH));
        datePicker.setMaxDate(System.currentTimeMillis() - 86400000);
        setnewText(date);
    }

    public void setDateText(final TextView name) {
        datePicker.init(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), new DatePicker.OnDateChangedListener() {
            //            当dp日期改变时回调onDateChanged方法
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                获取dp的年月日的值，在textView上显示出来
                c.set(year, monthOfYear, dayOfMonth);
                name.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
            }
        });
    }

    public void setnewText(final TextView newdate) {
        datePicker.init(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), new DatePicker.OnDateChangedListener() {
            //            当dp日期改变时回调onDateChanged方法
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                获取dp的年月日的值，在textView上显示出来
                c.set(year, monthOfYear, dayOfMonth);
                newdate.setText(year + "-" + monthOfYear);

            }
        });
    }

    @OnClick({R.id.title_back, R.id.iv_delete, R.id.tv_date, R.id.re_branstalk, R.id.ed_starttime, R.id.ed_endtime})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_date:
                redatepicker.setVisibility(View.VISIBLE);
                setnewText(date);
                date.setTextColor(ContextCompat.getColor(this, R.color.appbar_blue));
                viewone.setBackgroundColor(ContextCompat.getColor(this, R.color.appbar_blue));
                break;
            case R.id.iv_delete:
                redatepicker.setVisibility(View.GONE);
                date.setText(R.string.Selectiontime);
                startTime.setText(R.string.Startdate);
                endtime.setText(R.string.EndDate);
                startTime.setTextColor(ContextCompat.getColor(this, R.color.alpha_15_black));
                endtime.setTextColor(ContextCompat.getColor(this, R.color.alpha_15_black));
                date.setTextColor(ContextCompat.getColor(this, R.color.alpha_15_black));
                viewone.setBackgroundColor(ContextCompat.getColor(this, R.color.alpha_15_black));
                break;
            case R.id.re_branstalk:
                if (isClick) {
                    isClick = false;
                    hidePicker(datePicker);
                    monte.setText(R.string.Bytheday);
                    date.setVisibility(View.VISIBLE);
                    viewone.setVisibility(View.VISIBLE);
                    linearDate.setVisibility(View.GONE);
                } else {
                    isClick = true;
                    showPicker(datePicker);
                    monte.setText(R.string.Monthlysettlement);
                    date.setVisibility(View.GONE);
                    linearDate.setVisibility(View.VISIBLE);
                    viewone.setVisibility(View.GONE);
                    setDateText(startTime);
                }
                break;
            case R.id.ed_starttime:
                redatepicker.setVisibility(View.VISIBLE);
                setDateText(startTime);
                startTime.setTextColor(ContextCompat.getColor(this, R.color.alpha_95_black));
                break;
            case R.id.ed_endtime:
                redatepicker.setVisibility(View.VISIBLE);
                setDateText(endtime);
                endtime.setTextColor(ContextCompat.getColor(this, R.color.alpha_95_black));
                break;
        }
    }

    /**
     * @param picker 传入一个DatePicker对象,隐藏相应的时间项
     */
    public static void hidePicker(DatePicker picker) {
        // 利用java反射技术得到picker内部的属性，并对其进行操作
        Class<? extends DatePicker> c = picker.getClass();
        try {
            Field fd = null, fm = null, fy = null;
            // 系统版本大于5.0
            if (Build.VERSION.SDK_INT >= TELVERSION) {
                int daySpinnerId = Resources.getSystem().getIdentifier("day", "id", "android");
                if (daySpinnerId != 0) {
                    View daySpinner = picker.findViewById(daySpinnerId);
                    if (daySpinner != null) {
                        daySpinner.setVisibility(View.GONE);
                        return;
                    }
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                // 系统版本大于4.0
                fd = c.getDeclaredField("mDaySpinner");
                fm = c.getDeclaredField("mMonthSpinner");
                fy = c.getDeclaredField("mYearSpinner");
            } else {
                fd = c.getDeclaredField("mDayPicker");
                fm = c.getDeclaredField("mMonthPicker");
                fy = c.getDeclaredField("mYearPicker");
            }
            // 对字段获取设置权限
            fd.setAccessible(true);
            fm.setAccessible(true);
            fy.setAccessible(true);
            // 得到对应的控件
            View vd = (View) fd.get(picker);
            View vm = (View) fm.get(picker);
            View vy = (View) fy.get(picker);

            vd.setVisibility(View.GONE);
            vm.setVisibility(View.VISIBLE);
            vy.setVisibility(View.VISIBLE);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param picker 传入一个DatePicker对象,展示相应的时间项
     */
    public static void showPicker(DatePicker picker) {
        // 利用java反射技术得到picker内部的属性，并对其进行操作
        Class<? extends DatePicker> c = picker.getClass();
        try {
            Field fd = null, fm = null, fy = null;
            // 系统版本大于5.0
            if (Build.VERSION.SDK_INT >= TELVERSION) {
                int daySpinnerId = Resources.getSystem().getIdentifier("day", "id", "android");
                if (daySpinnerId != 0) {
                    View daySpinner = picker.findViewById(daySpinnerId);
                    if (daySpinner != null) {
                        daySpinner.setVisibility(View.VISIBLE);
                        return;
                    }
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                // 系统版本大于4.0
                fd = c.getDeclaredField("mDaySpinner");
                fm = c.getDeclaredField("mMonthSpinner");
                fy = c.getDeclaredField("mYearSpinner");
            } else {
                fd = c.getDeclaredField("mDayPicker");
                fm = c.getDeclaredField("mMonthPicker");
                fy = c.getDeclaredField("mYearPicker");
            }
            // 对字段获取设置权限
            fd.setAccessible(true);
            fm.setAccessible(true);
            fy.setAccessible(true);
            // 得到对应的控件
            View vd = (View) fd.get(picker);
            View vm = (View) fm.get(picker);
            View vy = (View) fy.get(picker);

            vd.setVisibility(View.VISIBLE);
            vm.setVisibility(View.VISIBLE);
            vy.setVisibility(View.VISIBLE);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}