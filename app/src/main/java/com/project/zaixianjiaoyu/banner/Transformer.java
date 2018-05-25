package com.project.zaixianjiaoyu.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.project.zaixianjiaoyu.banner.transformer.AccordionTransformer;
import com.project.zaixianjiaoyu.banner.transformer.BackgroundToForegroundTransformer;
import com.project.zaixianjiaoyu.banner.transformer.CubeInTransformer;
import com.project.zaixianjiaoyu.banner.transformer.CubeOutTransformer;
import com.project.zaixianjiaoyu.banner.transformer.DefaultTransformer;
import com.project.zaixianjiaoyu.banner.transformer.DepthPageTransformer;
import com.project.zaixianjiaoyu.banner.transformer.FlipHorizontalTransformer;
import com.project.zaixianjiaoyu.banner.transformer.FlipVerticalTransformer;
import com.project.zaixianjiaoyu.banner.transformer.ForegroundToBackgroundTransformer;
import com.project.zaixianjiaoyu.banner.transformer.RotateDownTransformer;
import com.project.zaixianjiaoyu.banner.transformer.RotateUpTransformer;
import com.project.zaixianjiaoyu.banner.transformer.ScaleInOutTransformer;
import com.project.zaixianjiaoyu.banner.transformer.StackTransformer;
import com.project.zaixianjiaoyu.banner.transformer.TabletTransformer;
import com.project.zaixianjiaoyu.banner.transformer.ZoomInTransformer;
import com.project.zaixianjiaoyu.banner.transformer.ZoomOutSlideTransformer;
import com.project.zaixianjiaoyu.banner.transformer.ZoomOutTranformer;


public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}
