package com.gotten.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 10:48
 * @description
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
