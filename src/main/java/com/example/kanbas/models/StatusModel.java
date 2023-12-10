package com.example.kanbas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatusModel {
    private Long id_status;
    private String st_code;
    private String st_name;
    private String st_description;


    public static class Builder {
        private Long id_status;
        private String st_code;
        private String st_name;
        private String st_description;

        public Builder id_status(Long id_status) {
            this.id_status = id_status;
            return this;
        };
        public Builder st_code(String st_code) {
            this.st_code = st_code;
            return this;
        };
        public Builder st_name(String st_name) {
            this.st_name = st_name;
            return this;
        };
        public Builder st_description(String st_description) {
            this.st_description = st_description;
            return this;
        }
        public StatusModel build() {
            StatusModel statusModel = new StatusModel();
            statusModel.id_status = this.id_status;
            statusModel.st_code = this.st_code;
            statusModel.st_name = this.st_name;
            statusModel.st_description = this.st_description;
            return statusModel;
        }
    }
}
