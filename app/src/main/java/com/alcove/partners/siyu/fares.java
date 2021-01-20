/*
Created by Sirisha Balireddy on 28-05-2019 - SiYuVizag 1.1
 */
package com.alcove.partners.siyu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class fares extends second {
//Giving values to strings
TextView txt,txt2,txt1;
    String[] from = {"Jagadamba to R.K.Beach ", "Jagadamba to Madhurawada", "Jagadamba to Maddilapalem", "Jagadamba to MVP", "Jagadamba to Complex", "Jagadamba to Seethammadara",
            "Jagadamba to Kailasagiri", "Jagadamba to Submarine", "Jagadamba to ChinnaWaltair", "Jagadamba to PeddaWaltair",
            "Jagadamba to Rushikonda", "Jagadamba to Vuda Park", "Jagadamba to Zoo", "Jagadamba to Simhachalam", "Jagadamba to Gajuwaka",
            "Jagadamba to Akkayapalem", "Jagadamba to Kancharapalem", "R.K.Beach to Madhurawada", "R.K.Beach  to Maddilapalem", "R.K.Beach  to MVP", "R.K.Beach  to Complex", "R.K.Beach  to Seethammadara",
            "R.K.Beach  to Kailasagiri", "R.K.Beach  to Submarine", "R.K.Beach  to ChinnaWaltair", "R.K.Beach  to PeddaWaltair",
            "R.K.Beach  to Rushikonda", "R.K.Beach  to Vuda Park", "R.K.Beach  to Zoo", "R.K.Beach  to Simhachalam", "R.K.Beach  to Gajuwaka",
            "R.K.Beach  to Akkayapalem", "R.K.Beach  to Kancharapalem", "Madhurawada to Maddilapalem", "Madhurawada to MVP", "Madhurawada  to Complex", "Madhurawada to Seethammadara",
            "Madhurawada  to Kailasagiri", "Madhurawada  to Submarine", "Madhurawada to ChinnaWaltair", "Madhurawada to PeddaWaltair",
            "Madhurawada  to Rushikonda", "Madhurawada  to Vuda Park", "Madhurawada  to Zoo", "Madhurawada  to Simhachalam", "Madhurawada  to Gajuwaka",
            "Madhurawada  to Akkayapalem", "Madhurawada  to Kancharapalem", "Maddilapalem to MVP", "Maddilapalem   to Complex", "Maddilapalem to Seethammadara",
            "Maddilapalem  to Kailasagiri", "Maddilapalem  to Submarine", "Maddilapalem to ChinnaWaltair", "Maddilapalem to PeddaWaltair",
            "Maddilapalem  to Rushikonda", "Maddilapalem  to Vuda Park", "Maddilapalem  to Zoo", "Maddilapalem  to Simhachalam", "Maddilapalem  to Gajuwaka",
            "Maddilapalem  to Akkayapalem", "Maddilapalem  to Kancharapalem", "MVP  to Complex", "MVP to Seethammadara", "MVP  to Kailasagiri", "MVP  to Submarine", "MVP to ChinnaWaltair", "MVP to PeddaWaltair", "MVP  to Rushikonda", "MVP  to Vuda Park", "MVP  to Zoo", "MVP  to Simhachalam", "MVP  to Gajuwaka", "MVP  to Akkayapalem", "MVP  to Kancharapalem", "Complex to Seethammadara", "Complex  to Kailasagiri", "Complex  to Submarine", "Complex to ChinnaWaltair", "Complex to PeddaWaltair",
            "Complex  to Rushikonda", "Complex  to Vuda Park", "Complex  to Zoo", "Complex  to Simhachalam", "Complex  to Gajuwaka", "Complex  to Akkayapalem", "Complex  to Kancharapalem", "Seethammadara  to Kailasagiri", "Seethammadara  to Submarine", "Seethammadara to ChinnaWaltair", "Seethammadara to PeddaWaltair",
            "Seethammadara  to Rushikonda", "Seethammadara  to Vuda Park", "Seethammadara  to Zoo", "Seethammadara  to Simhachalam", "Seethammadara  to Gajuwaka",
            "Seethammadara  to Akkayapalem", "Seethammadara  to Kancharapalem", "Kailasagiri  to Submarine", "Kailasagiri to ChinnaWaltair", "Kailasagiri to PeddaWaltair",
            "Kailasagiri  to Rushikonda", "Kailasagiri  to Vuda Park", "Kailasagiri  to Zoo", "Kailasagiri  to Simhachalam", "Kailasagiri  to Gajuwaka",
            "Kailasagiri  to Akkayapalem", "Kailasagiri  to Kancharapalem", "Submarine to ChinnaWaltair", "Submarine to PeddaWaltair",
            "Submarine  to Rushikonda", "Submarine  to Vuda Park", "Submarine  to Zoo", "Submarine  to Simhachalam", "Submarine  to Gajuwaka",
            "Submarine  to Akkayapalem", "Submarine  to Kancharapalem", "ChinnaWaltair to PeddaWaltair",
            "ChinnaWaltair  to Rushikonda", "ChinnaWaltair  to Vuda Park", "ChinnaWaltair  to Zoo", "ChinnaWaltair  to Simhachalam", "ChinnaWaltair  to Gajuwaka",
            "ChinnaWaltair  to Akkayapalem", "ChinnaWaltair  to Kancharapalem", "PeddaWaltair  to Rushikonda", "PeddaWaltair  to Vuda Park", "PeddaWaltair  to Zoo", "PeddaWaltair  to Simhachalam", "PeddaWaltair  to Gajuwaka",
            "PeddaWaltair  to Akkayapalem", "PeddaWaltair  to Kancharapalem", "Rushikonda  to Vuda Park", "Rushikonda  to Zoo", "Rushikonda  to Simhachalam", "Rushikonda  to Gajuwaka",
            "Rushikonda  to Akkayapalem", "Rushikonda  to Kancharapalem", "Vuda Park  to Zoo", "Vuda Park   to Simhachalam", "Vuda Park   to Gajuwaka",
            "Vuda Park   to Akkayapalem", "Vuda Park   to Kancharapalem", "ZOO  to Simhachalam", "ZOO  to Gajuwaka",
            "ZOO   to Akkayapalem", "ZOO  to Kancharapalem", "Simhachalam  to Gajuwaka", "Simhachalam   to Akkayapalem", "Simhachalam  to Kancharapalem", "Gajuwaka   to Akkayapalem", "Gajuwaka  to Kancharapalem", "Akkayapalem  to Kancharapalem",
            "ZillaParishad to R.K.Beach ", "ZillaParishad to Madhurawada", "ZillaParishad to Maddilapalem", "ZillaParishad to MVP", "ZillaParishad to Complex", "ZillaParishad to Seethammadara",
            "ZillaParishad to Kailasagiri", "ZillaParishad to Submarine", "ZillaParishad to ChinnaWaltair", "ZillaParishad to PeddaWaltair",
            "ZillaParishad to Rushikonda", "ZillaParishad to Vuda Park", "ZillaParishad to Zoo", "ZillaParishad to Simhachalam", "ZillaParishad to Gajuwaka",
            "ZillaParishad to Akkayapalem", "ZillaParishad to Kancharapalem",

    };
    String[] dist1 = {"2.8km(7min)", "16.3km(36min)", "3.6km(10min)", "5.3km(15min)", "2.1km(8 min)", "4.4km(13min)", "10.8km(26min)", "3.9km(9min)", "3.5km(8min)", "4.4km(10min)", "16.8km(33min)",
            "4.8km(11min)", "8.3km(21min)", "18km(36min)", "17.2km(30min)", "3.5km(12min)", "6.3km(12min)", "16.3km(33min)", "3.6km(11min)", "5km(10min)", "3.1km(10min)", "4.8km(14min)", "8.6km(19min)", "1.1km(3min)",
            "2.4km(6min)", "2.9km(7min)", "11.4km(21min)", "2.3km(5min)", "9km(18min)", "19.1km(33min)", "18.9km(34min)", "5.4km(16min)", "7.9km(16min)", "13km(29min)", "12.4km(26min)", "15.5km(37min)", "14.9km(34min)", "13.8km(28min)",
            "16.5km(31min)", "16.3km(32min)", "13.8km(30min)", "9.1km(18min)", "15.3km(29min)", "8.4km(16min)", "23.3km(40min)", "31.9km(1hr 2min)", "16.2km(32min)", "19.2km(42min)", "1.7km(5min)",
            "2.4km(9min)", "2.4km(7min)", "6.1km(16min)", "4.3km(11min)", "3.8km(8min)", "2.5km(6min)", "10km(20min", "3.1km(9min)", "4.7km(11min)", "16km(24min)", "19km(33min)", "3.2km(9min)", "6.2km(15min)",
            "4.2km(13min)", "3.5km(10min)", "5.7km(14min)", "3.9km(8min)", "3.7km(8min)", "1.7km(5min)", "8.6km(16min)", "2.6km(6min)", "4.1km(11min)", "14.6km(24min)", "20.7km(38min)", "5km(14min)",
            "8km(20min", "3.4km(14min)", "9km(28min)", "5km(15min)", "4.3km(16min)", "4.1km(13min)", "13.4km(30min)", "5.2km(13min)", "7.2km(19min)", "17.6km(32min)", "16.7km(28min)", "2.3km(10min)",
            "5.1km(12min)", "6.9km(19min)", "5.7km(16min)", "4.7km(13min)", "4.3km(12km)", "11.1km(22min)", "4.9km(15min)", "5.5km(14min)", "15.9km(28min)", "19.1km(35min)", "2.3km(7min)", "5.2km(12min)",
            "7.9km(19min)", "6.9km(19min)", "6.5km(17min)", "9.5km(20min)", "6.6km(16min)", "5.6km(15min)", "16.3km(30min)", "25km(49min)", "9.2km(26min)", "12.2km(32min)", "1.7km(5min)",
            "2.3km(7min)", "10.8km(20min)", "1.8km(4min)", "8.5km(17min)", "18.6km(32min)", "19.7km(35min)", "6.2km(17min)", "8.6km(19min)", "800mtrs)3min)", "9.7km(19min)", "550mtr(3min)", "7.2km(16min)",
            "17.3km(31min)", "20.3km(38min)", "5.6km(17min)", "8.9km(20min)", "9.3km(17min)", "1.2km(3min)", "6.8km(14min)", "16.9km(29min)", "20.3km(36min)", "5.5km(16min)", "8.8km(19min)", "12.6km(25min)",
            "7.9km(14min)", "22.8km(40min)", "31.5km(58min)", "15.8km(34min)", "18.8km(39min", "7km(15min)", "17.2km(31min)", "20.2km(35min)", "6.5km(18min)", "9km(18min)", "14.9km(27min)", "23.6km(44min)",
            "7.9km(21min)", "10.9km(27min)", "19.4km(42min)", "18.1km(42min)", "15.1km(36min)", "19.4km(38min)", "14.3km(37min)", "3.5km(7min)", "2km(5min)", "16.6km(38min)", "3.9km(12min)",
            "5.5km(15min)", "2.6km(8min)", "4.9km(13min)", "10.6km(24min)", "3.1km(7min)", "4.2km(10min)", "4.2km(10min)", "13.4km(26min)", "4.3km(9min)", "10.9km(25min)", "19.1km(38min)", "17.9km(35min)",
            "4.2km(14min)", "7km(16min)"};
    double []dist2 ={2.8,16.3,3.6,5.3,2.1,4.4,10.8,3.9,3.5,4.4,16.8,4.8,8.3,18,17.2,3.5,6.3,16.3,3.6,5,3.1,4.8,8.6,1.1,2.4,2.9,11.4,2.3,9,19.1,18.9,5.4,7.9,13,12.4,15.5,14.9,13.8,
            16.5,16.3,13.8,9.1,15.3,8.4,23.3,31.9,16.2,19.2,1.7,2.4,2.4,6.1,4.3,3.8,2.5,10,3.1,4.7,16,19,3.2,6.2,4.2,3.5,5.7,3.9,3.7,1.7,8.6,2.6,4.1,14.6,20.7,5,
            8,3.4,9,5,4.3,4.1,13.4,5.2,7.2,17.6,16.7,2.3,5.1,6.9,5.7,4.7,4.3,11.1,4.9,5.5, 15.9, 19.1, 2.3, 5.2, 7.9, 6.9, 6.5, 9.5, 6.6, 5.6, 16.3, 25, 9.2, 12.2, 1.7,
            2.3, 10.8, 1.8, 8.5, 18.6, 19.7, 6.2, 8.6, 0.800, 9.7, 0.550, 7.2, 17.3, 20.3, 5.6, 8.9, 9.3, 1.2, 6.8, 16.9, 20.3, 5.5, 8.8, 12.6,
            7.9, 22.8, 31.5, 15.8, 18.8, 7, 17.2, 20.2, 6.5, 9, 14.9, 23.6, 7.9, 10.9, 19.4, 18.1, 15.1, 19.4, 14.3, 3.5, 2, 16.6, 3.9,5.5, 2.6, 4.9, 10.6, 3.1, 4.2, 4.2, 13.4, 4.3, 10.9, 19.1, 17.9, 4.2, 7};
    double af[]=new double[from.length];
    double bf[]=new double[from.length];

    ImageView home;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.fares);

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), second.class));
            }
        });

        Intent iget = getIntent();
        String c = iget.getExtras().getString("address");
        txt1=(TextView)findViewById(R.id.dist);
         txt =(TextView)findViewById(R.id.busfare);
         txt2 =(TextView)findViewById(R.id.autofare);
//Logic to take the value from previous activity compare it and assign their details
        for(int i=0;i<from.length;i++) {
            if (c.equals(from[i])) {
                 bf[i] = (dist2[i] * 2.5);
                af[i] = (dist2[i] * 4);
                txt1.setText(dist1[i]);
                txt.setText(" Rs. " +bf[i]);
                txt2.setText(" Rs. " + af[i]);


            }
        }


    }
//This function takes back to the previous activity onclick of the previous activity or page
    public void homeButton(View view){
        Intent gotoScreenVar = new Intent(fares.this,busFare.class);
        gotoScreenVar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(gotoScreenVar);
    }
}
