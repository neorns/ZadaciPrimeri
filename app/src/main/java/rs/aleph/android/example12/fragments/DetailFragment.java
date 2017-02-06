package rs.aleph.android.example12.fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.provider.JeloProvider;
import rs.aleph.android.example12.provider.KategorijaProvider;
import rs.aleph.android.example12.provider.SastojakProvider;

/**
 * Created by androiddevelopment on 6.2.17..
 */

public class DetailFragment extends Fragment {
    private int position;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        fillContent(position);



    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", position);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    private void fillContent(final int position){
// Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvNaziv = (TextView) getView().findViewById(R.id.tv_naziv);
        tvNaziv.setText(JeloProvider.getJeloById(position).getNaziv());

        TextView tvOpis = (TextView) getView().findViewById(R.id.tv_opis);
        tvOpis.setText(JeloProvider.getJeloById(position).getOpis());

        //TextView tvKategorija = (TextView) findViewById(R.id.tv_kategorija);
        //tvKategorija.setText(JeloProvider.getJeloById(position).getKategorija().getNaziv());

        Spinner kategorija = (Spinner) getView().findViewById(R.id.sp_kategorija);
        List<String> kategorije = KategorijaProvider.getKategorijaNazivi();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, kategorije);
        kategorija.setAdapter(adapter);
        kategorija.setSelection((int)JeloProvider.getJeloById(position).getKategorija().getId());

        //TextView tvSastojci = (TextView) findViewById(R.id.tv_sastojci);
        //tvSastojci.setText(jelo.getSastojci());


        final List<String> sastojciNazivi = SastojakProvider.getSastojakNazivi(JeloProvider.getJeloById(position));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, sastojciNazivi);

        ListView listView = (ListView) getView().findViewById(R.id.list_sastojci);

        listView.setAdapter(dataAdapter);

        TextView tvKalorije = (TextView) getView().findViewById(R.id.tv_kalorije);
        tvKalorije.setText(String.format(Locale.getDefault(),getString(R.string.jelo_calories),JeloProvider.getJeloById(position).getKalorije()));

        TextView tvCena = (TextView) getView().findViewById(R.id.tv_cena);
        tvCena.setText(String.format(Locale.getDefault(), getString(R.string.jelo_price),JeloProvider.getJeloById(position).getCena()));

    }

    public void setContent(final int position) {

        this.position = position;

    }

    public void updateContent(final int position) {

        this.position = position;

        fillContent(position);

    }
}
