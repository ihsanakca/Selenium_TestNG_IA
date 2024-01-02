package com.kraft.utilities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ddd {

        private String browser;
        private String email;
        private String password;
        private String url;

        public String getBrowser() {
            return browser;
        }

        @XmlElement
        public void setBrowser(String browser) {
            this.browser = browser;
        }

        public String getEmail() {
            return email;
        }

        @XmlElement
        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        @XmlElement
        public void setPassword(String password) {
            this.password = password;
        }

        public String getUrl() {
            return url;
        }

        @XmlElement
        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "AppConfig{" +
                    "browser='" + browser + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }


