package com.chootdev.blurim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.chootdev.blurimg.BlurImage;

public class MainActivity extends AppCompatActivity {

    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView) findViewById(R.id.img_blur);
        fromResource();
    }

    private void fromResource(){
        BlurImage.withContext(this)
                .blurFromResource(R.drawable.tiger)
                .into(imgView);
    }

    private void customImageScale(){
        BlurImage.withContext(this)
                .setBitmapScale(0.1f)
                .blurFromResource(R.drawable.tiger)
                .into(imgView);
    }

    private void customImageBlurRadius(){
        BlurImage.withContext(this)
                .setBlurRadius(9.5f)
                .blurFromResource(R.drawable.tiger)
                .into(imgView);
    }

    private void customAll(){
        BlurImage.withContext(this)
                .setBlurRadius(9.5f)
                .setBitmapScale(0.7f)
                .blurFromResource(R.drawable.tiger)
                .into(imgView);
    }

    private void loadFromUrl(){
        BlurImage.withContext(this)
                .blurFromUri("https://media.mnn.com/assets/images/2014/11/WhiteTiger02ColorfulAnimalsGallery.jpg.638x0_q80_crop-smart.jpg")
                .into(imgView);
    }
}
