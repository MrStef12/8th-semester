package main;

import java.util.List;
import java.util.ArrayList;

import main.model.FormatElement;
import main.model.FormatKind;
import main.model.FormatObject;
import main.model.FormatText;

public class DataFormatter {

    private List<FormatElement> model;

    public DataFormatter(List<FormatElement> model) {
        this.model = model;
    }

    public static Builder build() {
        return new Builder();
    }

    public String format(Object...inputs) {
        StringBuilder builder = new StringBuilder();
        for (FormatElement elm : model) {
            builder.append(elm.format(inputs));
        }
        return builder.toString();
    }

    public static class Builder {
        private List<FormatElement> model = new ArrayList<>();

        public Builder t(String text) {
            model.add(new FormatText(text));
            return this;
        }
    
        public Builder object(int index) {
            model.add(new FormatObject(FormatKind.OBJECT, index));
            return this;
        }
    
        public Builder day(int index) {
            model.add(new FormatObject(FormatKind.DAY, index));
            return this;
        }
    
        public Builder month(int index) {
            model.add(new FormatObject(FormatKind.MONTH, index));
            return this;
        }
    
        public Builder year(int index) {
            model.add(new FormatObject(FormatKind.YEAR, index));
            return this;
        }
    
        public DataFormatter end() {
            return new DataFormatter(model);
        }
    }

}