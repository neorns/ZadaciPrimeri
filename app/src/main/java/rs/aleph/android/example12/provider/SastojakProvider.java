package rs.aleph.android.example12.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.model.Jelo;
import rs.aleph.android.example12.model.Sastojak;

/**
 * Created by androiddevelopment on 1.2.17..
 */

public class SastojakProvider {
    public static List<String> getSastojakNazivi(Jelo jelo) {

        List<String> nazivi = new ArrayList<>();
        for (Sastojak sastojak:jelo.getSastojci()
             ) { nazivi.add(sastojak.getNaziv());

        }

        return nazivi;
    }


}
