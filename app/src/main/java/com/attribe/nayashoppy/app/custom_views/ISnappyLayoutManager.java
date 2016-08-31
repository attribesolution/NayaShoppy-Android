package com.attribe.nayashoppy.app.custom_views;

/**
 * Created by Sabih Ahmed on 31-Aug-16.
 */
public interface ISnappyLayoutManager {
    /**
     * @param velocityX
     * @param velocityY
     * @return the resultant position from a fling of the given velocity.
     */
    int getPositionForVelocity(int velocityX, int velocityY);

    /**
     * @return the position this list must scroll to to fix a state where the
     * views are not snapped to grid.
     */
    int getFixScrollPos();
}

