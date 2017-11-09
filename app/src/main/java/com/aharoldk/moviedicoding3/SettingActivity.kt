package com.aharoldk.moviedicoding3

import android.content.Intent
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import butterknife.BindString
import butterknife.ButterKnife
import com.aharoldk.moviedicoding3.utils.alarm.AlarmReceiver
import com.aharoldk.moviedicoding3.utils.gcmanager.SchedulerTask

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentManager.beginTransaction().replace(android.R.id.content, MyPreferenceFragment()).commit()

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    class MyPreferenceFragment : PreferenceFragment(), Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {

        private val alarmReceiver = AlarmReceiver()
        private var schedulerTask: SchedulerTask? = null

        @BindString(R.string.key_reminder_daily)
        internal var reminder_daily: String? = null

        @BindString(R.string.key_reminder_upcoming)
        internal var reminder_upcoming: String? = null

        @BindString(R.string.key_setting_locale)
        internal var setting_locale: String? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.preferences)

            ButterKnife.bind(this, activity)

            findPreference(reminder_daily).onPreferenceChangeListener = this
            findPreference(reminder_upcoming).onPreferenceChangeListener = this
            findPreference(setting_locale).onPreferenceClickListener = this

            schedulerTask = SchedulerTask(activity)
        }

        override fun onPreferenceChange(preference: Preference, o: Any): Boolean {
            val key = preference.key
            val isOn = o as Boolean

            if (key == reminder_daily) {
                if (isOn) {
                    alarmReceiver.setRepeatingAlarm(activity, "07:00")
                } else {
                    alarmReceiver.cancelAlarm(activity)
                }

                Toast.makeText(activity, getString(R.string.label_daily_reminder) + " " + if (isOn) getString(R.string.label_activated) else getString(R.string.label_deactivated), Toast.LENGTH_SHORT).show()
                return true
            }

            if (key == reminder_upcoming) {
                if (isOn) {
                    schedulerTask!!.createPeriodicTask()
                } else
                    schedulerTask!!.cancelPeriodicTask()

                Toast.makeText(activity, getString(R.string.label_upcoming_reminder) + " " + if (isOn) getString(R.string.label_activated) else getString(R.string.label_deactivated), Toast.LENGTH_SHORT).show()
                return true
            }

            return false
        }

        override fun onPreferenceClick(preference: Preference): Boolean {
            val key = preference.key

            if (key == setting_locale) {
                val intent = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(intent)
                return true
            }

            return false
        }
    }
}
