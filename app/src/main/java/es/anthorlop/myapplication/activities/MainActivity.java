package es.anthorlop.myapplication.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;

import es.anthorlop.flexiblecalendar.fragments.CalendarFragment;
import es.anthorlop.flexiblecalendar.listeners.CalendarListener;
import es.anthorlop.flexiblecalendar.listeners.ContentToLoadCalendarListener;
import es.anthorlop.myapplication.R;
import es.anthorlop.myapplication.fragments.ItemFragment;

public class MainActivity extends AppCompatActivity implements CalendarListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.my_calendar_content, CalendarFragment.newInstance()).commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_calendar_content, CalendarFragment.newInstance()).commitAllowingStateLoss();

                return true;
            case R.id.MnuOpc2:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_calendar_content, CalendarFragment.newInstance(2)).commitAllowingStateLoss();

                return true;
            case R.id.MnuOpc3:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_calendar_content, CalendarFragment.newInstance(1)).commitAllowingStateLoss();

                return true;
            case R.id.MnuOpc4:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_calendar_content, CalendarFragment.newInstance(0)).commitAllowingStateLoss();

                return true;
            case R.id.MnuOpc5:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_calendar_content,
                        CalendarFragment.newInstance(new ContentToLoadCalendarListener() {
                            @Override
                            public Fragment fragmentToLoad(Calendar date) {
                                return ItemFragment.newInstance(1);
                            }
                        })).commitAllowingStateLoss();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDateSelected(Calendar date) {

    }

    @Override
    public void onDateViewClicked(Calendar date) {

    }

    @Override
    public void onSwipe(Calendar from, Calendar to, boolean next) {

    }
}
