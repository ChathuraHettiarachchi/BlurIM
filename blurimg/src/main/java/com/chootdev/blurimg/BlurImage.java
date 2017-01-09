package com.chootdev.blurimg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by Choota on 1/9/17.
 */

public class BlurImage {
    private static float BITMAP_SCALE = 0.4f;
    private static float BLUR_RADIUS = 7.5f;

    private static Context thiscontext;
    private static BlurImage blurImage;

    private static Bitmap blurFillImage;

    public static BlurImage withContext(Context context) {
        thiscontext = context;
        return (blurImage = new BlurImage());
    }

    public static BlurImage setBlurRadius(float radius) {
        BLUR_RADIUS = radius;
        return blurImage;
    }

    public static BlurImage setBitmapScale(float scale) {
        BITMAP_SCALE = scale;
        return blurImage;
    }

    public static BlurImage blurFromResource(int resource) {
        Bitmap bitmap = BitmapFactory.decodeResource(thiscontext.getResources(), resource);
        BlurImage.blur(bitmap);
        return blurImage;
    }

    public static BlurImage blurFromUri(String imageUrl) {

//        URL url = null;
//        try {
//            url = new URL(imageUrl);
//            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Picasso.with(thiscontext)
                .load(imageUrl)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        BlurImage.blur(bitmap);
                        System.out.println("Test on load");
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        System.out.println("Test on fail");
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        System.out.println("Test on pre load");
                    }
                });

        return blurImage;
    }

    public static void into(ImageView imageView) {
        imageView.setBackground(new BitmapDrawable(thiscontext.getResources(), blurFillImage));
    }

    public static BlurImage blur(Bitmap image) {
        int width = Math.round(image.getWidth() * BITMAP_SCALE);
        int height = Math.round(image.getHeight() * BITMAP_SCALE);

        Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, height, false);
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);

        RenderScript rs = RenderScript.create(thiscontext);
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
        Allocation tmpOut = Allocation.createFromBitmap(rs, outputBitmap);
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);

        blurFillImage = outputBitmap;

        return blurImage;
    }
}
