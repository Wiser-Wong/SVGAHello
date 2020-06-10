package com.wiser.svgahello;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;

public class MainActivity extends AppCompatActivity {

    private SVGAImageView svgaImageView;

    private SVGAParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        svgaImageView = findViewById(R.id.svga_img);

        parser = new SVGAParser(this);

        parser.decodeFromAssets("Goddess.svga", new SVGAParser.ParseCompletion() {
            @Override
            public void onComplete(@NonNull SVGAVideoEntity svgaVideoEntity) {
                if(svgaImageView!=null) {
                    svgaImageView.setImageDrawable(new SVGADrawable(svgaVideoEntity));
                    svgaImageView.startAnimation();
                }
            }

            @Override
            public void onError() {

            }
        });
    }
}
