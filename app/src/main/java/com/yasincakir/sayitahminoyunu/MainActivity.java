package com.yasincakir.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView kalanHakki;
    TextView sonuc;
    EditText txtyazi;
    Button tahminEt;
    ImageView resim;


    private int randomSayi;
    private int hak=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kalanHakki = findViewById(R.id.textView);
        sonuc = findViewById(R.id.textView2);                       //Degerlerin Tanımlanması
        txtyazi = findViewById(R.id.editTextTextPersonName);
        tahminEt=findViewById(R.id.button);
        resim=findViewById(R.id.imageView2);




        Random rndNumber = new Random();                    //Random sayi olusturuyoruz
        randomSayi = rndNumber.nextInt(7);              //Burada random sayının hangi aralıkta deger alacagını belirliyoruz


        System.out.println(randomSayi);


    }

    public void sayiTahminEt(View view) {
        //String deger=txtyazi.getText().toString();

        if(TextUtils.isEmpty(txtyazi.getText().toString())){
            sonuc.setText("Degerimiz bos dondurulemez.........");             //bu if'i degerin bos dondurulmesinin engellemek icin kullaniyoruz

        }
        else{                             //Deger bos degilse else'nin icine giriyor

            int gelenDeger=Integer.parseInt(txtyazi.getText().toString());             //Sayi girecegimiz text'i integer ceviriyoruz burada


            if(gelenDeger==randomSayi){             //Yazdigimiz degerin dogrulugunu kontrol ediyoruz
                sonuc.setText("Dogru cevabi buldunuz");
                tahminEt.setEnabled(false);         //Butonun tıklanabilirligini kaptıyoruz

            }
            else if(gelenDeger!=randomSayi){        //Yazdigimiz deger dogru degilse bu else if icine giriyoruz

                if(hak>0){                  //kullanicimizin 3 hakkı var haklari buradan azaltiyoruz
                    hak--;
                    sonuc.setText("Yanlis giris yaptiniz");

                    kalanHakki.setText("Kalan Hak= "+ hak);
                }

                else{                                                   //haklarimizin bittigi zaman else blogunun içine giriyoruz
                    sonuc.setText("Dogru Cevap= " + randomSayi);        //dogru cevabın ne oldugunu gosteriyor
                    kalanHakki.setText("Hakkiniz Bitmistir");
                    tahminEt.setEnabled(false);                         //Butonun tıklanabilirligini kapatıyoruz
                    tahminEt.setText("Kaybettiniz");

                }
            }

        }





        }








}
