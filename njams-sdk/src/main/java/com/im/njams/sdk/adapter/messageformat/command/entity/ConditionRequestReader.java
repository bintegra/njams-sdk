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
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO
 * EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.im.njams.sdk.adapter.messageformat.command.entity;

import com.faizsiegeln.njams.messageformat.v4.command.Request;
import com.faizsiegeln.njams.messageformat.v4.projectmessage.Extract;
import com.faizsiegeln.njams.messageformat.v4.projectmessage.LogLevel;
import com.faizsiegeln.njams.messageformat.v4.projectmessage.LogMode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.im.njams.sdk.api.adapter.messageformat.command.exceptions.NjamsInstructionException;
import com.im.njams.sdk.common.JsonSerializerFactory;
import com.im.njams.sdk.utils.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConditionRequestReader extends DefaultRequestReader {

    private static final String UNABLE_TO_DESERIALZE_OBJECT = "Unable to deserialize: ";

    private ObjectMapper mapper = JsonSerializerFactory.getDefaultMapper();

    public ConditionRequestReader(Request requestToRead) {
        super(requestToRead);
    }

    public String getProcessPath() {
        return getParamByConstant(ConditionParameter.PROCESS_PATH);
    }

    private String getParamByConstant(ConditionParameter param) {
        return getParameter(param.getParamKey());
    }

    public String getActivityId() {
        return getParamByConstant(ConditionParameter.ACTIVITY_ID);
    }

    public Extract getExtract() throws NjamsInstructionException {
        return parse(getParamByConstant(ConditionParameter.EXTRACT), Extract.class);
    }

    public String getEngineWideRecording(){
        return getParamByConstant(ConditionParameter.ENGINE_WIDE_RECORDING);
    }

    public String getProcessRecording(){
        return getParamByConstant(ConditionParameter.PROCESS_RECORDING);
    }

    public LogLevel getLogLevel() throws NjamsInstructionException{
        return parse(getParamByConstant(ConditionParameter.LOG_LEVEL), LogLevel.class);
    }

    public LogMode getLogMode() throws NjamsInstructionException{
        return parse(getParamByConstant(ConditionParameter.LOG_MODE), LogMode.class);
    }

    public boolean getExcluded() {
        return Boolean.parseBoolean(getParamByConstant(ConditionParameter.EXCLUDE));
    }

    public List<String> searchForMissingParameters(ConditionParameter[] parametersToSearchFor) {
        return Arrays.stream(parametersToSearchFor)
                .filter(neededParameter -> StringUtils.isBlank(getParamByConstant(neededParameter)))
                .map(notFoundConditionParameter -> notFoundConditionParameter.getParamKey())
                .collect(Collectors.toList());
    }

    private <T> T parse(String objectToParse, Class<T> type) throws NjamsInstructionException {
        try {
            return mapper.readValue(objectToParse, type);
        } catch (IOException e) {
            throw new NjamsInstructionException(UNABLE_TO_DESERIALZE_OBJECT + objectToParse);
        }
    }
}
