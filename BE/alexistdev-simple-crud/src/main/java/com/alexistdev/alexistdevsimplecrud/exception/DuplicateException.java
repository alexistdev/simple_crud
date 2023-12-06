package com.alexistdev.alexistdevsimplecrud.exception;

import java.util.ResourceBundle;

public class DuplicateException extends Exception {

    public DuplicateException(String name, ResourceBundle resourceBundle) {
        super("Genre "+name + " " + resourceBundle.getString("duplicate"));
    }
}
