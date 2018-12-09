package com.beelabs.tbcinfo.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.beelabs.tbcinfo.R;
import com.beelabs.tbcinfo.model.db.CalendarModel;
import com.beelabs.tbcinfo.ui.component.SlidePanel;
import com.beelabs.tbcinfo.ui.component.calendar.view.CalendarPlayScheduleView;
import com.beelabs.tbcinfo.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

import app.beelabs.com.codebase.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by arysuryawan on 1/28/18.
 */

public class CalendarScheduleActivity extends BaseActivity {
    @BindView(R.id.calendar_view)
    CalendarPlayScheduleView calendarView;
    @BindView(R.id.panel_content)
    ViewGroup panelContent;
    @BindView(R.id.list_event)
    LinearLayout listEvent;
    @BindView(R.id.calendar_detail_event)
    ViewGroup calendarDetailEvent;
    @BindView(R.id.full_date_name)
    TextView fullDateNameText;

    private View panelSlide;
    private View panelSlideBottom;
    private static int childId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_schedule);
        ButterKnife.bind(this);


        setupCalendar(new Date());
        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {

                Calendar c = eventDay.getCalendar();
                Date date = c.getTime();

                Toast.makeText(CalendarScheduleActivity.this, DateUtil.formatString(date), Toast.LENGTH_SHORT).show();

            }
        });

//        createKidDropdown();
    }


    private void bindDataCalendarEvent(Date date, CalendarModel cal) {
        fullDateNameText.setText(DateUtil.formatStringWithDay(date, CalendarScheduleActivity.this));
        calendarDetailEvent.setVisibility(View.VISIBLE);

        View layout = LayoutInflater.from(this).inflate(R.layout.content_calendar_event, calendarDetailEvent, false);

        int icon = (cal.isStatus()) ? R.drawable.activity_done : R.drawable.activity_undone;
        ((ImageView) layout.findViewById(R.id.event_image)).setImageDrawable(getResources().getDrawable(icon));
        ((TextView) layout.findViewById(R.id.event_text)).setText(cal.getName());
        layout.setTag(cal.getId());
        listEvent.addView(layout);
    }

    private void setupCalendar(Date date) {

        try {

            calendarView.setDate(date);
        } catch (OutOfDateRangeException e) {
            e.printStackTrace();
        }
    }

    private void buildEvent(int childId) {
        calendarDetailEvent.setVisibility(View.GONE);
    }

//    private void createKidDropdown() {
//        User user = ProfileDao.getProfile(this);
//        panelContent.removeAllViews();
//        for (Child child : user.getChilds()) {
//            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            ViewGroup panelItem = (ViewGroup) inflater.inflate(R.layout.content_options_kid, findViewById(R.id.panel_content), false);
//            TextView tx = ((TextView) panelItem.findViewById(R.id.kid_name));
//            tx.setText(StringUtil.toCamelCase(child.getName()));
//            tx.setTag(child.getId());
//            panelContent.addView(panelItem);
//        }

//    }

    // dropdown listener
    public void onFilterEvent(View view) {
        boolean flag = view.getTag() == null ? false : (boolean) view.getTag();
        if (panelSlide != null) panelSlide.setVisibility(View.GONE);

        if (!flag) {
//            ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0);

            panelSlide = SlidePanel.showPanel(this, panelContent);
            ((ViewGroup) panelSlide.getParent()).setBackground(getResources().getDrawable(R.color.color_background_slide));
            ((ViewGroup) panelSlide.getParent()).setClickable(true);
            view.setTag(true);
        } else {
            ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
            ((ViewGroup) panelSlide.getParent()).setBackgroundColor(Color.TRANSPARENT);
            ((ViewGroup) panelSlide.getParent()).setClickable(false);
            view.setTag(false);
        }

    }

    // item dropdown listener
    public void onFilterKidItemSelected(View v) {
        String kidname = ((TextView) v).getText().toString();
        TextView filterKidname = ((TextView) findViewById(R.id.filter_event));
        filterKidname.setText(kidname);
        filterKidname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
        filterKidname.setTag(false);

        childId = (int) v.getTag();
        buildEvent(childId);
        if (panelSlide != null) {
            panelSlide.setVisibility(View.GONE);
            ((View) panelSlide.getParent()).setBackgroundColor(Color.TRANSPARENT);
            ((View) panelSlide.getParent()).setClickable(false);
        }
    }


    public void onClickItemEvent(View v) {
        Toast.makeText(this, "ID= " + v.getTag().toString(), Toast.LENGTH_SHORT).show();
//        panelSlideBottom = SlidePanel.showBottomPanel(this, findViewById(R.id.main_content_bottom_slide), R.layout.content_calendar_options);
        panelSlideBottom.findViewById(R.id.option_detail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalendarScheduleActivity.this, "Option Details", Toast.LENGTH_SHORT).show();
            }
        });

        panelSlideBottom.findViewById(R.id.option_mark_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalendarScheduleActivity.this, "Option Mark done", Toast.LENGTH_SHORT).show();
            }
        });

        panelSlideBottom.findViewById(R.id.option_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalendarScheduleActivity.this, "Option Delete", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        try {
            if (panelSlideBottom.getVisibility() == View.VISIBLE)
                panelSlideBottom.setVisibility(View.GONE);
            else
                super.onBackPressed();
        } catch (Exception e) {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.back_button)
    public void onBack(View view){
        onBackPressed();
    }
}
