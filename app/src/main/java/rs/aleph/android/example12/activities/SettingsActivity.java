package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import rs.aleph.android.example12.R;

/**
 * Created by Radni on 09.02.2017.
 */

public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }

    public static class SettingsFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Loads preferences from an XML resource
            addPreferencesFromResource(R.xml.preferences);
        }
    }
}
