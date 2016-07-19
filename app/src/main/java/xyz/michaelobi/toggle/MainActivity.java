package xyz.michaelobi.toggle;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import xyz.michaelobi.toggleton.togglestate.ToggleState;
import xyz.michaelobi.toggleton.ToggleableImageView;
import xyz.michaelobi.toggleton.togglestate.DrawableToggleState;
import xyz.michaelobi.toggleton.ToggleableWidget;

public class MainActivity extends AppCompatActivity {

    public static final String STATE_REPEAT_ALL = "repeat_all";
    public static final String STATE_REPEAT_ONE = "repeat_one";
    public static final String STATE_REPEAT_NONE = "repeat_none";
    private static final String TAG = "MainActivity";
    ToggleableImageView toggleableImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleableImageView = (ToggleableImageView) findViewById(R.id.toggle);
        ArrayList<DrawableToggleState> toggleStates = new ArrayList<>();

        toggleStates.add(new DrawableToggleState(STATE_REPEAT_ALL, ContextCompat.getDrawable(this, R.drawable.ic_repeat)));
        toggleStates.add(new DrawableToggleState(STATE_REPEAT_ONE, ContextCompat.getDrawable(this, R.drawable.ic_repeat_one)));
        toggleStates.add(new DrawableToggleState(STATE_REPEAT_NONE, ContextCompat.getDrawable(this, R.drawable.ic_android_black_24dp)));

        toggleableImageView.setToggleStates(toggleStates);
        toggleableImageView.setToggleListener(new ToggleableWidget.ToggleListener() {
            @Override
            public void onToggle(ToggleState previous, ToggleState current) {
                Log.d(TAG, "onToggle() called with: previous = [" + previous + "], current = [" + current + "]");
                Toast.makeText(MainActivity.this, "New State:" + current.getKey(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
