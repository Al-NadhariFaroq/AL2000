package ui.util;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * This is an easy way to use and manipulate {@link GridBagConstraints}
 * which specify the constraints for a component managed by the
 * {@link java.awt.GridBagLayout GridBagLayout} layout manager.
 */
public class GBC extends GridBagConstraints {
    boolean clone;

    private GBC(int x, int y) {
        this(x, y, true);
    }

    private GBC(int x, int y, boolean clone) {
        this(x, y, 1, 1, clone);
    }

    private GBC(int x, int y, int width, int height) {
        this(x, y, width, height, true);
    }

    private GBC(int x, int y, int width, int height, boolean clone) {
        gridx = x;
        gridy = y;
        gridwidth = width;
        gridheight = height;
        this.clone = clone;
    }

    /**
     * Create a {@link GridBagConstraints} with the specified row and column.
     * The leftmost column has address {@code x=0} and the top row has address {@code y=0}.
     * <p>
     * Use {@code GBC.RELATIVE} (the default value) to specify that the component
     * be placed just to the right of (for {@code x}) or just below (for {@code y})
     * the component that was added to the container just before this component was added.
     * We recommend specifying the {@code x} and {@code  y} values for each component
     * rather than just using {@code GBC.RELATIVE}; this tends to result in more predictable layouts.
     *
     * @param x the row
     * @param y the column
     * @return a {@link GridBagConstraints} with the specified position
     */
    public static GBC placeAt(int x, int y) {
        return new GBC(x, y);
    }

    /**
     * Create a {@link GridBagConstraints} with the specified row, column,
     * number of columns and number of rows in the component's display area.
     * The leftmost column has address {@code x=0} and the top row has address {@code y=0}.
     * The {@code width} and {@code height} constraints specify the number of cells the component uses,
     * not the number of pixels it uses, the default value is 1.
     * <p>
     * Use {@code GBC.RELATIVE} (the default value) to specify that the component
     * be placed just to the right of (for {@code x}) or just below (for {@code y})
     * the component that was added to the container just before this component was added.
     * We recommend specifying the {@code x} and {@code y} values for each component
     * rather than just using {@code GBC.RELATIVE}; this tends to result in more predictable layouts.
     * <p>
     * Use {@code GBC.REMAINDER} to specify that the component be the last one
     * in its row (for {@code width}) or column (for {@code height}).
     * Use {@code GBC.RELATIVE} to specify that the component be the next to last one
     * in its row (for {@code width}) or column (for {@code height}).
     * We recommend specifying the {@code width} and {@code height} values for each component
     * rather than just using {@code GBC.RELATIVE} and {@code GBC.REMAINDER};
     * this tends to result in more predictable layouts.
     * <p>
     * Note: {@link java.awt.GridBagLayout GridBagLayout} does not allow components to span multiple rows
     * unless the component is in the leftmost column,
     * or you have specified positive {@code x} and {@code y} values for the component.
     *
     * @param x      the row
     * @param y      the column
     * @param width  the number of column
     * @param height the number of row
     * @return a {@link GridBagConstraints} with the specified position and span
     */
    public static GBC placeAt(int x, int y, int width, int height) {
        return new GBC(x, y, width, height);
    }

    /**
     * Specify the row and column at the upper left of the component.
     * The leftmost column has address {@code x=0} and the top row has address {@code y=0}.
     * <p>
     * Use {@code GBC.RELATIVE} (the default value) to specify that the component
     * be placed just to the right of (for {@code x}) or just below (for {@code y})
     * the component that was added to the container just before this component was added.
     * We recommend specifying the {@code x} and {@code y} values for each component
     * rather than just using {@code GBC.RELATIVE}; this tends to result in more predictable layouts.
     *
     * @param x the row
     * @param y teh column
     * @return a {@link GridBagConstraints} with the specified positions
     */
    public GBC setPosition(int x, int y) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.gridx = x;
        gbc.gridy = y;
        return gbc;
    }

    /**
     * Specify the row at the upper left of the component.
     * The leftmost column has address {@code x=0}.
     * <p>
     * Use {@code GBC.RELATIVE} (the default value) to specify that the component be placed
     * just to the right of the component that was added to the container just before this component was added.
     * We recommend specifying the {@code x} values for each component
     * rather than just using {@code GBC.RELATIVE}; this tends to result in more predictable layouts.
     *
     * @param x the row
     * @return a {@link GridBagConstraints} with the specified row
     */
    public GBC setX(int x) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.gridx = x;
        return gbc;
    }

    /**
     * Specify the column at the upper left of the component.
     * The top row has address {@code y=0}.
     * <p>
     * Use {@code GBC.RELATIVE} (the default value) to specify that the component be placed
     * just below the component that was added to the container just before this component was added.
     * We recommend specifying the {@code y} values for each component
     * rather than just using {@code GBC.RELATIVE}; this tends to result in more predictable layouts.
     *
     * @param y teh column
     * @return a {@link GridBagConstraints} with the specified column
     */
    public GBC setY(int y) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.gridy = y;
        return gbc;
    }

    /**
     * Specify the number of columns (for {@code width}) or
     * rows (for {@code height}) in the component's display area.
     * These constraints specify the number of cells the component uses,
     * not the number of pixels it uses. The default value is 1.
     * <p>
     * Use {@code GBC.REMAINDER} to specify that the component be the last one
     * in its row (for {@code width}) or column (for {@code height}).
     * Use {@code GBC.RELATIVE} to specify that the component be the next to last one
     * in its row (for {@code width}) or column (for {@code height}).
     * We recommend specifying the {@code width} and {@code height} values for each component
     * rather than just using {@code GBC.RELATIVE} and {@code GBC.REMAINDER};
     * this tends to result in more predictable layouts.
     * <p>
     * Note: {@link java.awt.GridBagLayout GridBagLayout} does not allow components to span multiple rows
     * unless the component is in the leftmost column,
     * or you have specified positive column and row values for the component.
     *
     * @param width  the number of columns
     * @param height the number of rows
     * @return a {@link GridBagConstraints} with the specified span
     */
    public GBC setSpan(int width, int height) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        return gbc;
    }

    /**
     * Specify the number of columns in the component's display area.
     * These constraints specify the number of cells the component uses,
     * not the number of pixels it uses. The default value is 1.
     * <p>
     * Use {@code GBC.REMAINDER} to specify that the component be the last one in its row.
     * Use {@code GBC.RELATIVE} to specify that the component be the next to last one in its row.
     * We recommend specifying the {@code width} values for each component
     * rather than just using {@code GBC.RELATIVE} and {@code GBC.REMAINDER};
     * this tends to result in more predictable layouts.
     *
     * @param width the number of columns
     * @return a {@link GridBagConstraints} with the specified number of columns
     */
    public GBC setWidth(int width) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.gridwidth = width;
        return gbc;
    }

    /**
     * Specify the number of rows in the component's display area.
     * These constraints specify the number of cells the component uses,
     * not the number of pixels it uses. The default value is 1.
     * <p>
     * Use {@code GBC.REMAINDER} to specify that the component be the last one in its column.
     * Use {@code GBC.RELATIVE} to specify that the component be the next to last one in its column.
     * We recommend specifying the {@code height} values for each component
     * rather than just using {@code GBC.RELATIVE} and {@code GBC.REMAINDER};
     * this tends to result in more predictable layouts.
     * <p>
     * Note: {@link java.awt.GridBagLayout GridBagLayout} does not allow components to span multiple rows
     * unless the component is in the leftmost column,
     * or you have specified positive column and row values for the component.
     *
     * @param height the number of rows
     * @return a {@link GridBagConstraints} with the specified number of rows
     */
    public GBC setHeight(int height) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.gridheight = height;
        return gbc;
    }

    /**
     * Used when the component is smaller than its display area
     * to determine where (within the area) to place the component.
     * <p>
     * Valid values are:
     * <ul>
     * <li>{@code GBC.CENTER} (the default)
     * <li>{@code GBC.PAGE_START}
     * <li>{@code GBC.PAGE_END}
     * <li>{@code GBC.LINE_START}
     * <li>{@code GBC.LINE_END}
     * <li>{@code GBC.FIRST_LINE_START}
     * <li>{@code GBC.FIRST_LINE_END}
     * <li>{@code GBC.LAST_LINE_END}
     * <li>{@code GBC.LAST_LINE_START}
     * </ul>
     *
     * @param anchor the anchor value
     * @return a {@link GridBagConstraints} with the specified anchor
     */
    public GBC setAnchor(int anchor) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.anchor = anchor;
        return gbc;
    }

    /**
     * Used when the component's display area is larger than the component's requested size
     * to determine whether and how to resize the component.
     * <p>
     * Valid values are:<ul>
     * <li>{@code GBC.NONE} (the default)
     * <li>{@code GBC.HORIZONTAL} make the component wide enough to fill its display area horizontally, but do not change its height.
     * <li>{@code GBC.VERTICAL} make the component tall enough to fill its display area vertically, but do not change its width.
     * <li>{@code GBC.BOTH} make the component fill its display area entirely.
     * </ul>
     *
     * @param fill the fill value
     * @return a {@link GridBagConstraints} with the specified fill value
     */
    public GBC setFill(int fill) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.fill = fill;
        return gbc;
    }

    /**
     * Weights are used to determine how to distribute space
     * among columns ({@code weightX}) and among rows ({@code weightY});
     * this is important for specifying resizing behavior.
     * <p>
     * Unless you specify at least one non-zero value for {@code weightX} or {@code weightY},
     * all the components clump together in the center of their container.
     * This is because when the weight is 0.0 (the default), the {@link java.awt.GridBagLayout GridBagLayout} puts
     * any extra space between its grid of cells and the edges of the container.
     * <p>
     * Generally weights are specified with 0.0 and 1.0 as the extremes: the numbers in between are used as necessary.
     * Larger numbers indicate that the component's row or column should get more space.
     * For each column, the weight is related to the highest {@code weightX} specified for a component within that column,
     * with each multi-column component's weight being split somehow between the columns the component is in.
     * Similarly, each row's weight is related to the highest {@code weightY} specified for a component within that row.
     * Extra space tends to go toward the rightmost column and bottom row.
     *
     * @param weightX the weight on the column
     * @param weightY the weight on the row
     * @return a {@link GridBagConstraints} with the specified weights
     */
    public GBC setWeight(double weightX, double weightY) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.weightx = weightX;
        gbc.weighty = weightY;
        return gbc;
    }

    /**
     * WeightX is used to determine how to distribute space among columns;
     * this is important for specifying resizing behavior.
     * <p>
     * Unless you specify at least one non-zero value,
     * all the components clump together in the center of their container.
     * This is because when the weight is 0.0 (the default), the {@link java.awt.GridBagLayout GridBagLayout} puts
     * any extra space between its grid of cells and the edges of the container.
     * <p>
     * Generally weights are specified with 0.0 and 1.0 as the extremes: the numbers in between are used as necessary.
     * Larger numbers indicate that the component's column should get more space.
     * For each column, the weight is related to the highest {@code weightX} specified for a component within that column,
     * with each multi-column component's weight being split somehow between the columns the component is in.
     * Extra space tends to go toward the rightmost column.
     *
     * @param weightX the weight on the column
     * @return a {@link GridBagConstraints} with the specified weight on the column
     */
    public GBC setWeightX(double weightX) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.weightx = weightX;
        return gbc;
    }

    /**
     * WeightY is used to determine how to distribute space among rows;
     * this is important for specifying resizing behavior.
     * <p>
     * Unless you specify at least one non-zero value for {@code weightY},
     * all the components clump together in the center of their container.
     * This is because when the weight is 0.0 (the default), the {@link java.awt.GridBagLayout GridBagLayout} puts
     * any extra space between its grid of cells and the edges of the container.
     * <p>
     * Generally weights are specified with 0.0 and 1.0 as the extremes: the numbers in between are used as necessary.
     * Larger numbers indicate that the component's row should get more space.
     * For each row, the weight is related to the highest {@code weightY} specified for a component within that row,
     * with each multi-row component's weight being split somehow between the rows the component is in.
     * Extra space tends to go toward the bottom row.
     *
     * @param weightY the weight on the row
     * @return a {@link GridBagConstraints} with the specified weight on the row
     */
    public GBC setWeightY(double weightY) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.weighty = weightY;
        return gbc;
    }

    /**
     * Specifies the external padding of the component:
     * the minimum amount of space between the component and the edges of its display area.
     * By default, each component has no external padding
     *
     * @param top    the top external padding
     * @param left   the left external padding
     * @param bottom the bottom external padding
     * @param right  the right external padding
     * @return a {@link GridBagConstraints} with the specified external padding
     */
    public GBC setInsets(int top, int left, int bottom, int right) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.insets = new Insets(top, left, bottom, right);
        return gbc;
    }

    /**
     * Specifies the external padding of the component:
     * the minimum amount of space between the component and the edges of its display area.
     * By default, each component has no external padding
     *
     * @param topBottom the top and bottom external padding
     * @param leftRight the left and right external padding
     * @return a {@link GridBagConstraints} with the specified external padding
     */
    public GBC setInsets(int topBottom, int leftRight) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.insets = new Insets(topBottom, leftRight, topBottom, leftRight);
        return gbc;
    }

    /**
     * Specifies the external padding of the component:
     * the minimum amount of space between the component and the edges of its display area.
     * By default, each component has no external padding
     *
     * @param distance the external padding on each side
     * @return a {@link GridBagConstraints} with the specified external padding
     */
    public GBC setInsets(int distance) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.insets = new Insets(distance, distance, distance, distance);
        return gbc;
    }

    /**
     * Specifies the external padding of the component:
     * the minimum amount of space between the component and the edges of its display area.
     * The value is specified as an {@link Insets} object. By default, each component has no external padding
     *
     * @param insets the {@code Insets} object with the external padding
     * @return a {@link GridBagConstraints} with the specified external padding
     */
    public GBC setInsets(Insets insets) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.insets = insets;
        return gbc;
    }

    /**
     * Specifies the internal padding: how much to add to the size of the component.
     * The default value is zero.
     * <p>
     * The width of the component will be at least its minimum width plus {@code ipadX}*2 pixels,
     * since the padding applies to both sides of the component.
     * Similarly, the height of the component will be at least its minimum height plus {@code ipadY}*2 pixels.
     *
     * @param ipadX the internal padding on left and right
     * @param ipadY the internal padding on top and bottom
     * @return a {@link GridBagConstraints} with the specified internal padding
     */
    public GBC setIpad(int ipadX, int ipadY) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.ipadx = ipadX;
        gbc.ipady = ipadY;
        return gbc;
    }

    /**
     * Specifies the internal padding on the left and right side: how much to add to the size of the component.
     * The default value is zero.
     * <p>
     * The width of the component will be at least its minimum width plus {@code ipadX}*2 pixels,
     * since the padding applies to both sides of the component.
     *
     * @param ipadX the internal padding on left and right
     * @return a {@link GridBagConstraints} with the specified internal padding on the left and right
     */
    public GBC setIpadX(int ipadX) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.ipadx = ipadX;
        return gbc;
    }

    /**
     * Specifies the internal padding on the top and bottom side: how much to add to the size of the component.
     * The default value is zero.
     * <p>
     * The height of the component will be at least its minimum height plus {@code ipadY}*2 pixels,
     * since the padding applies to both sides of the component.
     *
     * @param ipadY the internal padding on top and bottom
     * @return a {@link GridBagConstraints} with the specified internal padding on the top and bottom
     */
    public GBC setIpadY(int ipadY) {
        GBC gbc = clone ? (GBC) clone() : this;
        gbc.ipady = ipadY;
        return gbc;
    }
}