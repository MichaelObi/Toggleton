package xyz.michaelobi.toggleton;


import java.util.ArrayList;

import xyz.michaelobi.toggleton.togglestate.ToggleState;

public interface ToggleableWidget<T extends ToggleState> {


    /**
     * Toggle widget state
     */
    void toggle();

    /**
     * Return the toggle states defined for the widget
     *
     * @return {@link ArrayList<T>}
     */
    ArrayList<T> getToggleStates();

    /**
     * Define states to toggle through and what to show for each state
     *
     * @param states
     */
    void setToggleStates(ArrayList<T> states);

    /**
     * Register a callback to be invoked when a toggle occurs.
     *
     * @param listener The callback that will run
     */
    void setToggleListener(ToggleListener listener);

    /**
     * Interface definition for a callback to be invoked when a the widget is toggled.
     */
    public interface ToggleListener {

        /**
         * Called when a widget has been toggled
         *
         * @param previous The state that was just left as defined in {@link ToggleableWidget#setToggleStates(ArrayList)}
         * @param current  The state that was just entered as defined in {@link ToggleableWidget#setToggleStates(ArrayList)}
         */
        void onToggle(ToggleState previous, ToggleState current);
    }
}
