package com.devapps.scoutProMalawi.Utils;

import com.devapps.scoutProMalawi.data.models.Agent;

public class AgentResponse {

    private AgentResponse() {
    }

    public static class Success extends AgentResponse {

        private final Agent agent;

        public Success(Agent agent) {
            this.agent = agent;
        }

        public Agent getAgent() {
            return this.agent;
        }
    }

    public static class Error extends AgentResponse {

        private final String message;

        public Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;

        }
    }

}
