///*
// * Copyright (c) 2019 Faiz & Siegeln Software GmbH
// *
// * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
// * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
// * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
// * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
// *
// * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
// * the Software.
// *
// * The Software shall be used for Good, not Evil.
// *
// * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
// * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO
// * EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
// * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
// * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
// */
//
//package com.im.njams.sdk.communication.instruction.util;
//
//import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
//import com.faizsiegeln.njams.messageformat.v4.command.Request;
//import com.faizsiegeln.njams.messageformat.v4.command.Response;
//import com.im.njams.sdk.utils.StringUtils;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class InstructionWrapper {
//
//    public static final int SUCCESS_RESULT_CODE = 0;
//    public static final int WARNING_RESULT_CODE = 1;
//    public static final int ERROR_RESULT_CODE = 2;
//
//    public static final String EMPTY_STRING = "";
//
//    private Instruction instruction;
//
//    public InstructionWrapper(Instruction instruction) {
//        this.instruction = instruction;
//    }
//
//    public Instruction getInstruction() {
//        return this.instruction;
//    }
//
//    public boolean isInstructionNull() {
//        return instruction == null;
//    }
//
//    public boolean isRequestNull() {
//        return isInstructionNull() || instruction.getRequest() == null;
//    }
//
//    public boolean isResponseNull() {
//        return isInstructionNull() || instruction.getResponse() == null;
//    }
//
//    public boolean isCommandNull() {
//        return isRequestNull() || instruction.getCommand() == null;
//    }
//
//    public boolean isCommandEmpty() {
//        return isCommandNull() || instruction.getCommand().equals(EMPTY_STRING);
//    }
//
//    public String getCommandOrEmptyString() {
//        String foundCommand = EMPTY_STRING;
//        if (!isCommandNull()) {
//            foundCommand = instruction.getCommand();
//        }
//        return foundCommand;
//    }
//
//    public void createResponseForInstruction(int resultCodeToSet, String resultMessageToSet) {
//        if (!isInstructionNull()) {
//            Response response = new Response();
//            response.setResultCode(resultCodeToSet);
//            response.setResultMessage(resultMessageToSet);
//            instruction.setResponse(response);
//        }
//    }
//
//    public Request getRequest() {
//        return instruction.getRequest();
//    }
//
//    public ResponseBuilder createResponse() {
//        return new ResponseBuilder();
//    }
//
//    public void setResponse(ResponseBuilder responseBuilder) {
//        if (!isInstructionNull()) {
//            instruction.setResponse(responseBuilder.build());
//        }
//    }
//
//    public List<String> checkForMissingRequestParameters(List<String> requestParamsToCheck) {
//        List<String> missingRequestParameters = new ArrayList<>();
//        if (!isRequestNull() && requestParamsToCheck != null) {
//            RequestParamChecker requestParamChecker = new RequestParamChecker(getRequest().getParameters(), requestParamsToCheck);
//            missingRequestParameters = requestParamChecker.check();
//        }
//        return missingRequestParameters;
//    }
//
//    public class ResponseBuilder {
//
//        private Response responseToBuild;
//
//        public ResponseBuilder() {
//            responseToBuild = new Response();
//        }
//
//        public ResponseBuilder setResultCode(int resultCode) {
//            responseToBuild.setResultCode(resultCode);
//            return this;
//        }
//
//
//        public ResponseBuilder setResultMessage(String resultMessage) {
//            responseToBuild.setResultMessage(resultMessage);
//            return this;
//
//        }
//
//        public ResponseBuilder setDateTime(LocalDateTime dateTime) {
//            responseToBuild.setDateTime(dateTime);
//            return this;
//        }
//
//        public ResponseBuilder setParameters(Map<String, String> parameters) {
//            responseToBuild.setParameters(parameters);
//            return this;
//        }
//
//        public ResponseBuilder addParameters(Map<String, String> parameters) {
//            responseToBuild.getParameters().putAll(parameters);
//            return this;
//        }
//
//        public ResponseBuilder putParameter(String key, String value) {
//            responseToBuild.getParameters().put(key, value);
//            return this;
//        }
//
//        private Response build() {
//            return responseToBuild;
//        }
//    }
//
//
//}
