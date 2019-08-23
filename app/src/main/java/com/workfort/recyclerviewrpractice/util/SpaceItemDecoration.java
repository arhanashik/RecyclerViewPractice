package com.workfort.recyclerviewrpractice.util;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int mClipPx;
    private final int mSpacePx;

    public SpaceItemDecoration(int clipPx, int spacePx) {
        mClipPx = clipPx;
        this.mSpacePx = spacePx;
    }

    @Override
    public void getItemOffsets(
            Rect outRect,
            @NonNull View view,
            @NonNull RecyclerView parent,
            @NonNull RecyclerView.State state
    ) {
        outRect.top = outRect.bottom=  mSpacePx;
        outRect.left = outRect.right = mClipPx;
    }
}
