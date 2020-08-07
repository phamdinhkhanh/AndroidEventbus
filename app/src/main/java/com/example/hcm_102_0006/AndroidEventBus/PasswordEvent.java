package com.example.hcm_102_0006.AndroidEventBus;

public class PasswordEvent {
    private CustomEvent mCustomItem;

    public PasswordEvent(CustomEvent customItem) {
        mCustomItem = customItem;
    }

    public CustomEvent getCustomItem() {
        return mCustomItem;
    }

    public void setCustomItem(CustomEvent customItem) {
        mCustomItem = customItem;
    }
}
