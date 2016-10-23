package mad9132.rgba;
import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Observable;
import java.util.Observer;
import model.RGBAModel;
public class MainActivity extends AppCompatActivity implements Observer
                                                            , SeekBar.OnSeekBarChangeListener
{
    private static final String ABOUT_DIALOG_TAG = "About";
    private static final String LOG_TAG          = "RGBA";

    // INSTANCE VARIABLES
    // Pro-tip: different naming style; the 'm' means 'member'
    private AboutDialogFragment mAboutDialog;
    private TextView            mColorSwatch;
    private RGBAModel           mModel;
    private SeekBar             mHueSB;
    private SeekBar             mSatSB;
    private SeekBar             mValSB;
    private TextView            mHueText;
    private TextView            mSatText;
    private TextView            mValText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAboutDialog = new AboutDialogFragment();
        mModel = new RGBAModel();
        mModel.setHue( RGBAModel.MAX_HUE );
        mModel.setSaturation( RGBAModel.MAX_SAT );
        mModel.setValue( RGBAModel.MAX_VAL );
        mModel.addObserver( this );
        mColorSwatch = (TextView) findViewById( R.id.colorSwatch );
        mHueSB = (SeekBar) findViewById( R.id.redSB );
        mSatSB = (SeekBar) findViewById( R.id.greenSB );
        mValSB = (SeekBar) findViewById( R.id.blueSB );
        mHueSB.setMax( RGBAModel.MAX_HUE );
        mSatSB.setMax( RGBAModel.MAX_SAT );
        mValSB.setMax( RGBAModel.MAX_VAL );
        mHueText = (TextView) findViewById(R.id.hueMain);
        mSatText = (TextView) findViewById(R.id.satMain);
        mValText = (TextView) findViewById(R.id.valMain);
        mHueSB.setOnSeekBarChangeListener( this );
        mSatSB.setOnSeekBarChangeListener( this );
        mValSB.setOnSeekBarChangeListener( this );
        this.updateView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnButtonClick(View view)
    {

        switch (view.getId())
        {

            case R.id.Black:
                Log.d("Pressed?", "You bet");
                Toast.makeText(this,"Black", Toast.LENGTH_LONG).show();
                mModel.asBlack();
                break;

            case R.id.Red:
                Toast.makeText(this,"Red", Toast.LENGTH_LONG).show();
                mModel.asRed();
                break;

            case R.id.Lime:
                Toast.makeText(this,"Lime", Toast.LENGTH_LONG).show();
                mModel.asLime();
                break;

            case R.id.Blue:
                Toast.makeText(this,"Blue", Toast.LENGTH_LONG).show();
                mModel.asBlue();
                break;

            case R.id.Yellow:
                Toast.makeText(this,"Yellow", Toast.LENGTH_LONG).show();
                mModel.asYellow();
                break;

            case R.id.Cyan:
                Toast.makeText(this,"Cyan", Toast.LENGTH_LONG).show();
                mModel.asCyan();
                break;

            case R.id.Magenta:
                Toast.makeText(this,"Magenta", Toast.LENGTH_LONG).show();
                mModel.asMagenta();
                break;

            case R.id.Silver:
                Toast.makeText(this,"Silver", Toast.LENGTH_LONG).show();
                mModel.asSilver();
                break;

            case R.id.Gray:
                Toast.makeText(this,"Gray", Toast.LENGTH_LONG).show();
                mModel.asGray();
                break;

            case R.id.Maroon:
                Toast.makeText(this,"Maroon", Toast.LENGTH_LONG).show();
                mModel.asMaroon();
                break;

            case R.id.Olive:
                Toast.makeText(this,"Olive", Toast.LENGTH_LONG).show();
                mModel.asOlive();
                break;

            case R.id.Green:
                Toast.makeText(this,"Green", Toast.LENGTH_LONG).show();
                mModel.asGreen();
                break;

            case R.id.Purple:
                Toast.makeText(this,"Purple", Toast.LENGTH_LONG).show();
                mModel.asPurple();
                break;

            case R.id.Teal:
                Toast.makeText(this,"Teal", Toast.LENGTH_LONG).show();
                mModel.asTeal();
                break;

            case R.id.Navy:
                Toast.makeText(this,"Navy", Toast.LENGTH_LONG).show();
                mModel.asNavy();
                break;

        }
    }

    /**
     * Event handler for the <SeekBar>s: red, green, blue, and alpha.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method
        if ( fromUser == false ) {
            return;
        }

        // Determine which <SeekBark> caused the event (switch + case)
        // GET the SeekBar's progress, and SET the model to it's new value
        switch ( seekBar.getId() ) {
            case R.id.redSB:
                mModel.setHue( (float) progress );
                mHueText.setText(getResources().getString(R.string.hue, progress));
                break;

            case R.id.greenSB:
                mModel.setHue( (float) progress );
                mHueText.setText(getResources().getString(R.string.saturation, progress));
                break;

            case R.id.blueSB:
                mModel.setHue( (float) progress );
                mHueText.setText(getResources().getString(R.string.value, progress));
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
       switch (seekBar.getId()) {
           case R.id.redSB:
               mColorSwatch.setText(getResources().getString(R.string.hue));
           break;
       }
    }

    // The Model has changed state!
    // Refresh the View to display the current values of the Model.
    @Override
    public void update(Observable observable, Object data) {
        this.updateView();
    }

    private void updateColorSwatch() {

        int Newcolor = Color.HSVToColor(new float[] {
                mModel.getMaxHue(), mModel.getMaxSat()/100, mModel.getMinVal()/100
        });

        mColorSwatch.setBackgroundColor( Newcolor );


    }

    public void updateView() {
        this.updateColorSwatch();
    }
}
