package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.provider.JeloProvider;
import rs.aleph.android.example12.provider.KategorijaProvider;
import rs.aleph.android.example12.provider.SastojakProvider;

// Each activity extends Activity class
public class SecondActivity extends Activity {

    //private Jelo jelo = new Jelo("bananas.jpg","Naziv jela","Opis jela. Ovde ide neki dugacak opis",null,100.0f, BigDecimal.valueOf( 300.00) );

    // onCreate method is a lifecycle method called when he activity is starting
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Each lifecycle method should call the method it overrides
        super.onCreate(savedInstanceState);
        // setContentView method draws UI
        setContentView(R.layout.activity_second_relative);

        // Shows a toast message (a pop-up message)
        //Toast toast = Toast.makeText(getBaseContext(), "Activity.onCreate()", Toast.LENGTH_SHORT);
        Toast toast = Toast.makeText(getBaseContext(), R.string.activity_oncreate, Toast.LENGTH_SHORT);
        toast.show();

        final int position = getIntent().getIntExtra("position", 0);


        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvNaziv = (TextView) findViewById(R.id.tv_naziv);
        tvNaziv.setText(JeloProvider.getJeloById(position).getNaziv());

        TextView tvOpis = (TextView) findViewById(R.id.tv_opis);
        tvOpis.setText(JeloProvider.getJeloById(position).getOpis());

        //TextView tvKategorija = (TextView) findViewById(R.id.tv_kategorija);
        //tvKategorija.setText(JeloProvider.getJeloById(position).getKategorija().getNaziv());

        Spinner kategorija = (Spinner) findViewById(R.id.sp_kategorija);
        List<String> kategorije = KategorijaProvider.getKategorijaNazivi();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, kategorije);
        kategorija.setAdapter(adapter);
        kategorija.setSelection((int)JeloProvider.getJeloById(position).getKategorija().getId());

        //TextView tvSastojci = (TextView) findViewById(R.id.tv_sastojci);
        //tvSastojci.setText(jelo.getSastojci());


        final List<String> sastojciNazivi = SastojakProvider.getSastojakNazivi(JeloProvider.getJeloById(position));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, sastojciNazivi);

        ListView listView = (ListView) findViewById(R.id.list_sastojci);

        listView.setAdapter(dataAdapter);

        TextView tvKalorije = (TextView) findViewById(R.id.tv_kalorije);
        tvKalorije.setText(String.format(Locale.getDefault(),getString(R.string.jelo_calories),JeloProvider.getJeloById(position).getKalorije()));

        TextView tvCena = (TextView) findViewById(R.id.tv_cena);
        tvCena.setText(String.format(Locale.getDefault(), getString(R.string.jelo_price),JeloProvider.getJeloById(position).getCena()));


    }

    // onStart method is a lifecycle method called after onCreate (or after onRestart when the
    // activity had been stopped, but is now again being displayed to the user)
    @Override
    protected void onStart() {
        super.onStart();

        Toast toast = Toast.makeText(getBaseContext(), R.string.activity_onstart, Toast.LENGTH_SHORT);
        toast.show();
    }

    // onRestart method is a lifecycle method called after onStop when the current activity is
    // being re-displayed to the user
    @Override
    protected void onRestart() {
        super.onRestart();

        Toast toast = Toast.makeText(getBaseContext(), R.string.activity_onrestart, Toast.LENGTH_SHORT);
        toast.show();
    }

    // onResume method is a lifecycle method called after onRestoreInstanceState, onRestart, or
    // onPause, for your activity to start interacting with the user
    @Override
    protected void onResume() {
        super.onResume();

        Toast toast = Toast.makeText(getBaseContext(), R.string.activity_onresume, Toast.LENGTH_SHORT);
        toast.show();
    }

    // onPause method is a lifecycle method called when an activity is going into the background,
    // but has not (yet) been killed
    @Override
    protected void onPause() {
        super.onPause();

        Toast toast = Toast.makeText(getBaseContext(), R.string.activity_onpause, Toast.LENGTH_SHORT);
        toast.show();
    }

    // onStop method is a lifecycle method called when the activity are no longer visible to the user
    @Override
    protected void onStop() {
        super.onStop();

        Toast toast = Toast.makeText(getBaseContext(), R.string.activity_onstop, Toast.LENGTH_SHORT);
        toast.show();
    }

    // onDestroy method is a lifecycle method that perform any final cleanup before an activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast toast = Toast.makeText(getBaseContext(), R.string.activity_ondestroy, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void btnOpenCameraClicked(View view) {

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivity(i);
    }
}
