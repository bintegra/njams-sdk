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
package com.im.njams.sdk.communication.jms;

import java.util.Properties;

import com.im.njams.sdk.pools.ObjectPool;
import com.im.njams.sdk.settings.Settings;

public class JmsSenderPool extends ObjectPool<JmsSenderImpl> {

    private Properties properties;

    public JmsSenderPool(Properties properties) {
        super(Integer.parseInt(properties.getProperty(Settings.PROPERTY_MAX_QUEUE_LENGTH, "8")));
        this.properties = properties;
    }

    @Override
    protected JmsSenderImpl create() {
        JmsSenderImpl sender = new JmsSenderImpl();
        sender.init(properties);
        return sender;
    }

    @Override
    public boolean validate(JmsSenderImpl sender) {
        // TODO: there must be a better solution!
        return true;
        //        return sender.isConnected();
    }

    @Override
    public void expire(JmsSenderImpl sender) {
        sender.close();
    }

}