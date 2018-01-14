package gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class DistribType {

    private final StringProperty strType;

    public DistribType(String strType) {
        this.strType = new SimpleStringProperty(strType);
    }

    public String getStrType() {
        return strType.get();
    }

    public void setStrType(String strType) {
        this.strType.set(strType);
    }

    public StringProperty strTypeProperty() {
        return strType;
    }

    @Override
    public String toString() {
        return getStrType();
    }
}