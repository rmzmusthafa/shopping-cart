package com.company.shopping_cart.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoleName {
    ROLE_ADMIN(1, ""), ROLE_USER(2, "");
    private static final Map<Long, String> ROLE = new HashMap<>();
    private static final RoleName[] values;

    private final Long roleId;
    private final String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    RoleName(long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public static RoleName getById(Long id) {
        if (null == id) {
            return null;
        }
        for (RoleName value : values) {
            if (value.getRoleId().equals(id)) {
                return value;
            }
        }
        return null;
    }

    static {
        values = values();
        for (RoleName value : values) {
            ROLE.put(value.getRoleId(), value.getRoleName());

        }
    }
}
