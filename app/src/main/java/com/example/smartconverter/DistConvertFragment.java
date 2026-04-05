package com.example.smartconverter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;

public class DistConvertFragment extends Fragment {

    private static final double KM_TO_MILES = 0.6214;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_dist_convert, container, false);

        RadioButton rbDistOption1 = v.findViewById(R.id.rbDistOption1);
        EditText    etDistInput   = v.findViewById(R.id.etDistInput);
        TextView    tvDistOutput  = v.findViewById(R.id.tvDistOutput);

        v.findViewById(R.id.btnDistCalc).setOnClickListener(btn -> {
            String raw = etDistInput.getText().toString().trim();
            if (TextUtils.isEmpty(raw)) {
                Toast.makeText(getContext(),
                        "Champ vide, veuillez saisir une valeur",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            double input  = Double.parseDouble(raw);
            double output = rbDistOption1.isChecked()
                    ? input * KM_TO_MILES
                    : input / KM_TO_MILES;

            tvDistOutput.setText(String.format("Résultat : %.2f", output));
        });

        return v;
    }
}