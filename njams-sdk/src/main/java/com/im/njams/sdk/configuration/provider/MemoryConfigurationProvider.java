/* 
 * Copyright (c) 2018 Faiz & Siegeln Software GmbH
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * The Software shall be used for Good, not Evil.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package com.im.njams.sdk.configuration.provider;

import com.im.njams.sdk.Njams;
import com.im.njams.sdk.configuration.Configuration;
import java.util.Properties;
import com.im.njams.sdk.configuration.ConfigurationProvider;

/**
 * ConfigurationProvider implementation which holds the configuration in memory.
 * Therefore, if this ConfigurationProvider is used, all values will be lost
 * after restart.
 *
 * @author pnientiedt
 */
public class MemoryConfigurationProvider implements ConfigurationProvider {

    private static final String PROPERTY_PREFIX = "njams.sdk.configuration.memory";

    private static final String NAME = "memory";
    private Configuration configuration;
    private Njams njams;

    /**
     * Returns the value {@value #NAME} as name for this ConfigurationProvider
     *
     * @return the name of this ConfigurationProvider
     */
    @Override
    public String getName() {
        return NAME;
    }

    /**
     * This does nothing because there is nothing to configure on this simple
     * ConfigurationProvider implementation
     *
     * @param properties Properties for configuration
     */
    @Override
    public void configure(Properties properties, Njams njams) {
        this.njams = njams;
    }

    /**
     * Returns the Configuration. If no Configuration exists yet, it creates a
     * new one
     *
     * @return the Configuration
     */
    @Override
    public Configuration loadConfiguration() {
        if (configuration == null) {
            configuration = new Configuration();
            configuration.setConfigurationProvider(this);
        }
        return configuration;
    }

    /**
     * Stores the given Configuration in memory
     *
     * @param configuration Configuration to save
     */
    @Override
    public void saveConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Returns the prefix for the MemoryConfigurationProvider. Only properties
     * starting with this prefix will be used for initialization.
     *
     * @return the prefix
     */
    @Override
    public String getPropertyPrefix() {
        return PROPERTY_PREFIX;
    }
}
