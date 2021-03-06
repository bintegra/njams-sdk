/*
 * Copyright (c) 2019 Faiz & Siegeln Software GmbH
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * The Software shall be used for Good, not Evil.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package com.im.njams.sdk.argos;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract base class for Argos Metrics.
 * <p>
 * Extend this class and use it in your @see {@link ArgosCollector}
 * Provide all attributes you want to send to Argos.
 */
public abstract class ArgosMetric {

    // the id of this component
    private String id;

    // the logical name (short name) of this component
    private String name;

    // the name of the container of this component; can be a server, or JVM name, or similar
    private String containerid;

    // the measurement name
    private String measurement;

    // the technology type
    private String type;

    private Map<String, Object> tags = new HashMap<>();

    public ArgosMetric(String id, String name, String containerid, String measurement, String type) {
        this.id = id;
        this.name = name;
        this.containerid = containerid;
        this.measurement = measurement;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContainerId() {
        return containerid;
    }

    public void setContainerId(String containerId) {
        this.containerid = containerId;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public void addTag(String key, Object value) {
        tags.put(key, value);
    }
}
