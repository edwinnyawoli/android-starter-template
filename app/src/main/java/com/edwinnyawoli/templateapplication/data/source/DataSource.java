package com.edwinnyawoli.templateapplication.data.source;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 *
 */

public interface DataSource {

    /**
     * A data source local to the device.
     */
    @Qualifier
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @interface Local {
    }

    /**
     * A data source that provides data not present on the device.
     */
    @Qualifier
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @interface Remote {
    }
}
