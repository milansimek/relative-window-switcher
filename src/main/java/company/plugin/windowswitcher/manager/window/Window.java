package company.plugin.windowswitcher.manager.window;

public class Window {

    private String handle;
    private Integer left;
    private Integer right;
    private Integer top;
    private Integer bottom;
    private Integer width;
    private Integer height;
    private boolean isActive;

    public Window(String handle, boolean isActive, int left, int top, int right, int bottom)
    {
        this.handle = handle;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.isActive = isActive;
    }

    public Window(String handle, boolean isActive, String left, String top, String width, String height)
    {
        this
                .setHandle(handle)
                .setLeft(left)
                .setTop(top)
                .setWidth(width)
                .setHeight(height)
                .setIsActive(isActive)
                .calculateRightBottom();
    }

    public Window setHandle(String handle) {
        this.handle = handle;
        return this;
    }

    public Window setBottom(int bottom) {
        this.bottom = bottom;
        return this;
    }

    public Window setBottom(String bottom) {
        this.bottom = Integer.parseInt(bottom);
        return this;
    }

    public Window setTop(int top) {
        this.top = top;
        return this;
    }

    public Window setTop(String top) {
        this.top = Integer.parseInt(top);
        return this;
    }

    public Window setLeft(int left) {
        this.left = left;
        return this;
    }

    public Window setLeft(String left) {
        this.left = Integer.parseInt(left);
        return this;
    }

    public Window setRight(int right) {
        this.right = right;
        return this;
    }

    public Window setRight(String right) {
        this.right = Integer.parseInt(right);
        return this;
    }

    public Window setWidth(int width) {
        this.width = width;
        return this;
    }

    public Window setWidth(String width) {
        this.width = Integer.parseInt(width);
        return this;
    }

    public Window setHeight(int height) {
        this.height = height;
        return this;
    }

    public Window setHeight(String height) {
        this.height = Integer.parseInt(height);
        return this;
    }

    public Window setIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public Window calculateRightBottom()
    {
        if(this.right == null){
            this.right = this.left + this.width;
        }
        if(this.bottom == null){
            this.bottom = this.top + this.height;
        }
        return this;
    }

    public String getHandle() {
        return handle;
    }

    public Integer getLeft() {
        return left;
    }

    public Integer getRight() {
        return right;
    }

    public Integer getTop() {
        return top;
    }

    public Integer getBottom() {
        return bottom;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
}
