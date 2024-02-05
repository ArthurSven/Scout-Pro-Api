package com.devapps.scoutProMalawi.Utils;

import com.devapps.scoutProMalawi.data.models.Team;

public abstract class TeamResponse {
    private TeamResponse() {}

    public static class Success extends TeamResponse {
        private final Team team;

        public Success(Team team) {
            this.team = team;
        }

        public Team getTeam() {
            return team;
        }
    }

    public static class Error extends TeamResponse {
        private final String message;

        public Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
