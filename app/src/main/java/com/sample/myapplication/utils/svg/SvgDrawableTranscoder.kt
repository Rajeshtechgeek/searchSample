package com.sample.myapplication.utils.svg

import android.graphics.Picture
import android.graphics.drawable.PictureDrawable
import android.util.Log
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.SimpleResource
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder
import com.caverock.androidsvg.SVG

/**
 * Convert the [SVG]'s internal representation to an Android-compatible one ([Picture]).
 */
class SvgDrawableTranscoder : ResourceTranscoder<SVG?, PictureDrawable> {
    override fun transcode(
        toTranscode: Resource<SVG?>, options: Options
    ): Resource<PictureDrawable>? {
        val svg = toTranscode.get()
        val picture = svg.renderToPicture()
        val drawable = PictureDrawable(picture)
        Log.d("SvgDrawableTranscoder", "Width: " + picture.width + " height: " + picture.height)
        return SimpleResource(drawable)
    }
}