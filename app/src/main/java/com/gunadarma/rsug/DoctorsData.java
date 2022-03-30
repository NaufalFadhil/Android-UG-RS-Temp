package com.gunadarma.rsug;

import java.util.ArrayList;

public class DoctorsData {
    private static String[] doctorNames = {
            "Dr. Sandy Texas, Sp. OG",
            "Dr. Squidward, Sp. B",
            "Dr. Patrick Star, Sp. A",
            "Dr. Yujin Crab, Sp. P"
    };

    private static String[] doctorDetails = {
            "Status\t: Dokter \n" +
                    "Spesialis\t: Organ Dalam \n" +
                    "Hari Kerja\t: Senin - Jum'at \n" +
                    "Jam Kerja\t: 10:00 - 15:00 \n" +
                    "Total Pasien\t: 15 Orang \n",
            "Status\t: Dokter \n" +
                    "Spesialis\t: Bedah \n" +
                    "Hari Kerja\t: Senin - Minggu \n" +
                    "Jam Kerja\t: 12:00 - 18:00 \n" +
                    "Total Pasien\t: 10 Orang \n",
            "Status\t: Dokter \n" +
                    "Spesialis\t: Anak \n" +
                    "Hari Kerja\t: Sabtu - Minggu \n" +
                    "Jam Kerja\t: 07:00 - 10:00 \n" +
                    "Total Pasien\t: 20 Orang \n",
            "Status\t: Dokter \n" +
                    "Spesialis\t: Paru \n" +
                    "Hari Kerja\t: Senin - Jumat \n" +
                    "Jam Kerja\t: 18:00 - 22:00 \n" +
                    "Total Pasien\t: 8 Orang \n"
    };

    private static int[] doctorsImages = {
            R.drawable.pic_sandy,
            R.drawable.pic_squidward,
            R.drawable.pic_patrick,
            R.drawable.pic_crab
    };

    static ArrayList<Doctor> getListData() {
        ArrayList<Doctor> list = new ArrayList<>();
        for (int position = 0; position < doctorNames.length; position++) {
            Doctor doctor = new Doctor();
            doctor.setName(doctorNames[position]);
            doctor.setDetail(doctorDetails[position]);
            doctor.setPhoto(doctorsImages[position]);
            list.add(doctor);
        }
        return list;
    }
}
