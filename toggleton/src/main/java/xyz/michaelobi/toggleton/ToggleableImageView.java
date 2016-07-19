package xyz.michaelobi.toggleton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import xyz.michaelobi.toggleton.togglestate.DrawableToggleState;

/**
 * An {@link ImageView} implementation that takes in different states and switches between them
 */
public class ToggleableImageView extends ImageView implements ToggleableWidget<DrawableToggleState>, View.OnClickListener {
    private ArrayList<DrawableToggleState> states = new ArrayList<>();

    private int previousStateIndex, currentStateIndex = 0;

    private ToggleListener toggleListener;

    public ToggleableImageView(Context context) {
        super(context);
    }

    public ToggleableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @SuppressLint("PrivateResource")
    private void init() {
        setImageDrawable(states.get(currentStateIndex).getResourceToDisplay());

        setOnClickListener(this);

        // setBackgroundDrawable(ContextCompat.getDrawable(getContext(), android.support.v7.appcompat.R.drawable.abc_control_background_material));
        setBackgroundResource(android.support.v7.appcompat.R.drawable.abc_control_background_material);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<DrawableToggleState> getToggleStates() {
        return states;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void setToggleStates(ArrayList<DrawableToggleState> states) {
        this.states = states;
        init();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void setToggleListener(ToggleListener toggleListener) {
        this.toggleListener = toggleListener;
    }


    @Override
    public void toggle() {
        if (states.isEmpty()) {
            throw new IllegalStateException("No states provided for Toggling");
        }
        previousStateIndex = currentStateIndex;
        currentStateIndex++;
        if (currentStateIndex > states.size() - 1) {
            currentStateIndex = 0;
        }
        setImageDrawable(states.get(currentStateIndex).getResourceToDisplay());

        // Notify listeners of the changes made
        if (toggleListener != null) {
            toggleListener.onToggle(
                    states.get(previousStateIndex),
                    states.get(currentStateIndex));
        }
    }

    @Override
    public void onClick(View v) {
        toggle();
    }
}
