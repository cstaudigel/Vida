package io.github.cstaudigel.domain;

public class Password {
    private String text;

    public Password(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
