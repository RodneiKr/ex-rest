package org.kr.exrest.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractKrEntity implements KrError {
    private List<String> error = new ArrayList<>();

    public List<String> error() {
        return this.error;
    }
    @Override
    public String toString() {
        return "error=" + this.error;
    }
}
