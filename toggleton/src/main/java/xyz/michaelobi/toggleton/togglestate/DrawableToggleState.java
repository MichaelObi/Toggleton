package xyz.michaelobi.toggleton.togglestate;

import android.graphics.drawable.Drawable;

import xyz.michaelobi.toggleton.ToggleableImageView;

/**
 * An implementation of {@link ToggleState} for {@link ToggleableImageView}
 */
public class DrawableToggleState extends ToggleState<Drawable> {
    public DrawableToggleState(String key, Drawable drawable) {
        super(key, drawable);
    }
}
