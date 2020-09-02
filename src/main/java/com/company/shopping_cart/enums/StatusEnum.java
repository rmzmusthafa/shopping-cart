package com.company.shopping_cart.enums;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {

    ACTIVE(1, "ACTIVE", "Active", "COMMON"), INACTIVE(2, "INACTIVE", "Inactive", "COMMON");

    public static final String COMMON = "COMMON";
    private static final Map<Long, String> STATUS = new HashMap<>();
    private static final StatusEnum[] values;

    private final Long statusId;
    private final String statusCode;
    private final String statusName;
    private final String statusType;

    StatusEnum(long statusId, String statusCode, String statusName, String statusType) {
        this.statusId = statusId;
        this.statusCode = statusCode;
        this.statusName = statusName;
        this.statusType = statusType;
    }

    public Long getStatusId() {
        return statusId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public String getStatusType() {
        return statusType;
    }

    public static StatusEnum getById(Long id, String type) {
        for (StatusEnum value : values) {
            if (value.getStatusId().equals(id) && value.getStatusType().equals(type)) {
                return value;
            }
        }
        return null;
    }

    public static StatusEnum getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (StatusEnum en : values) {
            if (en.getStatusCode().equals(code)) {
                return en;
            }
        }
        return null;
    }

    public static StatusEnum getById(Long id) {
        if (null == id) {
            return null;
        }
        for (StatusEnum value : values) {
            if (value.getStatusId().equals(id)) {
                return value;
            }
        }
        return null;
    }

    static {
        values = values();
        for (StatusEnum value : values) {
            if (value.getStatusType().equals(COMMON)) {
                STATUS.put(value.getStatusId(), value.getStatusName());
            }
        }
    }
}
