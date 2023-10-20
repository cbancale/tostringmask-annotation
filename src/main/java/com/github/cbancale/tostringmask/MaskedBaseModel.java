package com.github.cbancale.tostringmask;

import java.lang.reflect.Field;

public class MaskedBaseModel {

    @Override
    public final String toString() {
        StringBuilder outString = new StringBuilder();

        outString.append(this.getClass().getSimpleName()).append(" [");

        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                String name = field.getName();

                Object value = field.isAnnotationPresent(ToStringMask.class)
                        ? getMaskedValue(field.get(this).toString(), field.getAnnotation(ToStringMask.class))
                        : field.get(this);

                outString.append(name).append("=").append(value).append(", ");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        outString = new StringBuilder(outString.toString().replaceAll(", $", ""));

        outString.append("]");

        return outString.toString();
    }

    private String getMaskedValue(String value, ToStringMask tsm) {
        String maskedValue = "";

        MaskType type = tsm.type();
        int len = tsm.len();

        switch (type) {
            case FULL:
                maskedValue = fullMask(value);
                break;
            case EMAIL:
                maskedValue = emailMask(value);
                break;
            case SSN:
                maskedValue = ssnMask(value);
                break;
            case CUSTOM:
                maskedValue = customMask(value, len);
                break;
            default:
                maskedValue = fullMask(value);
                break;
        }

        return maskedValue;
    }

    private String emailMask(String value) {
        StringBuilder out = new StringBuilder();

        String left = value.split("@")[0];
        String right = value.split("@")[1];

        return out.append(mask(left.length())).append("@").append(right).toString();
    }

    private String ssnMask(String value) {
        StringBuilder out = new StringBuilder();

        String left = value.split("-")[0];
        String middle = value.split("-")[1];
        String right = value.split("-")[2];

        return out.append(mask(left.length())).append("-").append(mask(middle.length())).append("-").append(right)
                .toString();
    }

    private String fullMask(String value) {
        return mask(value.length());
    }

    private String customMask(String value, int length) {
        StringBuilder out = new StringBuilder();

        int maskLen = length > value.length() ? value.length() : length;
        String right = value.substring(maskLen);

        return out.append(mask(maskLen)).append(right).toString();
    }

    private String mask(int maskLen) {
        return "*".repeat(maskLen);
    }

}
