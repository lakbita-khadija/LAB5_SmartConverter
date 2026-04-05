package com.example.smartconverter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;

public class TempConvertFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_temp_convert, container, false);

        RadioButton rbOption1 = v.findViewById(R.id.rbOption1);
        EditText    etInput   = v.findViewById(R.id.etInput);
        TextView    tvOutput  = v.findViewById(R.id.tvOutput);

        v.findViewById(R.id.btnCalc).setOnClickListener(btn -> {
            String raw = etInput.getText().toString().trim();
            if (TextUtils.isEmpty(raw)) {
                Toast.makeText(getContext(),
                        "Champ vide, veuillez saisir une valeur",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            double input  = Double.parseDouble(raw);
            double output = rbOption1.isChecked()
                    ? input * 1.8 + 32
                    : (input - 32) / 1.8;

            tvOutput.setText(String.format("Résultat : %.2f", output));
        });

        return v;
    }
}