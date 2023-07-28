package org.kr.exrest.common;

import java.util.List;

public interface KrError {
    List<String> error();
    boolean hasError();
    KrError validate();
}
