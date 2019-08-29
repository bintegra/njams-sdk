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

package com.im.njams.sdk.adapter.messageformat.command.entity.defaults;

import com.faizsiegeln.njams.messageformat.v4.command.Response;
import com.im.njams.sdk.adapter.messageformat.command.entity.AbstractResponseWriter;
import com.im.njams.sdk.api.adapter.messageformat.command.ResultCode;

/**
 * This class provides methods to write the outgoing instruction's response.
 *
 * @param <W> The type of the DefaultResponseWriter for chaining the methods of the DefaultResponseWriter.
 * @author krautenberg
 * @version 4.1.0
 */
public class DefaultResponseWriter<W extends DefaultResponseWriter<W>> extends AbstractResponseWriter<W> {

    /**
     * Sets the underlying response
     *
     * @param responseToWrite the response to set
     */
    protected DefaultResponseWriter(Response responseToWrite) {
        super(responseToWrite);
    }

    /**
     * Sets the {@link ResultCode ResultCode} and the ResultMessage to the {@link Response response}.
     *
     * @param resultCode    the resultCode to set
     * @param resultMessage the resultMessage to set
     * @return itself via {@link #getThis() getThis()} for chaining DefaultResponseWriter methods
     */
    public W setResultCodeAndResultMessage(ResultCode resultCode, String resultMessage) {
        return setResultCode(resultCode).setResultMessage(resultMessage);
    }
}
