package com.webapp.trevo.utility;

import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class LoadableComponent<T extends LoadableComponent> {
    public RemoteWebDriver remoteDriver;

    LoadableComponent() {
    }

    @SuppressWarnings("unchecked")
    public T get() {
        try {
            this.isLoaded();
            return (T) this;
        } catch (Error e) {
            Log.info("Error encountered during page load: " + e.getMessage());
            this.load();
            this.isLoaded();
            return (T) this;
        }
    }

    protected abstract void load();

    protected abstract void isLoaded() throws Error;

}
