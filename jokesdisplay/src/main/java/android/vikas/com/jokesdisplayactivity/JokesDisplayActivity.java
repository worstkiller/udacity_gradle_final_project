package android.vikas.com.jokesdisplayactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static android.vikas.com.jokesdisplayactivity.LibConstants.JOKES_INTENT;

/**
 * Created by OFFICE on 12/4/2016.
 */

public class JokesDisplayActivity extends AppCompatActivity {

    private TextView textView;
    private String jokes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);
        textView = (TextView)findViewById(R.id.tvJokesDisplayLib);
        jokes = getIntent().getStringExtra(JOKES_INTENT);
        textView.setText(jokes);
    }

}
