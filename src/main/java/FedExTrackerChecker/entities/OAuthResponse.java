package FedExTrackerChecker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public class OAuthResponse {
    public String access_token;

    public String getAccessToken(){
        return access_token;
    }
}
